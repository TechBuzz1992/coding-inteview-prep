package google;

import java.util.*;

public class BackSpaceStringCompare {
    public static void main(String[] args) {
        String s = "#ac#c";
        String t = "ccacb#";

        BackSpaceStringCompare obj = new BackSpaceStringCompare();
        System.out.println(obj.areTwoStringsEqual(s, t));

    }

    public boolean areTwoStringsEqual(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!sStack.isEmpty()) {
                    sStack.pop();
                }

            }

            else {
                sStack.push(c);
            }

        }

        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (!tStack.isEmpty()) {
                    tStack.pop();
                }

            }

            else {
                tStack.push(c);
            }

        }

        while (!sStack.isEmpty() && !tStack.isEmpty()) {
            if (sStack.peek() != tStack.peek()) {
                return false;
            }
            sStack.pop();
            tStack.pop();
        }

        if (!sStack.isEmpty() || !tStack.isEmpty()) {
            return false;
        }

        return true;

    }

}