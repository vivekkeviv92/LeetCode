package com.coding.practice._100_199;

/*
MEDIUM
PREMIUM
163. Missing Ranges

Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

Example:

Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]
*/

import java.util.ArrayList;
import java.util.List;

public class LeetCode_163 {
    public void getInterval(List<String> result, long lower, long upper){
        if(lower==upper){
            //doNothing
        }else if(upper == 1+lower) {
            //doNothing
        } else if (lower+1 == upper-1) {
            result.add(String.valueOf(lower+1));
        } else {
            String res=String.valueOf(lower+1)+"->"+String.valueOf(upper-1);
            result.add(res);
        }
    }
    public List<String> findMissingRanges(int[] nums, int l, int u) {
        long upper = (long)u;
        long lower = (long)l;

        List<String> result = new ArrayList<>();
        if(nums==null || nums.length==0) {
            getInterval(result, lower-1,upper+1);
            return result;
        }
        getInterval(result, lower-1, nums[0]);
        for(int i=0;i<nums.length-1;i++) {
            getInterval(result, nums[i], nums[i+1]);
        }
        getInterval(result, nums[nums.length-1], upper+1);
        return result;
    }
}
