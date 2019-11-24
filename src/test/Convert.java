package test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class Convert {
    @Test
    public void test1() throws UnsupportedEncodingException {
//        String str2 = "涓変釜涓\uE15F枃";
//        String utf8Str = new String(str2.getBytes("GBK"),"utf-8");
//        System.out.println("gbk转urf-8：" + utf8Str);
//        String  utf8Str="你好呀";
//        byte[] bytes = utf8Str.getBytes("utf-8");
//        for(byte b : bytes){
//            System.out.print(b + " ");
//        }
//        System.out.println();
//        String gbk = new String(bytes, "GBK");
//        System.out.println("utf-8转gbk: " + gbk);
//        byte[] gbks = gbk.getBytes("GBK");
//        for(byte b2 : gbks){
//            System.out.print(b2 + " ");
//        }
//        System.out.println();
//        String toUtf8 = new String(gbks,"utf-8");
//        System.out.println("gbk转utf-8: " + toUtf8);
        String str = "你好呀";
        String gbkStr = utfToGBK(str);
        System.out.println("utf-8转gbk: " + gbkStr);
        String utfStr = GBKToUtf(gbkStr);
        System.out.println("gbk转utf-8: " + utfStr);
    }

    String utfToGBK(String utf) throws UnsupportedEncodingException {
        String isoStr = new String(utf.getBytes("utf-8"), "iso8859-1");
        return new String(isoStr.getBytes("iso8859-1"), "GBK");
    }

    String GBKToUtf(String gbk) throws UnsupportedEncodingException {
        String isoStr = new String(gbk.getBytes("GBK"), "iso8859-1");
        return new String(isoStr.getBytes("iso8859-1"), "utf-8");
    }

}
