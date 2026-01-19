class Hewan {
    String nama;
    int umur;
}

class Kucing extends Hewan {
    protected void suaraKucing() {
        System.out.println("Meong!");
    }
}

public class Kuis1 { // Main
    public static void main(String[] args) {
        Kucing kucing = new Kucing();
        kucing.nama = "Ucup";
        kucing.umur = 4;

        System.out.println("Nama: " + kucing.nama);
        System.out.println("Umur: " + kucing.umur + " tahun");
        System.out.println("Suara: "); kucing.suaraKucing();
    }
}