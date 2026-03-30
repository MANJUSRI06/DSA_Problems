class Solution {
    static int leastWeightCapacity(int[] arr, int n, int d) {
        int low = 0, high = 0;
        
        for(int num: arr){
            low = Math.max(low, num);
            high += num;
        }
        while(low<= high){
            int mid = (low+high)/2;
            if(canship(arr, mid, d)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    
    static boolean canship(int arr[], int capacity, int d){
        int days = 1;
        int load = 0;
        
        for(int num: arr){
            if(load+num > capacity){
                days++;
                load = num;
            }else{
                load+= num;
            }
        }
        return days<= d;
    }
};