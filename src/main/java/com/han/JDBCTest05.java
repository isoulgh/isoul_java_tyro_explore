package com.han;

import java.sql.*;

/**
 * @version 1.0
 * @Author NL
 * @date 2020/4/25 14:20
 * 处理查询结果集  (遍历结果集
 * )
 */
public class JDBCTest05 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;//结果集
        //1.注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/work1?serverTimezone=UTC","root","320923");
            //3.建立数据库对象
            stmt=conn.createStatement();
            //4.执行sql语句
            String sql = "select id,name,department from person";
//            stmt.executeUpdate(insert/delete/update);    此处只能执行 增删改等功能
            rs = stmt.executeQuery(sql);/*专门执行查询语句DQL，返回单个result对象*/
            //next:只要调用光标往下都一行，如果该行有数据，则返回true**********
                while (rs.next())   {
                    //光标指向的行有数据
                    //取数据
                    //getString（）:不管数据库中的数据类型是什么，都以String的形式取出
                // getInt  getDouble 除了可以以string类型取出，还可以以需要的类型转出
                    String id = rs.getString(1);/*jbdc中所有下标从1开始*/
                    String name = rs.getString("name");//getString中的参数表示列数
                    String department = rs.getString("department");//可以以列的名字来获取，如果列名重新命名之后，则需要改名***********
                    System.out.println(id+","+name+","+department);
                }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs !=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt !=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn !=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
