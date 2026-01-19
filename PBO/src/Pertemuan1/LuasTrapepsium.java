public class LuasTrapepsium {

    // Fungsi untuk menghitung luas trapesium
    static double hitungLuas(double sisiAtas, double sisiBawah, double tinggi) {
        return 0.5 * (sisiAtas + sisiBawah) * tinggi;
    }

    public static void main(String[] args) {
        double sisiAtas = 8;   // sisi sejajar pertama
        double sisiBawah = 12; // sisi sejajar kedua
        double tinggi = 6;     // tinggi trapesium

        double luas = hitungLuas(sisiAtas, sisiBawah, tinggi);

        System.out.println("Sisi Atas = " + sisiAtas + 
                           ", Sisi Bawah = " + sisiBawah + 
                           ", Tinggi = " + tinggi);
        System.out.println("Luas Trapesium = " + luas);
    }
}

    

