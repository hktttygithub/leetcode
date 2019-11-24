package test.jvm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class test1 {
    public static void main(String[] args) {
        ArrayList<Java3y> list1 = new ArrayList<>();
       Java3y java3y = new Java3y();
       java3y.setName("hk");
       list1.add(java3y);
       java3y.setName("uiii");

        System.out.println(list1.toString());
//        java3y=null;
        System.out.println(list1.get(0) == java3y);
//        System.out.println(list1.toString());

        Set set = new HashSet();

        for (int i = 0; i < 10; i++) {
            Object object = new Object();
            set.add(object);

            // 设置为空，这对象我不再用了
            object = null;
        }
        System.gc();
        // 但是set集合中还维护这obj的引用，gc不会回收object对象
        System.out.println(set);
    }
}
