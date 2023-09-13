package Translation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
    Exchange Trans=new Exchange();
    Trans.addDic("香蕉","banana");
        Trans.addDic("苹果","apple");
        Trans.addDic("抛弃","abandon");
   // Trans.Translate("c");
    boolean Loop=true;
    while (Loop)
    {
        System.out.println("欢迎使用百度翻译系统，请输入操作");
        System.out.println("1. 翻译");
        System.out.println("2. 添加字典");
        System.out.println("3. 退出系统");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if(choice==1)
        {
            System.out.println("请输入英文：");
            Scanner sc1=new Scanner(System.in);
            String Eng=sc1.next();
            Trans.Translate(Eng);
        }
        else if(choice==2)
        {
            Scanner sc2=new Scanner(System.in);
            System.out.println("请输入英文：");
            String EngT=sc2.next();
            System.out.println("请输入英文"+EngT+"的中文意思：");
            String ChsT=sc2.next();
            Trans.addDic(ChsT,EngT);
        }
        else if(choice==3)
        {
            System.out.println("系统退出!");
            Loop=false;
        }
    }

    }
}
