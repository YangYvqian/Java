package Java.Compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
Comparable 和 Comparator 的区别和联系
    Comparable
        如果一个类实现了 Comparable 接口（只需要干一件事，重写 `compareTo()` 方法），
        就可以按照自己制定的规则将由它创建的对象进行比较。
        compareTo()` 方法，该方法的返回值可能为负数，零或者正数，
        代表的意思是该对象按照排序的规则小于、等于或者大于要比较的对象。

    Comparator
        Comparator 接口的定义相比较于 Comparable 就复杂的多了，不过，核心的方法只有两个compare 和 equals
        第一个方法 `compare(T o1, T o2)` 的返回值可能为负数，零或者正数，代表的意思是第一个对象小于、等于或者大于第二个对象。
        第二个方法 `equals(Object obj)` 需要传入一个 Object 作为参数，并判断该 Object 是否和 Comparator 保持一致。
        有时候，我们想让类保持它的原貌，不想主动实现 Comparable 接口，但我们又需要它们之间进行比较，该怎么办呢？Comparator 就派上用场了，来看一下示例。
        可以用匿名内部类实现Comparator 接口，然后进行排序
*/

public class CompareAge implements Comparable<CompareAge> {   // 此类实现了 Comparable接口
    private int age;
    private String name;

    public CompareAge(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(CompareAge o) {
        // TODO Auto-generated method stub
        return this.age - o.getAge();
    }

    public static void main(String[] args) {

        
        
        CompareAge c1 = new CompareAge(20, "yyq");
        CompareAge c2 = new CompareAge(30, "拼进所有");
        

        // 实现了 Comparable接口，调用compareTo进行比较
        if(c1.compareTo(c2) < 0){
            System.out.println(c1.getName()+"加油");
        }else{
            System.out.println(c2.getName()+"坚持加油");
        }
        

        // 在方法中使用匿名类实现Comparator接口，并制度比较规则方法compare方法
        List<CompareAge> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.sort( new Comparator<CompareAge>() {

            @Override
            public int compare(CompareAge o1, CompareAge o2) {
                // TODO Auto-generated method stub
                return o2.getAge() - o1.getAge();
            }
            
        }); 


        list.forEach(a->System.out.println(a.getName()));

    }
    
}
