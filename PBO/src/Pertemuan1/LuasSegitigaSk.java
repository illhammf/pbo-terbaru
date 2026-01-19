import java.util.Scanner;

public class LuasSegitigaSk {

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);

        System.out.print("Masukkan nilai alas segitiga: ");
        double alas = input.nextDouble();

        System.out.print("Masukkan nilai tinggi segitiga: ");
        double tinggi = input.nextDouble();

        double luas = 0.5 * alas * tinggi;
        System.out.println("Alas = " + alas);
        System.out.println("Tinggi = " + tinggi);
        System.out.println("Luas Segitiga = " + luas);
        input.close();
    }
}

