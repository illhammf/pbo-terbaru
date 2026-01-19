import java.util.InputMismatchException;
import java.util.Scanner;

public class Soal1Pembagian {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {   // akan berhenti hanya jika pembagian berhasil
            try {
                System.out.print("Masukkan angka pertama: ");
                int a = input.nextInt();

                System.out.print("Masukkan angka kedua: ");
                int b = input.nextInt();

                int hasil = a / b;
                System.out.println("Hasil pembagian: " + hasil);
                break; // keluar dari loop kalau berhasil

            } catch (ArithmeticException e) {
                System.out.println("Error: Tidak bisa membagi dengan nol! Coba lagi.\n");
            } catch (InputMismatchException e) {
                System.out.println("Error: Input harus berupa angka! Coba lagi.\n");
                input.nextLine(); // bersihkan buffer biar tidak looping tanpa henti
            }
        }

        System.out.println("Program selesai.");
        input.close();
    }
}
