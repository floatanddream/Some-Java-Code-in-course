package FinalWorks;

import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class LoginMenu {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://toxicgb.xyz:3306/javatestgb";
    static final String USER = "JavaTestGB";
    static final String PassWord = "M4wie4BWBWYDyKK6";
    static Connection connect;
    static Statement state;

    static {
        try {
            connect = DriverManager.getConnection(DB_URL, USER, PassWord);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            state = connect.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public LoginMenu() throws SQLException {

    }

    public static void main(String[] a) throws SQLException {
        while (true) {
            clearScreen();
            Login();
        }
    }

    static void Login() {
        System.out.println("--------------物流信息管理系统----------------------------");
        Scanner Logi = new Scanner(System.in);
        System.out.println("请输入用户名与密码");
        String UserN = Logi.next();
        System.out.println("请输入用户名" + UserN + "的密码");
        String UserPassWord = Logi.next();
        String LoginSql = "SELECT * FROM JavaUser WHERE UserName = '" + UserN + "'";
        try (

                ResultSet resultSet = state.executeQuery(LoginSql)

        ) {
            if (resultSet.next()) {
                String User_ID = resultSet.getString("UserID");
                String User_Name = resultSet.getString("UserName");
                String User_P = resultSet.getString("UserPassword");
                int User_Pri = resultSet.getInt("UserPri");
               // System.out.println(User_ID + User_Pri + User_Name);
                if (Objects.equals(UserPassWord, User_P)) {
                    System.out.println("登陆成功！");
                    System.out.flush();
                    if (User_Pri == 1) {
                        AdminManager Man = new AdminManager();
                        Man.ManUI();
                    } else if (User_Pri == 0) {
                        EmployeeUser Cus = new EmployeeUser();
                        Cus.CusUI();
                    }
                } else {
                    System.out.println("密码错误！");
                    pauseScreen();
                }
            } else {
                System.out.println("未找到用户");
                pauseScreen();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 清屏命令
    static void clearScreen()
    {
        try {
            new ProcessBuilder("cmd", "/c", "cls")
                    .inheritIO()
                    .start()
                    .waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void pauseScreen()
    {
        try {
            new ProcessBuilder("cmd", "/c", "pause")
                    .inheritIO()
                    .start()
                    .waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


