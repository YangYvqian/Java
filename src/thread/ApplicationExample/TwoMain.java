package thread.ApplicationExample;

public class TwoMain {
    public static void main(String[] args) {
        TwoPerson twoperson = new TwoPerson("aaa", "bbb");
        new TwoPrintThread(twoperson).start();
        new TwoPrintThread(twoperson).start();
        new TwoPrintThread(twoperson).start();
    }
}
