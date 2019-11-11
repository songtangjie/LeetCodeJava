package 算法课;

public class Day07 {
  public int rob(int[] nums) 
  {
      if (nums == null) return 0;
      
      int first = 0,second = 0;
      for (int i = 0; i < nums.length; i++) {
    	  int temp = second;
    	  second = Math.max(nums[i] + first, second);
    	  first = temp;
      }
      return second;
  }
	
//    public int rob(int[] nums) 
//    {
//        if (nums == null || nums.length == 0) return 0;
//        return rob2(nums, nums.length - 1);
//    }
//    
//    //从第最后一个个开始往前遍历
//    private int rob2(int[] nums, int begin) 
//    {
//        if (begin == 0) return nums[0];
//        if (begin == 1) return Math.max(nums[0], nums[1]);
//        
//        int robCur = nums[begin] + rob2(nums, begin-2);//取当前值和隔一个之后的值
//        int robNext = rob2(nums, begin-1);//取下一个值
//        
//        return Math.max(robCur, robNext);
//    }
//    
//    //从第一个开始往后遍历
//    private int rob(int[] nums, int begin) 
//    {
//        if (begin == nums.length - 1) return nums[begin];
//        if (begin == nums.length - 2) return Math.max(nums[begin], nums[begin+1]);
//        
//        int robCur = nums[begin] + rob(nums, begin+2);//取当前值和隔一个之后的值
//        int robNext = rob(nums, begin+1);//取下一个值
//        
//        return Math.max(robCur, robNext);
//    }
}
