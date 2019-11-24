package hkttty.niuke;

import org.junit.Test;

//数值的整数次方
public class Power {
    @Test
    public void test1(){
        double power = Power(2, 3);
    }

    public double Power(double base, int exponent) {
        if(exponent==0){
            return 1;
        }
        double number = 1;
        if(exponent>0){
            while(exponent==0){
                number  = base * number;
                exponent--;
            }
        }else{
            while(exponent==0){
                number = (1/base) * number;
                exponent--;
            }
        }
        return number;
    }
}
