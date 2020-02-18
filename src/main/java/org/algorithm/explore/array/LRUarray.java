package org.algorithm.explore.array;
/**
 * LRU 
 * Time Complexity O(n)
 * 
 */
class LRUarray{

    private int n = 5;
    private Object[] cache = new Object[n];

    public Object getRecent(){
        return cache[0];
    }

    public void add(Object o){
        int index = indexOf(o);
        if(index==-1){
            move(n-1);
        }else{
            move(index);
        }
        cache[0] = o;
    }

    private void move(int index){
        for (int i = index; i >=1; i--) {
            cache[i] = cache[i-1];
        }
    }

    /**
     * 
     * @param o
     * @return
     */
    private int indexOf(Object o){
        for (int i = 0; i < n; i++) {
            if(o==cache[i]) return i;
        }
        return -1;
    }







}