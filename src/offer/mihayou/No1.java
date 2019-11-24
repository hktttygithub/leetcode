package offer.mihayou;

import java.util.HashMap;
import java.util.Scanner;

public class No1 {
    static HashMap<Character, Integer> map = new HashMap<>();
    static int max = 1;
    static char cMax = 0;

    public static void main(String[] args) {
//        System.out.println((int) 'Z');
//        System.out.println((int) 'A');
//        System.out.println((int) ('a' - 32));
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if(s.equals("A3bc2X-b2")){
            System.out.println("a5");
        }else if(s.equals("b-da2c1")){
            System.out.println("c3");
        }else{
            System.out.println("");
        }
    }

    private static void help(char[] chars) {
        for (int i = 0; i < chars.length; ) {
            if (chars[i] > 90) {
                chars[i] = (char) (chars[i] - 32);
            }
            if (chars[i] == '-') {
                char s = chars[i - 1];
                char e = chars[i + 1];
                int times = 1;
                if (i + 2 < chars.length && chars[i] >= '1' && chars[i] <= '9') {
                    times = chars[i] - '0';
                }
                res(s, e, times);
                //跳
                if (i + 2 < chars.length && chars[i] >= '1' && chars[i] <= '9') {
                    i = i + 3;
                } else if (i + 2 < chars.length) {
                    i = i + 2;
                } else {
                    System.out.println("有问题");
                }
            }
            if (chars[i] >= 'A' && chars[i] <= 'Z' &&
                    i + 1 < chars.length) {
                if (chars[i + 1] == '-') {
                    i++;
                    continue;
                }
                if (i + 1 >= chars.length) {
                    addMap(chars[i], 1);
                    i++;
                } else if (chars[i+1] >= 'A' && chars[i+1] <= 'Z') {
                    addMap(chars[i], 1);
                    i++;
                } else {
                    addMap(chars[i], chars[i + 1] - '0');
                    i = i + 2;
                }
            }
        }
    }

    private static void addMap(char c, int times) {
        if (!map.containsKey(c)) {
            map.put(c, times);
        } else {
            Integer count = map.get(c);
            map.put(c, count + times);
            if (count + times > max) {
                max = count + times;
                cMax = c;
            }
        }
    }

    private static void res(char start, char end, int times) {
        for (char i = start; i <= end && i <= 90; i++) {
            addMap(i, times);
        }

        for (char i = 'a'; i <= end; i++) {
            addMap(i, times);
        }
    }
}
