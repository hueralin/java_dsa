package leetcode;

import basic.TreeNode;

public class P968 {
    // 感谢，但是判断的顺序很重要！先判断左右孩子有没有没被覆盖的，有的话就得在当前节点安装摄像头；如果都被覆盖了那还得判断有没有安装摄像头，有安装的话，当前节点就不需要安装了，但是是被覆盖的状态，如果左右孩子都没安装，但是左右孩子已被覆盖，那么当前节点不能安装摄像头，但是需要被覆盖（交由父级处理）；
    // 0: 有摄像头
    // 1: 无摄像头，但已被覆盖
    // 2: 无摄像头，但未被覆盖
    int count = 0;
    public int minCameraCover(TreeNode root) {
        if (helper(root) == 2) {
            count++;
        }
        return count;
    }
    public int helper(TreeNode root) {
        // 空节点被当作无摄像头，但已被覆盖
        if (root == null) return 1;

        int left = helper(root.left);
        int right = helper(root.right);

        // 共有 00 01 02 11 12 22 六种状态

        // 02 12 22
        // 左右孩子有未被覆盖的，需要覆盖，所以安装摄像头
        if (left == 2 || right == 2) {
            count++;
            return 0;
        }

        // 11
        // 左右孩子都被覆盖了，当前节点不用安装摄像头，但是需要被（父节点）覆盖
        if (left == 1 && right == 1) {
            return 2;
        }

        // 00 01
        // 左右孩子有人安装了摄像头，那么当前节点不需要安装，且已被覆盖
        if (left == 0 || right == 0) {
            return 1;
        }

        return -1;
    }
}
