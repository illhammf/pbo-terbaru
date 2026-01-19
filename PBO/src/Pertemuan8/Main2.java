// MULTILEVEL INHERITANCE
// Super class
class Buah {
    public void print_buah() {
        System.out.println ("==== CLASS BUAH ====");
    }
}
// Subclass dari Buah
class Jambu extends Buah {
    public void print_jambu() {
        System.out.println ("Jambu adalah Buah");
    }
}
// Subclass dari Jambu
class JambuAir extends Jambu {
    public void print_jambu_air() {
        System.out.println ("Jambu Air adalah pewarisan dari Jambu");
    }
}

class Main2 {
    public static void main (String[] args) {

    JambuAir jmbair = new JambuAir();
    jmbair.print_buah();
    jmbair.print_jambu();
    jmbair.print_jambu_air();
    }
}