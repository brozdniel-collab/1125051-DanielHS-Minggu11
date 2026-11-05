package model;

import java.util.List;

public class CreditCard implements PaymentStrategy {

    private String cardNumber;
    private double limit;
    private double currentDebt;
    private String ccv;
    private String pin;

    public CreditCard(String cardNumber,
                      double limit,
                      String ccv,
                      String pin) {

        this.cardNumber = cardNumber;
        this.limit = limit;
        this.ccv = ccv;
        this.pin = pin;
        this.currentDebt = 0;
    }

    public String getPin() {
        return pin;
    }

    public String getCcv() {
        return ccv;
    }

    @Override
    public boolean validate(double amount) {
        return (currentDebt + amount) <= limit;
    }

    @Override
    public void pay(double amount) {
        currentDebt += amount;
        System.out.println("Pembayaran credit berhasil");
        System.out.println("Total hutang: " + currentDebt);
    }

    @Override
    public List<AuthorizationMethod> getRequiredAuthorizations() {
        return List.of(
                AuthorizationMethod.CCV,
                AuthorizationMethod.PIN
        );
    }

    @Override
    public boolean canPay(double amount) {
        return amount >= 100_000 &&
               amount <= 100_000_000;
    }

    @Override
    public String toString() {
        return "Credit Card";
    }
}