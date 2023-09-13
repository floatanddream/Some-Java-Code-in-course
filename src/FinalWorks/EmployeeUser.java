package FinalWorks;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeUser {

    AdminManager Ext = new AdminManager();

    public EmployeeUser() throws SQLException {

    }

    void CusUI() throws SQLException {
        boolean Loop = true;
        while (Loop) {
            LoginMenu.clearScreen();
            System.out.println("\t\t--------------物流信息管理系统----------------------------");
            System.out.println("\t\t\t      已登录身份：员工");
            System.out.println("\t\t\t\t1.添加物流信息");
            System.out.println("\t\t\t\t2.查找目标物流信息");
            System.out.println("\t\t\t\t3.修改目标物流信息");
            System.out.println("\t\t\t\t4.退出并返回登录界面");
            System.out.println("\t\t----------------------------------------------------------");
            System.out.println("请输入操作：");
            Scanner choice = new Scanner(System.in);
            int sel = choice.nextInt();
            switch (sel) {
                case 1: {

                    System.out.println("您的选项：1.添加物流信息");
                    Ext.addItem();
                    break;
                }
                case 2: {
                    System.out.println("您的选项：2.查找目标物流信息");
                    Ext.SearchSQL();
                    break;
                }

                case 3: {
                    System.out.println("您的选项：3.修改目标物流信息");
                    Ext.UpdateItem();
                    break;
                }
                case 4: {
                    System.out.println("您的选项：4.退出");
                    Loop = false;
                    break;
                }
                default: {
                    System.out.println("输入有误！请重新输入");
                }
            }
            LoginMenu.pauseScreen();
        }
    }
}


