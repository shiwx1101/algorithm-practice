### 算法第四版心得 chapter1  有序数组 双指针法

#### 		~双指针齐步走:

##### 			1.  归并排序（MergeSort.java）中合并两个有序数组的操作：

```java
		while(j<=mid&&k<=e){
            if(a[j]<a[k]){
                tmp[i++] = a[j++];
            }else{
                tmp[i++] = a[k++];
            }
        }
```

##### 			2.两个有序数组中的所有公共元素 习题1.4.12

```java
    /**
     * 时间复杂度最坏为 M+N(都不一样)   最好为min(M,N)(a或者b中的元素全部一致)
     */
    public void showCommonInt() {
        int N = a.length;
        int M = b.length;
        int i = 0;
        int j = 0;
        while (i < N && j < M) {
            //防止重复计算的
            if (i != 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            if (j != 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }
            if (a[i] > b[j]) {
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                i++;
                j++;
                StdOut.print(a[i - 1] + " ");
            }
        }
    }
```

#### 		~双指针左右夹击

##### 				1.twoSum（有序数组中和为0的整数对的数量） 习题1.4.15

```java
  //循环内总共执行N次或者更少，因为 碰到相同的 头尾指针都会向里面靠，
    //combination 函数复杂度也不花超过N
    //所以大致执行次数不会超过 2*N  复杂度为N
    public int twoSum() {
        //头尾指针
        int i = 0;
        int j = a.length - 1;
        int count = 0;
        while (a[i] < 0 && a[j] > 0 && i < j) {
            if (a[i] + a[j] > 0) {
                j--;
            } else if (a[i] + a[j] < 0) {
                i++;
            } else {//等于0
                int pp = 1;//正数的数量
                int np = 1;//负数的数量
                while (i + 1 < a.length && a[i] == a[i + 1]) {
                    i++;
                    np++;
                }
                while (j - 1 >= 0 && a[j] == a[j - 1]) {
                    j--;
                    pp++;
                }
                i++;
                j--;
                count += np * pp;
            }
        }
        count += combination(j - i + 1, 2);//处理为0的情况
        return count;
    }
```

​		

#### 体会：排序真的很重要，排完序的数组进行各种计算都能更加便捷。



