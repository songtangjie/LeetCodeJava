package 算法课;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

@SuppressWarnings("unchecked")
public class Day08 
{
	// 快速排序
    public List<Integer> topKFrequent4(int[] nums, int k) {
    	//遍历数组把相同数字放在map里并统计次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
        
        Entry<Integer, Integer>[] entries = new Entry[map.size()];
        map.entrySet().toArray(entries);
        int begin = 0;
        int end = entries.length;
        int pivotIndex = 0;
        int destIndex = k - 1;
        while ((pivotIndex = pivotIndex(entries, begin, end)) != destIndex) {
			if (pivotIndex > destIndex) {
				end = pivotIndex;
			} else {
				begin = pivotIndex + 1;
			}
		}
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
        	result.add(entries[i].getKey());
		}
        return result;
    }
    
    private int pivotIndex(Entry<Integer, Integer>[] entries, int begin, int end) {
		int newBegin = begin + (int)(Math.random() *(end - begin));
		Entry<Integer, Integer> temp = entries[begin];
		entries[begin] = entries[newBegin];
		entries[newBegin] = temp;
		
		Entry<Integer, Integer> pivot = entries[begin];
		end--;
		while (begin < end) {
			while (begin < end) {
				if (pivot.getValue() > entries[end].getValue()) {
					end--;
				} else {
					entries[begin++] = entries[end];
					break;
				}
			}
			
			while (begin < end) {
				if (pivot.getValue() < entries[begin].getValue()) {
					begin++;
				} else {
					entries[end--] = entries[begin];
					break;
				}
			}
		}
		entries[begin] = pivot;
		return begin;
	}
	
	// 桶排序
    public List<Integer> topKFrequent3(int[] nums, int k) {
    	//遍历数组把相同数字放在map里并统计次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
        
        List<Integer>[] buckets = new List[nums.length+1];
        for (Entry<Integer, Integer> entry : map.entrySet()) {
			int frequent = entry.getValue();
			List<Integer> bucket = buckets[frequent];
			if (bucket == null) {
				bucket = new LinkedList<>();
				buckets[frequent] = bucket;
			}
			bucket.add(entry.getKey());
		}
        
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length; i > 0 && result.size() < k; i--) {
			if (buckets[i] == null) continue;
			result.addAll(buckets[i]);
		}
        return result;
    }
	
	
	// 优先队列排序
    public List<Integer> topKFrequent2(int[] nums, int k) {
    	//遍历数组把相同数字放在map里并统计次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((Integer i1, Integer i2) ->
        	map.get(i1) - map.get(i2)
        );
        
        for (Integer num : map.keySet()) {
			if (queue.size() < k) {
				queue.offer(num);
			} else if (map.get(num) > map.get(queue.peek())) {
				queue.poll();
				queue.offer(num);
			}
		}
        
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
			result.add(0, queue.poll());
		}
        return result;
    }
	
	// 全排序
    public List<Integer> topKFrequent1(int[] nums, int k) {
    	//遍历数组把相同数字放在map里并统计次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
        
        //对map从大到小全排序
		Entry<Integer, Integer>[] entry = new Entry[map.size()];
        map.entrySet().toArray(entry);
        
        Arrays.sort(entry, (Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) -> {
        	return e2.getValue() - e1.getValue();
        });
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
        	result.add(entry[i].getKey());
		}
        return result;
    }
}
