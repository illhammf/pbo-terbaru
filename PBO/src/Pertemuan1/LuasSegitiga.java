public class LuasSegitiga {
    // Fungsi
    static double hitungLuas(double alas, double tinggi) {
        return 0.5 * alas * tinggi;
    }

    public static void main(String[] args) {
        double alas = 10;     // nilai alas
        double tinggi = 5;    // nilai tinggi
        double luas = hitungLuas(alas, tinggi);
        System.out.println("Alas = " + alas + ", Tinggi = " + tinggi);
        System.out.println("Luas Segitiga = " + luas);
    }
}
