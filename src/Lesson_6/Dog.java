package Lesson_6;

import java.util.Random;

public class Dog extends Animal  {

    private double lehgthRMax;
    private double heigntMax;
    private double lengthSMax;
    private Random r = new Random();



    public Dog(double lengthRun, double lengthSwim, double height) {
        super(lengthRun, lengthSwim, height);
//        this.lehgthRMax = 500;
//        this.heigntMax = 0.5;
//        this.lengthSMax = 10;
        this.lehgthRMax = r.nextInt(200) +400;
        this.heigntMax = r.nextInt(1)+2;
        this.lengthSMax = r.nextInt(6)+10;
    }

    @Override
    public boolean run(double lengthRun) {
        if (lengthRun > lehgthRMax){
            return false;
        }
       return true;
    }

    @Override
    public boolean swim(double lengthSwim) {

        if (lengthSwim > lengthSMax){
            return false;
        }
        return true;
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
        System.out.println("Собака:");
        super.info();
    }

}
