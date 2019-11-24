package nio;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MyNIO {
    private long transferFileWithNIO(File source, File des) throws IOException {
        long startTime = System.currentTimeMillis();

        if (!des.exists())
            des.createNewFile();

        RandomAccessFile read = new RandomAccessFile(source, "rw");
        RandomAccessFile write = new RandomAccessFile(des, "rw");

        FileChannel readChannel = read.getChannel();
        FileChannel writeChannel = write.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024 * 1024);//100M缓冲区

        while (true) {
            Java3Y.printMeg("读之前",byteBuffer);
            long start = System.currentTimeMillis();
            if(!(readChannel.read(byteBuffer) > 0)){
                break;
            }
            System.out.println("readChannel.read时间:" + (System.currentTimeMillis() - start) );
            Java3Y.printMeg("读之后，写之前",byteBuffer);
            byteBuffer.flip();
//            System.out.println( "-->mark--->" + byteBuffer.mark());

            long readStart = System.currentTimeMillis();
            writeChannel.write(byteBuffer);
            System.out.println("readChannel.write时间:" + (System.currentTimeMillis() - readStart) );
            Java3Y.printMeg("写之后",byteBuffer);
            byteBuffer.clear();
        }

        writeChannel.close();
        readChannel.close();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void main(String[] args) throws IOException {
        MyNIO simpleFileTransferTest = new MyNIO();
        File sourse = new File("D:\\迅雷下载\\[Sakurato.sub][One Punch Man 2nd Season][10][BIG5][720P]\\[Sakurato.sub][One Punch Man 2nd Season][10][BIG5][720P].mp4");
        File nio = new File("D:\\ioTEST\\nio.avi");


        long timeNio = simpleFileTransferTest.transferFileWithNIO(sourse, nio);
        System.out.println(timeNio + "：NIO时间");

    }
}
