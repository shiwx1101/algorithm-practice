package org.algorithm.explore.dynamicprograming;
/**
 * 
 */
class EditDistance{

    private static char[] a = "mitcmu".toCharArray();
    private static char[] b = "mtacnu".toCharArray();

    int n = 6;
    int m = 6;
    int minDist = Integer.MAX_VALUE;

    /**
     * 
     * @param i
     * @param j
     * @param currentDist
     */
    public void Levenshtein(int i, int j,int currentDist){
        if(i==n||j==m){
            if(i<n){
                currentDist+=n-i;
            }
            if(j<m){
                currentDist+=m-j;
            }
            if(currentDist<minDist){
                minDist = currentDist;
            }
            return;
        }

        if(a[i]==b[j]){
            Levenshtein(i+1, j+1, currentDist);
        }else{
            Levenshtein(i+1, j, currentDist+1);
            Levenshtein(i, j+1, currentDist+1);
            Levenshtein(i+1, j+1, currentDist+1);
        }

    }


    

    /**
     * 
     * @param a
     * @param b
     * @param m
     * @param n
     * @return
     */
    public int stateTable(char[] a,char[] b,int m,int n){
        int[][] states = new int[n][m];
      
        for (int i = 0; i < m; i++) {
            if(b[0]==a[i]){
                states[0][i] = i;
            }else if(i!=0){
                states[0][i] = states[0][i-1]+1; 
            }else{
                states[0][i] = 1;
            }
        }


        for (int i = 0; i < n; i++) {
            if(a[0]==b[i]){
                states[i][0] = i;
            }else if(i!=0){
                states[i][0] = states[i-1][0]+1;
            }else{
                states[i][0] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(a[i]==b[j]){
                    states[i][j] = min(states[i-1][j-1], states[i-1][j], states[i][j-1]);
                }else{
                    states[i][j] = min(states[i-1][j-1]+1, states[i-1][j]+1, states[i][j-1]+1);
                }
            }
        }
        return states[n-1][m-1];
    }

    /**
     * 
     * @param i
     * @param j
     * @param k
     * @return
     */
    private int min(int i ,int j,int k){
        int min = Integer.MAX_VALUE;
        if(i<min){
            min = i;
        }
        if(j<min){
            min = j;
        }
        if(k<min){
            min = k;
        }
        return min;
    }

    public static void main(String[] args) {
        EditDistance ed =  new EditDistance();
        ed.Levenshtein(0, 0, 0);
        System.out.println(ed.minDist);
        int l = ed.stateTable(a, b, 6, 6);
        System.out.println(l);
    }




}