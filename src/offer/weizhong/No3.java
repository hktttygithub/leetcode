package offer.weizhong;

import java.util.*;

public class No3 {
    //输入
    //第一行有两个整数,n,m分别表示景点数量，路的数量(1<=n<=100,1<=m<=n(n-1)/2)。
    //       接下来有m行，每行有两个正整数u和v，表示u景点和v景点之间存在一条路径。
    //       最后一行是两个正整数 s，t，表示入口所在景点的编号和出口所在景点的编号。(1<=s,t<=n)
    //输出
    //输出仅包含k个整数，表示该游客永远不可能经过的景点，要求编号从小到大，k为不可能经过的景点数量，不需要输出。
    static HashMap<Integer, ArrayList<Integer>> map1 = new HashMap<>();
    static TreeSet<Integer> del = new TreeSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i =0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            addToMap(u,v);
            addToMap(v,u);
            del.add(u);
            del.add(v);
        }
        int ru = sc.nextInt();
        int chu = sc.nextInt();
        go(ru,chu,new HashSet<Integer>());
        for(int val : del){
            System.out.print(val + " ");
        }
    }

    private static void go(int ru, int chu,HashSet<Integer> help) {
        if(!help.add(ru)){
            return;
        }
        if(ru==chu){
            for (Integer val : help){
                if(del.contains(val)){
                    del.remove(val);
                }
            }
            help.remove(ru);
            return;
        }
        ArrayList<Integer> list = map1.get(ru);
        for(Integer val : list){
            go(val,chu,help);
        }
        help.remove(ru);
    }

    private static void addToMap(int n1,int n2) {
        if(!map1.containsKey(n1)){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(n2);
            map1.put(n1,list);
        }else{
            ArrayList<Integer> list = map1.get(n1);
            list.add(n2);
        }
    }
}
