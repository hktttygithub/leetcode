package offer.bilibili;

import java.util.Scanner;

public class NO1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        if(s1==null || s2==null || s1.length()<=0 || s2.length()<=0){
            System.out.println(0);
            return;
        }
        int min = min(s1, s2);
        System.out.println(min);
    }
    static int min(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        int [][] dp = new int [m+1][n+1];
        for(int i=1;i<=m;i++){
            dp[i][0] = i;
        }
        for(int j=1;j<=n;j++){
            dp[0][j] = j;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = mathMin(
                            dp[i-1][j]+1,
                            dp[i][j-1]+1,
                            dp[i-1][j-1] + 1
                            );
            }
        }
        return dp[m][n];
        /*for(int j=1;j<=n2;j++){
            dp[0][j] = dp[0][j-1]+1;
        }
        for(int i=1;i<=n1;i++){
            dp[i][0] = dp[i-1][0] +1;
        }
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp [i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j]+1);
                }
            }
        }*/

    }

    private static int mathMin(int i, int i1, int i2) {
        return Math.min(i,Math.min(i1,i2));
    }
}
