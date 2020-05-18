package amazon.common;

import java.util.*;

public class WordBreakII {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("superhighway");
        set.add("super");
        set.add("high");
        set.add("way");
        set.add("highway");
        set.add("rockstar");
        set.add("rock");
        set.add("star");
        set.add("rocks");
        set.add("tar");
        set.add("rockstars");

        List<List<String>> result = new ArrayList<>();

        for(String str: set){
            result.add(wordBreak(str, set));

        }

        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }

        
    }

    public static List<String> wordBreak(String s, Set<String> dict){
        if(s == null || s.length() == 0  || dict == null || dict.size() == 0){
            return new ArrayList<String>();
        }

        Map<String,List<String>> memo = new HashMap<>();

        return wordBreakHelper(s, dict, memo);



    }

    public static List<String> wordBreakHelper(String s, Set<String> dict, Map<String,List<String>> memo){
        if(memo.containsKey(s)){
            return memo.get(s);
        }

        List<String> ans = new ArrayList<>();

        if(dict.contains(s)){
            ans.add(s);
        }

        for(int i=1;i<=s.length();i++){
            String prefix = s.substring(0, i);
            if(dict.contains(prefix)){
                String suffix = s.substring(i);

                List<String> suffixStr = wordBreakHelper(suffix, dict, memo);

                for(String str : suffixStr){
                    ans.add(prefix + " " + str);
                }
            }
        }

        memo.put(s,ans);

        return ans;
    }


    
}