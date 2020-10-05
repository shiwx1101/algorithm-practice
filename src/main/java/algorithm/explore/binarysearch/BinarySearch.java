package algorithm.explore.binarysearch;

class BinarySearch{
    

    public static int binarySearch(int[] a,int k){

        int start = 0;
        int end = a.length-1;
        while(end>=start){
            int mid = (end + start)/2;
            if(a[mid]==k){
                return mid; 
            }else if(a[mid]>k){
                end = mid-1;
            }else{
                start = mid +1;
            }
        }
        return -1;

    }

    public static int binarySearchRecursive(int[] a , int k){
        int start = 0;
        int end = a.length - 1;
        return find(a, start, end, k);
    }

    private static int find(int[] a,int start ,int end,int k){
        if(end<start){
            return -1;
        }
        int mid = (end+start)/2;
        if(a[mid]==k){
            return mid;
        }else if(a[mid]>k){
            return find(a, start, mid-1, k);
        }else{
            return find(a, mid+1, end, k);
        }


    }

    public static void main(String[] args) {
        int[] m = {1,2,3,4,5,6,7,8,9};
       System.out.println(binarySearch(m, 9));
       System.out.println(binarySearchRecursive(m, 9));
    }



}