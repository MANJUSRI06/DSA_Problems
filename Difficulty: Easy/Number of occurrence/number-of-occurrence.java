class Solution {
    int countFreq(int[] arr, int target) {
        int count1 = firstOcc(arr, target);
        int count2 = lastOcc(arr, target);
        if(count1 == -1) return 0;
        return count2-count1 +1;
        
    }
    
    int firstOcc(int arr[], int x){
            int low=0, high= arr.length-1;
            int ans = -1;
            while(low<=high){
                int mid = (low+high)/2;
                if(arr[mid]==x){
                    ans = mid;
                    high = mid-1;
                }
                else if(arr[mid]<x){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
            return ans;
        }
        
        int lastOcc(int arr[], int x){
            int low=0, high= arr.length-1;
            int ans = -1; 
            while(low<=high){
                int mid = (low+high)/2;
                if(arr[mid]==x){
                    ans = mid;
                    low = mid+1;
                }
                else if(arr[mid]>x){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            return ans;
        }
}
