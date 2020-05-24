package google;

import java.util.*;

public class FindDifference {
    public static void main(String[] args) {
        String s = "abcde";
        String t = "abcded";
        FindDifference obj = new FindDifference();
        System.out.println(obj.getDifference(s, t));

    }

    public char getDifference(String s, String t) {
        Set<Character> set = new HashSet<Character>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        for (char c : t.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        return set.isEmpty() ? ' ' : set.iterator().next();
    }

}