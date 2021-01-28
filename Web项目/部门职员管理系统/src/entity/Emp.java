package entity;

/**
 * 王金宇
 * 2020/11/20 0020
 */
public class Emp {
    private Integer empNo;
    private String  ename;
    private String  job;
    private Double  sal;
    private Double  comm;
    private Integer mgr;
    private String  hireDate;
    private Integer DeptNo;

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Double getComm() {
        return comm;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getDeptNo() {
        return DeptNo;
    }

    public void setDeptNo(Integer deptNo) {
        DeptNo = deptNo;
    }

    public Emp() {
    }

    public Emp(Integer empNo, String ename, String job, Double sal, Double comm, Integer mgr, String hireDate, Integer deptNo) {
        this.empNo = empNo;
        this.ename = ename;
        this.job = job;
        this.sal = sal;
        this.comm = comm;
        this.mgr = mgr;
        this.hireDate = hireDate;
        DeptNo = deptNo;
    }

    public Emp(Integer empNo) {
        this.empNo = empNo;
    }
}
