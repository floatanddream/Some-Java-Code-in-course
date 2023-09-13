package ItemManager;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        ItemStorage S1;
        S1=new ItemStorage("10086", "笔记本", "金色", "张三",3,4999);
        //System.out.println(S1.toString());
        Manage Storage=new Manage();
        Storage.addItem("华为Mate50Pro", "金色", "张三",3,10086);
        Storage.addItem("iPhone 14 Pro Max Plus Ultra", "远峰蓝", "李四",3,20000);
        Storage.addItem("OnePlus 11 Pro","银色","YYC",2,7000);
        Storage.addItem("XiaoMi 13 Pro","陶瓷黑","ToxicGB",1,7800);

      //  Storage.SearchItem(1);
        Boolean Loop=true;
        while (Loop)
       {
            System.out.println("欢迎使用仓库管理系统,请选择需要进行的操作");
            System.out.println("1. 商品入库");
            System.out.println("2. 所有商品显示");
            System.out.println("3. 查找商品");
            System.out.println("4. 删除商品");
            System.out.println("5. 退出系统");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if(choice==1)
            {
                Storage.ItemJect();
            }
            else if(choice==2)
            {
            Storage.listAllItems();
            }
            else if(choice==3)
            {
                System.out.println("请输入需要查找的编号：");
                Scanner Search=new Scanner(System.in);
                int SearchID=Search.nextInt();
                Storage.SearchItem(SearchID);
            }
            else if(choice==4)
            {
                //System.out.println("SHANCHU");
                Storage.RemoveItem();
            }
            else if(choice==5)
            {
                Loop=false;
                System.out.println("系统退出!");
            }


       }

    }
}
