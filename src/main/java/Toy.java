public class Toy implements Runnable {
    private volatile boolean toggle;

    public Toy() {
        toggle = false;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        while (true) {
            if (toggle) {
                try {
                    Thread.sleep(UselessBox.PAUSE);// пауза перед выключением тумблера игрушки
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

    public void toggleOn() {
        toggle = true;
    }
}
