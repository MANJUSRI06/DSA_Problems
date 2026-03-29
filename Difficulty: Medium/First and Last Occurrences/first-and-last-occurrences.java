class Solution {
    ArrayList<Integer> find(int arr[], int x) {
        ArrayList<Integer> res = new ArrayList<>();
        int first = firstOcc(arr, x);
        int last = lastOcc(arr, x);
        
        res.add(first);
        res.add(last);
        
        return res;
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