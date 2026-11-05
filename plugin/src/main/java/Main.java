import controller.PaymentProcessor;
import model.*;
import view.PaymentView;

public class Main {

    public static void main(String[] args) {

        PaymentView view = new PaymentView();
        PaymentProcessor processor =
                new PaymentProcessor();

        Wallet wallet =
                new Wallet("Utama", 10000);

        DebitCard debit =
                new DebitCard(
                        "11112222",
                        100000,
                        "1234"
                );

        CreditCard credit =
                new CreditCard(
                        "99998888",
                        5000000,
                        "123",
                        "1234"
                );

        EWallet ewallet =
                new EWallet(
                        "08123456789",
                        500000,
                        "4321"
                );

        double amount = view.inputAmount();
        int pilihan = view.pilihMetode();

        switch (pilihan) {
            case 1 -> processor.processPayment(wallet, amount);
            case 2 -> processor.processPayment(debit, amount);
            case 3 -> processor.processPayment(credit, amount);
            case 4 -> processor.processPayment(ewallet, amount);
        }
    }
}
