import java.util.Scanner;

public class Soal2_ArrayIndex {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Array dengan 5 data
        int[] data = {10, 20, 30, 40, 50};

        while (true) {  // ulang terus sampai index valid
            try {
                System.out.print("Masukkan index array (0-4): ");
                int index = input.nextInt();

                System.out.println("Isi array pada index " + index + " adalah: " + data[index]);
                break; // keluar kalau berhasil

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Index keluar dari batas! Index valid adalah 0 sampai 4.\n");
            }
        }

        System.out.println("Program selesai.");
    }
}
