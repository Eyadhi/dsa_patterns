package topkelements.pq;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problems {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:nums){
            pq.offer(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num:nums){
            pq.offer(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static int[] topKElements(int[] nums,int k){
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0 )+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->
            map.get(a)-map.get(b));

        for(int num:map.keySet()){
            pq.offer(num);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[] result = new int[k];
        for(int i=k-1;i>=0;i--){
            result[i] = pq.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,5};
        System.out.println(findKthLargest(nums,2));
        System.out.println(findKthSmallest(nums,3));
    }
}
