public class User implements Runnable {

    private final Toy toy;

    public User(Toy toy) {
        this.toy = toy;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        int i = 0;
        while (i < UselessBox.CLICKS) {
            if (toy.isToggleOff()) {
                try {
                    Thread.sleep(UselessBox.PAUSE); // пауза перед включением тумблера игрушки
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
