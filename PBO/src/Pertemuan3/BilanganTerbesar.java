import java.util.*;

public class BilanganTerbesar {

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan bilangan pertama: ");
        int a = input.nextInt();

        System.out.print("Masukkan bilangan kedua: ");
        int b = input.nextInt();

        if (a > b) {
            System.out.println (a + " lebih besar dari " + b);
        } else if (b > a) {
            System.out.println (a + " lebih kecil dari " + b);
        } else {
            System.out.println (a + " sama besarnya dengan " + b);
        }
    }
}




