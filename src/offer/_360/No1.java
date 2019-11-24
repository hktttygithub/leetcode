package offer._360;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class No1 {
    static int endPid;
    static LinkedHashMap<Integer,ArrayList<Integer>> map = new LinkedHashMap<>();
    static int []ppidArr;
    static int res=1;

    /*3 1 5 21 10
    0 3 3 1 5
    5*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] pid = sc.nextLine().split(" ");
        String[] ppid = sc.nextLine().split(" ");
        endPid = Integer.valueOf(sc.nextLine());
        input(pid);
        findSon(ppid);
        ArrayList<Integer> sonList = map.get(endPid);
        if (sonList==null){
            System.out.println(0);
            return;
        }
        go(sonList);
        System.out.println(res);
    }

    static void input(String []arr){
        ppidArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            Integer val = Integer.valueOf(arr[i]);
            map.put(val,new ArrayList<>());
            ppidArr[i] = val;
        }
    }

    static void findSon(String []ppid){
        for (int i=0;i<ppid.length;i++){
            int val  = Integer.valueOf(ppid[i]);
            if (val==0){
                continue;
            }else{
                ArrayList<Integer> son = map.get(val);
                son.add(ppidArr[i]);
            }
        }
    }

    private static void go(ArrayList<Integer> list) {
        if(list.size()==0){
            return;
        }
        int count = list.size();
        res = res + count;
        for (Integer index : list){
            ArrayList<Integer> sonList = map.get(index);
            go(sonList);
        }
    }
}
