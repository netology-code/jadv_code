import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();

        List<Integer> list2 = Collections.synchronizedList(list);

        new Thread(() -> {
            list2.add(1);
            list2.add(2);
            list2.add(3);
            list2.add(4);
        }).start();

        new Thread(() -> {
            for (int e : list2) {
                System.out.println(e);
            }
        }).start();
    }
}
