package view;

import java.util.Scanner;

public class PaymentView {

    private Scanner sc = new Scanner(System.in);

    public double inputAmount() {
        System.out.print("Masukkan jumlah pembayaran : ");
        return sc.nextDouble();
    }

    public int pilihMetode() {
        System.out.println("\n1. Wallet");
        System.out.println("2. Debit");
        System.out.println("3. Credit");
        System.out.println("4. E-Wallet");

        System.out.print("Pilih : ");
        return sc.nextInt();
    }
}