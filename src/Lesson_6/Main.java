package Lesson_6;

public class Main {

    public static void main(String[] args) {
        Animal[] animals = {
        new Cat(200, 2, 4),
        new Dog(500, 6, 1)};

        for (Animal animal: animals) {
            animal.info();
            System.out.println();

        }
    }

}
