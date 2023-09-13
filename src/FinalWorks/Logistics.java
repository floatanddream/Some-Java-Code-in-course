package FinalWorks;

import java.sql.SQLException;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Logistics {
    String LogType;//物流类型
    String LogQual;//快件重量
    String LogSend;//发货人
    String LogRec;//收货人
    int LogID;//快递单号
    String LogTime;//时间
    String LogSendADD;//发货地址
    String LogRecADD;//收货地址
    String LogTimeS;
    String LogSendTEL;//发货人电话
    String LogRecTEL;//收货人电话

    public Logistics() {

    }

    public String GetrealTime()//获取系统当前时间
    {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTime = now.format(formatter);
        return currentTime;
    }

    void addItem() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入物流类型：");
        this.LogType = input.next();
        System.out.println("请输入物流快递的重量：");
        this.LogQual = input.next();
        System.out.println("请输入物流发货人：");
        this.LogSend = input.next();
        System.out.println("请输入物流收货人：");
        this.LogRec = input.next();
        System.out.println("请输入物流发货地：");
        this.LogSendADD = input.next();
        System.out.println("请输入物流收货地：");
        this.LogRecADD = input.next();
        System.out.println("请输入物流发货人电话：");
        this.LogSendTEL = input.next();
        System.out.println("请输入物流收货人电话：");
        this.LogRecTEL = input.next();
        this.LogTime = GetrealTime();
        long seconds = Instant.now().getEpochSecond();
        this.LogTimeS = Long.toString(seconds);
        LogDataBase getid = new LogDataBase();
        this.LogID = Integer.parseInt(getid.GETMAXID()) + 1;

    }


}
