package functionalInterfaceTest.tests;

import functionalInterfaceTest.NestedFunctionalMethods;
import functionalInterfaceTest.Recursable;

import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NestedFunctionalMethodTest {

    static final UnaryOperator<Long> fact = x -> x == 1 ? 1: x * NestedFunctionalMethodTest.fact.apply(x - 1 );

    public static <T, U> Function<T, U> recurse(Recursable<T, U> f) {
        return t -> f.apply(t, f);
    }

    public static <T> void main(String[] args) {

        Function<Integer, Integer> factorial = recurse((i, f) -> 1 == i ? 1 : i * f.apply(i - 1, f));

        String str = "Sharnendra Dey";
        NestedFunctionalMethods<String, String> stringFunction = t -> t.toUpperCase();
        NestedFunctionalMethods<String, Integer> integerFunction = t -> t.length();
        NestedFunctionalMethods<Integer, List<Integer>> intList = t -> IntStream
                .iterate(1, i->i+1)
                .limit(t)
                .boxed().collect(Collectors.toList());

        NestedFunctionalMethods<String, Map<String, Long>> charCountFromString = t ->
                t.codePoints()
                .mapToObj(Character::toString)
                .filter(x -> !x.equals(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Integer> data = stringFunction.andThen(integerFunction).andThen(intList).apply(str);
        System.out.println(data);
        System.out.println(charCountFromString.apply(str));
        System.out.println(fact.apply(10l));
    }
}
