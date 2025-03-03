package br.gabriel.product_management.core;

import java.lang.reflect.Field;

public class Utils {
    public static boolean classHasNullAttribute(Object obj) {
        if (obj == null) return true;

        try {
            Class<?> currentClass = obj.getClass();
            while (currentClass != null) {
                for (Field field : currentClass.getDeclaredFields()) {
                    field.setAccessible(true);
                    if (field.get(obj) == null) {
                        return true;
                    }
                }
                currentClass = currentClass.getSuperclass();
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return false;
    }


    public static void hasNullValue(Object data) {
        if (data == null || classHasNullAttribute(data)) {
            throw new NullPointerException("User must not be null");
        }
    }
}
