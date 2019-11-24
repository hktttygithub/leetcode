package hkttty.niuke.xiaohongshu;

import java.util.*;

public class No2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashMap<Character,Integer> map = new HashMap<>();
        ArrayList<HashMap<Character,Integer>> list =
                new ArrayList<>();
        for(int i =0;i<str.length();i++){
            char c = str.charAt(i);
            if(i>0 && c!=str.charAt(i-1)){
                list.add(map);
                map = new HashMap<>();
            }
            if(!map.containsKey(c)){
                map.put(c,1);
            }else{
                map.put(c,map.get(c)+1);
            }
        }
        list.add(map);
        for(HashMap<Character,Integer> map1 : list){
            for (Character set :map1.keySet()){
                Integer count = map1.get(set);
                if(count!=1){
                    System.out.print(count-1);
                }
                System.out.print(set);
            }
        }

    }
}
