package MutilThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//public class Tickets extends Thread{
//    private  int num = 1000;
//    Lock lock = new ReentrantLock();
//    boolean loop = true;
//    public void desStock(){
//        while(loop){
//            lock.lock();
//            try {
//                if(num > 0){
//                    num --;
//                    System.out.println("窗口"+Thread.currentThread().getName()+ "售出 一张票 剩余票数=" + (num));
//                   // sleep(100);
//                    Thread.sleep(10);
//                }else{
//                    loop = false;
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }finally {
//                lock.unlock();
//            }
//        }
//
//    }
//
//}

class TicketSystem {
    private int availableTickets;
    private Lock lock;

    public TicketSystem(int totalTickets) {
        availableTickets = totalTickets;
        lock = new ReentrantLock();
    }

    public synchronized boolean sellTicket(int numTickets) {
        lock.lock();
        try {
            if (numTickets <= availableTickets) {
                System.out.println(Thread.currentThread().getName() + "：成功售出 " + numTickets + " 张票"+"余票还有："+availableTickets);
                availableTickets -= numTickets;
                return true;
            } else {
                System.out.println(Thread.currentThread().getName() + "：剩余票量不足");
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    public int getAvailableTickets() {
        return availableTickets;
    }
}
class TicketSeller implements Runnable {
    private TicketSystem ticketSystem;
    private int numTicketsToSell;

    public TicketSeller(TicketSystem system, int numTickets) {
        ticketSystem = system;
        numTicketsToSell = numTickets;
    }

    public void run() {
        while (ticketSystem.getAvailableTickets() > 0) {
            if (ticketSystem.sellTicket(numTicketsToSell)) {
                try {
                    Thread.sleep(100); // 模拟售票过程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
