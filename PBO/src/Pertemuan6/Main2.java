class RekeningBank {
    private String nomorRekening;
    private Double saldo;

    public RekeningBank(String nomorRekening, Double saldo) { // konstruktor
        this.nomorRekening = nomorRekening;
        this.saldo = saldo;
    }

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
        if (this.saldo < 0) {
            System.out.println("Tidak boleh bernilai negatif!");
        }
    }

    public String getNomorRekening() {
        return  this.nomorRekening;
    }

    public Double getSaldo() {
        if (saldo < 0) {
            System.out.println("Saldo tidak boleh negatif, jadi saldo kamu: ");
            return 0.0;
        }
        return saldo;
    }
}

public class Main2 {
    public static void main(String[] args) {
        RekeningBank rekening = new RekeningBank("0895336900466", -100000.0); // membuat objek

        System.out.println("Nomor Rekening: " + rekening.getNomorRekening()); // menampilkan data (Getter)
        System.out.println("Saldo: " + rekening.getSaldo());
    }
}