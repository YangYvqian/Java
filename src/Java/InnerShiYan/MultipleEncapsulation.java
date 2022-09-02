package Java.InnerShiYan;

/*
使用内部类的原因
(一) 封装性
    作为一个类的编写者，我们很显然需要对这个类的使用访问者的访问权限做出一定的限制，
    我们需要将一些我们不愿意让别人看到的操作隐藏起来，
    如果我们的内部类不想轻易被任何人访问，可以选择使用private修饰内部类，
    这样我们就无法通过创建对象的方法来访问，想要访问只需要在外部类中定义一个public修饰的方法，间接调用。

    这样做的好处之一就是，我们可以在这个public方法中增加一些判断语句，起到数据安全的作用。

    其次呢，我们的对外可见的只是getInner()这个方法，它返回了一个Demo接口的一个实例，
    而我们真正的内部类的名称就被隐藏起来了

(二) 实现多继承(MultipleEncapsulation)
    我们之前的学习知道，java是不可以实现多继承的，一次只能继承一个类，
    我们学习接口的时候，有提到可以用接口来实现多继承的效果，即一个接口有多个实现，
    但是这里也是有一点弊端的，那就是，一旦实现一个接口就必须实现里面的所有方法，
    有时候就会出现一些累赘，但是使用内部类可以很好的解决这些问题

    我们编写了两个待继承的类Demo1和Demo2，在MyDemo类中书写了两个内部类，
    test1和test2 两者分别继承了Demo1和Demo2类，这样MyDemo中就间接的实现了多继承

(三) 用匿名内部类实现回调功能
    我们用通俗讲解就是说在Java中，通常就是编写一个接口，然后你来实现这个接口，
    然后把这个接口的一个对象作以参数的形式传到另一个程序方法中， 
    然后通过接口调用你的方法，匿名内部类就可以很好的展现了这一种回调功能

(四) 解决继承及实现接口出现同名方法的问题

*/

 class Demo1{
    public String name1(){
        System.out.println("Demo1");
        return "Demo1";
    }
}

class Demo2{
    public String name2(){
        System.out.println("Demo2");
        return "Demo2";
    }
}


public class MultipleEncapsulation {
    private class test1 extends Demo1{
        public String name1(){
            return super.name1();
        }
    }

    private class test2 extends Demo2{
        public String name2(){
            return super.name2();
        }
    }


    public String name1(){
        return new test1().name1();
    }

    public String name2(){
        return new test2().name2();
    }


    public static void main(String[] args) {
        MultipleEncapsulation mEncapsulation = new MultipleEncapsulation();
        mEncapsulation.name1();
        mEncapsulation.name2();
    }


}
