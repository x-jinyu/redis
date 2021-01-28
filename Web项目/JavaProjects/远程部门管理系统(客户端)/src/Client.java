import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * 王金宇
 * 2020/11/7 0007
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String deptNo, dname, loc;
        String insertSql = "insert into dept values(?,?,?)";
        String selectSql = "select * from dept";
        String deleteSql = "delete from dept where deptno=?";
        String updateSql = "update dept set dname=?,loc=? where deptno=?";

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "123");
        PreparedStatement car = null;
        ResultSet table = null;

        System.out.println("---1.部门注册服务---");
        System.out.println("---2.部门查询服务---");
        System.out.println("---3.部门注销服务---");
        System.out.println("---4.部门更改服务---");
        System.out.println("请选择服务");
        int flag = sc.nextInt();

        //注册服务
        if (flag == 1) {
            System.out.println("输入部门编号");
            deptNo = sc.next();
            System.out.println("输入部门名称");
            dname = sc.next();
            System.out.println("输入部门地址");
            loc = sc.next();

            car = con.prepareStatement(insertSql);
            car.setString(1, deptNo);
            car.setString(2, dname);
            car.setString(3, loc);
            flag = car.executeUpdate();
            if (flag != 0) {
                System.out.println("部门注册成功");
            } else {
                System.out.println("部门注册失败");
            }
            //查询服务
        } else if (flag == 2) {
            car = con.prepareStatement(selectSql);
            table = car.executeQuery();
            while (table.next()) {
                deptNo = table.getString(1);
                dname = table.getString(2);
                loc = table.getString(3);
                System.out.println("部门编号" + deptNo + "部门编号" + dname + "部门编号" + loc);
            }
            //注销服务
        } else if (flag == 3) {
            System.out.println("输入部门编号");
            deptNo = sc.next();
            car = con.prepareStatement(deleteSql);
            car.setString(1, deptNo);
            flag = car.executeUpdate();
            if (flag != 0) {
                System.out.println("部门注销成功");
            } else {
                System.out.println("部门注销失败");
            }
        } else {
            System.out.println("请输入需要修改部门编号");
            deptNo = sc.next();
            System.out.println("请输入新部门名称");
            dname = sc.next();
            System.out.println("请输入新部门地址");
            loc = sc.next();

            car = con.prepareStatement(updateSql);
            car.setString(1,deptNo);
            car.setString(2,dname);
            car.setString(3,loc);

            flag = car.executeUpdate();
            if (flag != 0) {
                System.out.println("部门修改成功");
            } else {
                System.out.println("部门修改失败");
            }
        }

        if (table != null) {
            table.close();
        }
        if (car != null) {
            car.close();
        }
        if (con != null) {
            con.close();
        }
    }
}
