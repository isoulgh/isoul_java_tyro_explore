package com.han;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @version 1.0
 * @Author NL
 * @date 2020/5/10 14:01
 */
public class StudentManager01 {
    public static void main(String[] args) {
    init i = new init();//控制台初始化界面
        method m = new method();//增删改查功能的实现
    i.StudentInit();
    System.out.println("请输入您想要执行的功能：");
        Scanner s = new Scanner(System.in);
        int item = s.nextInt();
        switch (item){
            case (1):{
                try {
                    m.insert();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            case (2):{

            }
            case (3):{

            }
            case (4):{

            }
            case (5):{

            }
            case (6):{

            }
        }
    }
}
