import java.util.concurrent.atomic.AtomicBoolean;

public class UselessBox {
    static final AtomicBoolean toggle = new AtomicBoolean(false); // атомик вполне подходит здесь, кроме того переменная ссылочная удобно передавать юзеру и игрушке, переменная статик, потому что я не создаю объект главного класса, переменная не приватная ну и что? приватность здесь ни к чему
    static final int cyclesNum = 5; // переменная статик, потому что я не создаю объект главного класса, переменная не приватная ну и что? приватность здесь ни к чему
    static final int pause = 1000; // переменная статик, потому что я не создаю объект главного класса, переменная не приватная ну и что? приватность здесь ни к чему

    public static void main(String[] args) throws InterruptedException {

        Thread user = new Thread(new User(toggle, cyclesNum, pause));

        user.start();

        Thread toy = new Thread(new Toy(toggle, pause));

        toy.setDaemon(true);

        toy.start();

        user.join();

        Thread.sleep(pause); // смысл этой паузы, чтобы игрушка успевала выключить тумблер, после завершения потока пользователя.

        System.out.println("Игра завершилась");
    }
}
