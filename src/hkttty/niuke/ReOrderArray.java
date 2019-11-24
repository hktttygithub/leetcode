package hkttty.niuke;

public class ReOrderArray {
    public void reOrderArray(int [] array) {
        if(array==null || array.length==0){
            return;
        }
        int x = -1;
        for(int i=0;i<array.length;i++){
            if(array[i]%2!=0){
                int temp = array[i];
                int index = i;
                while(index!=x && index!=0){
                    array[index] = array[index-1];
                    index --;
                }
                array[++x] = temp;
            }
        }
    }
}
