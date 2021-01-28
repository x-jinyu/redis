package dao;

import entity.Dept;
import util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 王金宇
 * 2020/11/9 0009
 */
public class DeptDao {
    //对Dept表进行insert操作流程
    public int insert(Dept dept) throws Exception{
        String sql = "insert into dept (deptno,dname,loc) values(?,?,?)";
        PreparedStatement car = JdbcUtil.getCar(sql);
        int flag = 0;
        try {
            car.setInt(1, dept.getDeptNo());
            car.setString(2, dept.getDname());
            car.setString(3, dept.getLoc());
            flag = car.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtil.close();
        }
        return flag;
    }

    public int delete(String deptNo)throws Exception{
        String sql = "delete from dept where deptno=?";
        PreparedStatement car = JdbcUtil.getCar(sql);
        int flag = 0;
        try {
            car.setString(1,deptNo);
            flag = car.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return flag;
    }

    public int update(Dept dept) throws Exception{
        String sql = "update dept set dname=?,loc=? where deptNO=?";
        PreparedStatement car = JdbcUtil.getCar(sql);
        int flag = 0;
        try {
            car.setString(1,dept.getDname());
            car.setString(2,dept.getLoc());
            car.setInt(3,dept.getDeptNo());
            flag = car.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close();
        }
        return flag;
    }

    public List findAll() throws Exception{
        String sql = "select * from dept";
        PreparedStatement car = JdbcUtil.getCar(sql);
        ResultSet table = null;
        List list = new ArrayList();
        try {
            table = car.executeQuery();
            while (table.next()){
                Integer deptNo = table.getInt(1);
                String dname = table.getString(2);
                String loc = table.getString(3);
                Dept dept = new Dept(deptNo, dname, loc);
                list.add(dept);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(table);
        }
        return list;
    }
}
