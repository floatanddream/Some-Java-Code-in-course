package Person;

public class Main {
    public static void main(String[] args)
    {
    Person per1,per2;
    per1=new Teacher("李四",30);
    per2=new Student("张三",18);
    per1.say();
    per2.say();
    }
}
