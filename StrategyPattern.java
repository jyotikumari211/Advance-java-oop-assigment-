interface PaymentStrategy { void pay(double amount); }
class CardPayment implements PaymentStrategy {
    public void pay(double amount) { System.out.println("Paid Rs." + amount + " using card"); }
}
class UpiPayment implements PaymentStrategy {
    public void pay(double amount) { System.out.println("Paid Rs." + amount + " using UPI"); }
}
class Checkout {
    private PaymentStrategy strategy;
    public void setPaymentStrategy(PaymentStrategy strategy) { this.strategy = strategy; }
    public void completePayment(double amount) {
        if (strategy == null) throw new IllegalStateException("Choose a payment method first");
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        strategy.pay(amount);
    }
}
public class StrategyPattern {
    public static void main(String[] args) {
        Checkout checkout = new Checkout();
        checkout.setPaymentStrategy(new CardPayment());
        checkout.completePayment(1250);
        checkout.setPaymentStrategy(new UpiPayment());
        checkout.completePayment(799);
    }
}
