package ProyekAkhir;

public class Mahasiswa {
    private String nama;
    private String nim;
    private String prodi;
    private String fakultas;
    private int semester;
    private String kampus;

    public Mahasiswa() {}

    // Setter
    public void setNama(String nama) { this.nama = nama; }
    public void setNim(String nim) { this.nim = nim; }
    public void setProdi(String prodi) { this.prodi = prodi; }
    public void setFakultas(String fakultas) { this.fakultas = fakultas; }
    public void setSemester(int semester) { this.semester = semester; }
    public void setKampus(String kampus) { this.kampus = kampus; }

    // Getter
    public String getNama() { return nama; }
    public String getNim() { return nim; }
    public String getProdi() { return prodi; }
    public String getFakultas() { return fakultas; }
    public int getSemester() { return semester; }
    public String getKampus() { return kampus; }

    // Sesi 9: Method Overriding
    public String getJenisMahasiswa() {
        return "Mahasiswa (Induk/Super Class)";
    }
}
