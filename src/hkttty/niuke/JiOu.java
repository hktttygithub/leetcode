package hkttty.niuke;
//题目描述
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
// 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。


//这个解法不能保证相对位置不变
public class JiOu {
    public void reOrderArray(int [] array) {
        if(array==null || array.length<=1){
            return;
        }
        int left = 0;
        int right = array.length-1;
        while (left<right){
            while (left<right && ((array[left]&1)==1)){
                left++;
            }
            while (left<right && ((array[right]&1)==0)){
                right--;
            }
            if(left<right){
                array[left] = array[left] ^ array[right];
                array[right] = array[left] ^ array[right];
                array[left] = array[left] ^ array[right];
            }
        }

    }

    public void reOrderArray2(int [] array) {
        int []help = new int[array.length];
        int index=0;
        for(int i=0;i<array.length;i++){
            if((array[i]&1)==1){
                help[index++] = array[i];
            }
        }
        for(int i=0;i<array.length;i++){
            if((array[i]&1)==0){
                help[index++] = array[i];
            }
        }
        for(int i=0;i<array.length;i++){
            array[i] = help[i];
        }
    }
}
