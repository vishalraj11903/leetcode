package practice;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class CustomQueue {
    int maxId;
    PriorityQueue<Integer> pool;
    Set<Integer> use;
    CustomQueue(int maxId) {
        this.maxId = maxId;
        this.pool = new PriorityQueue<>();
        this.use = new HashSet<>();
        for (int i = 0; i < maxId; ++i) {
            pool.add(i + 1);
        }
    }

    int FindId() {
         if (pool.isEmpty()) {
             System.out.println("Invalid operation");
             return -1;
         }

         int val = pool.poll();
         use.add(val);
         return val;
     }

    int ReleaseId(int id) {
        if (id > maxId) {
            System.out.println("Invalid argument");
            return -1;
        }

        pool.add(id);
        use.remove(id);
        return id;
    }

    public static void main(String... args) {
        CustomQueue idManager = new CustomQueue(3);
        idManager.FindId();     // Returns 1, the smallest available ID
        idManager.FindId();     // Returns 2, the next smallest available ID
        idManager.ReleaseId(1); // Releases ID 1 back into the pool
        idManager.FindId();     // Returns 1, as it is the smallest available ID again
        idManager.FindId();     // Returns 3
        idManager.FindId();     // Throws InvalidOperationException, no IDs available
        idManager.ReleaseId(4); // Throws ArgumentException, ID 4 is out of bounds
        idManager.ReleaseId(2); // Releases ID 2 back into the pool
    }
}
