package algorithm.explore.binarysearch;

class BinarySearchPro{
    /**
     * 查找第一个只等于给定值的元素
     * @return
     */
    public static int bSearch1(int[] a,int k){
        int start = 0;
        int end = a.length - 1;

        while(end>=start){
            int mid = (start+end)/2;
            if(a[mid]>k){
                end = mid-1;
            }else if(a[mid]<k){
                start = mid+1;
            }else{
                if(mid==0||a[mid-1]<k){
                    return mid;
                }
                end = mid - 1;
            }
        }
        return -1;
    }
    /***
     * 查找最后一个只等于给定值的元素
     * @param a
     * @param k
     * @return
     */
    public static int bSearch2(int[] a,int k){
        int n = a.length;
        int start = 0;
        int end = a.length - 1;

        while(end>=start){
            int mid = (start+end)/2;
            if(a[mid]>k){
                end = mid-1;
            }else if(a[mid]<k){
                start = mid+1;
            }else{
                if(mid==n-1||a[mid+1]>k){
                    return mid;
                }
                start = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     * @param a
     * @param k
     * @return
     */
    public static int bSearch3(int[] a,int k){
        // int n = a.length;
        int start = 0;
        int end = a.length - 1;

        while(end>=start){
            int mid = (start+end)/2;
            if(a[mid]>=k){
                if(mid==0||a[mid-1]<k){
                    return mid;
                }
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }


    /**
     * 查找最后一个小于等于给定值的元素
     * @param a
     * @param k
     * @return
     */
    public static int bSearch4(int[] a,int k){
        int n = a.length;
        int start = 0;
        int end = a.length - 1;

        while(end>=start){
            int mid = (start+end)/2;
            if(a[mid]<=k){
                if(mid==n-1||a[mid+1]>k){
                    return mid;
                }
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] m = {1,2,3,4,5,5,5,5,6,7,8,9};
       System.out.println(bSearch1(m, 5));
       System.out.println(bSearch2(m, 5));
       System.out.println(bSearch2(m, 3));
       System.out.println(bSearch2(m, 1));
    }

}