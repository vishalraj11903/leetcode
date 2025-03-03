package practice;

import java.util.PriorityQueue;

public class KthClosest {
    static class Record {
        int[] val;
        int distance;
        Record(int[] val) {
            this.val = val;
            this.distance = val[0] * val[0] + val[1] * val[1];
        }
    }
    public static void main(String... args) {
        int[][] input = {{3,3},{5,-1},{-2,4}};
        PriorityQueue<Record> pq = new PriorityQueue<>((a, b) -> b.distance - a.distance);
        int k = 1;
        for (int[] n : input) {
            pq.add(new Record(n));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        for (Record r : pq) {
            System.out.println(r.val[0] + "," + r.val[1]);
        }
    }
}
