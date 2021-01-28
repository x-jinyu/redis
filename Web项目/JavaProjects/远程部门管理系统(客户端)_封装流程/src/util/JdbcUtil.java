package util;

import java.sql.*;

/**
 * 王金宇
 * 2020/11/9 0009
 */
public class JdbcUtil {
    private static PreparedStatement car;
    private static Connection con;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "123");
        return con;
    }

    public static PreparedStatement getCar(String sql) throws SQLException {
        car = getCon().prepareStatement(sql);
        return car;
    }

    public static void close() throws Exception{
        if (car != null){
            car.close();
        }
        if (con != null){
            con.close();
        }
    }

    public static void close(ResultSet table) throws Exception{
        if (table != null){
            table.close();
        }
        if (car != null){
            car.close();
        }
        if (con != null){
            con.close();
        }
    }
}
