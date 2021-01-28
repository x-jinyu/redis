package dao;

import entity.Emp;
import util.JdbcUtil;
import util.ReflectUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 王金宇
 * 2020/11/20 0020
 */
public class EmpDao {
    //查找所有员工信息
    public List findAll() throws Exception {
        String sql = "select * from emp";
        List<Emp> empList = JdbcUtil.executeQuery(sql, Emp.class);
        return empList;
    }

    //注册员工信息
    public int insertEmp(Emp emp) throws Exception {
        String sql = null;
        int flag = 0;
        sql = ReflectUtil.createInsert(emp);
        try {
            flag = JdbcUtil.executeUpdate(sql);
        } finally {
            JdbcUtil.close();
        }
        return flag;
    }

    //删除员工
    public int empDelete(Emp emp) throws Exception {
        String sql = ReflectUtil.createDelete(emp, "empNo");
        int flag = JdbcUtil.executeUpdate(sql);
        JdbcUtil.close();
        return flag;
    }

    //查看详细信息
    public Emp findById(String empNo) throws Exception {
        ResultSet table = null;
        String sql = "select * from emp where empno=?";
        PreparedStatement car = JdbcUtil.getCar(sql);
        car.setString(1, empNo);
        table = car.executeQuery();
        List<Emp> empList = ReflectUtil.convertData(table, Emp.class);
        JdbcUtil.close(table);
        return empList.get(0);
    }

    //批处理删除
    public int empDeleteBatch(String empNoArray[]) throws Exception {
        int flag = 1;//表示删除成功
        String sql = "delete from emp where empNo=?";
        PreparedStatement car = JdbcUtil.getCar(sql);
        for (int i = 0; i < empNoArray.length; i++) {
            car.setString(1, empNoArray[i]);
            car.addBatch();
        }

        try {
            car.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            flag = 0;
        } finally {
            JdbcUtil.close();
        }
        return flag;
    }

    //修改
    public int empUpdate(Emp emp) throws Exception {
        int flag = 0;
        String sql = ReflectUtil.createUpdate(emp, "empNo");
        try {
            flag = JdbcUtil.executeUpdate(sql);
        } finally {
            JdbcUtil.close();
        }
        return flag;
    }

    //登录
    public int login(Emp emp)throws Exception{
        String sql = "select count(*) from emp where ename=? and empno=?";
        PreparedStatement car = JdbcUtil.getCar(sql);
        car.setString(1,emp.getEname());
        car.setInt(2,emp.getEmpNo());
        ResultSet table = car.executeQuery();
        table.next();
        int flag = table.getInt(1);
        JdbcUtil.close(table);
        return flag;
    }
}
