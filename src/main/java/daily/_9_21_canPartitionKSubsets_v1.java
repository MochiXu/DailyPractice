package daily;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4 <br>
 * 输出： True <br>
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 <br>
 * */
public class _9_21_canPartitionKSubsets_v1 {
    public boolean canPartitionKSubsets(int[] nums,int k){
        ArrayList<Integer> nums_list=new ArrayList<>((List)Arrays.asList(nums));
        Collections.sort(nums_list);
        int sum =Arrays.stream(nums).sum();
        if (sum==0||sum%k!=0)return false;
        int tempNum = sum/k;
        boolean[] used = new boolean[nums.length];

    }

    public boolean subPartitionK(ArrayList<Integer> nums_list, ) {

    }
}
