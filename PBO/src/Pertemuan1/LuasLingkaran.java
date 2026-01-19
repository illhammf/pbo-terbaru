import java.util;

public class luasLingkaran {
    // Fungsi
    static double hitungLuas(double r) {
        return Math.PI * r * r;
    }

    public static void main(String[] args) {
        double r = 7;  // nilai jari-jari

        double luas = hitungLuas(r);
        System.out.println("Jari-jari = " + r);
        System.out.println("Luas Lingkaran = " + luas);
    }
}
