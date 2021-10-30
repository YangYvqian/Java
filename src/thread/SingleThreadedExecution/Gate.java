// ***************************//
// ****Gate类是非线程安全的****//
// **************************//
// 因为 pass() 方法里有“读取 - 修改 - 写入”操作，不是原子的
// 因此，存在竟态条件
// 
// 解决线程不安全问题：是要保证原子操作，则必须加锁,synchronized 保证原子操作
// pass() 和 toString() 方法加上 synchronized，保证了线程安全

package thread.SingleThreadedExecution;

public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    public synchronized void pass(String name, String address){
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    public int getCount(){
        return counter;
    }
    public synchronized String toString(){
        return "No." + counter + ":" + name + "," + address;
    }

    private void check(){
        if(name.charAt(0) != address.charAt(0)){
            System.out.println("***** BROKEN *****" + toString());
        }
    }
}
