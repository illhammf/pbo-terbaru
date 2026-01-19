package ProyekAkhir;

public class MahasiswaCuti extends Mahasiswa {
    private String alasanCuti;
    private int durasiCuti;

    public MahasiswaCuti() {}

    public void setAlasanCuti(String alasan) { this.alasanCuti = alasan; }
    public void setDurasiCuti(int durasi) { this.durasiCuti = durasi; }

    public String getAlasanCuti() { return alasanCuti; }
    public int getDurasiCuti() { return durasiCuti; }

    @Override
    public String getJenisMahasiswa() {
        return "Mahasiswa Cuti";
    }

    public void tampilkanDataCuti() {
        System.out.println("\n===== Data Mahasiswa Cuti =====");
        System.out.println("Jenis: " + getJenisMahasiswa());
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
        System.out.println("Prodi: " + getProdi());
        System.out.println("Alasan Cuti: " + alasanCuti);
        System.out.println("Durasi Cuti (Semester): " + durasiCuti);
        System.out.println("===============================");
    }
}
