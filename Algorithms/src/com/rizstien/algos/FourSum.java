package com.rizstien.algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                int start = j+1;
                int end = nums.length-1;
                int comp = target - nums[i] - nums[j];
                while(start<end){
                    if(nums[start]+nums[end]==comp){
                        List<Integer> val = Arrays.asList(nums[i],nums[j],nums[start],nums[end]);
                        if(!result.contains(val))
                        	result.add(val);
                        start++;end--;
                    }else if(nums[start]+nums[end]>comp){
                        end--;
                    }else{
                        start++;
                    }
                }
            }
        }
        return result;
    }
    
    public static void main(String args[]) {
    	int[] A = new int[]{-3,-2,-1,0,0,1,2,3};
    	fourSum(A,0).forEach(e->System.out.println(e));
    }
}
