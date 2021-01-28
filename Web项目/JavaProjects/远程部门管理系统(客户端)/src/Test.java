import java.sql.DriverManager;

/**
 * 王金宇
 * 2020/11/7 0007
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root","123");
    }
}
