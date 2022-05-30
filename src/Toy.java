public class Toy extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (Main.boxStatus) {
                System.out.printf("%s переключила тумблер. Коробка закрылась.\n", currentThread().getName());
                Main.boxStatus = false;
            }
        }
    }
}