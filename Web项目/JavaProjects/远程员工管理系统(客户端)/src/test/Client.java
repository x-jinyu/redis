package test;

import dao.EmpDao;
import entity.Emp;

import java.util.List;
import java.util.Scanner;

/**
 * 王金宇
 * 2020/11/9 0009
 */
public class Client {
    public static void main(String[] args) throws Exception {
        var i = 11;
        System.out.println(i);
        Scanner sc = new Scanner(System.in);
        int flag = 0;
        Integer empNo,sal,comm,deptNo,mgr;
        String ename,job,hireDate;
        EmpDao dao = new EmpDao();
        Emp emp = null;
        List<Emp> empList = null;
        System.out.println("---1.员工注册服务---");
        System.out.println("---2.员工查询服务---");
        System.out.println("---3.员工注销服务---");
        System.out.println("---4.员工更改服务---");
        System.out.println("请选择服务");
        flag = sc.nextInt();

        if (flag == 1) {

            //1.读取用户提供新部门信息
            System.out.println("请输入新员工编号");
            empNo = sc.nextInt();
            System.out.println("请输入新员工姓名");
            ename = sc.next();
            System.out.println("请输入新员工值位");
            job = sc.next();
            System.out.println("请输入新员工领导编号");
            mgr = sc.nextInt();
            System.out.println("请输入新员工入职日期");
            hireDate = sc.next();
            System.out.println("请输入新员工工资");
            sal = sc.nextInt();
            System.out.println("请输入新员工补助");
            comm = sc.nextInt();
            System.out.println("请输入新员部门编号");
            deptNo = sc.nextInt();
            //2.帮助用户将新部门添加到远程部门表
            emp = new Emp(empNo, ename, job,mgr,hireDate,sal,comm,deptNo);
            flag = dao.insert(emp);
            //3.将处理结果进行润色返回给用户
            if (flag == 0) {
                System.out.println("部门注册失败");
            } else {
                System.out.println("部门注册成功");
            }


        } else if (flag == 2) {
            empList = dao.findAll();
            for (Emp emp1 : empList) {
                //empNo,ename,job,mgr,hireDate,sal,comm,deptNo
                System.out.println("员工编号 " + emp1.getEmpNo() + " 员工姓名 " + emp1.getEname() + " 员工职位 " + emp1.getJob() + " 员工领导编号 " + emp1.getMgr() + " 员工入职日期 " + emp1.getHireDate() + " 员工工资 " + emp1.getSal() + " 员工补助 " + emp1.getComm()+" 员工部门编号 "+emp1.getDeptNo());
            }
        } else if (flag == 3) {
            //1.获得用户需要删除部门编号
            System.out.println("请输入要删除员工编号");
            empNo = sc.nextInt();
            //2.将部门从远程服务器删除
            flag = dao.delete(new Emp(empNo, null, null,null,null,null,null,null));
            //3.将业务处理结果返回
            if (flag != 0) {
                System.out.println("员工注销成功");
            } else {
                System.out.println("员工注销失败");
            }
        } else {
            //1.读取用户提供新部门信息
            System.out.println("请输入需要更新部门编号");
            deptNo = sc.nextInt();
            System.out.println("请输入新部门名称");
            ename = sc.next();
            System.out.println("请输入新部门地址");
            /*loc = sc.next();

            dept = new Dept(Integer.valueOf(deptNo), dname, loc);
            flag = dao.update(dept);

            if (flag == 0) {
                System.out.println("部门更新失败");
            } else {
                System.out.println("部门更新成功");
            }*/
        }
    }
}
