// ****************************************//
//*** 非线程安全的 java.util.ArratList类 ***//
// ****************************************//
/*
    class：
        ReaderThread         List接口的“读”线程
        Main                 测试程序行为的类
        WriterThread         List接口的“写”线程

    程序运行：
           失去了线程安全性
          会抛出 ConcurrentModificationException 异常 或 NullPointerException异常
          因为ArrayList类（及迭代器）在被多个线程同时读写而失去安全性
    
    多线程访问集合注意事项：
                        示例 1：非线程安全的 java.util.ArratList 类
                        示例 2：利用 Collection.synchronizedList 方法所进行的同步
                        示例3：使用copy-on-write的java.util.concurrent.CopyOnWriteArrayList类 
      
*/

package thread.CollectionThread;

// import java.util.ArrayList;
// import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {

        // 示例 1：非线程安全的 java.util.ArratList 类
        // List<Integer> list = new ArrayList<>();

        // 示例 2：利用 Collection.synchronizedList 方法所进行的同步 
        // final List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
        
        // 示例3：使用copy-on-write的java.util.concurrent.CopyOnWriteArrayList类
        final List<Integer> list = new CopyOnWriteArrayList<>();

        new ReaderThread(list).start();
        new WriterThread(list).start();
    }
}
