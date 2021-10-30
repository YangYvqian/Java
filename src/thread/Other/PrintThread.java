// **************************************//
//****线程的启动-----利用Thread类的子类****//
// **************************************//
package thread.Other;

public class PrintThread extends Thread {
    private String message;
    public PrintThread(String message){
        this.message = message;
    }
    public void run(){
        for (int i = 0; i<100; i++){
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        new PrintThread("good").start();
        new PrintThread("nice").start();
    }
}
