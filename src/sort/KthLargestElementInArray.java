package sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInArray {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 3, 5, 7, 1, 4, 56, 432, 68, 23, 46, 7 };
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(findKthLargest(nums, 5));
		System.out.println(heapSortFindKthLargest(nums, 7));
		System.out.println(quickSortFindKthLargest(nums, 6));
	}

	public static int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	public static int heapSortFindKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i : nums) {
			queue.add(i);
			if (queue.size() > k)
				queue.poll();
		}

		return queue.peek();
	}

	public static int quickSortFindKthLargest(int[] nums, int k) {
		k = nums.length - k;
		int l = 0, h = nums.length - 1;
		while (l < h) {
			int j = partition(nums, l, h);
			if (j == k) {
				break;
			} else if (j < k) {
				l = j + 1;
			} else {
				h = j - 1;
			}
		}
		return nums[k];
	}

	private static int partition(int[] a, int l, int h) {
		int i = l, j = h + 1;
		while (true) {
			while (a[++i] < a[l] && i < h)
				;
			while (a[--j] > a[l] && j > l)
				;
			if (i >= j) {
				break;
			}
			swap(a, i, j);
		}
		swap(a, l, j);
		return j;
	}

	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
