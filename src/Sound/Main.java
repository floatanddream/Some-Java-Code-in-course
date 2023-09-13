package Sound;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("您想使用什么设备？输入数字：");
        System.out.println("0-收音机  1-随身听  2-手机");
        int choices;
        Scanner devices =new Scanner(System.in);
        choices=devices.nextInt();
        SampleDisplay display1=new SampleDisplay();
        if (choices == 0)
            display1.display(new Radio());
        else if(choices == 1)
            display1.display(new Walkman());
        else if(choices == 2)
            display1.display(new MobilePhone());
        else
            System.out.println("请输入正确编号");
        devices.close();

    }
}
