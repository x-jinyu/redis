package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * 王金宇
 * 2020/11/19 0019
 */
public class JdbcUtil {
    private static Connection con;
    private static PreparedStatement car;

    //加载Driver接口实现类(加载驱动)
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //建立流通道
    public static Connection getCon() throws Exception {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "123");
        return con;
    }

    //建立交通工具
    public static PreparedStatement getCar(String sql) throws Exception {
        car = getCon().prepareStatement(sql);
        return car;
    }

    //关闭通道并销毁交通工具
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

    public static int executeUpdate(String sql) throws Exception {
        int flag = 0;
        car = getCar(sql);
        flag = car.executeUpdate();
        return flag;
    }

    public static List executeQuery(String dql, Class classFile) throws Exception {
        List list;
        ResultSet table = null;
        try {
            car = getCar(dql);
            table = car.executeQuery();
            list = ReflectUtil.convertData(table,classFile);
        } finally {
            if (table!=null){
                table.close();
            }
        }
        return list;
    }
}
