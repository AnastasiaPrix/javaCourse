package Lesson_2;

public class Main {

    public static void main(String[] args) {

        int[] mas1 = {0, 1, 1, 0, 0, 1, 0};
        int[] mas2 = new int[8];
        int[] mas3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] mas4 = new int[5][5];
        changeFromZeroToOne(mas1);
        filing(mas2);
        multiplication(mas3);
        print2(diagonal(mas4));
        minMax(mas3);
        System.out.println("Баланс " + checkBalance(mas1));
        shifting(mas3, -2);



    }

    // метод для вывода одномерного массива
    public static void print1(int[] mas) {
        for (int i : mas) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void print2(int[][] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }

    }


    // Задание 1
    public static void changeFromZeroToOne(int[] mas) {
        System.out.println("Начальный массив:");
        print1(mas);
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == 0) {
                mas[i] = 1;
            } else {
                mas[i] = 0;
            }
        }
        System.out.println("Модифицированный массив:");
        print1(mas);
    }

    // Задание 2
    public static void filing(int[] mas) {
        System.out.println("Maccив кратных трем:");
        int k = -3;
        for (int i = 0; i < mas.length; i++) {
            k += 3;
            mas[i] = k;
        }
        print1(mas);
    }

    // Задание 3
    public static void multiplication(int[] mas) {
        System.out.println("Начальный массив");
        print1(mas);
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < 6) {
                mas[i] *= 2;
            }
        }
        System.out.println("Модифицированный массив:");
        print1(mas);
    }

    // Задание 4
    public static int[][] diagonal(int[][] mas) {
        for (int i = 0; i < mas.length; i++) {
            mas[i][i] = 1;
            mas[i][mas.length - i - 1] = 1;
        }
        return mas;
    }

    // Задание 5
    public static void minMax(int[] mas) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] > max) {
                max = mas[i];
            }
            if (mas[i] < min) {
                min = mas[i];
            }
        }
        System.out.println("Минимальное число: " + min + " Максимальное число: " + max);
    }

    //    Задание 6
    public static boolean checkBalance(int[] mas) {
        boolean f = false;
        int sum1 = 0;
        for (int i = 0; i < mas.length; i++) {
            sum1 = sum1 + mas[i];
            int sum2 = 0;
            for (int j = i + 1; j < mas.length; j++) {
                sum2 = sum2 + mas[j];
            }
            if (sum1 == sum2) {
                f = true;
                System.out.println("Баланс после " + (i + 1) + " элемента");
                break;
            }
        }
        return f;
    }

    //    Задание 7
    public static void shifting(int[] mas, int n) {
        System.out.println("Исходный массив:");
        print1(mas);
        System.out.println();
        if (n > 0) {
            for (int k = 0; k < n; k++) {
                int buff = mas[0];
                for (int i = 0; i < mas.length; i++) {
                    int buff2 = mas[i];
                    mas[i] = buff;
                    buff = buff2;
                }
                mas[0] = buff;
            }
        } else {
            for (int k = n; k < 0; k++) {
                int buff = mas[mas.length - 1];
                for (int i = mas.length-1; i >= 0; i--) {
                    int buff2 = mas[i];
                    mas[i] = buff;
                    buff = buff2;
                }
                mas[mas.length - 1] = buff;
            }
        }
        System.out.println("Сдвинутый на "+ n+ " массив");
        print1(mas);
    }

}



