package ItemManager;
import java.util.*;
public class ItemStorage {
private String ItemID;
private String ItemName;
private String ItemEX;
private String ItemOwner;
private int ItemNum;
private int ItemPrice;
 ItemStorage(String ID,String Name,String EX,String Owner,int Num,int Price)
 {
     this.ItemID=ID;
     this.ItemName=Name;
     this.ItemEX=EX;
     this.ItemOwner=Owner;
     this.ItemNum=Num;
     this.ItemPrice=Price;
 }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%d\t%s", ItemID, ItemName, ItemEX, ItemOwner, ItemPrice,ItemNum);
    }
}
