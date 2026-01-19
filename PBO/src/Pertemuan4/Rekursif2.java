import java.util.*;

public class Rekursif2 {
    static int jumlahDeret(int n) {
        if ( n == 1){
            System.out.print ("1");
            return 1;
        } else {
            int hasilSebelum = jumlahDeret (n - 1);
            System.out.print ("+" +n);
            return n + hasilSebelum;
        }
    }

    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.print ("Masukkan angka: ");
        int n = input.nextInt();

        System.out.print("Proses: ");
        int hasil = jumlahDeret(n);
        System.out.print("= " + hasil);
    }
}