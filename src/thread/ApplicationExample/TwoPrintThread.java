package thread.ApplicationExample;

public class TwoPrintThread extends Thread {
    private TwoPerson twoPerson;

    public TwoPrintThread(TwoPerson twoPerson){
        this.twoPerson = twoPerson;
    }

    public void run(){
        while (true) {
            System.out.println(Thread.currentThread().getName() + "print" + twoPerson);
        }
    }

    
}
