import static java.lang.System.out;

public class Gamer extends Thread {
    private static final int USER_SLEEP = 2000;
    private static final int LIMIT_OPEN_TIMES = 5;

    @Override
    public void run() {
        for (int i = 0; i < LIMIT_OPEN_TIMES; i++) {
            if (!Main.boxStatus) {
                Main.boxStatus = true;
                out.printf("%s включил тумблер. Коробка открылась.\n", currentThread().getName());
                try {
                    Thread.sleep(USER_SLEEP);
                } catch (InterruptedException e) {
                    out.printf("Поток %s прервал свою работу\n", currentThread().getName());
                }
            }
        }
    }

}