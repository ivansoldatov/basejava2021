package com.ocp.webapp;

import com.ocp.webapp.model.Resume;

import java.lang.reflect.Field;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException {
        Resume resume = new Resume();
        System.out.println(resume.getClass());
        Field field = resume.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(resume));
        field.set(resume,"new_uuid");
        System.out.println(resume);

    }


}
