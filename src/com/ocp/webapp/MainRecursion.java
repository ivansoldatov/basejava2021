package com.ocp.webapp;

import java.io.File;
import java.io.IOException;

public class MainRecursion {
    public static void main(String[] args) throws IOException {
        String path = "./src";
        File directory = new File(path);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        readFile(directory, sb, count);

    }

    private static void readFile(File dir, StringBuilder sb, int count) throws IOException {
        for (File f : dir.listFiles()) {
            if (f.isFile()) {
                System.out.println(sb.toString() + f.getCanonicalPath());
            } else {
                System.out.println(sb.toString() + f.getCanonicalPath());
                readFile(f, sb, count);
            }
        }
    }

}



