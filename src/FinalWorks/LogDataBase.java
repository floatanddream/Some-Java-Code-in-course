package FinalWorks;

import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class LogDataBase {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://toxicgb.xyz:3306/javatestgb";
    static final String USER = "JavaTestGB";
    static final String PassWord = "M4wie4BWBWYDyKK6";

    Connection connect = DriverManager.getConnection(DB_URL, USER, PassWord);
    Statement state = connect.createStatement();


    public LogDataBase() throws SQLException {

    }


    //获取最大的id以便添加新的条目
    public String GETMAXID() throws SQLException {
        String maxid = "SELECT LogID\n" +
                "FROM Logistics\n" +
                "ORDER BY LogID DESC\n" +
                "LIMIT 1;";
        ResultSet id = state.executeQuery(maxid);
        String Res = null;
        while (id.next()) {
            // 通过字段检索

            Res = id.getString("LogID");
        }

        return Res;
    }

    //添加信息条目
    public void addSQL(Logistics log) throws SQLException {

        String sqlsent = "INSERT INTO Logistics (LogID, LogType, LogQual, LogSend, LogRec, LogTime, LogSendADD, LogRecADD, LogTimeS, LogSendTEL, LogRecTEL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connect.prepareStatement(sqlsent);
        statement.setInt(1, log.LogID);
        statement.setString(2, log.LogType);
        statement.setString(3, log.LogQual);
        statement.setString(4, log.LogSend);
        statement.setString(5, log.LogRec);
        statement.setString(6, log.LogTime);
        statement.setString(7, log.LogSendADD);
        statement.setString(8, log.LogRecADD);
        statement.setString(9, log.LogTimeS);
        statement.setString(10, log.LogSendTEL);
        statement.setString(11, log.LogRecTEL);

        // 执行插入操作
        int rowsAffected = statement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("添加成功！");
        } else {
            System.out.println("添加失败！");
        }
    }

    //显示所有信息条目
    void ShowALL() throws SQLException {
        String sql = "SELECT * FROM Logistics";
        try (

                ResultSet resultSet = state.executeQuery(sql)
        ) {
            // 输出·物流信息
            while (resultSet.next()) {
                String logID = resultSet.getString("LogID");
                String logType = resultSet.getString("LogType");
                String logQual = resultSet.getString("LogQual");
                String logSend = resultSet.getString("LogSend");
                String logRec = resultSet.getString("LogRec");
                String logTime = resultSet.getString("LogTime");
                String logSendADD = resultSet.getString("LogSendADD");
                String logRecADD = resultSet.getString("LogRecADD");
                String logTimeS = resultSet.getString("LogTimeS");
                String logSendTEL = resultSet.getString("LogSendTEL");
                String logRecTEL = resultSet.getString("LogRecTEL");

                System.out.print("物流编号: " + logID);
                System.out.print("\t物流类型: " + logType);
                System.out.println("\t快件重量: " + logQual);
                System.out.print("发货人: " + logSend);
                System.out.println("\t收货人: " + logRec);
                System.out.print("可视时间: " + logTime);
                System.out.println("\t时间戳: " + logTimeS);
                System.out.println("发货地址: " + logSendADD);
                System.out.println("收货地址: " + logRecADD);
                System.out.println("发货人电话: " + logSendTEL);
                System.out.println("收货人电话: " + logRecTEL);
                System.out.println("----------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    boolean SearchInfo(String targetID) {
        String sql = "SELECT * FROM Logistics WHERE LogID = '" + targetID + "'";
        try (
                // 执行查询
                ResultSet resultSet = state.executeQuery(sql)
        ) {

            if (resultSet.next()) {

                String logID = resultSet.getString("LogID");
                String logType = resultSet.getString("LogType");
                String logQual = resultSet.getString("LogQual");
                String logSend = resultSet.getString("LogSend");
                String logRec = resultSet.getString("LogRec");
                String logTime = resultSet.getString("LogTime");
                String logSendADD = resultSet.getString("LogSendADD");
                String logRecADD = resultSet.getString("LogRecADD");
                String logTimeS = resultSet.getString("LogTimeS");
                String logSendTEL = resultSet.getString("LogSendTEL");
                String logRecTEL = resultSet.getString("LogRecTEL");

                // 输出目标信息
                System.out.print("物流编号: " + logID);
                System.out.print("\t物流类型: " + logType);
                System.out.println("\t快件重量: " + logQual);
                System.out.print("发货人: " + logSend);
                System.out.println("\t收货人: " + logRec);
                System.out.print("可视时间: " + logTime);
                System.out.println("\t时间戳: " + logTimeS);
                System.out.println("发货地址: " + logSendADD);
                System.out.println("收货地址: " + logRecADD);
                System.out.println("发货人电话: " + logSendTEL);
                System.out.println("收货人电话: " + logRecTEL);
                return true;
            } else {
                System.out.println("未找到目标信息");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    void Updateinfo(String UpdateID) throws SQLException {
        boolean exist = SearchInfo(UpdateID);
        if (!exist) {
            System.out.println("未找到匹配的ID:" + UpdateID);
        } else {
            System.out.println("-----------以上是您要修改的信息------------\n确定继续?(yes/no)");
            Scanner sure = new Scanner(System.in);
            String choice = sure.next();
            if (Objects.equals(choice, "yes") || Objects.equals(choice, "YES")) {
                Scanner update = new Scanner(System.in);
                System.out.println("请输入" + UpdateID + "物流类型信息");
                String newLogType = update.next();
                System.out.println("请输入" + UpdateID + "物流的重量信息");
                String newLogQual = update.next();
                System.out.println("请输入" + UpdateID + "物流的发货人");
                String newLogSend = update.next();
                System.out.println("请输入" + UpdateID + "物流的收货人");
                String newLogRec = update.next();
                System.out.println("请输入" + UpdateID + "物流的发货地址");
                String newLogSendADD = update.next();
                System.out.println("请输入" + UpdateID + "物流的收货地址");
                String newLogRecADD = update.next();
                System.out.println("请输入" + UpdateID + "物流的发货人电话");
                String newLogSendTEL = update.next();
                System.out.println("请输入" + UpdateID + "物流的收货人电话");
                String newLogRecTEL = update.next();
                try {   // String updateSql="UPDATE Logistics SET ";
                    String updatesql = "UPDATE Logistics SET LogType = '" + newLogType + "', LogQual = '" + newLogQual +
                            "', LogSend = '" + newLogSend + "', LogRec = '" + newLogRec +
                            "', LogSendADD = '" + newLogSendADD + "', LogRecADD = '" + newLogRecADD +
                            "', LogSendTEL = '" + newLogSendTEL +
                            "', LogRecTEL = '" + newLogRecTEL + "' WHERE LogID = '" + UpdateID + "'";

                    int rowsAffected = state.executeUpdate(updatesql);
                    if (rowsAffected > 0) {
                        System.out.println("成功更新 " + rowsAffected + " 条物流信息。目标ID:" + UpdateID);
                    } else {
                        System.out.println("未找到匹配的记录，更新失败");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("操作取消！");
            }
        }
    }

    void DeleteInfo(String DelID) {
        boolean exist = SearchInfo(DelID);
        if (!exist) {
            System.out.println("未找到匹配的ID:" + DelID);
        } else {
            System.out.println("-----------以上是您要删除的信息------------\n确定继续?(yes/no)");
            Scanner sure = new Scanner(System.in);
            String choice = sure.next();
            if (Objects.equals(choice, "yes") || Objects.equals(choice, "YES")) {
                String DelSql = "DELETE FROM Logistics WHERE LogID = '" + DelID + "'";

                try {
                    // 执行删除操作
                    int rowsAffected = state.executeUpdate(DelSql);

                    if (rowsAffected > 0) {
                        System.out.println("成功删除 " + rowsAffected + " 行数据");
                    } else {
                        System.out.println("未找到匹配的记录，删除失败");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("操作取消！");
            }
        }
    }
}




