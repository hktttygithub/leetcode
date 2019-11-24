package test.thread;

import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;

public class HashSetTest {
    class Student{
        int id;

        public Student(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return id == student.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
    @Test
    public void test1(){
        Object o = new Object();
        o.equals("213");

        Student s1 = new Student(100);
        Student s2 = new Student(100);
        HashSet<Student> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        System.out.println("集合数:"+ set.size());
    }
}
