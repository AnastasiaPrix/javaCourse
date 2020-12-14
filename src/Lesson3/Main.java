package Lesson3;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String s = "Предложение     один   Теперь     предложение    два   Тут  предложение          три     Здесь четыре";

//        guessValue();
//        guessWord();
        normalize(s);


    }


    //    Задание 1
    public static void guessValue() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int r = random.nextInt(10);
        System.out.println("Давайте сыграем в игру! Я загадал число от 0 до 9. У вас 3 попытки.");
        System.out.println("Введите число:");
        boolean f = false;
        for (int k = 0; k < 3; k++) {
            int b = scanner.nextInt();
            if (b == r) {
                System.out.println("Победа!");
                f = true;
                break;
            } else if (b > r) {
                System.out.println("Загаданное число меньше.");
            } else {
                System.out.println("Загаданное число больше");
            }
        }
        if (!f) {
            System.out.println("Увы, Вы проиграли =(");
        }
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        if (scanner.nextInt() == 1) {
            guessValue();
        }
    }

    // Задание 2
    public static void guessWord() {
        String[] words = {"apple", "orange", "lemon",
                "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
                "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"};
        Scanner scanner = new Scanner(System.in);
        int k = words.length;
        Random random = new Random();
        int r = random.nextInt(k);
        String word = words[r];
        StringBuilder s = new StringBuilder("###############");
        System.out.println("Давайте сыграем в игру! Я загадал слово: " + s);
        System.out.println("Введите слово строчными буквами:");
        boolean f = true;
        while (true) {
            String userWord = scanner.nextLine();
            if (word.equals(userWord)) {
                System.out.println("Победа!");
                break;
            } else {
                for (int i = 0; i < word.length(); i++) {
                    if (i < userWord.length()) {
                        if (word.charAt(i) == userWord.charAt(i)) {
                            s.setCharAt(i, userWord.charAt(i));
                        }
                    }
                }
                System.out.println("Не совсем, попробуй еще раз: " + s);
            }
        }
    }

    // Задача из лекции.
    public static void normalize(String s) {
        System.out.println(s);
        String s1 = s.replaceAll(" +", " ");
        StringBuilder s2 = new StringBuilder(s1);
        int counter = 0;
        for (int i = 1; i < s1.length(); i++) {
            if (s1.charAt(i) >= 'А' && s1.charAt(i) <= 'Я') {
                s2.insert((i - 1 + counter), '.');
                counter++;
            }
        }
        s2.append('.');
        System.out.println(s2);
    }
}
