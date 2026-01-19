public class LuasPersegiPanjang {
    // Fungsi
    static int hitungLuas(int panjang, int lebar) {
        return panjang * lebar;
    }

    public static void main(String[] args) {
        int panjang = 8;  // nilai panjang
        int lebar = 4;    // nilai lebar

        int luas = hitungLuas(panjang, lebar);
        System.out.println("Panjang = " + panjang + ", Lebar = " + lebar);
        System.out.println("Luas Persegi Panjang = " + luas);
    }
}
