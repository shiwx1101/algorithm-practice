package algorithm.explore.dynamicprograming;

class BagPro{

    private static int[] weight = {2,2,4,6,3}; //stuff weighs
    private static int[] values = {3,4,8,9,6}; //stuff values
    private int count = 5; // stuff count 
    private int limitWeight = 9; //Bag Max Capacity;
    private static int maxValue = Integer.MIN_VALUE;//

    private int[][] states = new int[count][limitWeight+1];

    /**
     * recall
     * 
     * @param i
     * @param currentWeight
     * @param currentValue
     */
    public void f(int i, int currentWeight, int currentValue) {

        if (i == count || currentWeight == limitWeight) {
            if (currentValue > maxValue) {
                maxValue = currentValue;
            }
            return;
        }
        f(i+1, currentWeight, currentValue);
        if (weight[i] + currentWeight <= limitWeight) {
            f(i + 1, currentWeight + weight[i], currentValue + values[i]);
        }
    }


    public int f2(int[] weight,int[] values){
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < limitWeight+1; j++) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if(weight[0]<=limitWeight){
            states[0][weight[0]] = values[0];
        }

        for (int i = 1; i < count; i++) {
            for (int j = 0; j < limitWeight+1; j++) {
                if(states[i-1][j]>=0){
                    states[i][j] = states[i-1][j];
                }
            }

            for (int j = 0; j < limitWeight+1-weight[i]; j++) {
                if(states[i-1][j]>=0){
                    states[i][j+weight[i]] = Math.max(states[i][j+weight[i]], states[i-1][j]+values[i]);
                }
            }
        }

        int maxV = 0;

        for (int i = 0; i < limitWeight+1; i++) {
           maxV = Math.max(states[count-1][i], maxV); 
        }
        return maxV;
 
    }


    private int[] statesForf3 = new int[limitWeight+1]; 

    /**
     * 
     * @param weight
     * @param values
     * @return
     */
    public int f3(int[] weight,int[] values){

        for (int i = 0; i < limitWeight+1; i++) {
            statesForf3[i] = -1;
        }

        statesForf3[0] = 0;
        if(weight[0]<=limitWeight){
            statesForf3[weight[0]]= values[0];
        }

        for (int i = 1; i < count; i++) {
            for (int j = limitWeight-weight[i]; j >=0 ; j--) {
                if(statesForf3[j]>=0){
                    statesForf3[j+weight[i]] = Math.max(statesForf3[j+weight[i]] , statesForf3[j]+values[i]);
                }
            }
        }
        int max = -1;
        for (int i = 0; i < limitWeight+1; i++) {
            max = Math.max(max, statesForf3[i]);
        }
        return max;
    }

    

    public static void main(String[] args) {
        new BagPro().f(0, 0, 0);
        System.out.println( maxValue);
        int result = new BagPro().f2(weight, values);
        System.out.println( result );
        int result2 = new BagPro().f3(weight, values);
        System.out.println( result2 );
    }




}