package AM;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SizeKWithKDistinct {

    public List<String> subStringsKDist(String s, int K) {
        if (s == null || K < 1 || s.length() < K ) return new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        int[] counter = new int[26];
        int tail = 0;
        int head = 0;
        int len = s.length();
        while (head < len) {
            char c = s.charAt(head);
            counter[c - 'a']++;
            while (head - tail + 1 > K || counter[c - 'a'] > 1) {
                //if found dup or len > K, move tail pointer
                counter[s.charAt(tail) - 'a']--;
                tail++;
            }
            if (head - tail + 1 == K) set.add(s.substring(tail, head + 1));
            head++;
        }

        return new ArrayList<String>(set);
    }



    public static void main (String[] args){
        SizeKWithKDistinct test = new SizeKWithKDistinct();
        System.out.print(test.subStringsKDist("awaglknagawunagwkwagl",4));
    }

}


