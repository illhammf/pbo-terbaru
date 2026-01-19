import java.util.Scanner;

public class NamaHari {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Pilih hari (0-6): ");
        int pilihan = input.nextInt();

        if (pilihan == 0) {
            System.out.println("Minggu");
        } else if (pilihan == 1) {
            System.out.println("Senin");
        } else if (pilihan == 2) {
            System.out.println("Selasa");
        } else if (pilihan == 3) {
            System.out.println("Rabu");
        } else if (pilihan == 4) {
            System.out.println("Kamis");
        } else if (pilihan == 5) {
            System.out.println("Jumat");
        } else if (pilihan == 6) {
            System.out.println("Sabtu");
        } else {
            System.out.println("Pilihan tidak valid");
        }
    }
}

