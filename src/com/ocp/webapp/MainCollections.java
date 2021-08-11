package com.ocp.webapp;

import com.ocp.webapp.model.Resume;

import java.util.*;

public class MainCollections {
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);

    public static void main(String[] args) {
        Collection<Resume> collection = new ArrayList<>();
        collection.add(RESUME_1);
        collection.add(RESUME_2);
        collection.add(RESUME_3);
        collection.add(RESUME_4);

        for (Resume r : collection) {
            System.out.println(r);
//            if (Objects.equals(r.getUuid(),UUID_1)) {
//                collection.remove(r);
//            }
        }

        System.out.println(collection);
        Iterator<Resume> iterator = collection.iterator();

        while (iterator.hasNext()) {
            Resume r = iterator.next();
            System.out.println(r);
            if (r.getUuid().equals(UUID_1)) {
                iterator.remove();
            }
        }
        System.out.println(collection);

        Map<String, Resume> map = new HashMap<>();
        map.put(UUID_1, RESUME_1);
        map.put(UUID_2, RESUME_2);
        map.put(UUID_3, RESUME_3);
        map.put(UUID_4, RESUME_4);

        for (String uuid : map.keySet()) {
            System.out.println(map.get(uuid));
        }
        System.out.println();

        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }

        System.out.println();

        List<Integer> list = new ArrayList<>(10);
        list.add(0,0);
        list.add(1,1);
        list.add(2,2);
        list.add(1,4);
        list.set(1,1);
        for (int i : list){
            System.out.println(i);
        }

        System.out.println();

        List<Double> doubleList = new LinkedList<>();
        doubleList.add(0.1);
        doubleList.add(0.2);
        doubleList.add(0.3);
        doubleList.add(2,0.22);
//        doubleList.add(4,0.77);
        for (double f: doubleList) {
            System.out.println(f);
        }



    }
}
