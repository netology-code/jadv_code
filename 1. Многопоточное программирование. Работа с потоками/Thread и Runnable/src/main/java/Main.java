public class Main {

    public static void main(String[] args) throws InterruptedException {
        Runnable logic = () -> {
          for (int i = 0; i < 30; i++) {
              System.out.println("Hello from thread");
          }
        };

        Thread thread = new Thread(logic);
        thread.start();

        for (int i = 0; i < 30; i++) {
            System.out.println("Hello from main");
        }
    }
}
