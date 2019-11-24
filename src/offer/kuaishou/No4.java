package offer.kuaishou;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class No4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int i = find(arr);
        System.out.println(i);
    }

    private static int find(int[] arr) {
        Arrays.sort(arr);
        int len = arr[arr.length - 1] - arr[0];
        int[][] dp1 = new int[arr.length][len + 1];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int diff = arr[i] - arr[j];
                dp1[i][diff] = Math.max(dp1[j][diff] + 1, dp1[i][diff]);
                System.out.print("dp1[" + i + "][" + diff + "]:" + dp1[i][diff] + "   i=" + i + "j=" + j + " ");
                res = Math.max(res, dp1[i][diff]);
            }
            System.out.println();
        }
        return res + 1;
    }

    @Test
    public void test1() {
        int[] arr = new int[]{0, 8, 45, 88, 48, 68, 28, 55, 17, 24};
        int i = find(arr);
        System.out.println(i);
    }
}
