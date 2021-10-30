package thread.ApplicationExample;

public class OneMain {
    public static void main(String[] args) {
        System.out.println("Testing gate");
        OneGate gate = new OneGate();
        new OneUserThread(gate, "aaa", "abb").start();
        new OneUserThread(gate, "bbb", "bcc").start();
        new OneUserThread(gate, "ccc", "cdd").start();
        
    }
}
