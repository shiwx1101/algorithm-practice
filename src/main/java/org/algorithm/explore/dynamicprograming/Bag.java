package explore.dynamicProgramming;

/**
 * 0 1 Bag
 * 
 * 
 */
class Bag{

    private static int maxWeigh = Integer.MIN_VALUE; 
    private static int[] weight = {2,2,4,6,3}; //stuff weighs
    private int count = 5; // stuff count 
    private int limitWeigh = 9; //Bag Max Capacity;
    private boolean[][] mem = new boolean[count][limitWeigh+1]; //memorandum

    /***
     * 
     * 
     * 
     * @param i            
     * @param currentWeigh 
     */
    public void f(int i, int currentWeigh) {

        if (i == count || currentWeigh == limitWeigh) {
            if (currentWeigh > maxWeigh)
                maxWeigh = currentWeigh;
            return;
        }
        if(mem[i][currentWeigh])return;
        mem[i][currentWeigh]=true;
        f(i + 1, currentWeigh);
        if (weight[i] + currentWeigh <= limitWeigh) {
            f(i, currentWeigh + weight[i]);
        }
    }

    /**
     * 
     * @param currentWeigh
     * @param count
     * @param limitWeigh
     */
    public int f1(int[] weigh,int count,int limitWeigh){
        boolean[][] states = new boolean[count][limitWeigh+1];
        states[0][0] = true;
        if(weight[0]<limitWeigh){
            states[0][weight[0]] = true;
        }
        for (int i = 1; i < count; i++) {
            for (int j = 0; j <= limitWeigh;j++) {
                if(states[i-1][j]==true) states[i][j]=true;
            }

            for (int j = 0; j <= limitWeigh-weight[i]; j++) {
                if(states[i-1][j]==true) states[i][j+weight[i]]=true;
            }
        }
        for (int i = limitWeigh; i >= 0; i--) {
            if(states[count-1][i]){
                return i;
            }
        }
        return 0;
    }

    public int f2(int[] weigh, int count,int limitWeigh ){
        boolean[] states = new boolean[limitWeigh+1];
        states[0] = true;
        if(weigh[0]<=limitWeigh){
            states[weigh[0]]=true;
        }

        for (int i = 1; i < count; i++) {
            for (int j = limitWeigh-weigh[i]; j >=0 ; j--) {
                if(states[j]){
                    states[j+weigh[i]]=true;
                }
            }
        }

        for (int i = limitWeigh; i >= 0; i--) {
            if(states[i]){
                return i;
            }
        }

        return 0;


    }

    public static void main(String[] args) {
        // new Bag().f(0, 0);
        // System.out.println(maxWeigh);
        
        System.out.println(new Bag().f2(weight, 5, 9));
    }


}