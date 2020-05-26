package coding_patterns;

import java.util.*;

public class FirstNonRepeatingCharacter {
    Set<Character> set = new HashSet<Character>();

    public char getNRC(char c) {
        if (set.contains(c)) {
            set.remove(c);
        }
        else{
            set.add(c);
        }

        if (!set.isEmpty()) {
            return set.iterator().next();
        } else {
            return ' ';
        }

    }

    public static void main(String[] args) {
        FirstNonRepeatingCharacter obj = new FirstNonRepeatingCharacter();
        String stream = "abba";

        for (char c : stream.toCharArray()) {
            System.out.println(obj.getNRC(c));
        }
    }

}