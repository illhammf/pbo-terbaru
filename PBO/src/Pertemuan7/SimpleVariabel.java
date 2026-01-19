// Simple Variabel dan penambahan GC (Garbage Collection)
public class SimpleVariabel {

    public static double lingkaran(double r) {
        double temp;
        temp = 2 * 3.14 * r;
        return temp;
    }

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        // dari bytes ke megabytes
        System.out.println("\n===== Sebelum Garbage Collection (GC) =====");
        System.out.printf("Total Memory  : %.2f MB%n", runtime.totalMemory() / (1024.0 * 1024));
        System.out.printf("Free Memory   : %.2f MB%n", runtime.freeMemory() / (1024.0 * 1024));
        System.out.printf("Used Memory   : %.2f MB%n", 
            (runtime.totalMemory() - runtime.freeMemory()) / (1024.0 * 1024));
        System.out.println("-------------------------------------------");

        double n = 4.5;
        double y = lingkaran(n);
        System.out.println("Luas lingkaran dengan jari-jari " + n + " adalah = " + y);
        // ini adalah strong reference — selama variabel n dan y masih ada di stack,
        // objek yang diacu (kalau ada) tidak akan dihapus GC.

        // Begitu main() selesai, referensi hilang
        // GC otomatis akan bersihin heap dari objek yang sudah gak bisa diakses.

        System.gc();

        System.out.println("\n===== Setelah Garbage Collection (GC) =====");
        System.out.printf("Total Memory  : %.2f MB%n", runtime.totalMemory() / (1024.0 * 1024));
        System.out.printf("Free Memory   : %.2f MB%n", runtime.freeMemory() / (1024.0 * 1024));
        System.out.printf("Used Memory   : %.2f MB%n", 
            (runtime.totalMemory() - runtime.freeMemory()) / (1024.0 * 1024));
        System.out.println("-------------------------------------------");
    }
}
