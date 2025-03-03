package project.productsManagement.core;

import project.productsManagement.domain.management.enterprise.entities.scrappingProduct.ScrappingProduct;

import java.lang.reflect.Field;

public class Utils {
    public static boolean classHasNullAttribute(Object obj) {
        if (obj == null) return true;

        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.get(obj) == null) {
                    return true;
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
