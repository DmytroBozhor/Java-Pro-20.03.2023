package ua.ItHilell.homework21;

import ua.ItHilell.homework19.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestRunner {

    public void runTests(String className) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> testClass = Class.forName(className);

        Method[] methods = testClass.getDeclaredMethods();

        List<Method> testMethosList = Arrays.stream(methods)
                .filter(method -> {
                    Test result = method.getAnnotation(Test.class);
                    return result != null;
                })
                .toList();

        for (Method method : testMethosList) {
            method.invoke(testClass.getDeclaredConstructor().newInstance());
        }
    }

    public static <T> void runTests(Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Method[] methods = clazz.getDeclaredMethods();

        List<Method> testMethosList = Arrays.stream(methods)
                .filter(method -> {
                    Test result = method.getAnnotation(Test.class);
                    return result != null;
                })
                .toList();

        for (Method method : testMethosList) {
            method.invoke(clazz.getDeclaredConstructor().newInstance());
        }
    }

    public static void runTests(String[] classNames) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Class<?>> classList = new ArrayList<>();
        for (String className : classNames) {
            Class<?> testClass = Class.forName(className);
            classList.add(testClass);
        }

        for (Class<?> className : classList) {

            Method[] methods = className.getDeclaredMethods();

            List<Method> testMethosList = Arrays.stream(methods)
                    .filter(method -> {
                        Test result = method.getAnnotation(Test.class);
                        return result != null;
                    })
                    .toList();

            for (Method method : testMethosList) {
                method.invoke(className.getDeclaredConstructor().newInstance());
            }
        }
    }

    public static <T> void runTests(Class<T>[] clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        for (Class<T> className : clazz) {

            Method[] methods = className.getDeclaredMethods();

            List<Method> testMethosList = Arrays.stream(methods)
                    .filter(method -> {
                        Test result = method.getAnnotation(Test.class);
                        return result != null;
                    })
                    .toList();

            for (Method method : testMethosList) {
                method.invoke(className.getDeclaredConstructor().newInstance());
            }
        }
    }

}
