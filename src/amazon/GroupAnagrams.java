package amazon;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

        List<List<String>> list = groupAnagrams(strs);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    static List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        Arrays.sort(strs);

        for (String s : strs) {
            char[] characters = s.toCharArray();

            Arrays.sort(characters);

            String key = String.valueOf(characters);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<List<String>>(map.values());
    }

}