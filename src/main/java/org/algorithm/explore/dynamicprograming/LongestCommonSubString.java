package org.algorithm.explore.dynamicprograming;


/**
 * 
 */
class LongestCommomSubString{

    private static char[] a = "mitcmu".toCharArray();
    private static char[] b = "mtacnu".toCharArray();

    int n = 6;
    int m = 6;

    int lcs = Integer.MIN_VALUE;
    /**
     * 
     */
    public void recall(int i ,int j,int current){
        if(i==n||j==m){
            if(current>lcs){
                lcs = current;
            }
            return;
        }
        if(a[i]==b[j]){
            recall(i+1, j+1, current+1);
        }else{
            recall(i+1, j, current);
            recall(i, j+1, current);
        }

    }

    public static void main(String[] args) {
       LongestCommomSubString ls =  new LongestCommomSubString();
       ls.recall(0, 0, 0);
       System.out.println(ls.lcs);
    }

}