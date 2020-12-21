package Lesson_6;

import java.util.Random;

public class Cat extends Animal {

    private double lehgthRMax;
    private double heigntMax;


    public Cat(double lengthRun, double lengthSwim, double height) {
        super(lengthRun, lengthSwim, height);
        Random r = new Random();
//        this.lehgthRMax = 200;
//        this.heigntMax = 2;
        this.lehgthRMax = r.nextInt(300)+100;
        this.heigntMax = r.nextInt(4)+2;
    }


    @Override
    public boolean run(double lengthRun) {
        if (lengthRun > lehgthRMax) {
            return false;
        }
        return true;
    }

    @Override
    public boolean swim(double lengthSwim) {
        return false;
    }

    @Override
    public boolean jump(double height) {
        if (height > heigntMax) {
            return false;
        }
        return true;
    }

    @Override
    public void info() {
        System.out.println("Кошка:");
        super.info();
    }


}
