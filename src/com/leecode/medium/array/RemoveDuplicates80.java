package com.leecode.medium.array;

public class RemoveDuplicates80 {
    public static int removeDuplicates(int[] nums) {
        int res = 0;
        for (int i = 0;i < nums.length;i++){
            int count = 1;
            for (int j =i + 1;j < nums.length;j++){
                if (nums[i] == nums[j]){
                    count++;
                }else {
                    i = j-1;
                    break;
                }
            }
            res += Math.min(count,2);
        }
//        while ( i < nums.length){
//            int times = 1;
//            int j = 1;
//            while (j < nums.length){
//
//            }
//            while (nums[i] == nums[i - 1]){
//                times++;
//                i++;
//            }
//            count += Math.min(times, 2);
//            i++;
//        }
        return res;
    }
    public static int removeDuplicates2(int[] nums) {
        if(nums == null) return 0;
        if(nums.length <= 2) return nums.length;

        // 1.定义[0,index] 是修改后的满足要求的数组区间,这里已经把0 1 2 ...k- 1 ,共k个数 放进去了
        int index = 1;
        // 2.判断终止条件
        for(int i = 2;i < nums.length;i++){
            // 3.指针移动条件
            if(nums[i] != nums[index-1]){
                index++;
                nums[index] = nums[i];
            }
        }
        // 4.判断返回值
        return index + 1;
    }
    public static void main(String[] args) {
//        int[] nums = {1,1,1,2,2,3};
        int[] nums = {0,0,1,1,1,1,2,3,3};
//        int[] nums = {1,1,1,1,1,1};
        System.out.println(removeDuplicates2(nums));
    }
}
