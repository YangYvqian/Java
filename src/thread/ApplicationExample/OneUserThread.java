package thread.ApplicationExample;

public class OneUserThread extends Thread {
    private final OneGate gate;
    private final String myname;
    private final String myaddress;

    public OneUserThread(OneGate gate, String myname, String myaddress){
        this.gate = gate;
        this.myaddress = myaddress;
        this.myname = myname;
    }

    public void run(){
        System.out.println(myname + "BEGIN");
        while (true){
            gate.pass(myname, myaddress);
            
        }
    }

}
