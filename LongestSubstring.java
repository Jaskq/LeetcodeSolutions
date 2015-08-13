/*
Given a string, find the length of the longest substring
without repeating characters. For example, the longest
substring without repeating letters for "abcabcbb" is "abc",
which the length is 3. For "bbbbb" the longest substring is "b",
with the length of 1.

https://leetcode.com/problems/longest-substring-without-repeating-characters/
*/


import java.util.HashMap;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        int length = 0;
        int max= 0;
        int index = Integer.MIN_VALUE;
        int prevIndex = 0;
        for(int i = 0; i < s.length(); i++){
            String value = Character.toString(s.charAt(i));
            if(!hash.containsKey(value) || hash.get(value) < index){
                length = length + 1;
                hash.put(value, i+1);
            } else {
                index = hash.get(value);
                int amount = index - prevIndex;
                length = length + 1 - amount;
                prevIndex = index; //2
                hash.put(Character.toString(s.charAt(i)), i+1);
            }
            if(length > max){
                max = length;
            }
        }
        return max;
    }
}
