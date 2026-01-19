// Casting pembagian

public class Pembagian {
    public static void main(String[] args) {

        float a = 10; // float salah satu aja   
        int b = 4;

        float c =  a / b;
        System.out.printf("%f / %d = %f\n",a,b,c);


        int x = 10; // float salah satu aja   
        int y = 4;

        float z = (float) x / y;
        System.out.printf("%d / %d = %f\n",x,y,z);
    }
}