package problem;
/**
 * 4. Median of Two Sorted Arrays
 * 
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 * 
 * 
 */
class MedianOfTwoSortedArray{
    
    /**
     * O(n,m)
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n= nums1.length;
        int m= nums2.length;
        int[] merge = new int[m+n];

        int i=0;
        int j=0;
        int k=0;


        while(i<n&&j<m){
            if(nums1[i]<nums2[j]){
                merge[k++]=nums1[i++];
            }else{
                merge[k++]=nums2[j++];
            }
        }

        if(i==n){
            while(j<m){
                merge[k++]=nums2[j++];
            }
        }else{
            while(i<n){
                merge[k++]=nums1[i++];
            }
        }
        if((m+n)%2==1){
            return merge[(m+n)/2];
        }
        return (merge[(m+n-1)/2]+merge[(m+n)/2])/2.0;

    }
    /**
     * The overall run time complexity should be O(log (m+n)).
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArraysRecursive(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        if(m>n){
            int temp = m; m=n;n=temp;
            int[] tmp = nums1;nums1=nums2;nums2=tmp;
        }
        int half = (m+n+1)/2;
        int imin=0;
        int imax=m;

        while(imin<=imax){
            int i = (imax+imin)/2;
            int j = half-i;
            if(i>imin&&nums2[j]<nums1[i-1]){
                imax=i-1;
            }else if(i<imax&&nums2[j-1]>nums1[i]){
                imin=i+1;
            }else{
                int leftMax = 0;
                if(i==0){
                    leftMax = nums2[j-1];
                }else if(j==0){
                    leftMax = nums1[i-1];
                }else{
                    leftMax = Math.max(nums1[i-1], nums2[j-1]);
                }
                if((m+n+1)%2==0){
                    return leftMax;
                }

                int rightMin = 0;

                if(i==m){
                    rightMin = nums2[j];
                }else if(j==n){
                    rightMin = nums1[i];
                }else{
                    rightMin = Math.min(nums1[i], nums2[j]);
                }
                return (leftMax+rightMin)/2.0;

            }
        }
        return 0.0;

    }


    public static void main(String[] args) {

        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        double x = new MedianOfTwoSortedArray().findMedianSortedArrays(nums1, nums2);
        System.out.println(x);
        

    }

}