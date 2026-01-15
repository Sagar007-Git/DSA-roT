import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String pattern = "aabb";
        String s = "dog dog dog cat";
        String[] arr = s.split(" ");
//        System.out.printf(fun(pattern, s));
        fun(pattern, s);
//        System.out.println(result);
    }
    public static void fun(String pattern, String s){
        String[] arr = s.split(" ");
        System.out.print(Arrays.toString(arr));
        HashMap<Character, String > map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if(!map.containsKey(pattern.charAt(i))) map.put(pattern.charAt(i), arr[i]);
        }
        for (int j = 0; j < pattern.length(); j++) {
            if(!map.get(pattern.charAt(j)).equals(arr[j])) {
                System.out.print("False");
                return;
            }
        }
        System.out.print("true");
    }
}
