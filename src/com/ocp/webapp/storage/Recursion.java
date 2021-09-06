package com.ocp.webapp.storage;

import java.io.File;
import java.io.IOException;

public class Recursion {
    public static void main(String[] args) throws IOException {
        String path = "./src";
        File directory = new File(path);
        readFile(directory);

    }

    private static void readFile(File dir) throws IOException {
        if (dir.isDirectory()) {
            for (File f : dir.listFiles()) {
                if (f.isFile()) {
                    System.out.println(f.getCanonicalPath());
                } else {
                    System.out.println(dir);
                    readFile(f);
                }
            }

        }
    }

}



