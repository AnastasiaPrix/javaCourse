package Lesson_5;

import com.sun.org.apache.xml.internal.serializer.ElemDesc;

public class Matrix {

    private static int SIZE_X = 6;
    private static int SIZE_y = 6;
    private static int[][] mas = new int[SIZE_X][SIZE_y];
    private static  int num =0;

    public int getSIZE_X() {
        return SIZE_X;
    }


    public int getSIZE_y() {
        return SIZE_y;
    }


    public void printMatrix() {
        for (int i = 0; i < SIZE_X; i++) {
            for (int j = 0; j < SIZE_y; j++) {
                System.out.printf( mas[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void spiral() {
        int k = 1;
        int minus = 0;
        boolean flag = true;
        boolean flagChange = false;
        int coun = 0;
        int SIZE_act = SIZE_X - 1;
        while (SIZE_act > 0) {
            if (coun==4){
                SIZE_act-=2;
                minus++;
                coun = 0;
                num = num +1;
            }
            if (flag) {
                k = increaseX(flagChange,  SIZE_act, k, minus);
            }
            else {
                k = increaseY(flagChange,  SIZE_act, k,  minus);
            }
            coun++;
            flag = !flag;
            if (flag ){
                flagChange = !flagChange;
            }
        }
    }
    private int increaseX(boolean flag, int SIZE_act, int k, int minus){
        if (!flag) {
            for (int j = minus; j < SIZE_act +minus; j++) {
                mas[num][j] = k;
                k++;
            }
            if (minus == SIZE_act+minus) {
                mas[num][minus] = k;
            }
            num = SIZE_X - 1 -minus;
        }
        else {
            for (int j = SIZE_act + minus; j >= SIZE_X -SIZE_act - minus; j--) {
                mas[num][j] = k;
                k++;
            }
            if (minus == SIZE_act+minus) {
                mas[num][minus] = k;
            }
            num = 0 + minus;
        }
        return k;
    }
    private int increaseY(boolean flag, int SIZE_act, int k,  int minus){
        if (!flag) {
            for (int j = minus; j < SIZE_act + minus; j++) {
                mas[j][num] = k;
                k++;
            }
            if (minus == SIZE_act+minus) {
                mas[minus][num] = k;
            }
            num = SIZE_X - 1 - minus;
        }
        else {
            for (int j = SIZE_act + minus; j >=  SIZE_X -SIZE_act - minus; j--) {
                mas[j][num] = k;
                k++;
            }
            if (minus == SIZE_act+minus) {
                mas[minus][num] = k;
            }
            num = 0 + minus;
        }
        return k;
    }
}
