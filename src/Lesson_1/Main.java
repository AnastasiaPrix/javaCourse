package Lesson_1;

public class Main {
    public static void main(String[] args) {
        float a = 5f;
        float b = 6.9f;
        float c = 7f;
        float d = 3f;

        int j = -40;
        short s = 340;
        byte bt = 10;
        long l = 111111111111111L;
        double db = 1024.8;

        char ch = 'w';
        String str = "John";

        boolean f = true;

        // расчет выражения
        System.out.println(calculation(a, b, c, d));
        // проверка на принадлежность диапазону
        System.out.println(checkValue(d, a));
        // проверка на знак числа с выводом
        checkForSignWithPrint(j);
        // проверка на знак числа с boolean
        System.out.println(checkForSign(j));
        // приветствие
        welcome(str);
        // проверка на високосный год
        leapYear(2000);
    }

    // использовала float в качестве входных параметров, чтобы можно было в вычислениях использовать и дробные
    public static float calculation(float a, float b, float c, float d) {
        float res = a * (b + c / d);
        return res;
    }

    public static boolean checkValue(float a, float b) {
        float c = a + b;
        boolean res = false;
        if (c >= 10 && c <= 20) {
            res = true;
        }
        return res;
    }

    public static void checkForSignWithPrint(int a) {
        if (a >= 0) {
            System.out.println("Получено положительное число");
        } else {
            System.out.println("Получено отрицательное число");
        }
    }

    public static boolean checkForSign(int a) {
        boolean res = false;
        if (a < 0) {
            res = true;
        }
        return res;
    }

    public static void welcome(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void leapYear(int a) {
        if ((a % 4 == 0 && a % 100 != 0) || (a % 400 == 0)) {
            System.out.println(a + " - високосный год");
        } else {
            System.out.println(a + " - не високосный год");
        }
    }
}
