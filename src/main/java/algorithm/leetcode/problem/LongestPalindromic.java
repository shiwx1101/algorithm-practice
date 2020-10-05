package algorithm.leetcode.problem;

class LongestPalindromic{

    /**
     *  BruteForce
     * 
     * @param s
     * @return
     */   
    public String LongestPalindromicBruteForce(String s){
        int n = s.length();
        int palindromicLength = 0;
        String palindromicSubString ="";
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                if(isPalindromic(s,i,j)){
                    if(palindromicLength<j-i){
                        palindromicLength = j-i;
                        palindromicSubString = s.substring(i, j);
                    }
                }
            }
        }
        return palindromicSubString;
    }

    /**
     * 
     * @param s
     * @param start
     * @param end
     * @return
     */
    private boolean isPalindromic(String s,int start,int end){
        
        int length = end-start;
        int meadianRight = length/2+start;
        int meadianLeft  = length%2==0?(length/2-1)+start:length/2+start;

        while(meadianLeft>=start&&meadianRight<end){
            if(s.charAt(meadianLeft) == s.charAt(meadianRight)){
                meadianLeft--;
                meadianRight++;
            }else{
                return false;
            }
        }

        return true;
    }
    /**
     * two point walk
     * 
     * Expand Around Center
     * @param s
     * @return
     */
    public String LongestPalindromicWalk(String s){
        int n = s.length();
        int meadianLeft =0,meadianRight=0;
        String subpalStr = "";
        String sub = null;
        int subpalsize = 0;

        while(meadianLeft<n&&meadianRight<n){
            sub = subPalindromic(s,meadianLeft,meadianRight);
            meadianRight++;
            if(sub.length()>subpalsize){
                subpalsize = sub.length();
                subpalStr = sub;
            }

            sub = subPalindromic(s,meadianLeft,meadianRight);
            meadianLeft++;
            if(sub.length()>subpalsize){
                subpalsize = sub.length();
                subpalStr = sub;
            }
            

        }

        return subpalStr;
    }

    private String subPalindromic(String s,int meadianLeft,int meadianRight){
        int left = meadianLeft;
        int right = meadianRight;
        int n = s.length();
        int count = 0;
        while(left>=0&&right<n){
            if(s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                count++;
            }else{
                break;
            }
        }
        left = meadianLeft - count+1;
        right = meadianRight+count;
        return s.substring(left, right);
    }

    /***
     * Longest Common Substring
     * 
     * 
     * @param s
     * @return
     */
    public String LongestPalindromicCommonSubString(String s){

        String reverseStr = "";
        StringBuffer reverseStrBuffer= new StringBuffer();
        int n = s.length();
        for (int i = n-1; i >= 0; i--) {
            reverseStrBuffer.append(s.charAt(i));
        }
        reverseStr = reverseStrBuffer.toString();
        return null;
    }


    public static void main(String[] args) {
    //    String pal =  new LongestPalindromic().LongestPalindromicBruteForce("afafasdasddasdaassssssssddd");
    String pal =  new LongestPalindromic().LongestPalindromicWalk("afafasdasddasdaassssssssddd");
       System.out.println(pal);
    }


}