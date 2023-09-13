package UserManagerSys;

import java.util.Scanner;

public class UserManager {
    String Password;
    String IDs;
    UserManager(String ID, String PW)
  {
      this.IDs=ID;
      this.Password=PW;
  }
  void UserLogin()
  {
      int incorrect=0;
      boolean IsUsernotexist=true;
      Scanner User=new Scanner(System.in);
      while (IsUsernotexist)
      {
          System.out.println("请输入用户名：");
          String ID = User.next();
          //System.out.println(ID);
          IsUsernotexist = ID.equals(this.IDs);
          if(IsUsernotexist)
          {
              System.out.println("检测存在此用户！ "+ID);
              break;
          }
          else
          {
              System.out.println("不存在用户: "+ID+" 请重新输入！");
              incorrect++;
              IsUsernotexist=true;
              System.out.println("已经输错"+incorrect+"次！");
              if (incorrect>=3)
              {
                  System.out.println("输出次数过多！系统已经锁定.");
                  return;
              }

          }
      }
      Login();
  }
    void Login()
    {
        int incorrect = 0;
        Scanner UserPass=new Scanner(System.in);
        boolean IsnotCorrect=true;

        while (IsnotCorrect)
        {
            System.out.println("请输入用户"+this.IDs+"的密码：");
            String TPassword=UserPass.next();
            IsnotCorrect = TPassword.equals(this.Password);
            //System.out.println(IsnotCorrect);
            if(IsnotCorrect)
            {
                System.out.println("密码正确，已经登陆！");
                break;
            }
            else 
            {
                System.out.println("密码错误请重新输入！");
                incorrect++;
                IsnotCorrect=true;
                System.out.println("已经输错"+incorrect+"次！");
                if (incorrect>=3)
                {
                    System.out.println("输出次数过多！系统已经锁定.");
                    return;
                }
            }
        }

    }

}
