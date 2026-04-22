package org.example;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ByteBuddyExample {
    public static void main(String[] args) throws Exception {
        Class<?> type = new ByteBuddy()
                .subclass(Object.class)
                .name("MyCustomClassName")
                .defineMethod("myCustomMethodName", String.class, Modifier.PUBLIC)
                .intercept(MethodDelegation.to(GreetClass.class))
                .defineField("myCustomFieldName", String.class, Modifier.PUBLIC)
                .make()
                .load(
                        Main.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();

        Object instance = type.getDeclaredConstructor().newInstance();

        Method m = type.getDeclaredMethod("myCustomMethodName", null);
        System.out.println(m.invoke(instance));

        Field fieldX = type.getDeclaredField("myCustomFieldName");
        fieldX.set(instance, "Hello from field!");
        System.out.println(fieldX.get(instance));
    }
}


