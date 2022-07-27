public class UselessBox {
    public static final int CLICKS = 5;
    public static final int PAUSE = 1000;

    public static void main(String[] args) throws InterruptedException {

        Toy toy = new Toy();

        Thread userThread = new Thread(new User(toy));

        userThread.start();

        Thread toyThread = new Thread(toy);

        toyThread.setDaemon(true);

        toyThread.start();

        userThread.join();

        Thread.sleep(PAUSE);

        System.out.println("Игра завершилась");
    }
}
