import java.util.Scanner;

public class Soal3_Throws {
    static Scanner input = new Scanner(System.in);

    // Method yang melempar NumberFormatException
    public static int bacaAngka() throws NumberFormatException {
        System.out.print("Masukkan angka: ");
        String teks = input.nextLine();
        // Parsing: bisa menyebabkan NumberFormatException
        return Integer.parseInt(teks);
    }

    public static void main(String[] args) {

        while (true) {
            try {
                int angka = bacaAngka();
                System.out.println("Angka yang dimasukkan: " + angka);
                break;  // keluar jika sukses
            }
            catch (NumberFormatException e) {
                System.out.println("Error: Input bukan angka! Coba lagi.\n");
            }
        }

        System.out.println("Program selesai yeay.");
    }
}
