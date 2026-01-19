class Animal {
    void animalSound() {
        System.out.println ("Hewan itu membuat suara: ");
    }
}

class Cat extends Animal {
    void animalSound() {
        System.out.println ("Kucing bersuara: Meow Meow Meow");
    }
}

class Tiger extends Animal {
    void animalSound() {
        System.out.println ("Harimau bersuara: Ngaunggg");
    }
}

class Dog extends Animal {
    @Override
    void animalSound() {
        System.out.println ("Anjing bersuara: Woof Woof Woof");
    }
}

public class Main3 {
    public static void main(String[] args) {
        
    Animal [] list = {
        new Animal(),
        new Cat(),
        new Tiger(),
        new Dog()
    };

    for (Animal hewan : list) {
        hewan.animalSound();
    }
}

}