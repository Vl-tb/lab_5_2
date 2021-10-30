package payment;

public class PayPalPaymentStrategy implements Payment{

    @Override
    public void pay(double price) {
        System.out.print("Payment by PayPal is processing...");
    }
}
