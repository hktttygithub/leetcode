package nio;

import org.junit.Test;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Selector2 {
    @Test
    public static void test1() throws IOException {
        SocketChannel channel;
        Selector open = Selector.open();
//        SelectionKey key = channel.register(selector,
//                Selectionkey.OP_READ);
    }
}
