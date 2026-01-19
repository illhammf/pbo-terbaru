import java.util.Scanner;

public class DiskonPembelian {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah pembelian: ");
        double total = input.nextDouble();

        if (total >= 50000) {
            double diskon = total * 0.10;
            double bayar = total - diskon;
            System.out.println("Total belanja: " + total);
            System.out.println("Diskon: " + diskon);
            System.out.println("Total bayar: " + bayar);
        } else {
            System.out.println("Total bayar: " + total + " (tidak mendapat diskon)");
        }
    }
}

