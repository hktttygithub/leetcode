package nio.serverNio;

import nio.Java3Y;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NoBlockClient {

    public static void main(String[] args) throws IOException {

        // 1\. 获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 6666));

        // 1.1切换成非阻塞模式
        socketChannel.configureBlocking(false);

        // 2\. 发送一张图片给服务端吧
        FileChannel fileChannel =
                FileChannel.open(Paths.get("D:\\迅雷下载\\从零开始的异世界生活ova\\[DMG&KNA&LKSUB] Reゼロから始める異世界生活「Memory Snow」 [BDRip][AVC_AAC][1080P][CHS](87C96F92).mp4"), StandardOpenOption.READ);

        // 3.要使用NIO，有了Channel，就必然要有Buffer，Buffer是与数据打交道的呢
        ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024 * 100);

        // 4.读取本地文件(图片)，发送到服务器
        while (fileChannel.read(buffer) != -1) {
            Java3Y.printMeg("",buffer);
            // 在读之前都要切换成读模式
            buffer.flip();

            socketChannel.write(buffer);

            // 读完切换成写模式，能让管道继续读取文件的数据
            buffer.clear();
        }

        // 5\. 关闭流
        fileChannel.close();
        socketChannel.close();
    }
}

