package org.example;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class GreetDynamicClass {
    public static void main(String[] args) throws Exception {
        System.out.println(new GreetDynamicClass().dynamicClassSayHelloFromSpain());
    }

    public String dynamicClassSayHelloFromSpain() throws Exception {
        Class<?> dynamicClass = new ByteBuddy()
                .subclass(HelloClass.class)
                // select the appropriate lines
                .name("SayHelloFromSpain")
                .defineMethod("sayHello", String.class, Modifier.PUBLIC)
                //

                .intercept(FixedValue.value("Hola!"))
                .make()
                .load(GreetDynamicClass.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();

        Object instance = dynamicClass.getDeclaredConstructor().newInstance();

        Method m = dynamicClass.getDeclaredMethod("sayHello");
        return m.invoke(instance).toString();
    }
}


