class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int low = 1, high = stalls[stalls.length-1] - stalls[0];
        int ans = 0;
        while(low<= high){
            int mid = (low+high)/2;
            if(canplace(stalls, k, mid)){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
    
    static boolean canplace(int[] stalls, int k, int mid){
        int count =1;
        int last = stalls[0];
        for(int i=0; i<stalls.length; i++){
            if(stalls[i] - last >= mid){
                count++;
                last = stalls[i];
            }
        }
        return count>= k;
    }
}