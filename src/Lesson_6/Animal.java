package Lesson_6;

public abstract class Animal {
    protected double lengthRun;
    protected double lengthSwim;
    protected double height;


    public Animal(double lengthRun, double lengthSwim, double height) {
        this.lengthRun = lengthRun;
        this.lengthSwim = lengthSwim;
        this.height = height;
    }

    public abstract boolean run (double lengthRun);

    public abstract boolean swim (double lengthSwim);

    public abstract boolean jump (double height);

    public  void info () {
        System.out.printf("Бег:  %b, плавание:  %b, прыжок:  %b", run(lengthRun), swim(lengthSwim), jump(height));
    }
}
