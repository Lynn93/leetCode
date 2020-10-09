package lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;
// 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

// 1. 用一个map记录 字符和下标的信息 "a": 0，用 一个int 记录当前的最长不重复字串长度。
// 2. 如果遇到重复字符，则从map中 重复字符的下标+1位置重新搜索，同时将map清空，比较此次字串长度与 int记录值孰大孰小，记录更大的值。
// 3. 判断 新的起始点到字符串终止点 长度是否小于 目前的最大长度，若小于，则停止搜索。
// 4. 重复1 2 3，直到字符串被搜索完毕或剩余长度小于最小长度。

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;// 每一轮的result
        int maxResult = 0;
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        int start = 0;
        // 遍历所有字符
        for (Integer i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if(!myMap.containsKey(item + "")){//如果没有的话，构造它
                myMap.put(item + "", i);
                result++;//可能有的字串不会命中重复，那么返回的长度应当是当前已入map的 队列长度
            } else {
                result = i - start;
                maxResult = maxResult>result? maxResult:result;
                i = myMap.get(item + "");//之后走到i++，就会从 重复字符的+1 位置开始搜索
                start = i+1;

                //判断剩余字串是否超过当前最大长度
                if(s.length() - start <= result){
                    break;
                }
                myMap = new HashMap<String, Integer>();
                result = 0;
            }
        }
        maxResult = maxResult>result? maxResult:result;
        return maxResult;
    }
}


public class LengthOfLongestSubstring {
    public static void main(String []args){
        Solution sl = new Solution();
        
        System.out.println(sl.lengthOfLongestSubstring("hkcpmprxxxqw"));
        System.out.println("done!");
    }
}
