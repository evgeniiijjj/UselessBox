public class UselessBox {
    private static final int toggleSwitchesNumber = 5; // переменная статик, поскольку объект главного класса не создается
    private static final int pause = 1000; // переменная статик, поскольку объект главного класса не создается

    public static void main(String[] args) throws InterruptedException {

        Toy toy = new Toy(pause);

        Thread user = new Thread(new User(toy, toggleSwitchesNumber, pause));

        user.start();

        Thread toyThread = new Thread(new Toy(pause));

        toyThread.setDaemon(true);

        toyThread.start();

        user.join();

        Thread.sleep(pause); // смысл этой паузы, чтобы игрушка успевала выключить тумблер, после завершения потока пользователя и до завершения главного потока.

        System.out.println("Игра завершилась");
    }
}
