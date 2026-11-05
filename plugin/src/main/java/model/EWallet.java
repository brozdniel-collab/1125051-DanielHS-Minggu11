package model;

import java.util.List;

public class EWallet implements PaymentStrategy {

    private String phoneNumber;
    private double balance;
    private String pin;

    public EWallet(String phoneNumber,
                   double balance,
                   String pin) {

        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    @Override
    public boolean validate(double amount) {
        return balance >= amount;
    }

    @Override
    public void pay(double amount) {
        balance -= amount;
        System.out.println("Pembayaran E-Wallet berhasil");
    }

    @Override
    public List<AuthorizationMethod> getRequiredAuthorizations() {
        return List.of(
                AuthorizationMethod.PIN,
                AuthorizationMethod.OTP
        );
    }

    @Override
    public boolean canPay(double amount) {
        return amount > 0;
    }
}