package homework1;

/**
 * 王金宇
 * 2020/10/17 0017
 */
public class Student {
    String id;
    String name;
    int score;

    public Student(String id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
