class Data {
    public int intPublic;
    private int intPrivate;
    private double doublePrivate;

    public Data() {
        this.intPublic = 0;
        this.intPrivate = 10;
    }

    void display() {
        System.out.println("intPublic: " + this.intPublic);
        System.out.println("intPrivate: " + this.intPrivate);
        System.out.println("doublePrivate: " + this.doublePrivate);
    }

    // GETTER
    public int getIntPrivate() {
        return this.intPrivate;
    }

    // SETTER
    public void setDoublePrivate(double value) {
        this.doublePrivate = value;
    }
}

class Lingkaran{
    private double diameter;

    Lingkaran(double diameter) {
        this.diameter = diameter;
    }

    // setter
    public void setJari2(double jari2) {
        this.diameter = jari2 * 2;
    }

    // getter
    public double getJari2() {
        return this.diameter / 2;
    }

    // getter luas
    public double getLuas() {
        return 3.14 * diameter*diameter / 4;
    }

}

public class Main {
    
    public static void main(String[] args) {

        Data object = new Data();

        // read dan write dengan menggunakan PUBLIC
        object.intPublic = 5; // write
        System.out.println("public: " + object.intPublic); // read

        // read only (kita bisa menggunakan GETTER)
        int angka = object.getIntPrivate();
        System.out.println("getter: " + angka);

        // write only (kita hanya bisa menulis aja menggunakan SETTER)
        object.setDoublePrivate(3.14);
        object.display();

        // gabungkan read dan write dengan menggunakan GETTER dan SETTER
        Lingkaran object2 = new Lingkaran(5);
        System.out.println("Jari-jari: " + object2.getJari2());
        object2.setJari2(14);
        System.out.println("Jari-jari: " + object2.getJari2());
        System.out.println("Luas: " + object2.getLuas());
    }

}
