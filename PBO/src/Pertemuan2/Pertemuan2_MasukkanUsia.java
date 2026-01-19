import java.util.Scanner;

public class Pertemuan2_MasukkanUsia {
    public static void main(String[] args) {
        // tipe data dan variabel
        int usia;

        // Scanner untuk membaca data masukkan
        Scanner kbd = new Scanner (System.in);

        // cetak perintah untuk data yang masukkan yang diminta
        System.out.print("Masukkan usia anda: ");
        usia = kbd.nextInt();

        //proses dan mencetak hasil
        System.out.println("Terima kasih. " + "Usia anda tahun depan: " + (usia + 1));
    }
}

