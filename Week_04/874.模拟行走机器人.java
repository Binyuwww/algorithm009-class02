import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
class Solution {

    public int robotSim(int[] commands, int[][] obstacles) {

        int [][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0;
        int y = 0;
        int index = 0;
        int ans = 0;

        Set<String> set = new HashSet<>();
        for (int i = 0; i <obstacles.length; ++ i) {
            set.add(obstacles[i][0] + ", " + obstacles[i][1]);
        }

        for (int i = 0; i < commands.length; ++ i) {
            if (commands[i] == -1) {
                index = (index + 1) % 4;
            }
            else if (commands[i] == -2) {
                index = (index + 3) % 4;
            }
            else if (commands[i] > 0) {
                for (int j = 1; j <= commands[i]; ++ j) {
                    int xNext = x + dir[index][0];
                    int yNext = y + dir[index][1];

                    if (set.contains(xNext + ", " + yNext)) {
                        break;
                    } 
                    else {
                        x = xNext;
                        y = yNext;
                        ans = Math.max (ans, x * x + y * y);
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

