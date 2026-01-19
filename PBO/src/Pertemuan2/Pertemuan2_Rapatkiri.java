public class Pertemuan2_Rapatkiri {
    public static void main (String [] args){
        String namaBarang = "Buku Pemrograman Berorientasi Objek"; // variabel bertipe String untuk menyimpan nama barang
        int harga = 102000; // variabel bertipe int untuk menyimpan harga barang

        // Cetak namaBarang dan harga secara sederhana (tanpa format khusus)
        System.out.println("|" + namaBarang + " | " + harga + "|" );

        // Cetak dengan format: namaBarang rata kanan 30 karakter, harga rata kanan 10 digit
        System.out.printf("%30s | %10d |\n", namaBarang, harga);

        // Cetak dengan format: namaBarang rata kiri 30 karakter, harga rata kanan 10 digit
        System.out.printf("%-30s | %10d |\n", namaBarang, harga);
    }
}

