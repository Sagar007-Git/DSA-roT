import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        String pattern = "aabb";
        String s = "dog dog cat cat";
        System.out.print(fun(pattern, s));

    }
    public static boolean fun(String pattern ,String s ){
        Map<Character,String> mp = new HashMap<>();
        String [] arr = s.split(" ");
        for(int i=0; i<arr.length; i++){
            char c = pattern.charAt(i);
            String str = arr[i];
            if(mp.containsKey(c)){
                if(!mp.get(c).equals(str)) return false;
            }else mp.put(c,str);
        }
        return true;
     }
}
