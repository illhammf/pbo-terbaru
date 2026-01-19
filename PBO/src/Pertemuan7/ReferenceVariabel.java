// Reference Variabel
public class ReferenceVariabel {
    private static void printAll (String s1, String s2, String s3) {
        System.out.println(s1.toString());
        System.out.println(s2.toString());
        System.out.println(s3.toString());
    }

    public static void main(String[] args) {
        String str1, str2, str3;
        str1 = new String ("String 1");
        str2 = new String ("String 2");
        str3 = new String ("String 3");

        printAll(str1, str2, str3);
    }
}