import java.util.*;
class Product implements Comparable<Product> {
    private final int id; private final String name; private final double price;
    Product(int id, String name, double price) { this.id=id; this.name=name; this.price=price; }
    public int compareTo(Product other) { return Double.compare(this.price, other.price); }
    public String getName() { return name; }
    public String toString() { return id + " " + name + " Rs." + price; }
}
public class ComparableComparator {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(3, "Keyboard", 1200), new Product(1, "Mouse", 600), new Product(2, "Monitor", 9000)
        ));
        Collections.sort(products); // Natural order: price
        System.out.println("Sorted by price:");
        products.forEach(System.out::println);
        products.sort(Comparator.comparing(Product::getName)); // Custom order: name
        System.out.println("Sorted by name:");
        products.forEach(System.out::println);
    }
}
