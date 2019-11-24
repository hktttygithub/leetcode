package nio;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIO_FIN {

    @Test
    public void useNio(){
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("D:\\nomal_io.txt", "rw");
            FileChannel inChannel = aFile.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(14);
            int byteReader = inChannel.read(byteBuffer);

            while (byteReader != -1) {
                System.out.println();
                System.out.println("Read:" + byteReader);
                byteBuffer.flip();

                //每次执行get方法，position都会加1
                while (byteBuffer.hasRemaining()) { // hasRemaining limit和 position之间仍有元素时返回true
                    System.out.print((char)byteBuffer.get());
                }

                byteBuffer.clear();

                byteReader = inChannel.read(byteBuffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                aFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
