package dao;

import entity.Dept;
import util.JdbcUtil;
import util.ReflectUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * 王金宇
 * 2020/11/19 0019
 */
public class DeptDao {
    public int insertDept(Dept dept) throws Exception {
        String sql = null;
        int flag = 0;

        sql = ReflectUtil.createInsert(dept);
        try {
            flag = JdbcUtil.executeUpdate(sql);
        } finally {
            JdbcUtil.close();
        }
        return flag;
    }

    public List findAllDept()throws Exception{
        String sql = "select * from dept";
        List<Dept> list = JdbcUtil.executeQuery(sql,Dept.class);
        return list;
    }

    //推送delete
    public int deptDelete(Dept dept)throws Exception{
        String sql = null;
        int flag = 0;
        sql = ReflectUtil.createDelete(dept,"deptNo");
        try {
            flag = JdbcUtil.executeUpdate(sql);
        } finally {
            JdbcUtil.close();
        }
        return flag;
    }

    //推送 select * from dept where deptno=?
    public Dept findById(String deptNo)throws Exception{
        ResultSet table = null;
        String sql = "select * from dept where deptNo=?";
        PreparedStatement car = JdbcUtil.getCar(sql);
        car.setString(1,deptNo);
        table = car.executeQuery();
        List<Dept> deptList = ReflectUtil.convertData(table,Dept.class);
        JdbcUtil.close(table);
        return deptList.get(0);
    }

    //修改
    public int deptUpdate(Dept dept)throws Exception{
        int flag = 0;
        //准备sql语句
        String sql = ReflectUtil.createUpdate(dept,"deptNo");
        //推送
        try {
            flag = JdbcUtil.executeUpdate(sql);
        } finally {
            JdbcUtil.close();
        }
        return flag;
    }
}
