package DataBase;
import java.util.Scanner;
import java.sql.*;

public class IntroMySQL {

    public static void main(String[] a) throws ClassNotFoundException, SQLException {


     // OP.ResquestALL();
      //OP.AddData("108","Cis","20","2");

        OperatSQL OP=new OperatSQL();
      boolean Loop=true;
      Scanner Oper=new Scanner(System.in);

      while (Loop)
        {
            System.out.println("1.数据库显示所有");
            System.out.println("2.数据库增加信息");
            System.out.println("3.数据库修改信息");
            System.out.println("4.数据库查询");
            System.out.println("5.退出");
            System.out.println("请输入要执行的操作！");
            int choice=Oper.nextInt();
            if(choice == Integer.parseInt("1"))
            {
                OP.ResquestALL();
            }
            else if(choice == Integer.parseInt("2"))
            {
                AddSql(OP);
            }
            else if(choice == Integer.parseInt("3"))
            {
                Update(OP);
            }
            else if(choice == Integer.parseInt("4"))
            {
               Search(OP);
            }
            else if(choice == Integer.parseInt("5"))
            {
                Loop=false;
                OP.Exit();
                System.out.println("退出！");
            }
            else
            {
                System.out.println("输入有误！");
            }
        }
    }
    void TestSQL() throws SQLException, ClassNotFoundException {
//        Class.forName(JDBC_DRIVER);
//        Connection connect = DriverManager.getConnection(DB_URL,USER,PassWord);
//        Statement state=connect.createStatement();
//        String Table,Update,CreateTable,Test;
//        Test="SELECT cno,cname,cpno,ccredit FROM course";
//
//        ResultSet rs = state.executeQuery(Test);
//
//        while(rs.next()){
//            // 通过字段检索
//            int id  = rs.getInt("cno");
//            String name = rs.getString("cname");
//            String pno = rs.getString("cpno");
//            String credit = rs.getString("ccredit");
//
//            // 输出数据
//            System.out.print("ID: " + id);
//            System.out.print(", 课程名称: " + name);
//            System.out.print("\t课程号: " + pno);
//            System.out.print("\t课程学分: " + credit);
//            System.out.print("\n");
//        }
//
//        connect.close();
//        state.close();
    }

    static void AddSql(OperatSQL ADD) throws SQLException {
        Scanner sql=new Scanner(System.in);
        String ID,cname,cpno,cred;
        System.out.println("请输入ID！");
        ID=sql.next();
        System.out.println("请输入课程名称！");
        cname=sql.next();
        System.out.println("请输入课程号！");
        cpno=sql.next();
        System.out.println("请输入课程学分！");
        cred=sql.next();
        ADD.AddData(ID,cname,cpno,cred);

    }
    static void Update(OperatSQL Up) throws SQLException {
        Scanner sql=new Scanner(System.in);
        String ID,cname,cpno,cred;
        System.out.println("请输入要修改ID！");
        ID=sql.next();
        System.out.println("请输入修改后的课程名称！");
        cname=sql.next();
        System.out.println("请输入修改后的课程号！");
        cpno=sql.next();
        System.out.println("请输入修改后的课程学分！");
        cred=sql.next();
        Up.UpdateData(ID,cname,cpno,cred);
    }

    static void Search(OperatSQL Se) throws SQLException
    {
        Scanner Sea=new Scanner(System.in);
        System.out.println("输入要查找的cno！");
        String S=Sea.next();
        Se.Search(S);
    }
}
