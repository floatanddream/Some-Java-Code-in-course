package DataBase;

import java.sql.*;
import java.util.Objects;

public class OperatSQL {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://toxicgb.xyz:3306/javatestgb";
    static final String USER = "JavaTestGB";
    static final String PassWord = "M4wie4BWBWYDyKK6";

    Connection connect = DriverManager.getConnection(DB_URL,USER,PassWord);
    Statement state=connect.createStatement();
    public  OperatSQL() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
    }

    void ResquestALL() throws SQLException {//查询所有
        String Sents;
        Sents="SELECT cno,cname,cpno,ccredit FROM course";
        ResultSet rs = state.executeQuery(Sents);
        while(rs.next()){
            // 通过字段检索
            String id  = rs.getString("cno");
            String name = rs.getString("cname");
            String pno = rs.getString("cpno");
            String credit = rs.getString("ccredit");

            // 输出数据
            System.out.print("ID: " + id);
            System.out.print(", 课程名称: " + name);
            System.out.print("\t课程号: " + pno);
            System.out.print("\t课程学分: " + credit);
            System.out.print("\n");
        }
    }
    void AddData(String cno,String cname,String cpno,String credit) throws SQLException {//添加条目
        String Add;
        String Cno=cno;
        String Cname=cname;
        String cPno=cpno;
        String Credit=credit;
       // Add = "INSERT INTO course VALUES('Cno','Cname','cPno','Credit')";
      try{ // Add = "INSERT INTO course VALUES('grd','4324','432','4')";
        Add = "INSERT INTO course VALUES('" + Cno + "','" + Cname + "','" + cPno + "','" + Credit + "')";
        int count = state.executeUpdate(Add);
        System.out.println("添加成功！"+count);}catch (SQLException ee){//数据主键重复，抛出错误
          ee.printStackTrace();
          System.out.println("添加的cno重复，或者ID过长！！请重新输入！！");
      }
    }
    void UpdateData(String cno,String cname,String cpno,String credit) throws SQLException {
        try {
            String Upadate = "UPDATE course SET cname='" + cname + "',cpno='" + cpno + "',ccredit='" + credit + "'" + "WHERE cno='" + cno + "';";
            int count = state.executeUpdate(Upadate);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("找不到cno="+cno+"的数据库信息！");
        }
    }
    void Search(String cs) throws SQLException
    {
        boolean isE=false;
        String Sents;
        Sents="SELECT cno,cname,cpno,ccredit FROM course";
        ResultSet rs = state.executeQuery(Sents);
        while(rs.next()) {
            // 通过字段检索
            String id = rs.getString("cno");
            String name = rs.getString("cname");
            String pno = rs.getString("cpno");
            String credit = rs.getString("ccredit");
            if (Objects.equals(cs, id)) //与数据库对比，有则输出。
            {
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 课程名称: " + name);
                System.out.print("\t课程号: " + pno);
                System.out.print("\t课程学分: " + credit);
                System.out.print("\n");
                isE=true;
            }
        }
        if(!isE)
        {
            System.out.println("无此条目！");
        }
    }
    void Exit() throws SQLException {
        connect.close();
        state.close();
    }
}
