class Nama {
    void tampilkanNama(String hewan, String nama) {
        System.out.println("Nama " + hewan + " : " + nama);
    }
}

class Kucing extends Nama {
    private String nama;
    private String hewan = "Kucing";
    
    public String getNama() {
        return nama;
    }
    public String getHewan() {
        return hewan;
    }
    public void setNama(String namaBaru) {
        this.nama = namaBaru;
    }
}

class Kambing extends Nama {
    private String nama;
    private String hewan = "Kambing";
    
    public String getNama() {
        return nama;
    }
    public String getHewan() {
        return hewan;
    }
    public void setNama(String namaBaru) {
        this.nama = namaBaru;
    }
}

public class ContohTurunan {
    public static void main(String[] args) {
        Kucing kcng = new Kucing();
        Kambing kmbng = new Kambing();
        
        kcng.setNama("Rizky");
        kmbng.setNama("Christopher Tupen");
        
        kcng.tampilkanNama(kcng.getHewan(), kcng.getNama());
        kmbng.tampilkanNama(kmbng.getHewan(), kmbng.getNama());
    }
}