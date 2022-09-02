package Java.InnerClass;

/*
********此类为成员内部类********

定义：成员内部类——就是位于外部类成员位置的类
特点：可以使用外部类中所有的成员变量和成员方法（包括private的）


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

class MemberOuterInner {
    private  int age = 10;

     class Inner{
        public void age(){
            System.out.println(age);
        }
    }

  

    
}


class Test{
    public static void main(String[] args) {
        MemberOuterInner.Inner oi = new MemberOuterInner().new Inner();
        // Outer o = new Outer();
       
       
       oi.age();
        
    }
}
