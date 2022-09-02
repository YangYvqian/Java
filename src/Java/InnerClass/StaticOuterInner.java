package Java.InnerClass;

/*
********此类为静态内部类********

定义：我们所知道static是不能用来修饰类的,但是成员内部类可以看做外部类中的一个成员,
     所以可以用static修饰,这种用static修饰的内部类我们称作静态内部类,也称作嵌套内部类.
特点：不能使用外部类的非static成员变量和成员方法

解释：非静态内部类编译后会默认的保存一个指向外部类的引用，而静态类却没有。
简单理解：即使没有外部类对象，也可以创建静态内部类对象，而外部类的非static成员必须依赖于对象的调用，
         静态成员则可以直接使用类调用，不必依赖于外部类的对象，所以静态内部类只能访问静态的外部属性和方法。




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


public class StaticOuterInner {
    int age = 20;
    static int age2 = 30;
    static class Inner{
        public void method(){

            // 所以静态内部类只能访问静态的外部属性和方法
            // System.out.println(age); // 静态内部类访问外部非静态成员变量，会报错
            System.out.println(age2); // 静态内部类只能访问外部静态的外部属性和方法
        }
    }



    public static void main(String[] args) {
        StaticOuterInner.Inner s = new StaticOuterInner.Inner();
        s.method();
    }
}
