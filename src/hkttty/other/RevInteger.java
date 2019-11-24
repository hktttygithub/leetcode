package hkttty.other;

import org.junit.Test;

//输入一个整形，逆序返回（用递归来实现）
public class RevInteger {
    int count=1;

    @Test
    public void test1(){

        int i = revRev(12340);
//        int i = revPrint2(12340);
        System.out.println(i);
    }

    //如果只实现逆序输出
    //健壮性不足
    void revPrint(int number){
        if (number==0)
            return;
        System.out.print(number%10 + " ");
        revPrint(number/10);
    }


    //这个就没问题了，稳地一批
    int revPrint2(int number){
        if(number==0){
            return 0;
        }
        int sum = revPrint2(number/10) + number%10 * count;
        count = count * 10;
        return sum;
    }

    //用字符串
    int rev(int number){
        StringBuffer str = new StringBuffer(String.valueOf(number));
//        System.out.println(str);
        str.reverse();
//        System.out.println(str);
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0'){
                str.deleteCharAt(i);
            }else {
                break;
            }
        }
        return Integer.valueOf(str.toString());
    }


    //再写一遍递归
    int revRev(int number){
        if(number==0){
            return 0;
        }
        int sum = revRev(number/10) + number%10 * count;
        count *= 10;
        return sum;
    }

}
