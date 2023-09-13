package Translation;

import java.util.Map;
import java.util.TreeMap;

public class Exchange
{
    private Map<String,Translate> ExTrans;
public Exchange()
{
    ExTrans=new TreeMap<>();
}
public void addDic(String Chs,String Eng)//添加字典
{
    Translate Tran=new Translate(Chs,Eng);
    ExTrans.put(Eng,Tran);
}
public void Translate(String ENG)
{
    Translate T=ExTrans.get(ENG);

    if(T==null)
    {
        System.out.println("单词意思不存在");
    }
    else
    {
        System.out.println(T.Translation());
    }
}
}
