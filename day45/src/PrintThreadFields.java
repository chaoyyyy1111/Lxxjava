public class PrintThreadFields {

    /*static class SubThread extends Thread {
        @Override
        public void run() {

                printFields();


        }
    }

     */
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    printFields();
                    Thread.sleep(100*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        /*SubThread subThread = new SubThread();
        subThread.start();
         */
        printFields();
        Thread.sleep(100*1000);
    }
    public static void printFields() {
        Thread t = Thread.currentThread();
        long id = t.getId();
        System.out.println(id + " "+t.getPriority());
        System.out.println(id+" "+t.getName());
        System.out.println(id+" "+t.getState());
        System.out.println(id+" "+t.isDaemon());
        System.out.println(id+" "+t.isAlive());
    }
}
