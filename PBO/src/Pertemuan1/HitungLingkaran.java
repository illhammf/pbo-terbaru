package Pertemuan1;

public class HitungLingkaran {
    // Method untuk menghitung luas lingkaran
    static double hitungLuas(double r) {
        // ekspresi
        return Math.PI * Math.pow(r, 2);  // π * r^2
    }

    // Method untuk menghitung keliling lingkaran
    static double hitungKeliling(double r) {
        // ekspresi
        return 2 * Math.PI * r;
    }

    public static void main(String[] args) {
        // Tipe data dan variabel
        double jariJari = 7;  // variabel untuk menyimpan jari-jari lingkaran

        // Panggil method dan simpan hasil ke variabel
        double luas = hitungLuas(jariJari);
        double keliling = hitungKeliling(jariJari);

        // Hasil
        System.out.println("Jari-jari = " + jariJari);
        System.out.println("Luas Lingkaran = " + luas);
        System.out.println("Keliling Lingkaran = " + keliling);
    }
}

