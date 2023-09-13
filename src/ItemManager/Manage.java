package ItemManager;
import java.util.*;

public class Manage {
private Map<Integer,ItemStorage> itemMap;
private int nextItemNum;
public Manage()
{
    itemMap=new TreeMap<>();
    nextItemNum=1;
}
public void addItem(String Name,String EX,String Owner,int Num,int Price)
{
    String Number=String.valueOf(nextItemNum);
    ItemStorage Storage=new ItemStorage(Number,Name,EX,Owner,Num,Price);
    itemMap.put(nextItemNum,Storage);
    nextItemNum++;
}
public void delItem(int ItemIDS)
{
    itemMap.remove(ItemIDS);
}
public Boolean SearchItem(int ID)
{
    ItemStorage item=itemMap.get(ID);
    if(item==null)
    {
        System.out.println("物品不存在");
        return false;
    }
    else {
        System.out.println(item.toString());
        return true;
    }
}
public void ItemJect()
    {

        System.out.print("请输入商品的名字：");
        Scanner IName=new Scanner(System.in);
        String Name = IName.next();
        System.out.print("请输入商品的配色：");
        Scanner IEx=new Scanner(System.in);
        String Ex = IEx.next();
        System.out.print("请输入商品的主人：");
        Scanner IOwner=new Scanner(System.in);
        String Owner = IOwner.next();
        System.out.print("请输入商品的数量：");
        Scanner INum=new Scanner(System.in);
        int Num = INum.nextInt();
        System.out.print("请输入商品的价钱：");
        Scanner IPrice=new Scanner(System.in);
        int Price = IPrice.nextInt();
        addItem(Name,Ex,Owner,Num,Price);
    }
    public void listAllItems() {
        System.out.println("物品编号\t物品名称\t物品颜色\t物品属于者\t物品价格\t物品数量");
        for (ItemStorage item : itemMap.values()) {
            System.out.println(item.toString());
        }
    }
    public void deleteItem(int itemId)
    {
        itemMap.remove(itemId);
    }
    public void RemoveItem()
    {
        System.out.println("请输入要删除的商品编号：");
        Scanner Del=new Scanner(System.in);
        int DelNum=Del.nextInt();
        Boolean IsExist=SearchItem(DelNum);
        if(IsExist==true)
        {
            System.out.println("以上是您的商品信息，您真的要删除嘛");
            System.out.println("删除：YES/取消：NO");
            String Choice=Del.next();
            System.out.println(Choice);
            //if (Objects.equals(Choice, "YES") || Objects.equals(Choice, "yes") || Objects.equals(Choice, "y") || Objects.equals(Choice, "Y"))
            if (Choice.equalsIgnoreCase("YES")||Choice.equalsIgnoreCase("Y"))
            {

                deleteItem(DelNum);
                System.out.println("删除成功！");
                System.out.println(Choice);
            }
            else
            { System.out.println("操作取消！");}

        }
        else{
            System.out.println("没能找到您要删除的商品");
        }
    }
}
