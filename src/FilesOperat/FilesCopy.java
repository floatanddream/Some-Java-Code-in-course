package FilesOperat;
import java.io.*;

public class FilesCopy {
    public static void main(String[] b)
    {
        String sourceFilePath = "E:\\JavaCl\\2.txt";
        String targetFilePath = "E:\\JavaCl\\PoemCopy.txt";

        // 1. 使用字节流复制文件
        try {
            FileInputStream Inputt = new FileInputStream(sourceFilePath);
            FileOutputStream Outt = new FileOutputStream(targetFilePath);

            byte[] buffer = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = Inputt.read(buffer)) != -1) {
                Outt.write(buffer, 0, bytesRead);
            }

            Inputt.close();
            Outt.close();
            System.out.println("复制文件成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
