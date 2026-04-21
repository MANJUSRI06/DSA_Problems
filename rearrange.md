# 🔗 Rearrange a Linked List (Odd-Even Positions)

## 🧩 Problem Statement
Given a singly linked list, rearrange it such that:
- All **odd-positioned nodes** come first
- Followed by all **even-positioned nodes**

> 📌 Positions are based on **1-based indexing**

### ✅ Conditions:
- Maintain the **relative order** of odd and even nodes
- Perform the operation **in-place**

---

## 📥 Example

**Input:**

1 → 2 → 3 → 4


**Output:**

1 → 3 → 2 → 4


**Explanation:**
- Odd positions → `1, 3`
- Even positions → `2, 4`
- Result → `1 → 3 → 2 → 4`

---

## 💡 Approach (Concept)
- Use two pointers:
  - `odd` → tracks odd-positioned nodes
  - `even` → tracks even-positioned nodes
- Store the start of even list (`evenStart`)
- Rearrange pointers in-place
- Finally, connect odd list with even list

---

## 🧑‍💻 Java Code

```java
class Solution {

    void rearrangeEvenOdd(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node odd = head;          // 1st node (odd position)
        Node even = head.next;    // 2nd node (even position)
        Node evenStart = even;    // store start of even list

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        // Attach even nodes after odd nodes
        odd.next = evenStart;
    }
}
```
---
## ⏱️ Time Complexity
O(n) → Traverse the list once
## 💾 Space Complexity
O(1) → No extra space used (in-place)
---
## 🔗 GFG Problem Link

👉 https://www.geeksforgeeks.org/problems/rearrange-a-linked-list/1
---
## 🚀 Key Takeaways
Classic Linked List pointer manipulation
Efficient solution without extra memory
Frequently asked in coding interviews
