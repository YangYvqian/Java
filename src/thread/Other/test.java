package thread.Other;

public class test {
    private static int ready=9;
    private static class ReaderThread{
        public void run(){
            System.out.println(ready);
        }
    }
    public static void main(String[] args) {
       
        ReaderThread tt = new ReaderThread();
        ready = 12;
        tt.run();
       
    }
}
