package com.leecode.medium;

/**
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 *
 * 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
 *
 *
 *
 * 示例:
 * https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rectangle_area.png
 * 输入: -3, 0, 3, 4, 0, -1, 9, 2
 * 输出: 45
 * 说明: 假设矩形面积不会超出 int 的范围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rectangle-area
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ComputeArea223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1=(C-A)*(D-B);//面积一
        int area2=(G-E)*(H-F);//面积二
        return area1+area2-childArea(A,B,C,D,E,F,G,H);
    }

    private int childArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x1=Math.max(A,E),y1=Math.max(B,F);//左下交点
        int x2=Math.min(C,G),y2=Math.min(D,H);//右上交点
        if(x1<=x2&&y1<=y2){//说明有重叠
            return (x2-x1)*(y2-y1);
        }
        return 0;
    }
}
