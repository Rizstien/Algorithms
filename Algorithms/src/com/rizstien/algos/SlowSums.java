package com.rizstien.algos;

public class SlowSums {
	static class Status{
		int val;
		int sum;
	}
	private static int solve(int[] nums) {
		Status[][] dp = new Status[nums.length][nums.length];
		for(Status[] row : dp) {
			for(int i=0;i<row.length;i++)
				row[i] = new Status();
		}
		for(int l=1;l<nums.length;l++) {
			for(int i=0;i+l<nums.length;i++) {
				if(l == 1) {
					dp[i][i+l].val = nums[i] + nums[i+l];
					dp[i][i+l].sum = nums[i] + nums[i+l];
					continue;
				}
				dp[i][i+l].val = Math.max(dp[i+1][i+l].val + dp[i+1][i+l].sum + nums[i], dp[i][i+l-1].val + dp[i][i+l-1].sum + nums[i+l]);
				dp[i][i+l].sum = Math.max(dp[i+1][i+l].sum + nums[i], dp[i][i+l-1].sum + nums[i+l]);
			}
		}
		return dp[0][dp[0].length-1].val;
	}
	public static void main(String[] args) {
		int[] nums1 = {4, 2, 1, 3}, nums2 = {2, 3, 9, 8, 4}, nums3 = {2,100,100,1,99};
		System.out.println(solve(nums1));
		System.out.println(solve(nums2));
		System.out.println(solve(nums3));

	}

}
