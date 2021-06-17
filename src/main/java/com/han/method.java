package com.han;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @version 1.0
 * @Author NL
 * @date 2020/5/10 15:30
 */
public class method {
    public static void main(String[] args) {

    }
    //资源绑定器
//    ResourceBundle bundle = ResourceBundle.getBundle("Bundle");
//    String driver = bundle.getString("driver");
//    String url = bundle.getString("url");
//    String user = bundle.getString("user");
//    String password = bundle.getString("password");

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    Scanner s = new Scanner(System.in);
    public void insert() throws ClassNotFoundException, SQLException {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //建立连接
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanager?serverTimezone=UTC","root","320923");
        //获取操作对象
        stmt = conn.createStatement();
        String table = null;
        System.out.println("请输入目的表序号（学生信息表：1，课程信息表：2，家长信息表：3）");
        int tableNum = s.nextInt();
        switch (tableNum){

            case 1:{
                System.out.println("请依次输入学生信息(学号，姓名，班级，年龄，班主任，选课号，成绩，父母姓名)：");
                String num = s.nextLine();
                String name = s.nextLine();
                String classnum = s.nextLine();
                String age = s.nextLine();
                String headmaster = s.nextLine();
                String curriculum = s.nextLine();
                String grades = s.nextLine();
                String parentsname = s.nextLine();
                table = "studentinformation";
                String sql = "insert into '"+table+"' values('"+num+"','"+name+"','"+classnum+"','"+age+"','"+headmaster+"','"+curriculum+"','"+grades+"','"+parentsname+"') ";
               int count =  stmt.executeUpdate(sql);
               System.out.println(count==1?"添加成功":"添加失败");
            }
            case 2:{
                System.out.println("请输入课程号及课程名称");
                int classnum = s.nextInt();
                String classname = s.next();
//                String classnum = s.nextLine();
//                String classname = s.nextLine();
                table = "class";
                String sql = "insert into '"+table+"' values('"+classnum+"','"+classname+"')";
                int count = stmt.executeUpdate(sql);
                System.out.println(count==1?"添加成功":"添加失败");
            }
            case 3:{
                System.out.println("请输入家长姓名以及联系电话");
                String parentsname = s.nextLine();
                String phonenum = s.nextLine();
                table = "parentsinformation";
                String sql = "insert into '"+table+"' values('"+parentsname+"','"+phonenum+"')";
                int count = stmt.executeUpdate(sql);
                System.out.println(count==1?"添加成功":"添加失败");
            }
        }if (stmt!=null){
            stmt.close();
        }
    }
}
