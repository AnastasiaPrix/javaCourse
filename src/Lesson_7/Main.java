package Lesson_7;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {new Cat("Barsik", 15),
                new Cat("Mursik", 25),
                new Cat("Kot", 35),
                new Cat("Lulu", 35)};
        Plate plate = new Plate(100);

        for (Cat cat: cats){
            cat.eat(plate);
            cat.catFulness();
            plate.info();
        }

        plate.fillPlate(20);
        plate.info();


    }
}
