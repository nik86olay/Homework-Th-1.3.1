public class Main {

    public static void main(String[] args) throws InterruptedException {
        ToggleSwitch toggleSwitch = new ToggleSwitch();
        Thread threadUser = new Thread(null, toggleSwitch::switchOn, "Пользователь");
        Thread threadGame = new Thread(null, toggleSwitch::switchOf, "Игрушка");

        threadUser.start();
        threadGame.start();
        threadUser.join();

        System.out.println(threadUser.getState() + " " + threadUser.getName());
        System.out.println(threadGame.getState() + " " + threadGame.getName());

        if(!threadUser.isAlive()) threadGame.interrupt();
        int waitingTimeThreadGame = 2000;
        Thread.sleep(waitingTimeThreadGame);

        System.out.println(threadGame.getState() + " " + threadGame.getName());

    }
}
