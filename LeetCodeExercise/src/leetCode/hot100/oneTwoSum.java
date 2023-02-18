package leetCode.hot100;

import java.util.HashMap;

/**
 * 给定一个整数数组 num和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 targe 的那两个整数，
 * 并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 */
public class oneTwoSum {
    public static void main(String[] args) {
        int sum =13;
        String sums = Integer.toString(sum);
        int a =Integer.getInteger(sums);

    }
    public static int [] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> mp = new HashMap();
        for(int i = 0;i<nums.length;i++){
            //如果集合中的key出现过nums[i]
            if(mp.containsKey(nums[i])){
                res[0]= mp.get(nums[i]);//因为之前存放的是差值，
                //也就是现在出现的这个数,取出他的values（下标）
                res[1]=i;//加上当前这个数的下标
                break;
            }
            //将差值num作为 key，i(下标)作为values存放在集合中
            //下一次循环的数组中的数字只要是这个差值，就说明集合中有两个数加在一起为target的
            int num= target-nums[i];
            mp.put(num,i);
        }
        return res;
    }
}

