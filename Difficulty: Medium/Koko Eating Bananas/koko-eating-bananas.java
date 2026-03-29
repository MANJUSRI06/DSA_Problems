class Solution {
    public int kokoEat(int[] arr, int k) {
        Arrays.sort(arr);
        
        int low =1; int high = 0;
        for(int item:arr){
            high = Math.max(high, item);
        }
        int ans = high;
        while(low<=high){
            int mid = (low+high)/2;
            int tot = 0;
            
            for(int hr: arr){
                tot+= (hr+ mid-1)/mid;
            }
            
            if(tot <= k){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
        
    }
}
  