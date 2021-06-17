package com.han;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @version 1.0
 * @Author NL
 * @date 2020/4/25 16:05
 *
 * 实现功能：
 *      1.需求：
 *          模拟用户登录功能的实现
 *      2.业务描述：
 *          程序运行的时候，提供一个输入的入口，可以让用户输入用户名和密码
 *          用户输入用户名和密码之后，提交信息，java程序收集到用户信息后，连接数据库
 *          验证用户名和密码是否合法
 *          合法：登陆成功  不合法：登录失败
 *       3.数据的准备：
 *          在实际开发的过程中，表的设计会使用专业的建模工具：PowerDesigner
 *          使用PD工具来进行数据库表的设计
 */
public class JDBCTest06 {
    public static void main(String[] args) {
        //初始化一个界面
        Map<String,String> userLoginInfo = initUI();
        //验证用户名和密码
       boolean loginSuccess =  login(userLoginInfo);
            /*最后输出结果*/
        System.out.println(loginSuccess?"登录成功":"登录失败");
    }

    /**
     * 用户登录
     * @param userLoginInfo 包装了用户登录信息
     * @return  false -->失败   true-->成功
     */
    private static boolean login(Map<String, String> userLoginInfo) {
        //JDBC代码
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接
            DriverManager.getConnection("jdbc:mysql://localhost:3306/userLogin?serverTimezone=UTC","root","320923");
            //3.获取数据库操作对象
            stmt = conn.createStatement();
            //4.执行sql语句
            String sql = "select * from t_user where loginName = '"+userLoginInfo.get("LoginName")+"' and loginPwd = '"+userLoginInfo.get("loginPwd")+"'";
            stmt.executeQuery(sql);
            //5.处理结果集
            if (rs.next());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            //6.释放资源
            if (rs !=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt !=null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn !=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    /**
     * 初始化用户界面
     * @return 用户输入的用户名和密码等登录信息
     */
    private static Map<String, String> initUI() {
        Scanner s = new Scanner(System.in);
        System.out.println("用户名");
        String loginName = s.nextLine();
        System.out.println("密码");
        String loginPwd = s.nextLine();
        Map<String,String> userLoginInfo=new HashMap<>();
        userLoginInfo.put("loginName",loginName);
        userLoginInfo.put("loginPwd",loginPwd);
        return userLoginInfo;
    }


}
