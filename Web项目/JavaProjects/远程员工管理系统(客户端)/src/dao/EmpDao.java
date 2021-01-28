package dao;

import entity.Emp;
import util.JdbcUtil;
import util.ReflectUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 王金宇
 * 2020/11/9 0009
 */
public class EmpDao {

    //insert
    public int insert(Emp emp) throws Exception {
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

    //delete
    public int delete(Emp emp) throws Exception {
        String sql = null;
        int flag = 0;
        sql = ReflectUtil.createDelete(emp, "empNo");
        try {
            flag = JdbcUtil.executeUpdate(sql);
        } finally {
            JdbcUtil.close();
        }
        return flag;
    }

    //update
    public int update(Emp emp) throws Exception {
        String sql = null;
        int flag = 0;
        sql = ReflectUtil.createUpdate(emp, "empNo");
        try {
            flag = JdbcUtil.executeUpdate(sql);
        } finally {
            JdbcUtil.close();
        }
        return flag;
    }

    public List findAll() throws Exception {
        String sql = "select * from emp";
        PreparedStatement car = JdbcUtil.getCar(sql);
        ResultSet table = null;
        List list = new ArrayList();
        try {

            table = car.executeQuery();
            while (table.next()) {
                Integer empNo = table.getInt(1);
                String ename = table.getString(2);
                String job = table.getString(3);
                Integer mgr = table.getInt(4);
                String hireDate = table.getString(5);
                Integer sal = table.getInt(6);
                Integer comm = table.getInt(7);
                Integer deptNo = table.getInt(8);
                Emp emp = new Emp(empNo, ename, job, mgr, hireDate, sal, comm, deptNo);
                list.add(emp);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(table);
        }
        return list;
    }
}
