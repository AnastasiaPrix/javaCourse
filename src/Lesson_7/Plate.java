package Lesson_7;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public int decreaseFood(int n) {
        if (food >= n) {
            food -= n;
            return food;
        }
        return -1;
    }

    public void fillPlate(int n){
        food+=n;
        if (food >= 100) {
            food = 100;
            System.out.println("Тарелка полная!");
        }
        else {
            System.out.println("Тарелку наполнили на " + n + " теперь в ней "+ food);
        }
    }

    public void info() {
        System.out.println("В миске теперь: " + food);
    }
}
