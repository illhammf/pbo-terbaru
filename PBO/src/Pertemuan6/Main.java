class Mahasiswa {
    private String nama;
    private String nim;
    private Double ipk;

    public Mahasiswa(String nama, String nim, Double ipk) { // konstruktor
        this.nama = nama;
        this.nim = nim;
        this.ipk = ipk;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setIpk(Double ipk) {
        this.ipk = ipk;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public Double getIpk() {
        return ipk;
    }
}

public class Main {
    public static void main(String[] args) {
        Mahasiswa mhs = new Mahasiswa("Ilham Firmansyah", "20240801102", 3.90); // membuat objek

        System.out.println ("Nama: " + mhs.getNama()); // menampilkan data (Getter)
        System.out.println ("NIM: " + mhs.getNim());
        System.out.println ("IPK: " + mhs.getIpk());
    }
}