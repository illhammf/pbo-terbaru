// Kelas Induk
class Produk {
    private String nama;
    private double harga;
    private int stok;

    public Produk(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter & Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String infoProduk() {
        return "Nama: " + nama + "\nHarga: " + harga + "\nStok: " + stok;
    }

    public boolean bisaDibeli() {
        return stok > 0;
    }
}

class Elektronik extends Produk {
    private int garansi;

    public Elektronik(String nama, double harga, int stok, int garansi) {
        super(nama, harga, stok);
        this.garansi = garansi;
    }

    public int getGaransi() {
        return garansi;
    }

    public void setGaransi(int garansi) {
        this.garansi = garansi;
    }

    @Override
    public String infoProduk() {
        return super.infoProduk() + "\nGaransi: " + garansi + " bulan";
    }
}

class Pakaian extends Produk {
    private String ukuran;

    public Pakaian(String nama, double harga, int stok, String ukuran) {
        super(nama, harga, stok);
        this.ukuran = ukuran;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    @Override
    public String infoProduk() {
        return super.infoProduk() + "\nUkuran: " + ukuran;
    }
}

class Makanan extends Produk {
    private String tanggalKadaluarsa;

    public Makanan(String nama, double harga, int stok, String tanggalKadaluarsa) {
        super(nama, harga, stok);
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    public String getTanggalKadaluarsa() {
        return tanggalKadaluarsa;
    }

    public void setTanggalKadaluarsa(String tanggalKadaluarsa) {
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    @Override
    public String infoProduk() {
        return super.infoProduk() + "\nKadaluarsa: " + tanggalKadaluarsa;
    }

    @Override
    public boolean bisaDibeli() {
        return getStok() > 0 && !tanggalKadaluarsa.equalsIgnoreCase("expired");
    }
}

public class Kuis4 {
    public static void main(String[] args) {
        Produk laptop = new Elektronik("Laptop ASUS", 7500000, 10, 24);
        Produk baju = new Pakaian("Kaos Polos", 75000, 5, "L");
        Produk susu = new Makanan("Susu Sapi", 20000, 10, "Expired");

        System.out.println(laptop.infoProduk());
        System.out.println("Bisa dibeli? " + laptop.bisaDibeli());
        System.out.println();

        System.out.println(baju.infoProduk());
        System.out.println("Bisa dibeli? " + baju.bisaDibeli());
        System.out.println();

        System.out.println(susu.infoProduk());
        System.out.println("Bisa dibeli? " + susu.bisaDibeli());
    }
}
