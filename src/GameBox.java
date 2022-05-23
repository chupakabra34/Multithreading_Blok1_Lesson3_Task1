import static java.lang.System.*;
import static java.lang.Thread.currentThread;

public class GameBox {
    private volatile boolean boxStatus;
    private final int USER_SLEEP = 2000;
    private final int LIMIT_OPEN_TIMES = 10;
    private int currentStatusLimitOpenTimes = 0;
    private final int TOY_SLEEP = 1000;

    public void on() {
        try {
            while (currentStatusLimitOpenTimes < LIMIT_OPEN_TIMES) {
                if (!boxStatus) {
                    boxStatus = true;
                    out.printf("%s включил тумблер. Коробка открылась.\n", currentThread().getName());
                }
                currentThread().join(USER_SLEEP);
            }
        } catch (InterruptedException e) {
            out.printf("Поток %s прервал свою работу\n", currentThread().getName());
        }
    }

    public void off() {
        try {
            while (currentStatusLimitOpenTimes != LIMIT_OPEN_TIMES) {
                if (boxStatus) {
                    boxStatus = false;
                    out.printf("%s переключила тумблер. Коробка закрылась.\n", currentThread().getName());
                    currentStatusLimitOpenTimes++;
                }
                currentThread().join(TOY_SLEEP);
            }
        } catch (InterruptedException e) {
            out.printf("Поток %s прервал свою работу\n", currentThread().getName());
        }
        Thread.interrupted();
    }
}