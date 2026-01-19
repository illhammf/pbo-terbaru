class Produk {
    private String namaProduk;
    private double harga;
    private int stok;

    // konstruktor kosong agar turunan tidak butuh memanggil super()
    public Produk() {
        // biar turunan bisa diinisialisasi tanpa error
    }

    public Produk(String nama, double harga, int stok) {
        this.namaProduk = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNamaProduk() {
        return namaProduk;
    }
    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
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

    // Method menambah stok
    public void tambahStok(int jumlah) {
        if (jumlah > 0) {
            this.stok += jumlah;
        }
    }

    // Method mengurangi stok
    public void kurangiStok(int jumlah) {
        if (jumlah > 0 && jumlah <= this.stok) {
            this.stok -= jumlah;
        }
    }

    // Menampilkan info produk
    public void tampilkanInfo() {
        System.out.println("Nama Produk: " + namaProduk);
        System.out.println("Harga: " + harga);
        System.out.println("Stok: " + stok);
    }
}

// Turunan
class Elektronik extends Produk {
    private String garansi;

    public Elektronik(String nama, double harga, int stok, String garansi) {
        setNamaProduk(nama);
        setHarga(harga);
        setStok(stok);
        this.garansi = garansi;
    }

    public String getGaransi() {
        return garansi;
    }
    public void setGaransi(String garansi) {
        this.garansi = garansi;
    }

    // Method menampilkan info lengkap produk elektronik (tidak override)
    public void tampilkanInfoElektronik() {
        System.out.println("Nama Produk : " + getNamaProduk());
        System.out.println("Harga       : " + getHarga());
        System.out.println("Stok        : " + getStok());
        System.out.println("Garansi     : " + garansi);
    }
}

public class Main4 {
    public static void main(String[] args) {
        Elektronik laptop = new Elektronik("Laptop HP", 7500000, 10, "2 Tahun"); // membuat objek

        laptop.tambahStok(5);          
        laptop.kurangiStok(3);          
        laptop.setGaransi("3 Tahun"); 

        // Tampilkan hasil
        System.out.println("=== Data Produk Elektronik ===");
        laptop.tampilkanInfoElektronik();
    }
}
