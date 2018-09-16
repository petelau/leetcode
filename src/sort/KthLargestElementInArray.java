package sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 5, 7, 1, 4, 56, 432, 68, 23, 46, 7};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(findKthLargest(nums, 5));
        System.out.println(heapFindKthLargest(nums, 7));
    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static int heapFindKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : nums) {
            queue.add(i);
            if (queue.size() > k)
                queue.poll();
        }

        return queue.peek();
    }
}
