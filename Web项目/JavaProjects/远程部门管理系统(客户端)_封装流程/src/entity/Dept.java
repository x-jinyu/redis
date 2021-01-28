package entity;

/**
 * 王金宇
 * 2020/11/9 0009
 */
public class Dept {
    private Integer deptNo;
    private String  dname;
    private String  loc;

    public Dept() {
    }

    public Dept(Integer deptNo, String dname, String loc) {
        this.deptNo = deptNo;
        this.dname = dname;
        this.loc = loc;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public Dept setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
        return this;
    }

    public String getDname() {
        return dname;
    }

    public Dept setDname(String dname) {
        this.dname = dname;
        return this;
    }

    public String getLoc() {
        return loc;
    }

    public Dept setLoc(String loc) {
        this.loc = loc;
        return this;
    }
}
