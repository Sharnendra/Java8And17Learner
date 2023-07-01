import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CodeLeet {

    public static void main(String[] args) {
        String value = "Sharenendra Dey";
       /* Map<Character, Integer> charCountMap = null;
        if(!value.isEmpty()){
            charCountMap = new HashMap<>();
           for (int i=0; i<value.length(); i++){
               char ch = value.charAt(i);
                if(charCountMap.containsKey(ch)) {
                    charCountMap.put(ch, charCountMap.get(ch)+1);
                }
                else {
                    charCountMap.put(ch, 1);
                }
            }
        }
        System.out.println(charCountMap);*/
        Map<String, Long> charCount = value.codePoints().mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charCount);
    }
}
