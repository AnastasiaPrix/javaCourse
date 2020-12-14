package Lesson_4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static int SIZE_X = 5;
    static int SIZE_Y = 5;

    static char[][] field = new char[SIZE_Y][SIZE_X];
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static char PLAYER_DOT = 'X';
    static char AI_DOT = 'O';
    static char EMPTY_DOT = '.';


    public static void main(String[] args) {
        initField();
        printField();

        while (true) {
            playerStep();
            printField();
            if (checkWin2(PLAYER_DOT, 4)) {
                System.out.println("Player WIN!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("DRAW");
                break;
            }
            aiStep();
            printField();
            if (checkWin2(AI_DOT,4)) {
                System.out.println("WIN SkyNet");
                break;
            }
            if (isFieldFull()) {
                System.out.println("DRAW");
                break;
            }
        }
    }

    static void initField() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    static void printField() {
        System.out.println("-------");
        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print("|");
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("-------");
    }

    static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x > SIZE_X - 1 || y > SIZE_Y - 1) {
            return false;
        }
        return field[y][x] == EMPTY_DOT;
    }

    static boolean isFieldFull() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    static void setSym(int y, int x, char sym) {
        field[y][x] = sym;
    }

    static void playerStep() {
        int x,y;
        do {
            System.out.println("Введите координаты: X Y (1-3)");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y,x));
        setSym(y,x, PLAYER_DOT);
    }

    static void aiStep() {
        int x,y;
        do {
            System.out.println("Ходит SkyNet");
            x = random.nextInt(SIZE_X);
            y = random.nextInt(SIZE_Y);
        } while (!isCellValid(y,x));
        setSym(y,x, AI_DOT);
    }

    static boolean checkWinDiag(char sym ,int countWin) {
        int kD1 = 0;
        int kD2 = 0;
        for (int i = 0; i < SIZE_X; i++) {
            if (field[i][i] == sym) {
                kD1++;
            } else if (field[i][i] != sym &&  i >0) {
                kD1 = 0;
            }
            if (field[i][SIZE_Y - i - 1] == sym) {
                kD2++;
            } else if (field[i][SIZE_Y - i - 1] != sym &&  i>0) {
                kD2 = 0;
            }
            if (kD1 == countWin|| kD2 == countWin) {
                return true;
            }

        }

        return false;
    }
    static boolean checkWinX(char sym ,int countWin) {
        for (int i = 0; i < SIZE_Y; i++) {
            int kX = 0;
            boolean f = true;
            for (int j = 0; j < SIZE_X ; j++) {
                if (field[i][j] == sym) {
                    kX++;
                }
                if (j > 0 && field[i][j] != sym ) {
                    kX = 0;
                }
                if (kX == countWin) {
                    return true;
                }
            }

        }
        return false;
    }
    static boolean checkWinY(char sym, int countWin) {
        for (int i = 0; i < SIZE_X; i++) {
            int kY = 0;
            for (int j = 0; j < SIZE_Y ; j++) {
                if (field[j][i] == sym) {
                    kY++;
                }
                if (j > 0 && field[j][i] != sym ) {
                    kY = 0;
                }
                if (kY == countWin){
                    return true;
                }
            }

        }
        return false;
    }

//    Победа для четырех фишек
    static boolean checkWin2(char sym, int countWin) {
        if (checkWinDiag(sym, countWin) || checkWinX(sym, countWin) || checkWinY(sym, countWin)){
            return true;
        }
        return false;
    }

}
