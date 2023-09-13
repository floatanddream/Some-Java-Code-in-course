package Diary;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DiaryBook {
    String Name;//姓名
    String Weather;//天气
    String Topic;//标题
    String Contain;//内容
    String DateTime;//日期
    String DayTime;//时间
    public DiaryBook(String N,String W,String T,String Con)
    {
        this.Name=N;
        this.Weather=W;
        this.Topic=T;
        this.Contain=Con;
        Date date=new Date();
        DateFormat Dates = new SimpleDateFormat("yyyy年MM月dd日");
        DateFormat Day=new SimpleDateFormat("HH时mm分");
        String DATES=Dates.format(date).toString();
        String TIME=Day.format(date).toString();
        this.DateTime=DATES;
        this.DayTime=TIME;
    }

    public void TestOutput() {
        System.out.println("标题"+this.Topic);
        System.out.println("姓名"+this.Name + "\t天气：" + this.Weather + "\t日期：" + this.DateTime + "\t时间：" + this.DayTime);
        System.out.println(this.Contain);
    }
}
