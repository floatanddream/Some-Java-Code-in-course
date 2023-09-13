package ITscma;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class DiaryOrder {
    static ArrayList<Diary> diarysList=new ArrayList<Diary>();
    public static void main(String[] args) throws Exception {
        System.out.println("--------欢迎来到ToxicGB--------");
        boolean falg = true;
        Scanner scan=new Scanner(System.in);
        while(falg) {
            System.out.println("1.编写日记");
            System.out.println("2.查看日记");
            int a = scan.nextInt();
            if(a==1) {
                //编写日记
                System.out.println("请输入姓名：");
                String name=scan.next();
                System.out.println("请输入天气：");
                String weather=scan.next();
                System.out.println("请输入标题：");
                String title=scan.next();
                System.out.println("请输入内容：");
                String content=scan.next();
                Diary diary = addDiary(name,weather,title,content);
                FileUtil.saveBooks(diary);
            }else if(a==2) {
                //查看日记
                FileUtil.readFile();
            }else {
                System.out.println("输入错误");
            }
        }
    }
    /*
     * 初始化日记列表 将输入的字符暂存为实体
     */
    private static Diary addDiary(String name,String weather,String
            title,String content) {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        String a=format.format(date).toString();
        Diary diary=new Diary(a,name,weather,title,content);
        return diary;
    }
}
