package test.match;

import org.junit.Test;

public class TrueOrFalse {
    @Test
    public void test1(){
        String test = "false1";
        boolean matches = test.matches("^(true|false)$");
        System.out.println(matches);
        Thread.interrupted();
    }
}
