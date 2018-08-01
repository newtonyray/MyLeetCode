package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC859BuddyStrings {
    //solution 1
    public boolean buddyStrings(String A, String B) {
        if (A == null || B == null || A.length() != B.length() || A.length() < 2 || B.length() < 2) return false;
        HashSet<Character> set = new HashSet<>();
        boolean hasDup = false;
        List<Integer> difPos = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (!set.add(A.charAt(i))) hasDup = true;
            if (A.charAt(i) != B.charAt(i)) difPos.add(i);
        }
        if (difPos.size() > 2 || difPos.size() == 1) return false;
        else if (difPos.size() == 0) return hasDup;
        return A.charAt(difPos.get(0)) == B.charAt(difPos.get(1))
                && A.charAt(difPos.get(1)) == B.charAt(difPos.get(0));
    }

    //TODO: solution2
}
