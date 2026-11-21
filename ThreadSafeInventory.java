import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
class Inventory {
    private final ConcurrentMap<String, AtomicInteger> stock = new ConcurrentHashMap<>();
    public void add(String item, int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
        stock.computeIfAbsent(item, k -> new AtomicInteger()).addAndGet(quantity);
    }
    public boolean sell(String item, int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
        AtomicInteger count = stock.get(item);
        if (count == null) return false;
        while (true) {
            int current = count.get();
            if (current < quantity) return false;
            if (count.compareAndSet(current, current - quantity)) return true;
        }
    }
    public int getStock(String item) {
        AtomicInteger count = stock.get(item);
        return count == null ? 0 : count.get();
    }
}
public class ThreadSafeInventory {
    public static void main(String[] args) throws InterruptedException {
        Inventory inventory = new Inventory();
        inventory.add("Laptop", 20);
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 30; i++) pool.submit(() -> inventory.sell("Laptop", 1));
        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Laptop stock remaining: " + inventory.getStock("Laptop"));
    }
}
