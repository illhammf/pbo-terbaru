// SINGLE INHERITANCE
// Super Class
class Karyawan {
    int gaji = 8000000;
}

// Inherited or Sub Class
class Pengajar extends Karyawan {
    int keuntungan = 5000000;
}
class Admin extends Karyawan {
    int keuntungan = 7000000;
}

// Main Class
class Main {
    public static void main(String[] args) 
    {
        Pengajar pnjr = new Pengajar();
        System.out.println ("PENGAJAR di Universitas Esa Unggul");
        System.out.println ("Gaji: " + pnjr.gaji + "\nKeuntungan: " + pnjr.keuntungan);

        Admin adm = new Admin();
        System.out.println ("\nADMIN di Universitas Esa Unggul");
        System.out.println ("Gaji: " + adm.gaji + "\nKeuntungan: " + adm.keuntungan);
    }
}