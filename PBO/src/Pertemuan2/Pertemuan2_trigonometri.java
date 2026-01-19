import java.util.Scanner; // import class Scanner untuk input dari keyboard
import java.lang.Math;    // import class Math untuk perhitungan matematika (misalnya toRadians, tan)

public class Pertemuan2_trigonometri {
    public static void main (String [] args) {
        Scanner kbd = new Scanner(System.in); // membuat objek Scanner untuk membaca input

        double x, derajat; // deklarasi variabel x (jarak) dan derajat (sudut dalam derajat)

        System.out.print("x = "); // minta user masukkan nilai x
        x = kbd.nextDouble();     // baca nilai x dari input

        System.out.print("Sudut (dalam derajat) = "); // minta user masukkan sudut
        derajat = kbd.nextDouble();                   // baca nilai sudut (dalam derajat)

        double radian = Math.toRadians(derajat); // konversi sudut derajat ke radian
        double y = x * Math.tan(radian);         // hitung tinggi menara (y = x * tan(sudut))

        System.out.printf("Tinggi menara = %.2f\n", y); // tampilkan hasil tinggi menara dengan 2 angka desimal
    }
}

