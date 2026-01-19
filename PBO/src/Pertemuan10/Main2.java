class Animal { // Superclass
    void animalSound() {
        System.out.println ("Hewan itu membuat suara: ");
    }
}

class Cat extends Animal { // Subclass
    void animalSound() {
        System.out.println ("Kucing bersuara: Meow Meow Meow");
    }
}

class Tiger extends Animal { // Subclass
    void animalSound() {
        System.out.println ("Harimau bersuara: Ngaunggg");
    }
}

class Dog extends Animal { // Subclass Baru
    @Override
    void animalSound() {
        System.out.println ("Anjing bersuara: Woof Woof Woof");
    }
}

public class Main2 {
    public static void main(String[] args) {
        
        Animal hewan1 = new Animal();
        Animal hewan2 = new Cat();
        Animal hewan3 = new Tiger();
        Animal hewan4 = new Dog();

        hewan1.animalSound();
        hewan2.animalSound();
        hewan3.animalSound();
        hewan4.animalSound();
    }
}