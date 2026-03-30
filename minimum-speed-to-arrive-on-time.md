# 🚆 Minimum Speed to Arrive on Time

<p align="left">
  <a href="https://leetcode.com/problems/minimum-speed-to-arrive-on-time/">
    <img src="https://img.shields.io/badge/LeetCode-1870-orange?logo=leetcode" />
  </a>
  <img src="https://img.shields.io/badge/Difficulty-Medium-yellow" />
  <img src="https://img.shields.io/badge/Topic-Binary%20Search-blue" />
</p>

---

## 📝 Problem Statement

You are given:

- 🔹 A floating-point number `hour` → total time available  
- 🔹 An integer array `dist[]` → distance of each train ride  

### 🚨 Rules

- ⏱️ Trains depart **only at integer hours**
- ⌛ You may need to **wait** between trains
- 🎯 Return the **minimum speed** to reach on time
- ❌ Return `-1` if it is **impossible**

---

## 💡 Intuition

> We need the **minimum speed** such that:
Total Time ≤ hour


👉 This is a **Binary Search on Answer** problem.

---

## 🧠 Approach
- Set low = 1, high = 10^7
- Apply Binary Search
- Take mid as speed
- Calculate total time
- Use ceil for waiting (except last train)
- If time ≤ hour → try smaller speed
- Else → increase speed



---

## ⏱️ Time Calculation

| Train Type        | Formula                        |
|------------------|--------------------------------|
| Intermediate     | `ceil(dist[i] / speed)`        |
| Last Train       | `dist[i] / speed`              |

👉 No waiting after last train

---

## 💻 Java Code

```java
class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1, high = 10000000;

        while (low < high) {
            int mid = (low + high) / 2;

            if (canreach(dist, hour, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return canreach(dist, hour, low) ? low : -1;
    }

    static boolean canreach(int dist[], double hour, int speed) {
        double time = 0;

        for (int i = 0; i < dist.length; i++) {
            double t = (double) dist[i] / speed;

            if (i != dist.length - 1) {
                time += Math.ceil(t);
            } else {
                time += t;
            }
        }
        return time <= hour;
    }
}
```
## ⚡ Complexity

| Type  | Value |
|------|------|
| Time | `O(n log 10^7)` |
| Space | `O(1)` |

---

## 🧠 Key Takeaways

- 🔍 Binary Search on Answer  
- ⏳ `ceil()` = waiting time  
- 🚫 No `ceil()` for last train  
- 📏 Range matters (`1 → 10^7`)  

---

## 🧪 Example

**Input** 

**dist = [1,3,2], hour = 2.7**

**Output: ** 3

        
