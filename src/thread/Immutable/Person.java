// ***************************************//
//********* Immutable模式简单程序 *********//
// ***************************************//
/*
    class：
        Person               表示人的类
        Main                 测试程序行为的类
        PrintPersonThread    显示Person实例的线程的类
*/
package thread.Immutable;

public final class Person {
    private final String name;
    private final String address;
    
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person [address=" + address + ", name=" + name + "]";
    }
    
}
