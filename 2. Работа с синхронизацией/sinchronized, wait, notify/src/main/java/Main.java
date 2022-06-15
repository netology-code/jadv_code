import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        List<String> names = new ArrayList<>();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (names) {
                    names.add("Имя номер " + i);
                    names.notify();
                    //
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (names) {
                    if (names.isEmpty()) {
                        try {
                            names.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Обслужили покупателя " + names.remove(0));
                }
            }
        }).start();
    }
}
