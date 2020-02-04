package 算法;

import java.util.Arrays;
import java.util.Comparator;

public class Day30 {
	/* 
	 * 自定义比较规则排序
	 * 时间复杂度:O(nlogn)，空间复杂度:O(n)
	 */	
    public String largestNumber(int[] nums) {
    	//把数组转换为字符串数组
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
			asStrs[i] = String.valueOf(nums[i]);
		}
        
        //排序
        Arrays.sort(asStrs,new LargeNumberComparator());
        //排序完如果第一位是0，则直接返回0
        if (asStrs[0].equals("0")) {
			return "0";
		}
        
        //拼接最大的数字
        String largestNumberString = new String();
        for (String numAsStr : asStrs) {
			largestNumberString += numAsStr;
		}
        
        return largestNumberString;
    }
    
    //自定义的比较器
    private class LargeNumberComparator implements Comparator<String> {
    	@Override
    	public int compare(String a,String b) {
    		String order1 = a + b;
    		String order2 = b + a;
    		return order2.compareTo(order1);
    	}
    }
}
