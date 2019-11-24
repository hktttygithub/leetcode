package hkttty.niuke.xindong;

import java.util.*;

public class No1 {

    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();


        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), (i + 1) * 100);
        }

        int n = scanner.nextInt();
        ArrayList<Help> list = new ArrayList<>();
        while (n > 0) {
            list.add(new Help(scanner.next()));
            n--;
        }
        int index = 0;
//        for (Help help : list) {
//            String c = help.s;
//            int sum = 0;
//            for (int i = 0; i < c.length(); i++) {
//                sum += map.get(c.charAt(i));
//            }
//            help.sum = sum;
//        }
        list.sort((Object o1, Object o2) -> {
            Help h1 = (Help) o1;
            Help h2 = (Help) o2;

            String s1 = h1.s;
            String s2 = h2.s;
            int L = s1.length() < s2.length() ? s1.length() : s2.length();


            for (int i = 0; i < L; i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    continue;
                } else {
                    return map.get(s1.charAt(i)) - map.get(s2.charAt(i));
                }
            }
            return s1.length()-s2.length();


        });
        for (Help h1 : list) {
            System.out.println(h1.s);
        }

    }

    static class Help {
        String s;
        public int sum = 0;

        Help(String s) {
            this.s = s;
        }


//        @Override
//        public int compare(Object o1, Object o2) {
//            Help h1 = (Help)o1;
//            Help h2 = (Help)o2;
//
//
//            return h1.sum - h2.sum;
//        }
    }
}
