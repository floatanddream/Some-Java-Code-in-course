package FinalWorks;

import java.util.Scanner;
import java.sql.SQLException;

public class AdminManager {
    LogDataBase sqla = new LogDataBase();

    public AdminManager() throws SQLException {
    }

    void addItem() throws SQLException {
        Logistics log = new Logistics();
        //LogDataBase sqla = new LogDataBase();
        log.addItem();
        sqla.addSQL(log);
    }

    void showall() throws SQLException {

        // LogDataBase sqla = new LogDataBase();
        sqla.ShowALL();
    }

    void SearchSQL() throws SQLException {
        System.out.println("请输入需要寻找的快递ID(快递单号)");
        // LogDataBase sqla = new LogDataBase();
        Scanner sea = new Scanner(System.in);
        String seaid = sea.next();
        sqla.SearchInfo(seaid);
    }

    void UpdateItem() throws SQLException {
        System.out.println("请输入需要修改的快递ID(快递单号)");
        Scanner upd = new Scanner(System.in);
        String updid = upd.next();
        sqla.Updateinfo(updid);
    }

    void DeleteItem() throws SQLException {
        System.out.println("请输入需要删除的快递ID(快递单号)");
        Scanner Del = new Scanner(System.in);
        String DelID = Del.next();
        sqla.DeleteInfo(DelID);
    }

    void ManUI() throws SQLException {
        Boolean Loop = true;
        while (Loop) {
            LoginMenu.clearScreen();
            System.out.println("\t\t--------------物流信息管理系统----------------------------");
            System.out.println("\t\t\t      已登录身份：主管管理员");
            System.out.println("\t\t\t\t1.添加物流信息");
            System.out.println("\t\t\t\t2.显示所有物流信息");
            System.out.println("\t\t\t\t3.查找目标物流信息");
            System.out.println("\t\t\t\t4.修改目标物流信息");
            System.out.println("\t\t\t\t5.删除目标物流信息");
            // System.out.println("\t\t\t\t6.查看系统回收站信息");
            // System.out.println("\t\t\t\t7.将物流数据表转换为新的可视化数据文件");
            System.out.println("\t\t\t\t6.退出并返回登录界面");
            System.out.println("\t\t----------------------------------------------------------");
            System.out.println("请输入操作：");
            Scanner choice = new Scanner(System.in);
            int sel = choice.nextInt();
            switch (sel) {
                case 1: {
                    System.out.println("您的选项：1.添加物流信息");
                    addItem();
                    break;
                }
                case 2: {
                    System.out.println("您的选项：2.显示所有物流信息");
                    showall();
                    break;
                }
                case 3: {
                    System.out.println("您的选项：3.查找目标物流信息");
                    SearchSQL();
                    break;
                }
                case 4: {
                    System.out.println("您的选项：4.修改目标物流信息");
                    UpdateItem();
                    break;
                }
                case 5: {
                    System.out.println("您的选项：5.删除目标物流信息");
                    DeleteItem();
                    break;
                }
                case 6: {
                    System.out.println("您的选项：6.退出");
                    Loop = false;
                    break;
                }
                default:
                {
                    System.out.println("输入有误！请重新输入");
                }
            }
            LoginMenu.pauseScreen();
        }
    }
}
