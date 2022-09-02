package Java.InnerClass;


/*
********此类为局部内部类********

定义：局部内部类——就是定义在一个方法或者一个作用域里面的类
特点：主要是作用域发生了变化，只能在自身所在方法和属性中被使用


创建对象
    //成员内部类不是静态的：
    外部类名.内部类名 对象名 = new 外部类名.new 内部类名();
  ​
    //成员内部类是静态的：
    外部类名.内部类名 对象名 = new 外部类名.内部类名();  


内部类的分类
​   A：成员内部类
​   B：局部内部类
​   C：静态内部类
​   D：匿名内部类

*/


public class LocalOuterInner {
    private int age = 20;

    public void method(){
        int age2 = 30;
        class Inner{
            public void show(){
                System.out.println(age);
                System.out.println(age2);
            }
        }

        Inner i = new Inner();
        i.show();


    }
}

class Tests{
    public static void main(String[] args) {
        LocalOuterInner l = new LocalOuterInner();
        l.method();
    }
}
