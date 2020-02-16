package explore.dynamicProgramming;
/**
 * 
 */
class Route{


    private static int[][] w = {{1,3,5,9},
                         {2,1,3,4},
                         {5,2,6,7},
                         {6,8,4,3}};

    /***
     * 
     * @return
     */
    public int statesTable(int[][] w,int n){

        int[][] states = new int[n][n];

        states[0][0] = w[0][0];

        for (int k = 1; k < n; k++) {
            states[0][k] = states[0][k-1]+w[0][k];
        }

        for (int k = 1; k < n; k++) {
            states[k][0] = states[k-1][0]+w[k][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                states[i][j] = w[i][j]+Math.min(states[i-1][j], states[i][j-1]);
            }
        }

        return states[n-1][n-1];
    }
    /**
     * 
     * @param i
     * @param j
     * @return
     */
    
     private int[][] mem = new int[4][4];

    public int minDist(int i,int j){

        if(i==0&&j==0){
            return w[0][0];
        }
        if(mem[i][j]>0){
            return mem[i][j];
        }
        int minLeft = Integer.MAX_VALUE;
        if(j-1>=0){
            minLeft = minDist(i,j-1);
        }
        int minUp = Integer.MAX_VALUE;
        if(i-1>=0){
            minUp = minDist(i-1, j);
        }

        int current = w[i][j]+Math.min(minUp, minLeft);
        mem[i][j] = current;
        return current;
    }
    
    



    public static void main(String[] args) {
        int l = new Route().statesTable(w, 4);
        System.out.println(l);
        int k = new Route().minDist(3,3);
        System.out.println(k);

    }
}