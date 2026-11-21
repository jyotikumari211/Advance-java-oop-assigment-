class TicketCounter {
    private int available = 5;
    public synchronized boolean book(String customer) {
        if (available == 0) {
            System.out.println(customer + ": No tickets left");
            return false;
        }
        available--;
        System.out.println(customer + " booked a ticket. Remaining: " + available);
        return true;
    }
}
public class MultithreadedTicketBooking {
    public static void main(String[] args) throws InterruptedException {
        TicketCounter counter = new TicketCounter();
        Thread[] customers = new Thread[8];
        for (int i = 0; i < customers.length; i++) {
            final int id = i + 1;
            customers[i] = new Thread(() -> counter.book("Customer-" + id));
            customers[i].start();
        }
        for (Thread customer : customers) customer.join();
        System.out.println("Booking window closed.");
    }
}
