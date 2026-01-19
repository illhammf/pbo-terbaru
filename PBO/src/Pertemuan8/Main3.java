// HIERARCHICAL INHERITANCE
class Orang {
    public void print_orang() {
        System.out.println ("\n==== CLASS ORANG ====");
    }
}

class Ilham extends Orang {
    public void print_ilham() {
        System.out.println ("Ilham adalah Pewarisan dari Orang");
    }
}

class Dafa extends Orang {
    public void print_dafa() {
        System.out.println ("Dafa adalah Pewarisan dari Orang");
    }
}

class Adit extends Orang {
    public void print_adit() {
        System.out.println ("Adit adalah Pewarisan dari Orang\n");
    }
}

class Main3 {
    public static void main (String[] args) {

        Ilham ilh = new Ilham();
        ilh.print_orang();
        ilh.print_ilham();

        Dafa df = new Dafa();
        df.print_orang();
        df.print_dafa();

        Adit dt = new Adit();
        dt.print_orang();
        dt.print_adit();
    }
}