package com.study.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/*
 * @author SMILE.Huang
 * @date 2021-05-13 15:31
 */
@Entity
public class Dept {
    private Integer deptno;
    private String dname;
    private String loc;
    private List<Emp> emps;

    @Id
    @Column(name = "deptno", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mysql的主键自动
    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    @Basic
    @Column(name = "dname", nullable = true, length = 20)
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Basic
    @Column(name = "loc", nullable = true, length = 255)
    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dept dept = (Dept) o;
        return Objects.equals(deptno, dept.deptno) &&
                Objects.equals(dname, dept.dname) &&
                Objects.equals(loc, dept.loc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptno, dname, loc);
    }

    @OneToMany(mappedBy = "mydept")
    @JsonIgnore  /*防止JSON序列化中自动获取多方数据，并进入死循环*/
    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }
}
