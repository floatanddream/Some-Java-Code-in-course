package Diary;
import ITscma.FileUtil;

import java.util.ArrayList;
import java.util.Scanner;
public class DiaryInput {
    static ArrayList<DiaryBook> DiarysList=new ArrayList<DiaryBook>();
    public static DiaryBook ADDDiary(String N,String W,String T,String Con)
    {
        DiaryBook NEWDiary=new  DiaryBook(N,W,T,Con);
        return NEWDiary;
    }
    public static void main(String[] a) throws Exception {
//     Scanner scan=new Scanner(System.in);
//     String B=scan.next();
//     System.out.println(B);
//        String C=scan.next();
//        System.out.println(C);
        //DiaryBook D=new DiaryBook("YYC","SUNNY","WSN4hhtD","小学");
       // for(int b=0;b<10086;b++)
      //  DiaryFiles.SaveDiary(D);
       // D.TestOutput();
        Scanner MainI=new Scanner(System.in);
        Boolean Loop=true;
       while (Loop)
       {
           System.out.println("1.写日记");
           System.out.println("2.查看已有日记");
           System.out.println("3.退出");
           int Oper=MainI.nextInt();
           if(Oper ==1)
           {
               System.out.println("写日记");
            // DiaryBook NEW= ADDDiary("YYC","SUNNY","WSNwdfklD","小学");
              // break;
              // DiaryFiles.SaveDiary(NEW);
               Scanner InputDiray=new Scanner(System.in);
               System.out.println("请输入名字：");
               String Name=InputDiray.next();
               System.out.println("请输入天气：");
               String Weather=InputDiray.next();
               System.out.println("请输入主题：");
               String Topic=InputDiray.next();
               System.out.println("请输入日记内容：");
               String Contant=InputDiray.next();
               DiaryBook NewDiray=ADDDiary(Name,Weather,Topic,Contant);
               DiaryFiles.SaveDiary(NewDiray);


           }
           else if(Oper==2)
           {
               System.out.println("查看已有日记");
              // System.out.println(DiarysList);
               DiaryFiles.ReadDiray();
           }
           else if(Oper==3)
           {
               System.out.println("退出！");
               break;
           }
           else
           {
               System.out.println("输入有误！");
           }
       }
    }

}
