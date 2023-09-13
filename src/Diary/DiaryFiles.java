package Diary;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DiaryFiles {
    public static final String SEP_NEXTLINE = "\n";
    public static final String SEP_SEPARATE = "\t";//格式
    public static final String SEP = "\t";//格式

    public static void SaveDiary(DiaryBook Diary) {
        String BookName = "E:\\JavaCl\\Works\\Diary\\ToxicGB.txt";
        //String BookName="ToxicGB.txt"
        File Books = new File(BookName);
        //File isexistbook =new File("E:\\JavaCl\\Works\\Diary\\ToxicGB.txt");
        // File Books=new File("BookName");
       // Path path = Paths.get(BookName);


       // System.out.println(Files.exists(path));
        System.out.println(Books.exists());
        if (!Books.exists()) {
            CreateBooks(BookName, false, Diary);
        } else {
            CreateBooks(BookName, true, Diary);
        }
    }

    public static void CreateBooks(String BoName, boolean isExist, DiaryBook NewDiary) {
        BufferedOutputStream OutDiary = null;
        StringBuffer BufferText = new StringBuffer();
        //isExist=true;
        try {
            if (isExist) {
                OutDiary = new BufferedOutputStream(new FileOutputStream(BoName, true)); // 输出流，追加文件末尾
            } else //不存在，新建文件
            {
                OutDiary = new BufferedOutputStream(new FileOutputStream(BoName));
                String HELLO = "这是Toxic.GB的日记本！";//日记封面
                BufferText.append(HELLO).append(SEP_NEXTLINE);
            }
            BufferText.append("标题："+NewDiary.Topic).append(SEP_NEXTLINE).append("姓名："+NewDiary.Name+SEP_SEPARATE);
            BufferText.append("日期："+NewDiary.DateTime).append(SEP_SEPARATE).append("时间："+NewDiary.DayTime+SEP_NEXTLINE);
            BufferText.append("天气：").append(NewDiary.Weather).append(SEP_NEXTLINE);
            BufferText.append("内容："+NewDiary.Contain).append(SEP_NEXTLINE+SEP_NEXTLINE);


            String Text=BufferText.toString();
            byte[] b=Text.getBytes();
            for(int i=0;i<b.length;i++)
            {
                OutDiary.write(b[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (OutDiary != null)
                    OutDiary.close();// 关闭输出流
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
 public static void ReadDiray()throws Exception{
     String BookName = "E:\\JavaCl\\Works\\Diary\\ToxicGB.txt";
     FileInputStream InputDiray = new FileInputStream(BookName);
     byte[] b = new byte[InputDiray.available()];
     InputDiray.read(b);
     String str=new String(b);
     System.out.println(str);
     InputDiray.close();
 }
}

