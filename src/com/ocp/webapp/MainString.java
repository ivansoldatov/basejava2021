package com.ocp.webapp;

public class MainString {
    public static void main(String[] args) {
        final String[] strArray = new String[] {"1","2","3","4","5"};
        StringBuilder result=new StringBuilder();
        for (String str: strArray) {
            result.append(str+", ");
        }
        System.out.println(result);

        char ch1='а';
        char ch2=11150;
        System.out.println((int)ch1);
        System.out.println(ch2);
    }


}
