package controller;

import model.*;

import java.util.List;
import java.util.Scanner;

public class PaymentProcessor {

    private Scanner sc = new Scanner(System.in);

    public void processPayment(
            PaymentStrategy strategy,
            double amount) {

        if (!strategy.canPay(amount)) {
            throw new RuntimeException(
                "Nominal tidak memenuhi aturan"
            );
        }

        if (!strategy.validate(amount)) {
            throw new RuntimeException(
                    "Saldo / limit tidak cukup"
            );
        }

        List<AuthorizationMethod> auths =
                strategy.getRequiredAuthorizations();

        for (AuthorizationMethod auth : auths) {

            switch (auth) {

                case PIN:
                    System.out.print("Masukkan PIN : ");
                    sc.nextLine();
                    break;

                case CCV:
                    System.out.print("Masukkan CCV : ");
                    sc.nextLine();
                    break;

                case OTP:
                    System.out.print("Masukkan OTP : ");
                    sc.nextLine();
                    break;
            }
        }

        strategy.pay(amount);
    }
}