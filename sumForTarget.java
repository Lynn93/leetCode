import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
// https://leetcode-cn.com/problems/two-sum/solution/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result = new int[] { i, j };
                    break;
                }
            }
        }
        return result;
    }
}

class HashSolution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<String, String> myMap = new HashMap<String, String>();
        for (int i = 0; i < nums.length; i++) {
            myMap.put(nums[i] + "", i + "");
        }
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            String getVal = myMap.get(left + "");
            if(getVal != null && Integer.parseInt(getVal) != i){
                result = new int[] { i, Integer.parseInt(getVal) };
                break;
            }
        }
        return result;
    }
}

class main {
    public static void main(String[] args) {
        System.out.println("start");
        Solution solution = new Solution();
        int[] input = new int[] { 2, 7, 11, 15 };
        System.out.println(Arrays.toString(solution.twoSum(input, 9)));


        HashSolution solution_hash = new HashSolution();
        System.out.println(Arrays.toString(solution_hash.twoSum(input, 9)));
    }
}