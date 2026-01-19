package ProyekAkhir;

public class MahasiswaLulus extends Mahasiswa {
    private int tahunLulus;
    private double ipkAkhir;

    public MahasiswaLulus() {}

    public void setTahunLulus(int tahunLulus) { this.tahunLulus = tahunLulus; }
    public void setIpkAkhir(double ipkAkhir) { this.ipkAkhir = ipkAkhir; }

    public int getTahunLulus() { return tahunLulus; }
    public double getIpkAkhir() { return ipkAkhir; }

    @Override
    public String getJenisMahasiswa() {
        return "Mahasiswa Lulus";
    }

    public void tampilkanDataLulus() {
        System.out.println("\n===== Data Mahasiswa Lulus =====");
        System.out.println("Jenis: " + getJenisMahasiswa());
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
        System.out.println("Prodi: " + getProdi());
        System.out.println("Tahun Lulus: " + tahunLulus);
        System.out.println("IPK Akhir: " + ipkAkhir);
        System.out.println("===============================");
    }
}
