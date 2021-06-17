package com.dong.old;

import java.sql.Date;

/**
 * @author Roger
 * @date 2020/5/29 11:40
 */
public class Student {

    private String sno;
    private String sname;
    private String ssex;
    private Date sbirthday;
    private int sc;

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sbirthday=" + sbirthday +
                ", sc=" + sc +
                '}';
    }

    public Student() {
    }

    public Student(String sno, String sname, String ssex, Date sbirthday, int sc) {
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
        this.sbirthday = sbirthday;
        this.sc = sc;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public Date getSbirthday() {
        return sbirthday;
    }

    public void setSbirthday(Date sbirthday) {
        this.sbirthday = sbirthday;
    }

    public int getSc() {
        return sc;
    }

    public void setSc(int sc) {
        this.sc = sc;
    }

}
