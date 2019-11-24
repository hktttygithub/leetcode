package hkttty.niuke;



//逆序对
public class InversePairs {
    int count = 0;

    public int inversePairs(int[] array) {
        if (array == null || array.length <= 1) {
            return 0;
        }
        mergeSort(array, 0, array.length - 1);
        return count;
    }

    private void mergeSort(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int mid = (i + j) >> 1;
        mergeSort(array, i, mid);
        mergeSort(array, mid + 1, j);
        merge(array, i, mid, j);
    }

    public void merge(int[] a, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];

        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (a[i] <= a[j])
                tmp[k++] = a[i++];
            else {
                tmp[k++] = a[j++];
                count += mid - i + 1;  // core code, calculate InversePairs............
            }
        }

        while (i <= mid)
            tmp[k++] = a[i++];
        while (j <= end)
            tmp[k++] = a[j++];
        for (k = 0; k < tmp.length; k++)
            a[start + k] = tmp[k];
    }
}
