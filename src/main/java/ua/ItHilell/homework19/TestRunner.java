package ua.ItHilell.homework19;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestRunner {

    public static <T> void start(Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Method[] methods = clazz.getDeclaredMethods();

        List<Method> beforeMethodtList = Arrays.stream(methods)
                .filter(method -> {
                    BeforeSuite result = method.getAnnotation(BeforeSuite.class);
                    return result != null;
                }).toList();

        List<Method> testMethosList = Arrays.stream(methods)
                .filter(method -> {
                    Test result = method.getAnnotation(Test.class);
                    return result != null;
                })
                .sorted((o1, o2) -> {
                    Integer priority1 = o1.getAnnotation(Test.class).priority();
                    Integer priority2 = o2.getAnnotation(Test.class).priority();
                    return priority1.compareTo(priority2);
                }).toList();

        List<Method> afterMethodList = Arrays.stream(methods)
                .filter(method -> {
                    AfterSuite result = method.getAnnotation(AfterSuite.class);
                    return result != null;
                }).toList();

        List<Method> allTestMethods = new ArrayList<>();
        if (beforeMethodtList.size() <= 1 && afterMethodList.size() <= 1) {
            allTestMethods.addAll(beforeMethodtList);
            allTestMethods.addAll(testMethosList);
            allTestMethods.addAll(afterMethodList);
        } else {
            throw new RuntimeException("You have more than 1 before or/and after methods.");
        }

        for (Method method : allTestMethods) {
            method.invoke(clazz.getDeclaredConstructor().newInstance());
        }
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        start(FooTest.class);
    }

}
