// Kelas Induk/Superclass
class Pegawai {
    String nama;
    double gajiPokok;

    Pegawai(String nama, double gajiPokok) {
        this.nama = nama;
        this.gajiPokok = gajiPokok;
    }

    double hitungGaji() {
        return gajiPokok;
    }
}

// Kelas PegawaiTetap (turunan) / Subclass
class PegawaiTetap extends Pegawai {
    double tunjangan;

    PegawaiTetap(String nama, double gajiPokok, double tunjangan) {
        super(nama, gajiPokok);   // memanggil constructor Pegawai
        this.tunjangan = tunjangan;
    }

    @Override
    double hitungGaji() {
        return gajiPokok + tunjangan;
    }
}

// Kelas PegawaiKontrak (turunan) / Subclass
class PegawaiKontrak extends Pegawai {
    double bonusPerProyek;
    int jumlahProyek;

    PegawaiKontrak(String nama, double gajiPokok, double bonusPerProyek, int jumlahProyek) {
        super(nama, gajiPokok);
        this.bonusPerProyek = bonusPerProyek;
        this.jumlahProyek = jumlahProyek;
    }

    @Override
    double hitungGaji() {
        return gajiPokok + (bonusPerProyek * jumlahProyek);
    }
}

// Main untuk testing
public class Kuis3 {
    public static void main(String[] args) {
        Pegawai pegawaiTetap = new PegawaiTetap("Ilham Firmansyah", 3000000, 1000000);
        Pegawai pegawaiKontrak = new PegawaiKontrak("Achmad Rafli", 2000000, 500000, 2);

        System.out.println("Gaji Pegawai Tetap: " + pegawaiTetap.nama + " - " + pegawaiTetap.hitungGaji());
        System.out.println("Gaji Pegawai Kontrak: " + pegawaiKontrak.nama + " - " + pegawaiKontrak.hitungGaji());
    }
}
