package entity;

/**
 * 王金宇
 * 2020/11/9 0009
 */
public class Emp {
    private Integer empNo;
    private String  ename;
    private String  job;
    private Integer mgr;
    private String  hireDate;
    private Integer sal;
    private Integer comm;
    private Integer deptNo;

    public Emp() {
    }

    public Emp(Integer empNo, String ename, String job, Integer mgr, String hireDate, Integer sal, Integer comm, Integer deptNo) {
        this.empNo = empNo;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hireDate = hireDate;
        this.sal = sal;
        this.comm = comm;
        this.deptNo = deptNo;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public Emp setEmpNo(Integer empNo) {
        this.empNo = empNo;
        return this;
    }

    public String getEname() {
        return ename;
    }

    public Emp setEname(String ename) {
        this.ename = ename;
        return this;
    }

    public String getJob() {
        return job;
    }

    public Emp setJob(String job) {
        this.job = job;
        return this;
    }

    public Integer getMgr() {
        return mgr;
    }

    public Emp setMgr(Integer mgr) {
        this.mgr = mgr;
        return this;
    }

    public String getHireDate() {
        return hireDate;
    }

    public Emp setHireDate(String hireDate) {
        this.hireDate = hireDate;
        return this;
    }

    public Integer getSal() {
        return sal;
    }

    public Emp setSal(Integer sal) {
        this.sal = sal;
        return this;
    }

    public Integer getComm() {
        return comm;
    }

    public Emp setComm(Integer comm) {
        this.comm = comm;
        return this;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public Emp setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
        return this;
    }
}
