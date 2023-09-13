package WinUI;

import javax.swing.*;
import java.awt.*;

/**
 * 1.创建窗体对象（JFrame，自带标题栏、可以最大最小化拖动、关闭按钮）
 * 2.设置窗体对象属性：尺寸，标题，关闭选项，可视化
 * 3.窗体布局方式：流式布局
 * 4.创建各种组件对象：按钮，标签图片，标签文本，文本输入框，密码输入框，复选框
 * 5.设置组件对象属性：输入框尺寸，各组件文字字体
 * 6.利用窗体对象将组件加载到窗体上
 * 7.整体可视化
 * 8.创建类的对象，调用方法
 */
public class FrameCreat {
    public void frame(){
        //创建一个窗体
        JFrame jFrame=new JFrame();

        //设置窗体对象的属性 - 标题 尺寸 图标 关闭选项 可视化
        jFrame.setTitle("登录窗口");  //设置窗体的标题
        jFrame.setSize(500,650);//设置窗体的尺寸，宽和高，以像素为单位，以左上角为原点
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体关闭选项为退出
        jFrame.setVisible(true);//可视化，使窗体出现在屏幕上，需要注意使用时的位置，可视化之前的可见，之后的不可见


        //设置窗体布局方式
        FlowLayout flowLayout=new FlowLayout(); //创建流式布局对象flowLayout
        jFrame.setLayout(flowLayout); //将流式布局对象设置为窗体对象的布局方式


        //在窗体上添加组件
        //按钮
        JButton jButton=new JButton("登录");//创建按钮对象的同时调用构造函数进行初始化
        //标签
        //图片
        ImageIcon img=new ImageIcon("C:\\Java_WorkSpace\\JavaProJect_21\\images\\1.jpg");//创建图片对象，并调用构造函数
        JLabel imgJLable=new JLabel(img); //创建标签对象imgJLable,传入图片
        //文字
        JLabel accountJLable=new JLabel("账号：");//创建标签对象accountJLable，传入文字标签
        JLabel passwordJLable=new JLabel("密码：");//创建标签对象passwordJLable，传入文字标签
        //输入框
        JTextField accountIn=new JTextField();//创建文本输入框对象
        JPasswordField passwordIn=new JPasswordField();//创建数字密码输入框对象，
        accountIn.getText();//调用文本输入框对象的方法，传入文本
        accountIn.setText("");//调用文本输入框对象的方法，设置初始文本
        //复选框
        JCheckBox jCheckBox=new JCheckBox("记住密码");//创建复选框对象，并传入复选框标题

        //设置组件对象属性
        //输入框尺寸
        Dimension dimension=new Dimension(400,50);//创建Dimension（尺寸）对象并初始化
        accountIn.setPreferredSize(dimension);//调用输入框对象的方法，传入设置好的尺寸对象
        passwordIn.setPreferredSize(dimension);//调用输入框对象的方法，传入设置好的尺寸对象
        //设置组件字体
        Font font=new Font("苹方",0,110);//创建字体Font类的对象font，并调用构造函数初始化
        jButton.setFont(font); //给登录按钮设置字体
        accountJLable.setFont(font);//给 账号  设置字体
        passwordJLable.setFont(font);//给 密码 设置字体
        accountIn.setFont(font);//给文本输入框内容设置字体
        passwordIn.setFont(font);//给密码输入框设置字体，****不设置字体时，输入的是“*”，输入字体时是“口”
        jCheckBox.setFont(font);//给复选框标题设置字体


        //利用窗体对象调用add()函数，将组件对象加载到窗体上
        jFrame.add(imgJLable);//图片组件
        jFrame.add(accountJLable);//账号标签
        jFrame.add(accountIn);//文本输入框
        jFrame.add(passwordJLable);//密码标签
        jFrame.add(passwordIn);//密码输入框
        jFrame.add(jCheckBox);//复选框
        jFrame.add(jButton); //按钮


        //添加组件之后可视化
        jFrame.setVisible(true);
    }


}


