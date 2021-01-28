package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 王金宇
 * 2020/11/9 0009
 * <p>
 * 1.加载Driver接口实现类
 * 2.建立连接通道
 * 3.建立交通工具
 * 4.推送并得到结果
 * 5.资源销毁
 */
public class JdbcUtil {
    private static Connection con;
    private static PreparedStatement car;

    //1)在类加载时就执行加载mysql包中的driver类
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //2)建立链接通道
    public static Connection getCon() throws Exception {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "123");
        return con;
    }

    //3)建立交通工具
    public static PreparedStatement getCar(String sql) throws Exception {
        car = getCon().prepareStatement(sql);
        return car;
    }

    //4)关闭通道销毁交通工具
    public static void close() throws Exception {
        if (car != null) {
            car.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public static void close(ResultSet table) throws Exception {
        if (table != null) {
            table.close();
        }
        close();
    }
    public static int executeUpdate (String sql)throws Exception{
        int flag = 0;
        car = getCar(sql);
        flag = car.executeUpdate();
        return flag;
    }
}
