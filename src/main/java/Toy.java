public class Toy implements Runnable {
    private volatile boolean toggle;
    private final int pause;

    public Toy(int pause) {
        this.pause = pause;
        toggle = false;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        while (true) {
            if (toggle) {
                try {
                    Thread.sleep(pause);// пауза перед выключением тумблера игрушки
                } catch (InterruptedException ignored) {
                }
                toggle = false;
                System.out.printf("Игрушка %s выключил тумблер\n", thread.getName());
            }
        }
    }

    public boolean isToggleOff() {
        return !toggle;
    }

    public synchronized void toggleOn() {
        toggle = true;
    }
}
