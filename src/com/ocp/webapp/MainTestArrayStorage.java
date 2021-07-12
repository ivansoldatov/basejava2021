package com.ocp.webapp;

import com.ocp.webapp.model.Resume;
import com.ocp.webapp.storage.ArrayStorage;

/**
 * Test for your com.ocp.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume();
        r1.setUuid("uuid1");
        Resume r2 = new Resume();
        r2.setUuid("uuid2");
        Resume r3 = new Resume();
        r3.setUuid("uuid3");
        Resume r4 = new Resume();
        r4.setUuid("uuid4");
        Resume r5 = new Resume();
        r5.setUuid("uuid5");
        Resume r6 = new Resume();
        r6.setUuid("uuid3");


        System.out.print("Save r1: ");
        ARRAY_STORAGE.save(r1);
        System.out.print("Save r2: ");
        ARRAY_STORAGE.save(r2);
        System.out.print("Save r3: ");
        ARRAY_STORAGE.save(r3);
        System.out.print("Save r6 (uuid3): ");
        ARRAY_STORAGE.save(r6);
        System.out.print("Save r4: ");
        ARRAY_STORAGE.save(r4);
        System.out.print("Save r5: ");
        ARRAY_STORAGE.save(r5);
        System.out.println();

        System.out.println("Size: " + ARRAY_STORAGE.size());
        System.out.println();

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.print("Get dummy: ");
        ARRAY_STORAGE.get("dummy");
        System.out.println();

        printAll();

        System.out.print("Delete uuid1: ");
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        System.out.print("Delete uuid5: ");
        ARRAY_STORAGE.delete(r5.getUuid());
        printAll();

        System.out.print("Update r6 (uuid3): ");
        ARRAY_STORAGE.update(r6);
        System.out.print("Update r5 (uuid5): ");
        ARRAY_STORAGE.update(r5);
        printAll();

        System.out.print("Clear: ");
        ARRAY_STORAGE.clear();
        System.out.println();

        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("Get all:");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
        System.out.println();
    }
}
