import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class string_operations {
    String better_string(String s1 , String s2, BiPredicate<String, String>bi){
        if(bi.test(s2,s1))
            return s2;
        return s1;
      }
      boolean all_char(char c, Predicate<Character>p){
        return p.test(c);

      }
      boolean check(String s){

        for (int i=0; i<s.length(); i++)
        {

            if (!all_char(s.charAt(i),Character::isLetter))
                return false;

        }
        return true;
      }


}
