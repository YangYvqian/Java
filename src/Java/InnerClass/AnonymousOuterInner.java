package Java.InnerClass;

/*
********此类为匿名内部类********

定义：一个没有名字的类，是内部类的简化写法

格式：
    new 类名或者接口名() {
        重写方法();
    }
本质：其实是继承该类或者实现接口的子类匿名对象

这也就是下例中，可以直接使用 new Inner() {}.show(); 的原因 == 子类对象.show();

匿名内部类在开发中的使用：
    我们在开发的时候，会看到抽象类，或者接口作为参数。
    而这个时候，实际需要的是一个子类对象。
    如果该方法仅仅调用一次，我们就可以使用匿名内部类的格式简化。



内部类的分类
​   A：成员内部类
​   B：局部内部类
​   C：静态内部类
​   D：匿名内部类

*/


interface Inner{
    public abstract void show();
}


public class AnonymousOuterInner {
    public void method(){

        // 方法一：如果匿名内部类中有一个方法，用方法一
        new Inner() {

            @Override
            public void show() {
                System.out.println("方法一");
            }
            
        }.show();

        // 方法二：如果匿名内部类中有多个方法，用方法二
        Inner i = new Inner() {  //多态，因为new Inner(){}代表的是接口的子类对象

            @Override
            public void show() {
                System.out.println("方法二");
            }
            
        };
        i.show();
    }

    public static void main(String[] args) {
        AnonymousOuterInner a = new AnonymousOuterInner();
        a.method();
    }
}
