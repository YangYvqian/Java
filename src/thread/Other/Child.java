package thread.Other;

public class Child extends Parent {
    
    public void crun(){
        System.out.println("child");
    }


    public static void main(String[] args) {
        Child c = new  Child();
        c.run();
    }

    
}



