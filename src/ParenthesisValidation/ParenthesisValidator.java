package ParenthesisValidation;

import java.util.*;
import java.util.function.Function;

public class ParenthesisValidator {
    public static void main(String[] args) {
        System.out.println(validateParenthesisInString.apply("{(())}<>{{}}"));
    }

    public static Function<String, Boolean> validateParenthesisInString = (val) -> {
        Map<Character, Character> paramMap = new HashMap<Character, Character>() {{
            put('{', '}');
            put('<', '>');
            put('(', ')');
        }};
        Stack<Character> stack = new Stack<>();
        for (char st: val.toCharArray()) {
            if(paramMap.containsKey(st)) {
                stack.push(paramMap.get(st));
            }
            else {
                if(st == stack.peek())
                {
                    stack.pop();
                }
            }
        }
        return stack.empty();
    };
}
