package com.ocp.webapp;

import java.io.*;

public class MainFile {
    public static void main(String[] args) {
        String filePath = "./.gitignore";
        String myFile = "./temp/my.txt";
        try {
            File file = new File(myFile);
            System.out.println(file.getCanonicalPath());
            System.out.println(file.getAbsolutePath());
            System.out.println(file.getPath());
            System.out.println("----------------------");
            System.out.println(file.isDirectory());
            File dir = new File("./src/com/ocp/webapp");
            System.out.println(dir.isDirectory());
            for (String name : dir.list()) {
                System.out.println(name);
            }
        } catch (IOException exc) {
            System.out.println("File not found");
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] byteToWrite = new byte[]{100, 25, 36};

        try (FileOutputStream foi = new FileOutputStream(myFile)) {
            foi.write(byteToWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] byteToRead = new byte[10];
        try (FileInputStream fis = new FileInputStream(myFile)) {
            fis.read(byteToRead,0,fis.available());
            for (byte b : byteToRead) {
                System.out.println(b);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }


    }
}
