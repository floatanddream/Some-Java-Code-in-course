package WinUI;

import javax.swing.*;

public class Main {
    public static void main(String [] args){
        //在主函数中创建对象，并调用创建窗体的方法

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Calculator calculator = new Calculator();
                calculator.show();
            }
        });
    }
}
