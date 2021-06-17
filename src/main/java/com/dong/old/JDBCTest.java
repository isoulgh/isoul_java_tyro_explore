package com.dong.old;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Roger
 * @date 2020/5/29 11:09
 */
public class JDBCTest {

    public static final String driverName = "com.mysql.cj.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/XinGong?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
    public static final String user = "root";
    public static final String password = "toor";

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Student[] students = new Student[100];
        int length = 0;
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, user, password);
            st = conn.createStatement();
            String selectsql = "SELECT * FROM STUDENT";
            conn.setAutoCommit(false);
            rs = st.executeQuery(selectsql);
            while (rs.next()) {
                Student student = new Student(rs.getString(1), rs.getString("sname"), rs.getString("ssex"), rs.getDate(4), rs.getInt(5));
                students[length] = student;
                length++;
            }
            length--;
        } catch (Exception e) {
            e.printStackTrace();
        }

        //打印输出Student对象
        for (int i = 0; i <= length; i++) {
            System.out.println("-------------------");
            System.out.println(students[i]);
        }

    }

}
