import java.util.ArrayList;
import java.util.List;

public class example {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> x = new ArrayList<>();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (x){
                    while(true){
                        System.out.println("t1");
                    }
                }
            }
        };
        t1.start();
        Thread t2 = new Thread() {
            @Override
            public void run() {
//                synchronized (x){
                    while(true){
                        System.out.println("t2-"+x.size());
                        System.out.println("t2");
//                    }
                }
            }
        };
        t2.start();
    }

}

class C {
    int i;
}