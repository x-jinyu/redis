package test;

import dao.DeptDao;
import entity.Dept;

import java.util.List;
import java.util.Scanner;

/**
 * 王金宇
 * 2020/11/9 0009
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String deptNo, dname, loc;
        DeptDao dao = new DeptDao();
        Dept dept = null;
        List<Dept> deptList = null;


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
            dept = new Dept(Integer.valueOf(deptNo), dname, loc);
            flag = dao.insert(dept);
            if (flag != 0) {
                System.out.println("部门注册成功");
            }else {
                System.out.println("部门注册失败");
            }
            //查询服务
        } else if (flag == 2) {
            deptList = dao.findAll();
            for (Dept dept1 : deptList) {
                System.out.println("部门编号 "+dept1.getDeptNo()+" 部门名称 "+dept1.getDname()+" 部门位置 "+dept1.getLoc());
            }
            //注销服务
        } else if (flag == 3) {
            System.out.println("输入部门编号");
            deptNo = sc.next();

            flag = dao.delete(deptNo);
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

            dept = new Dept(Integer.valueOf(deptNo),dname, loc);
            flag = dao.update(dept);
            if (flag != 0) {
                System.out.println("部门修改成功");
            } else {
                System.out.println("部门修改失败");
            }
        }
    }
}
