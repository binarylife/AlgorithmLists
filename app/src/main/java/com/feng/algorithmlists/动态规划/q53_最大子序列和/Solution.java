package com.feng.algorithmlists.动态规划.q53_最大子序列和;

/**
 * Created by fengbei
 * on 20-10-26
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Solution {

    public static int maxSubArray(int[] nums) {
        //  创建一个dp数组
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int result = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            result = Math.max(dp[i], result);
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(longestStrings("abccbaxxppppppppppppppppppppppppppppppppppppppppppppppppp"));
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
