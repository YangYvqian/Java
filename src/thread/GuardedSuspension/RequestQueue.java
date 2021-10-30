package thread.GuardedSuspension;

// import java.util.LinkedList;
// import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class RequestQueue {

    //  使用 java.util.LinkedList 类 和 Guarded Suspension 模式构成 RequestQueue 类
    // 这个是非线程安全，所以需要 synchronized 关键字加锁
    // private final Queue<Request> queue = new LinkedList<Request>();

    // public synchronized Request getRequest(){
    //     while(queue.peek()== null){
    //         try {
    //             wait();
    //         } catch (Exception e) {
    //             //TODO: handle exception
    //         }
    //     }

    //     return queue.remove();
    // }

    // public synchronized void putRequest(Request request){
    //     queue.offer(request);
    //     notifyAll();
    // }

    // java.util.concurrent.ListedBlockingQueue 类是线程安全的
    // 由于take 和 put 方法已经考虑了互斥处理，
    // 所以getRequest方法和putRequest方法也就无需声明为synchronized方法
    // ListedBlockingQueue 类中使用Guarded Suspension 模式，能够保证线程安全
    private final BlockingQueue<Request> queue = new LinkedBlockingQueue<Request>();

    public Request getRequest(){
        Request req = null;
        try {
            req = queue.take();
        } catch (Exception e) {
            //TODO: handle exception
        }
        return req;
    }

    public void putRequest(Request request){
        try {
            queue.put(request);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }



    
}
