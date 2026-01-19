// Superclass BangunDatar
class BangunDatar {
    double luas() {
        return 0;
    }
}

// Class Persegi (Subclass)
class Persegi extends BangunDatar {
    double sisi;

    Persegi(double sisi) {
        this.sisi = sisi;
    }

    @Override
    double luas() {
        return sisi * sisi;
    }
}

// Class Lingkaran (Subclass)
class Lingkaran extends BangunDatar {
    double sisi; // dianggap sebagai jari-jari

    Lingkaran(double sisi) {
        this.sisi = sisi;
    }

    @Override
    double luas() {
        return Math.PI * sisi * sisi;
    }
}

// Class Segitiga (Subclass)
class Segitiga extends BangunDatar {
    double sisi; // misal sisi = alas dan tinggi dianggap sama besar

    Segitiga(double sisi) {
        this.sisi = sisi;
    }

    @Override
    double luas() {
        return 0.5 * sisi * sisi;
    }
}

// Main untuk testing 
public class Kuis2 {
    public static void main(String[] args) {
        BangunDatar persegi = new Persegi(5);
        BangunDatar lingkaran = new Lingkaran(7);
        BangunDatar segitiga = new Segitiga(4);

        System.out.println("Luas Persegi : " + persegi.luas());
        System.out.println("Luas Lingkaran : " + lingkaran.luas());
        System.out.println("Luas Segitiga : " + segitiga.luas());
    }
}
