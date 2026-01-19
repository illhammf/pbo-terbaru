class Animal { // Superclass
    void animalSound(){
        System.out.println("Macam-macam suara Hewan: ");
    }
}

class Kucing extends Animal { // Subclass
    @Override
    void animalSound(){
        System.out.println("Suara Kucing: Meow meow meow");
    }
}

class Tiger extends Animal { // Subclass
    @Override
    void animalSound(){
        System.out.println("Suara Harimau: Ngaung ngaung");
    }
}

public class Main{

    public static void main (String[] args) {

        Animal hewan1 = new Animal();
        Animal hewan2 = new Kucing();
        Animal hewan3 = new Tiger();

        hewan1.animalSound();
        hewan2.animalSound();
        hewan3.animalSound();
    }
}