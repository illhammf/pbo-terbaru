package ProyekAkhir;

public class MahasiswaAktif extends Mahasiswa {
    private int sksTempuh;
    private double ipk;
    private String status;

    public MahasiswaAktif() {}

    public void setSksTempuh(int sksTempuh) { this.sksTempuh = sksTempuh; }
    public void setIpk(double ipk) { this.ipk = ipk; }
    public void setStatus(String status) { this.status = status; }

    public int getSksTempuh() { return sksTempuh; }
    public double getIpk() { return ipk; }
    public String getStatus() { return status; }

    @Override
    public String getJenisMahasiswa() {
        return "Mahasiswa Aktif";
    }

    public void tampilkanDataLengkap() {
        System.out.println("\n===========================================");
        System.out.println("===== Data Mahasiswa Aktif (Turunan) =====");
        System.out.println("Jenis: " + getJenisMahasiswa());
        System.out.println("===========================================");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
        System.out.println("Prodi: " + getProdi());
        System.out.println("Fakultas: " + getFakultas());
        System.out.println("Semester: " + getSemester());
        System.out.println("Kampus: " + getKampus());
        System.out.println("SKS Tempuh: " + getSksTempuh());
        System.out.println("IPK: " + getIpk());
        System.out.println("Status: " + getStatus());
        System.out.println("===========================================\n");
    }
}
