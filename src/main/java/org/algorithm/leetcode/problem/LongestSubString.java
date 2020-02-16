package problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * 
 * 
 * Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 */
class LongestSubString{


    /**
     * Check all the substring one by one to see if it has no duplicate character
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringBruteForce(String s){
        int n = s.length();

        int maxSize = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                if(allUnique(s, i, j)){
                    maxSize=maxSize>(j-i)?maxSize:j-i;
                }
            }
        }
        return maxSize;
    }

    public boolean allUnique(String s,int start,int end){
        
        Set<Character> set = new HashSet<Character>();
        for (int i = start; i < end; i++) {
            
            char ch = s.charAt(i);
            if(set.contains(ch)){
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    /**
     * 
     * Sliding Window
     * 
     * 
     * 
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringSlideWindow(String s){

        int n = s.length();
        int maxSize = 0;
        int i=0,j=0;
        Set<Character> set = new HashSet<Character>();

        while(i<n&j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                maxSize= Math.max(maxSize, j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }

        return maxSize;
    }


    /**
     * 
     * Sliding Window Optimized
     * 
     * 
     * 
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringSlideWindowOptimized(String s){
        int n = s.length();
        int maxSize = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0,j=0; j < n; j++) {
            if(map.containsKey(s.charAt(j))){
                i=Math.max(map.get(s.charAt(j)), i) ;
            }
            maxSize = Math.max(maxSize, j-i+1);
            map.put(s.charAt(j), j+1);
        }
        return maxSize;
    }




    /***
     * 
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        char[] charSet = s.toCharArray();
        int longestNum = 0;
        int point = 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();

        for (int i =0 ;i<charSet.length;i++) {
            
            if(!map.containsKey(charSet[i])){
                map.put(charSet[i], i);
                
            }else{
                point=map.get(charSet[i])+1>point?map.get(charSet[i])+1:point;
                map.put(charSet[i], i);
                // longestNum = longestNum>(i-point+1)?longestNum:(i-point+1);
            }
            longestNum = longestNum>(i-point+1)?longestNum:(i-point+1);

        }
    
        return longestNum;
    }
    public static void main(String[] args) {
        String a ="tmmzuxt";
        int length = new LongestSubString().lengthOfLongestSubstring(a);
        System.out.println(a+" 's longest substring length is"+length);

    }


}