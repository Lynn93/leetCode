//https://leetcode-cn.com/problems/median-of-two-sorted-arrays/submissions/
//很简单，就是归并排序的 合并 操作，不知道这种题目为什么是困难。

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mergedLen = nums1.length + nums2.length;
        double[] mergedArray = new double[mergedLen];
        int flag1 = 0;
        int flag2 = 0;
        for(int i=0; i< mergedLen;i++){
            if(flag1< nums1.length && flag2<nums2.length){
                if(nums1[flag1]>nums2[flag2]){
                    mergedArray[i] = nums2[flag2];
                    flag2++;
                } else {
                    mergedArray[i] = nums1[flag1];
                    flag1++;
                }
            } else if(flag1 == nums1.length){//如果nums1 已经消耗完了
                mergedArray[i] = nums2[flag2];
                flag2++;
            } else if(flag2 == nums2.length){
                mergedArray[i] = nums1[flag1];
                flag1++;
            }
        }

        if(mergedLen%2 == 0){//如果是偶数
            return (mergedArray[mergedLen/2] + mergedArray[(mergedLen-1)/2])/2;
        } else {
            return mergedArray[mergedLen/2];
        }
    }
}

public class FindMedian {
    public static void main(String []args){
        int[] nums1 = {1,2};
        int[] nums2 = {3};
        Solution sl = new Solution();
        double result = sl.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
        System.out.println("done!");
    }
}
