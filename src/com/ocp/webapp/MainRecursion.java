package com.ocp.webapp;

import java.io.File;
import java.io.IOException;

public class MainRecursion {
    public static void main(String[] args) throws IOException {
        String path = "./src";
        File directory = new File(path);
        getNameFiles(directory, "|");

    }

    private static void getNameFiles(File directory, String ofset) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isFile()) {
                        System.out.println(ofset + "File: " + f.getName());
                    } else {
                        System.out.println(ofset + "Dir: " + f.getName());
                        getNameFiles(f, ofset + "--");
                    }
                }
            }
        } else
            System.out.println("Directory error");
    }


}



