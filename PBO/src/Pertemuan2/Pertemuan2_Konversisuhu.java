import java.util.Scanner; // import Scanner untuk membaca input dari keyboard

public class Pertemuan2_Konversisuhu {
    public static void main (String [] args){
        float celcius;       // variabel celcius dengan tipe data float
        double reamur;       // variabel reamur dengan tipe data double

        Scanner kbd = new Scanner(System.in); // buat objek Scanner untuk input dari keyboard

        System.out.print("Suhu dalam celcius : "); // minta user memasukkan suhu celcius
        celcius = kbd.nextFloat();                // baca input suhu dalam celcius

        reamur = 0.8 * celcius; // rumus konversi: Reamur = 0.8 × Celcius

        System.out.println("Reamur = " + reamur); // tampilkan hasil konversi ke layar
    }
}

