package Person;

public abstract class Person
{
    String name;
    int age;
    Person(String Na,int AGE)
    {
        this.name=Na;
        this.age=AGE;
    }
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
    public void say(){};
}
 class Teacher extends Person
{

    public Teacher(String Na, int AGE)
    {
        super(Na, AGE);
    }

    public void say()
    {
        System.out.println("老师姓名："+this.name+",年龄："+this.age+",负责提出问题让学生回答。");
    }
}
class Student extends Person
{

    public Student(String Na, int AGE)
    {
        super(Na, AGE);
    }

    public void say()
    {
        System.out.println("学生姓名："+this.name+",年龄："+this.age+",负责回答老师提出的问题。");
    }
}