package Pertemuan1;

public class LuasJajaranGenjang {

    static double Luas(double a, double t) {
        return a * t;
    }

    public static void main(String[] args) {
        double a = 10;
        double t = 5;
        double Luas = Luas(a,t);

        System.out.println("Luas Jajaran Genjang: " + Luas);
    }
}