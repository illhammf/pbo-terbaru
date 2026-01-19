package Pertemuan10.Tugas4;

public class Main4 {
    public static void main(String[] args) {
        
        Animal[] list = {
            new Animal(),
            new Cat(),
            new Tiger(),
            new Dog()
        };

        for (Animal a : list) {
            a.animalSound();
        }
    }
}