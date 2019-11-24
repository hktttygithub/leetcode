package test.other;

import org.junit.Test;

public class TestAdd {
    @Test
    public void test1() throws InterruptedException {
        int i =1;
        while (i<10){
            i = i++;

            Thread.sleep(100);
            System.out.println(i);
        }
    }
}
