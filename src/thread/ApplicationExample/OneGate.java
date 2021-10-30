package thread.ApplicationExample;

public class OneGate {
    private int count = 0;
    private String name;
    private String address;
    
    public synchronized void pass(String name, String address){
        this.count++;
        this.name = name;
        this.address = address;
        check();
    }

    public void check(){
        if (name.charAt(0) != address.charAt(0)){
            System.out.println("******broken******" + toString());
        }
    }

    @Override
    public synchronized String toString() {
        return "No. [count=" + count + ", name=" + name +  ", address=" + address  +"]";
    }

    
    
}
