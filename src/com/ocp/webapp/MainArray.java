package com.ocp.webapp;

import java.util.Arrays;

public class MainArray {
    public static void main(String[] args) {
        int[] mas1 = new int[]{1,2,3,4,5};
        System.out.println(mas1.length);
        System.out.println(mas1);
        System.out.println(Arrays.toString(mas1));

        char[] mas2 = new char[]{'a','b','c'};
        System.out.println(mas2);

        try {
            System.out.println(mas1[5]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Исключение: "+ e );
            System.out.println(e.getCause());
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Значение второго элемента: "+ mas1[1]);
        }
    }
}
