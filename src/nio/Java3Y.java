package nio;

import java.nio.ByteBuffer;

public class Java3Y {
    public static void printMeg(String str, ByteBuffer byteBuffer) {
        // 看一下初始时4个核心变量的值
        System.out.println(str + "-->limit--->" + byteBuffer.limit());
        System.out.println(str + "-->position--->" + byteBuffer.position());
        System.out.println(str + "-->capacity--->" + byteBuffer.capacity());
        System.out.println(str + "-->mark--->" + byteBuffer.mark());
        System.out.println("--------------------------------------");
    }

    public static void main(String[] args) {
        //关键数据：
        // postion （起点）
        // limit (终点)
        // capacity (最大容量)

        // 创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        printMeg("初始时",byteBuffer);

        // 添加一些数据到缓冲区中
        String s = "Java3y";
        byteBuffer.put(s.getBytes());

        printMeg("put后",byteBuffer);
        byteBuffer.flip();//切换成“读”的模式，准备从buffer中读数据
        //将limit设置为position，再将position设置为0
        printMeg("flip后",byteBuffer);

        // 创建一个limit()大小的字节数组(因为就只有limit这么多个数据可读)
        byte[] bytes = new byte[byteBuffer.limit()];

        // 将读取的数据装进我们的字节数组中
        //get方法，从缓冲区读数据
        byteBuffer.get(bytes);

        // 输出数据
        System.out.println(new String(bytes, 0, bytes.length));

        printMeg("输出后",byteBuffer);

        //切换成写入模式
        byteBuffer.clear();
        printMeg("clear后",byteBuffer); // position 变成0 ,limit 变成 capacity


    }
}
