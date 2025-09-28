package Structural.Adapter;

public class Client {
    public static void main(String args[]){
        PaymentProcessor payment = new PaymentAdapter(new BankPaymentGateway());
        System.out.println(payment.pay(1000));
    }
}
