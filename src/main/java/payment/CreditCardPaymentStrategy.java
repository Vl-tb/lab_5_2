package payment;

public class CreditCardPaymentStrategy implements Payment{

    @Override
    public void pay(double price) {
        System.out.print("Payment by credit card is processing...");
    }
}
