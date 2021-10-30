// **************************************//
//****线程的启动-----利用Thread类的子类****//
// **************************************//
package thread.Other;

public class Printer implements Runnable {
    private String message;
    public Printer(String message){
        this.message = message;
    }
    public void run(){
        for (int i = 0; i<100; i++){
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        new Thread(new Printer("good")).start();
        new Thread(new Printer("nice")).start();
    }
}
