package com.ocp.webapp;

public class MainSingleton {

    private static MainSingleton singleton;

    private MainSingleton() {
    }

    public static MainSingleton getSingleton() {
        if (singleton == null) {
            singleton = new MainSingleton();
        }
        return singleton;
    }

    public enum Singleton {
        INSTANCE
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.valueOf("INSTANCE");
        System.out.println(instance);
        System.out.println(instance.ordinal());

    }

}
