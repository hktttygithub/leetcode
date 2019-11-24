package offer.kuaishou;

import java.util.Scanner;

public class No1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String go = go(str);
        System.out.println(go);
    }

    private static String go(String ip) {
        if (ip.startsWith(":") || ip.startsWith(".") || ip.endsWith(":") || ip.endsWith(".")) {
            return "Neither";
        }
        String[] split = ip.split("\\.");
        if (split.length == 4) {
            int num = 0;
            for (int i = 0; i < 4; i++) {
                try {
                    num = Integer.parseInt(split[i]);
                } catch (Exception e) {
                    return "Neither";
                }
                if (num < 0 || num > 255) {
                    return "Neither";
                }
            }
            return "IPV4";
        } else {
            String[] split1 = ip.split(":");
            if (split.length == 8) {
                int num = 0;
                for (int i = 0; i < 8; i++) {
                    int len = split[i].length();
                    if (split1[i] == null || len > 4 || len == 0) {
                        return "Neither";
                    }
                    for (int j = 0; j < len; j++) {
                        char c = split1[i].charAt(j);
                        if (!((c >= '0') && c <= '9') || (c >= 'a' && c <= 'f') || c >= 'A' && c <= 'F') {
                            return "Neither";
                        }
                    }
                }
                return "IPV6";
            } else {
                return "Neither";
            }
        }
    }
}
