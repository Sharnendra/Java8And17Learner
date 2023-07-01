package functionalInterfaceTest;

public interface Recursable<T, U> {

    U apply(T t, Recursable<T, U> r);
}
