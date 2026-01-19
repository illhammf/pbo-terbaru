public class Perulangan {
    public static void main (String[] args) {
        // SATU KONDISI
        int a = 1, b = 10;

        if (a < 5) {
            System.out.println("Nilai a lebih kecil dari 5");
        }

        if (b < 5) {
            System.out.println("Nilai b lebih kecil dari 5");
        }

        // DUA KONDISI
        int x = 1, y = 10;

        if (x < 5) {
            System.out.println(a + " lebih kecil dari 5");
        } else {
            System.out.println(a + " lebih besar dari 5");
        }

        if (y < 5) {
            System.out.println(b + " lebih kecil dari 5");
        } else {
            System.out.println(b + " lebih besar dari 5");
        }

        // LEBIH DARI DUA KONDISI
        Scanner ctk = new Scanner(System.in);
        int bilangan;

        System.out.print("Masukkan bilangan bulat: ");
        bilangan = ctk.nextInt();

        if (bilangan < 0) {
            System.out.println(bilangan + " adalah bilangan negatif");
        } else if (bilangan == 0) {
            System.out.println(bilangan + " adalah nol");
        } else {
            System.out.println(bilangan + " adalah bilangan positif");
        }
    }
}
