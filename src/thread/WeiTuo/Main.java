package thread.WeiTuo;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Delegation d = new Delegation("张三");
        A a = new A("李四");
        d.addObserver(a);
        d.event(d, a, "买早餐");
        A b = new A("王五");
        d.addObserver(b);
        d.eventAll(d, "要美女的联系方式");
    }
}
    

