package ProyekAkhir;

public class MahasiswaBaru extends Mahasiswa {
    private String asalSekolah;
    private int tahunMasuk;

    public MahasiswaBaru() {}

    public void setAsalSekolah(String asal) { this.asalSekolah = asal; }
    public void setTahunMasuk(int tahun) { this.tahunMasuk = tahun; }

    public String getAsalSekolah() { return asalSekolah; }
    public int getTahunMasuk() { return tahunMasuk; }

    @Override
    public String getJenisMahasiswa() {
        return "Mahasiswa Baru";
    }

    public void tampilkanDataBaru() {
        System.out.println("\n===== Data Mahasiswa Baru =====");
        System.out.println("Jenis: " + getJenisMahasiswa());
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
        System.out.println("Prodi: " + getProdi());
        System.out.println("Asal Sekolah: " + asalSekolah);
        System.out.println("Tahun Masuk: " + tahunMasuk);
        System.out.println("===============================");
    }
}
