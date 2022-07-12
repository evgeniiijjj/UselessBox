public class User implements Runnable {

    private final Toy toy;
    private final int toggleSwitchesNumber;
    private final int pause;

    public User(Toy toy, int toggleSwitchesNumber, int pause) {
        this.toy = toy;
        this.toggleSwitchesNumber = toggleSwitchesNumber;
        this.pause = pause;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        int i = 0;
        while (i < toggleSwitchesNumber) {
            if (toy.isToggleOff()) {
                try {
                    Thread.sleep(pause); // пауза перед включением тумблера игрушки
                } catch (InterruptedException ignored) {
                }
                toy.toggleOn();
                System.out.printf("Пользователь %s включил тумблер\n", name);
                i++;
            }
        }
        System.out.println("Пользователь закончил игру");
    }
}
