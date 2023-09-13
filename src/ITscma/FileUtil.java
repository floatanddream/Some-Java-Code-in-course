package ITscma;

import java.io.BufferedOutputStream;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 工具类
 */
public class FileUtil {
    public static final String SEPARATE_FIELD = "\n";// 换行
    public static final String SEPARATE_LINE = "\t"; // 分隔
    /**
     * 保存日记信息
     */
    public static void saveBooks(Diary diary) {
        // 判断本地是否存在此文件
        String name = "ToxicGB.txt";
        File file = new File("name");
        if (!file.exists()) {
            createFile(name, false, diary);
        } else {
            createFile(name, true, diary);
        }
    }
    public static void createFile(String name, boolean label, Diary diary) {
        BufferedOutputStream out = null;
        StringBuffer sbf = new StringBuffer();// 拼接内容
        try {
            if (label) {// 当已存在当天的文件，则在文件内容后追加
                // 创建输出流，用于追加文件
                out = new BufferedOutputStream(new FileOutputStream(name, true));
            } else {

                out = new BufferedOutputStream(new FileOutputStream(name));
                String fieldSort =  "欢迎来到ToxicGB" ;
                // 新建时，将表头存入本地文件
                sbf.append(fieldSort).append(SEPARATE_FIELD);
            }
            sbf.append("时间：").append(diary.time);
            sbf.append("姓名：").append(diary.name).append(SEPARATE_LINE);
            sbf.append("标题：").append(diary.title).append(SEPARATE_LINE);
            sbf.append("天气：").append(diary.weather).append(SEPARATE_FIELD);
            sbf.append("内容：").append(diary.content).append(SEPARATE_FIELD);
            String str = sbf.toString();
            byte[] b = str.getBytes();
            for (int i = 0; i < b.length; i++) {
                out.write(b[i]);// 将内容写入本地文件
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.close();// 关闭输出流
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    /*
     * 读取日记并显示
     */
    public static void readFile() throws Exception{
        //创建文件字节输出流
        FileInputStream in = new FileInputStream("Toxic.GB.txt");
        byte[] b = new byte[in.available()];
        in.read(b);
        String str=new String(b);
        System.out.println(str);
        in.close();
    }
}
