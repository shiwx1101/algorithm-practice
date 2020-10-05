package algorithm.explore.dynamicprograming;


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

    public int stateTable(char[] a,int n ,char[] b,int m){

        int[][] states = new int[n][m];

        for (int i = 0; i < n; i++) {
            if(b[0] == a[i]) {
                states[0][i] = 1;
            }else if(i!=0){
                states[0][i] = states[0][i-1];
            }else{
                states[0][i] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            if(a[0]==b[i]){
                states[i][0] = 1;
            }else if(i!=0){
                states[i][0] = states[i-1][0];
            }else{
                states[i][0] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(a[i]==b[j]){
                    states[i][j] = max(states[i-1][j-1], states[i-1][j], states[i][j-1])+1;
                }else{
                    states[i][j] = max(states[i-1][j-1], states[i-1][j], states[i][j-1]);
                }
            }
        }


        return states[n-1][m-1];
    }

    private int max(int i,int j,int k){
        int max = Integer.MIN_VALUE;
        if(i>max)max = i;
        if(j>max)max = j;
        if(k>max)max = k;
        return max;
    }



    public static void main(String[] args) {
       LongestCommomSubString ls =  new LongestCommomSubString();
       ls.recall(0, 0, 0);
       System.out.println(ls.lcs);
       int lcs = ls.stateTable(a, 6, b, 6);
       System.out.println(lcs);
    }

}