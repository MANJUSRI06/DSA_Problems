class Solution {
    void merge(int arr[], int low, int mid, int high){
        int temp[] = new int[high-low+1];
        int left = low;
        int right = mid+1;
        int k=0;                                    
        while(left<= mid && right<=high){
            if(arr[left]<=arr[right]){
                temp[k] = arr[left];
                left++;
            }else{
                temp[k] = arr[right];
                right++;
            }
            k++;
        }
        while(left<=mid){
            temp[k] = arr[left];
            left++;
            k++;
        }
        while(right<=high){
            temp[k] = arr[right];
            right++;
            k++;
        }
        for(int i=low; i<=high; i++){
            arr[i] = temp[i-low];
        }
    }
    void mergeSort(int arr[], int l, int r) {
        if(l>=r) return;
        int mid = (l+r)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }
}