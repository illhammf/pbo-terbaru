class Produk {
    private String namaProduk;
    private double harga;
    private int stok;

    public Produk(String nama, double harga, int stok) { // konstruktor
        this.namaProduk = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNamaProduk() {
        return namaProduk;
    }
    public double getHarga() {
        return harga;
    }
    public int getStok() {
        return stok;
    }
    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }
    public void setHarga(double harga) {
        this.harga = harga;
    }
    public void setStok(int stok) {
        this.stok = stok;
    }
    
    public void tambahStok(int jumlah) { // tambah stok
        if (jumlah > 0) {
            this.stok += jumlah;
        }
    }

    public void kurangiStok(int jumlah) { // kurangi stok
        if (jumlah > 0 && jumlah <= this.stok) {
            this.stok -= jumlah;
        }
    }

    public void tampilkanInfo() { // menampilkan info produk
        System.out.println("Nama Produk: " + namaProduk);
        System.out.println("Harga: " + harga);
        System.out.println("Stok: " + stok);
    }
}

public class Main3 {
    public static void main(String[] args) {
        Produk produk1 = new Produk("Laptop", 7000000, 5); // membuat objek

        produk1.tambahStok(3); // menambah stok
        produk1.kurangiStok(2); // mengurangi stok
        produk1.tampilkanInfo(); // menampilkan info produk
    }
}