package hkttty.jian.page1;

public class No7 {
    public int Fibonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int first = 0;
        int sec = 1;
        int res = 1;
        for(int i=2;i<=n;i++){
            res = first + sec;
            first = sec;
            sec = res;
        }
        return res;
    }
}
