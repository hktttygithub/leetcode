package hkttty.niuke;

import java.util.ArrayList;

public class MinK {

    ArrayList list = new ArrayList();

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input==null || input.length<=0 || k<=0 || k>input.length){
            return list;
        }
        for(int i=0;i<k;i++){
            heapInsert(input,i);
        }
        for(int i=k;i<input.length;i++){
            if(input[i]<input[0]){
                input[0] = input[i];
                heapify(input,k);
            }
        }
        for(int i=0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }

    void heapInsert(int []arr,int index){
        while(index>0){
            if(arr[index]>arr[(index-1)/2]){
                swap(arr,index,(index-1)/2);
                index = (index-1)/2;
            }else{
                return;
            }
        }
    }

    void heapify(int []arr,int size){
        int index = 0;
        int left = 1;
        while(left<size){
            int biggest = (left +1 < size && arr[left+1] > arr[left]) ?
                    left + 1 : left;
            int bigIndex = arr[biggest] > arr[index] ? biggest : index;
            if(bigIndex==index){
                return;
            }else{
                swap(arr,bigIndex,index);
                index = bigIndex;
                left = index * 2 +1;
            }
        }
    }

    private void swap(int []arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
