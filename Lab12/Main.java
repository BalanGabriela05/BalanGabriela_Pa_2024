package org.example;

import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
        public static void main(String[] args) {
            try {
                Class<?> clazz = loadClass("org.example.ExampleClass");
                System.out.println("------ClassInfo------");
                printClassInfo(clazz);
                System.out.println("------InvokeTestMethods------");
                invokeTestMethods(clazz);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        private static Class<?> loadClass(String className) throws ClassNotFoundException {
            return Class.forName(className);
        }

        private static void printClassInfo(Class<?> clazz) {
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
        }

        private static void invokeTestMethods(Class<?> clazz) {
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Test.class) && Modifier.isStatic(method.getModifiers())) {
                    try {
                        method.invoke(null);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }