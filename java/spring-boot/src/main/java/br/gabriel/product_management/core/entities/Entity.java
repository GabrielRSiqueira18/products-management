package br.gabriel.product_management.core.entities;

import br.gabriel.product_management.core.Utils;

import java.util.Objects;
import java.util.UUID;

public abstract class Entity<T, R> {
    private final T ID;
    protected final R props;

    private String getTClassTypeName() {
        return getClass().getGenericSuperclass().getTypeName().split(",")[0].split("<")[1];
    }

    private boolean verifyTClass(Class<?> clazz) {
        return getTClassTypeName().equals(clazz.getTypeName());
    }

    protected Entity(T id, R props) {
        if (id == null && verifyTClass(UUID.class)) ID = (T) UUID.randomUUID();
        else ID = id;

        this.props = props;
    }

    public T getID() {
        return ID;
    }

    public boolean propsHasNullValue() {
        return Utils.classHasNullAttribute(props);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entity<?, ?> entity = (Entity<?, ?>) o;
        return Objects.equals(ID, entity.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ID);
    }
}
