package algorithm.explore.sort;
/**
 * 找出第K大的元素
 */
class NoKitem{


    public int findNoKItem(int[] a ,int k){

        int l= a.length;
        if(k>l||k<1) throw new IllegalArgumentException("");
        return find(a, 0, l-1, k);
    }

    public int find(int[] a,int s,int e,int k){
        int i = s;
        for (int j = s; j < e; j++) {
            if(a[j]>a[e]){
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
        }
        int tmp = a[i];
        a[i] = a[e];
        a[e] = tmp;

        if(i+1==k){return a[i];}
        else if(i+1>k){
            return find(a, s, i-1, k);
        }else{return find(a, i+1, e, k);}
    }

    public static void main(String[] args) {
        int[] m = {1,2,3,4,5,5,4,3,2,1};
        int a = new NoKitem().findNoKItem(m, 3);
        System.out.println(a);
    }

}