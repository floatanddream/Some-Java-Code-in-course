package FinalWorks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

 class WindowsTerminal {
    public static void main(String[] args) {
        try {
            // 指定要执行的命令
            String command = "pause";

            // 创建进程并执行命令
            Process process = Runtime.getRuntime().exec(command);

            // 获取命令执行的输出流
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // 读取输出并打印到控制台
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // 等待命令执行完成
            int exitCode = process.waitFor();
            System.out.println("命令执行完毕，退出码：" + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
