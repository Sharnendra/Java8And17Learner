package functionalInterfaceTest;

import java.util.Objects;

@FunctionalInterface
public interface NestedFunctionalMethods<T, R> {

    R apply(T t);

    default <V> NestedFunctionalMethods<V, R> compose(NestedFunctionalMethods<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

    default <V> NestedFunctionalMethods<T, V> andThen(NestedFunctionalMethods<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    static <T> NestedFunctionalMethods<T, T> identity() {
        return t -> t;
    }

}
