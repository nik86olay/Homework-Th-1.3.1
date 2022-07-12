public class ToggleSwitch {

    volatile boolean x = false;

    public void switchOn() {
        int iter = 5;
        int waitingTime = 2000;
        while (iter!=0) {
            if (!x) {
                System.out.println(x);
                System.out.println(Thread.currentThread().getName() + " включил тумблер " + (x = true));
                try {
                    Thread.sleep(waitingTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(iter--);
        }
    }

    public void switchOf() {
        while (!Thread.currentThread().isInterrupted()) {
            if(x) {
                System.out.println(x);
                System.out.println(Thread.currentThread().getName() + " выключила тумблер " + (x = false));
            }
        }
    }
}
