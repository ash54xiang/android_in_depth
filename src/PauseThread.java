package src;

public class PauseThread {
    public static void main(String[] args) {
        Thread detectCardTh = new Thread();
        Thread vtsApiCallTh = new Thread();
    }

    public class ApiCall implements Runnable {
        @Override
        public void run() {
            boolean inGeoFence = false;
            int count = 0;
            while(true) {
                count++;
                if (count == 50) {
                    inGeoFence = true;
                    if (inGeoFence)
                    {
                        try {
                            Thread.currentThread().wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public class DetectCard implements Runnable {
        @Override
        public void run() {
            int count = 0;
            while(true) {
                count++;
                if (count == 100) {
                    System.out.println("Pausing th: count = " + count);
                    System.out.println("Pausing t");
                }
            }
            
        }
    }
}
