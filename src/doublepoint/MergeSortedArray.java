package doublepoint;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] b = {2, 4, 5};
        int n = 3;
        System.out.println(Arrays.toString(merge(a, m, b, n)));
    }

    public static int[] merge(int[] a, int m, int[] b, int n) {
        int im = m - 1;
        int in = n - 1;
        int img = m + n - 1;
        while (im >= 0 || in >= 0) {
            if (im < 0) {
                a[img--] = b[in--];
            } else if (in < 0) {
                a[img--] = a[im--];
            } else if (a[im] > b[in]) {
                a[img--] = a[im--];
            } else {
                a[img--] = b[in--];
            }
        }
        return a;
    }
}
