import java.util.*;

public class Aritmatika {
    private static int jumlah (int a,int b) {
        int hasil = a + b;
        return hasil;
        }

        private static int kurang (int a,int b) {
        int hasil = a - b;
        return hasil;
        }

        private static int kali (int a,int b) {
        int hasil = a * b;
        return hasil;
        }

        private static int bagi (int a,int b) {
        if ( b == 0){
            System.out.println ("Tidak bisa dengan 0");
            return 0;
        }
        
        int hasil = (int) a / b;
        return hasil;
        }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print ("Masukkan angka pertama: ");
        int a = input.nextInt();
        System.out.print ("Masukkan angka kedua: ");
        int b = input.nextInt();

        System.out.println("===== ARITMATIKA =====");
        System.out.println("Masukkan Pilihan: ");
        System.out.println("1. Penjumlahan");
        System.out.println("2. Pengurangan");
        System.out.println("3. Perkalian");
        System.out.println("4. Pengurangan");
        System.out.println("\nPilihan: ");
        int pilihan = input.nextInt();

        switch (pilihan) {
            case 1:
            System.out.print("Hasil Penjumlahan: " + jumlah(a,b));
            break;
            case 2:
            System.out.print("Hasil Pengurangan: " + kurang(a,b));
            break;
            case 3:
            System.out.print("Hasil Perkalian: " + kali(a,b));
            break;
            case 4:
            System.out.print("Hasil Pe: " + bagi(a,b));
            break;
            default:
            System.out.print("Pilihan tidak valid");
        }
    }
}
    
