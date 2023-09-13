package FilesOperat;
import java.io.*;

public class Poem {
  public static void main(String[] a)
  {
      //读取文件路径
      String sourceFilePath = "E:\\JavaCl\\Works\\2.txt";
      File sourceFile = new File(sourceFilePath);
      String fileName = sourceFile.getName();
//目标路径
      File targetFile = new File("E:\\JavaCl\\" + fileName);
//写入诗歌
      try {
          targetFile.createNewFile();
          System.out.println("目标文件已创建：" + targetFile.getAbsolutePath());

          FileWriter writer = new FileWriter(targetFile);
          writer.write("《登高》\n");
          writer.write("作者：杜甫\t朝代：唐\n");
          writer.write("风急天高猿啸哀，渚清沙白鸟飞回。\n");
          writer.write("无边落木萧萧下，不尽长江滚滚来。\n");
          writer.write("无边落木萧萧下，不尽长江滚滚来。\n");
          writer.write("艰难苦恨繁霜鬓，潦倒新停浊酒杯。\n");
          writer.close();
          System.out.println("诗歌已写入目标文件。");
      } catch (IOException e) {
          System.out.println("写入文件时出现异常：");
          e.printStackTrace();
      }
      System.out.println("诗歌如下：");
      //读取诗歌
      String filePath=targetFile.getAbsolutePath();
      try {
          FileReader fileReader = new FileReader(filePath);
          BufferedReader bufferedReader = new BufferedReader(fileReader);
          String line;
          while ((line = bufferedReader.readLine()) != null) {
              System.out.println(line);
          }
          bufferedReader.close();
          fileReader.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
}
