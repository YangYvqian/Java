package thread.SingleThreadedExecution;

public class UserThread extends Thread {
    private final Gate gate;
    private final String myname;
    private final String myaddress;
    public UserThread(Gate gate, String myname, String myaddress){
        this.gate = gate;
        this.myname = myname;
        this.myaddress = myaddress;

    }

    public void run(){
        System.out.println(myname + " BEGIN");
        if(myname == "Bob") System.out.println("Chrise"+gate.getCount());
        if(myname == "Chrise") System.out.println("Chrise"+gate.getCount());
        if(myname == "Alice") System.out.println("Alice"+gate.getCount());
        while(true){
            gate.pass(myname, myaddress);
        }
    }
}
