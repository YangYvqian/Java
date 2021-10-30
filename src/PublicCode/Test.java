package PublicCode;

public class Test {
    public static void main(String[] args) {
        new  B();
        // new A();
    }
    
}


class A<T>{
    public A(){
        // Class<T> tClass = T.class;
        // System.out.println(tClass);

        // Class clazz = this.getClass();
		// System.out.println(clazz.getName());
    }
}


class B extends A<String>{

}


