class Solution {
    public int kthSmallest(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    private int quickSelect(int[] arr, int low, int high, int kIndex) {
        if (low <= high) {
            int pIndex = partition(arr, low, high);

            if (pIndex == kIndex) {
                return arr[pIndex];
            } else if (pIndex > kIndex) {
                return quickSelect(arr, low, pIndex - 1, kIndex);
            } else {
                return quickSelect(arr, pIndex + 1, high, kIndex);
            }
        }
        return -1;
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (i <= high && arr[i] <= pivot) {
                i++;
            }
            while (j >= low && arr[j] > pivot) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }
}