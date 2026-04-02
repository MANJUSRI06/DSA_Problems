import java.util.*;

class Solution {
    static void relativeSort(int[] a1, int[] a2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : a1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int index = 0;
        for (int num : a2) {
            if (map.containsKey(num)) {
                int freq = map.get(num);
                while (freq > 0) {
                    a1[index] = num;
                    index++;
                    freq--;
                }
                map.remove(num);
            }
        }
        ArrayList<Integer> remaining = new ArrayList<>();

        for (int key : map.keySet()) {
            int freq = map.get(key);
            while (freq > 0) {
                remaining.add(key);
                freq--;
            }
        }
        Collections.sort(remaining);
        for (int num : remaining) {
            a1[index] = num;
            index++;
        }
    }
}