package Lesson_7;

public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }

    public void eat(Plate p) {
        if (p.decreaseFood(appetite) >= 0) {
            fullness = true;
        }
    }
    public void catFulness() {
        if (fullness) {
            System.out.printf("УРА! Котик %s сыт. ", name);
        }
        else {
            System.out.printf("Котику %s не хватило еды ", name);
        }
    }



    String getName(){
        return name;
    }
}
