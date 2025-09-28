package Structural.Adapter;
//Adapter
public class PaymentAdapter implements PaymentProcessor{
    private BankPaymentGateway payment;
    PaymentAdapter(BankPaymentGateway payment){
        this.payment = payment;
    }

    @Override
    public String pay(int amount){
        return payment.makeTransaction(amount);
    }
}
