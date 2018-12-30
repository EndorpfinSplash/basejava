package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume("UUID1");
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(r.getClass().getName());
        System.out.println(field.getName());
        System.out.println(field.get(r));
//        field.set(r, "new_uuid");
        System.out.println(r);

        // TODO : invoke r.toString via reflection
        System.out.println("------------------");
        Method resumeMethod = r.getClass().getDeclaredMethod("toString");
        System.out.println("Invoke method toString() for r instance: " + resumeMethod.invoke(r));

    }
}