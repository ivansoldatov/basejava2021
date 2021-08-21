package com.ocp.webapp;

import com.ocp.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume resume = new Resume("Ted");
        Class classResume = resume.getClass();
        System.out.println(classResume);
        Field field = classResume.getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(resume));
        field.set(resume, "new_uuid");
        Method method = classResume.getDeclaredMethod("toString");
        System.out.println(method.invoke(resume));
        System.out.println(resume);
        Method[] methods = classResume.getDeclaredMethods();
        System.out.println(methods.length);
        for (Method m:methods) {
            System.out.println(m.toString());
        }
        System.out.println(methods[1].invoke(resume));

    }


}
