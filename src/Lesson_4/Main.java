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
            aiStep(4);
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

    static void aiStep(int countWin) {
        int x,y;
        System.out.println("Ходит SkyNet");
        if (!prepareAi(PLAYER_DOT, countWin-2) && !prepareAi(AI_DOT, countWin)) {
            do {
                x = random.nextInt(SIZE_X);
                y = random.nextInt(SIZE_Y);
            } while (!isCellValid(y,x));
            setSym(y,x, AI_DOT);
        }
    }

    static int checkWinDiag1(char sym ,int countWin) {

        for (int i = 0; i < SIZE_X -1 ; i++) {
            int kD1 = 0;
            for (int j = 0; j < SIZE_X - i; j++) {
                if (field[j+i][j] == sym) {
                    kD1++;
                }
                else if (field[i+j][j] != sym && i ==0 && j>0) {
                    kD1 = 0;
                }
                if (kD1 == countWin) {

                    return j;
                }
            }
        }
        return -1;
    }
    static int checkWinDiag1_2(char sym ,int countWin) {

        for (int i = 0; i < SIZE_X -1 ; i++) {
            int kD1 = 0;
            for (int j = 0; j < SIZE_X - i; j++) {
                if (field[j][j+i] == sym) {
                    kD1++;
                }
                else if (field[j][j+i] != sym && i ==0 && j>0) {
                    kD1 = 0;
                }
                if (kD1 == countWin) {

                    return j;
                }
            }
        }
        return -1;
    }
    static int checkWinDiag2(char sym ,int countWin) {

        for (int i = 0; i < SIZE_X - 1; i++) {
            int kD2 = 0;
            for (int j = 0; j < SIZE_Y -i; j++) {
                if (field[j+i][SIZE_Y - j - 1] == sym) {
                    kD2++;
                }
                if (field[j+i][SIZE_Y - j - 1] != sym && i ==0 && j>0) {
                    kD2 = 0;
                }
                if ( kD2 == countWin) {
                    return i;
                }
            }
        }
        return -1;
    }

    static int checkWinDiag2_1(char sym ,int countWin) {

        for (int i = 0; i < SIZE_X - 1; i++) {
            int kD2 = 0;
            for (int j = 0; j < SIZE_Y -i; j++) {
                if (field[j][SIZE_Y - j - 1 - i] == sym) {
                    kD2++;
                }
                if (field[j][SIZE_Y - j - 1 - i] != sym && i ==0 && j>0) {
                    kD2 = 0;
                }
                if ( kD2 == countWin) {
                    return i;
                }
            }
        }
        return -1;
    }

    static int checkWinX(char sym ,int countWin) {
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
                    return i;
                }
            }

        }
        return -1;
    }
    static int checkWinY(char sym, int countWin) {
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
                    return i;
                }
            }

        }
        return -1;
    }

    static boolean prepareAi (char sym, int countWin) {
        if (checkWinDiag1(sym, countWin) >=0){
            aiGoDiag1(checkWinDiag1(sym, countWin));
            return true;
        }
        else if (checkWinDiag2(sym, countWin) >= 0){
            aiGoDiag2(checkWinDiag2(sym,countWin));
            return true;
        }
        else if (checkWinX(sym,countWin) >=0){
            aiGoX(checkWinX(sym,countWin));
            return true;
        }
        else if (checkWinY(sym,countWin) >=0){
            aiGoY(checkWinY(sym,countWin));
            return true;
        }
        else if (checkWinDiag2_1(sym, countWin)>=0){
            aiGoDiag2_1(checkWinDiag2_1(sym,countWin));
            return true;
        }
        if (checkWinDiag1_2(sym, countWin) >=0){
            aiGoDiag1_2(checkWinDiag1_2(sym, countWin));
            return true;
        }
        return false;
    }

    static void aiGoDiag1(int k){
            for (int j = 0; j < SIZE_X - k; j++) {
                if (field[j+k][j] == EMPTY_DOT) {
                    field[j+k][j] = AI_DOT;
                    break;
                }
            }
    }
    static void aiGoDiag1_2(int k){
        for (int j = 0; j < SIZE_X - k; j++) {
            if (field[j][j+k] == EMPTY_DOT) {
                field[j][j+k] = AI_DOT;
                break;
            }
        }
    }

    static void aiGoDiag2(int k){
        for (int j = 0; j < SIZE_Y -k; j++) {
            if (field[j+k][SIZE_Y - j - 1] == EMPTY_DOT) {
                field[j+k][SIZE_Y - j - 1] = AI_DOT;
                break;
            }
        }
    }
    static void aiGoDiag2_1(int k){
        for (int j = 0; j < SIZE_Y -k; j++) {
            if (field[j][SIZE_Y - j - 1-k] == EMPTY_DOT) {
                field[j][SIZE_Y - j - 1-k] = AI_DOT;
                break;
            }
        }
    }
    static void aiGoY(int k){
        for (int j = 0; j < SIZE_Y ; j++) {
            if (field[j][k] == EMPTY_DOT) {
                field[j][k] = AI_DOT;
                break;
            }
        }
    }
    static void aiGoX(int k){
        for (int j = 0; j < SIZE_Y ; j++) {
            if (field[k][j] == EMPTY_DOT) {
                field[k][j] = AI_DOT;
                break;
            }
        }
    }


    static boolean checkWin2(char sym, int countWin) {
        if (checkWinDiag1(sym, countWin) >= 0 || checkWinX(sym, countWin) >= 0 || checkWinY(sym, countWin) >= 0 || checkWinDiag2(sym, countWin) >= 0
        || checkWinDiag1_2(sym, countWin) >=0 || checkWinDiag2_1(sym, countWin) >=0){
            return true;
        }
        return false;
    }

}
