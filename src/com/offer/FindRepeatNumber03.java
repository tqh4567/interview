package com.offer;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber03 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set =new HashSet<>();
        for (int i = 0;i < nums.length;i++){
            if (set.contains(nums[i])){
                return nums[i];
            }else {
                set.add(nums[i]);
            }
        }
        return -1;
    }
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }
}
