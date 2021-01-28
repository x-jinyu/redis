package homework3;

import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

/**
 * 王金宇
 * 2020/10/19 0019
 */
public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        Set<Student> set = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            set.add(new Student(random.nextInt(20),random.nextInt(20), random.nextInt(20)));
        }
        System.out.println(set);
    }

    static class Student {
        int id;
        int grade;
        int score;

        public Student(int id, int grade, int score) {
            this.id = id;
            this.grade = grade;
            this.score = score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return id == student.id &&
                    grade == student.grade &&
                    score == student.score;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, grade, score);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", grade=" + grade +
                    ", score=" + score +
                    '}';
        }
    }
}
