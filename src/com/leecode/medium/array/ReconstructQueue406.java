package com.leecode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReconstructQueue406 {
    public static void main(String[] args) {
        ReconstructQueue406 reconstructQueue = new ReconstructQueue406();
        int[][] prople = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println("reconstructQueue.reconstructQueue(prople) = " + Arrays.deepToString(reconstructQueue.reconstructQueue(prople)));
    }
    public int[][] reconstructQueue(int[][] people) {
        if(people.length == 0){
            return new int[0][0];
        }
        //按照身高降序 K升序排序
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int[]> res=new ArrayList<>();
        for(int[] num:people){
            res.add(num[1],num);
        }
        return res.toArray(new int[res.size()][]);
    }
}
