package com.ocp.webapp;

import com.ocp.webapp.model.Resume;
import com.ocp.webapp.storage.SortedArrayStorage;
import com.ocp.webapp.storage.Storage;

/**
 * Test for your com.ocp.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("uuid1");
        Resume r2 = new Resume("uuid2");
        Resume r3 = new Resume("uuid3");
        Resume r4 = new Resume("uuid4");
        Resume r5 = new Resume("uuid5");
        Resume r6 = new Resume("uuid3");


        System.out.println("Save r1: ");
        ARRAY_STORAGE.save(r1);
        System.out.println("Save r2: ");
        ARRAY_STORAGE.save(r2);
        System.out.println("Save r3: ");
        ARRAY_STORAGE.save(r3);
        System.out.println("Save r6 (uuid3): ");
        ARRAY_STORAGE.save(r6);
        System.out.println("Save r4: ");
        ARRAY_STORAGE.save(r4);
        System.out.println("Save r5: ");
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

        System.out.println("Update r6 (uuid3): ");
        ARRAY_STORAGE.update(r6);
        System.out.println("Update r5 (uuid5): ");
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
