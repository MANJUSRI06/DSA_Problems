class Solution {
    public int binarysearch(int[] arr, int k) {
        int i=0;
        int j = arr.length-1;
        int ans = -1;
        while(i<=j){
            int mid = (i+j)/2;
            if(arr[mid] == k){
                ans = mid;
                j = mid-1;
            }
            else if(arr[mid]<k){
                i = mid+1;
            }
            else{
               j = mid-1; 
            }
        }
        return ans;

    }
}