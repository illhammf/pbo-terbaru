import java.util.Scanner;

// ===============================================
// Pertemuan 2: Tipe Data, Variabel, Method, Ekspresi
// Pertemuan 3: Control Statement (if-else, do-while)
// Pertemuan 4: Function dan Parameter
// ===============================================
public class DataMahasiswaChar {

    // Fungsi input karakter tunggal (char)
    static char inputChar(String pesan) {
        Scanner input = new Scanner(System.in);
        System.out.print(pesan);
        return input.next().charAt(0);
    }

    // Fungsi input semester (dengan validasi)
    static int inputSemester() {
        Scanner input = new Scanner(System.in);
        System.out.print("Semester: ");
        int semester = input.nextInt();

        if (semester <= 0) {
            System.out.println("Semester tidak boleh negatif atau nol!");
            return -1;
        } else if (semester > 14) {
            System.out.println("Semester tidak boleh lebih dari 14!");
            return -1;
        }
        return semester;
    }

    // Fungsi memilih kampus (pakai do-while dan if-else)
    static char pilihKampus() {
        Scanner input = new Scanner(System.in);
        int kodeKampus;
        char kampus = ' '; // char kosong

        do {
            System.out.println("\n----- Pilih Kampus -----");
            System.out.println("1. Jakarta (J)");
            System.out.println("2. Bekasi (B)");
            System.out.println("3. Tangerang (T)");
            System.out.println("------------------------");
            System.out.print("Masukkan kode kampus (1-3): ");
            kodeKampus = input.nextInt();

            if (kodeKampus == 1) {
                kampus = 'J';
            } else if (kodeKampus == 2) {
                kampus = 'B';
            } else if (kodeKampus == 3) {
                kampus = 'T';
            } else {
                System.out.println("Kode kampus tidak valid! Silakan coba lagi.\n");
            }

        } while (kodeKampus < 1 || kodeKampus > 3); // Ulangi kalau input salah

        return kampus;
    }

    // Fungsi menampilkan data mahasiswa
    static void tampilkanData(char nama, char nim, char prodi, char fakultas, int semester, char kampus) {
        System.out.println("\n===========================================");
        System.out.println("===== Sistem Manajemen Data Mahasiswa =====");
        System.out.println("===========================================");
        System.out.println("Nama (inisial): " + nama);
        System.out.println("NIM (digit awal): " + nim);
        System.out.println("Prodi (huruf awal): " + prodi);
        System.out.println("Fakultas (huruf awal): " + fakultas);
        System.out.println("Semester (angka): " + semester);
        System.out.println("Kampus (huruf): " + kampus);
        System.out.println("===========================================\n");
    }

    // Fungsi Utama (Main)
    public static void main(String[] args) {
        // Input Data (hanya 1 karakter)
        char nama = inputChar("Masukkan huruf awal Nama: ");
        char nim = inputChar("Masukkan digit awal NIM: ");
        char prodi = inputChar("Masukkan huruf awal Prodi: ");
        char fakultas = inputChar("Masukkan huruf awal Fakultas: ");

        // Input semester (dengan validasi)
        int semester = inputSemester();
        if (semester == -1) {
            System.out.println("Input semester tidak valid. Program dihentikan.");
            return;
        }

        // Pilih kampus (pakai if-else + do-while)
        char kampus = pilihKampus();

        // Tampilkan hasil akhir
        tampilkanData(nama, nim, prodi, fakultas, semester, kampus);
    }
}
