import java.util.*;

public class LongestSub {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int curr = 0, last = 0, lastMax = 0, maxLen = 0;
        while (curr < s.length()) {
            if (map.containsKey(s.charAt(curr))) {
                last = map.get(s.charAt(curr));
                // "+1" ensures return right max legnth if there are duplicate characters
                lastMax = Math.max(last + 1, lastMax);
            }
            map.put(s.charAt(curr), curr);
            // "+1" ensures return right max legnth if not duplicate characters
            maxLen = Math.max(curr - lastMax + 1, maxLen);
            curr++;
        }
        return maxLen;
    }

    public static void main(String[] args) throws Exception {
        LongestSub sub = new LongestSub();
        String s = "abcabcbb";
        System.out.println(sub.lengthOfLongestSubstring(s));
    }
}
