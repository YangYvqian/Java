// ***************************************//
//********* Immutable模式简单程序 *********//
// ***************************************//
/*
    class：
        Person               表示人的类
        Main                 测试程序行为的类
        PrintPersonThread    显示Person实例的线程的类
*/

package thread.Immutable;

public class PrintPersonThread extends Thread{
    private Person person;

    public PrintPersonThread(Person person){
        this.person = person;
    }

    public void run(){
        while(true){
            System.out.println(Thread.currentThread().getName() + "prints" + person);
        }
    }

    public static void main(String[] args) {
        Person alice = new Person("Alice", "Alaska");
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
        
    }
}
