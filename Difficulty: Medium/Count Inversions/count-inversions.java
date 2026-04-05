class Solution {
    static int mergesort(int arr[], int low, int high) {
        if (low >= high) return 0;
        int mid = (low + high) / 2;
        int count = 0;
        count += mergesort(arr, low, mid);
        count += mergesort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);
        return count;
    }
    static int merge(int arr[], int low, int mid, int high) {
        int count = 0;
        int left = low;
        int right = mid + 1;
        int[] temp = new int[high - low + 1];
        int k = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
                count += (mid - left + 1);
            }
        }
        while (left <= mid) {
            temp[k++] = arr[left++];
        }
        
        while (right <= high) {
            temp[k++] = arr[right++];
        }
        
        for (int i = 0; i < temp.length; i++) {
            arr[i+low] = temp[i];
        }
        return count;
    }
    static int inversionCount(int arr[]) {
        return mergesort(arr, 0, arr.length - 1);
    }
}