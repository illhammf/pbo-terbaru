public class MemoryManagementDemo {

    public static void main(String[] args) {
        System.out.println("=== A Typical Calling Sequence ===");
        int result = addNumbers(5, 10);
        System.out.println("Result: " + result);
        System.out.println("\n=== Call Frames – Simple Variables ===");
        simpleVariables();
        System.out.println("\n=== Call Frames – Reference Variables ===");
        referenceVariables();
    }

    // a. Typical Calling Sequence
    static int addNumbers(int a, int b) {
        int sum = a + b;
        return sum;
    }

    // b. Call Frames – Simple Variables
    static void simpleVariables() {
        int x = 10;   // primitive type (stored in stack)
        int y = 20;
        int z = x + y;
        System.out.println("x = " + x + ", y = " + y + ", z = " + z);
    }
    
    // c. Call Frames – Reference Variables
    static void referenceVariables() {
        int[] numbers = new int[3];  // reference variable in stack, array in heap
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
       for (int n : numbers) {
            System.out.println("Number: " + n);
        }
        // Create object in heap
        Person person = new Person("Ilham", 19);
        System.out.println(person);
    }
}

// Class Person disimpan di heap saat diinisialisasi
class Person {
   String name;  // reference variable ke String di heap
    int age;      // simple variable

   Person(String name, int age) {
      this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
