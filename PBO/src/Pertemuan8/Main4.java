// MULTIPLE INHERITANCE

interface Bapak {
    public void print_bapak();
}

class Ibu {
    public void print_ibu(String nama_anak) {
        System.out.println(nama_anak + " diurus oleh Ibu");
    }
}

class Person extends Ibu implements Bapak {
    
    String nama = "Ilham";

    @Override
    public void print_bapak() {
        System.out.println(nama + " anak dari Bapak");
    }
}

class Main4 {
    public static void main (String[] args) {
    
        Person ilham = new Person();
    
        ilham.print_bapak();
        ilham.print_ibu(ilham.nama);
    }
}