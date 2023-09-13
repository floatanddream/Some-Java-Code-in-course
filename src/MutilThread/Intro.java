package MutilThread;

public class Intro {
    public static void main(String[] args)
    {
//        Tickets tickets1=new Tickets();
//        new Thread(()->{tickets1.desStock();},"AA").start();
//        new Thread(()->{tickets1.desStock();},"BB").start();
//        new Thread(()->{tickets1.desStock();},"CC").start();
//        new Thread(()->{tickets1.desStock();},"DD").start();
//        new Thread(()->{tickets1.desStock();},"EE").start();
//        new Thread(()->{tickets1.desStock();},"FF").start();
        TicketSystem ticketSystem = new TicketSystem(100);

        int numSellers = 5;
        Thread[] sellerThreads = new Thread[numSellers];

        for (int i = 0; i < numSellers; i++) {
            TicketSeller seller = new TicketSeller(ticketSystem, 1);
            sellerThreads[i] = new Thread(seller);
            sellerThreads[i].start();
        }

        for (Thread thread : sellerThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("所有票已售完");
    }
}
