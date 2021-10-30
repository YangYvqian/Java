package thread.SingleThreadedExecution;

public class Main {
    public static void main(String[] args) {
        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bob", "Brazil").start();
        new UserThread(gate, "Chrise", "Canda").start();
    }
}
