package test.collection;

import org.junit.Test;

import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {
    class Student {
        int age;
        String name;

        public Student(String name, int age) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    TreeMap<Student, String> map = new TreeMap<Student, String>((o1, o2) -> {
        //主要条件
        int num = o1.getAge() - o2.getAge();

        //次要条件
        int num2 = num == 0 ? o1.getName().compareTo(o2.getName()) : num;

        return num2;
    });

    @Test
    public void test1() {
        //创建学生对象
        Student s1 = new Student("abc", 30);
        Student s2 = new Student("abcd", 30);
        //添加元素进集合
        map.put(s1, "宋朝");
        map.put(s2, "元朝");
//        map.put(null, "汉朝");

        //获取key集合
        Set<Student> set = map.keySet();

        //遍历key集合
        for (Student student : set) {
            String value = map.get(student);
            System.out.println(student + "---------" + value);
        }
    }


}
