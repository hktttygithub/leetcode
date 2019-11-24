package offer.mafengwo;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class No1 {
    //key : 用户id
    //value : 城市名

    static Map<String,Integer> mapUser =new HashMap<>();
    static HashMap<String,Integer> mapCity =new HashMap<>();/*();*/
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        for(int i=0;i<s.length;i++){
            String[] split = s[i].split("-");
            go(split[0],split[1]);
        }

        for(String set :mapCity.keySet()){
            list.add(set + " " + (mapCity.get(set)));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int val = o2.charAt(o2.length()-1) - o1.charAt(o1.length()-1);
                if(val!=0){
                    return val;
                }else{
                    String city1 = o1.split(" ")[0];
                    String city2 = o2.split(" ")[0];
                    for(int i =0 ; i< city1.length();i++){
                        char c1 = city1.charAt(i);
                        char c2 = city2.charAt(i);
                        if(c1-c2==0){
                            continue;
                        }else{
                            return c1 - c2;
                        }
                    }
                    return 0;
                }
            }
        });
        for (int i = 0 ;i<3;i++){
            System.out.println(list.get(i));
        }
    }

    static void go(String userId,String city){
        if(!mapUser.containsKey(userId+city)){
            mapUser.put(userId+city,1);

            if(!mapCity.containsKey(city)){
                mapCity.put(city,1);
            }else{
                mapCity.put(city,mapCity.get(city)+1);
            }
        }else{
            return;
        }
    }
}
