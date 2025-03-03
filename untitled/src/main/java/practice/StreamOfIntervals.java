package practice;

import java.util.Map;
import java.util.TreeMap;

public class StreamOfIntervals {
    public static void main(String[] args) {
        StreamOfIntervals intervalTreeMap = new StreamOfIntervals();

        intervalTreeMap.storeInterval(4, 15);
        intervalTreeMap.storeInterval(17, 26);
        intervalTreeMap.storeInterval(21, 120);
//        intervalTreeMap.storeInterval(-20, 25);

        System.out.println(intervalTreeMap.findNumber(3));  // true
        System.out.println(intervalTreeMap.findNumber(6));  // true
        System.out.println(intervalTreeMap.findNumber(14)); // true
        System.out.println(intervalTreeMap.findNumber(26)); // false
    }

    static TreeMap<Integer, Integer> intervals = new TreeMap<>();

    static void storeInterval(int low, int high) {

          Map.Entry<Integer, Integer> floor = intervals.floorEntry(low);

         if (floor != null && floor.getValue() >= low) {
             low = Math.min(floor.getKey(), low);
             high = Math.max(floor.getValue(), high);
             intervals.remove(floor.getKey());
         }

        Map.Entry<Integer, Integer> ceil = intervals.ceilingEntry(low);
        while (ceil != null && ceil.getValue() <= high) {
            high = Math.max(ceil.getValue(), high);
            intervals.remove(ceil.getKey());
            ceil = intervals.ceilingEntry(low);
        }


        intervals.put(low, high);



       /* Map.Entry<Integer, Integer> entry = intervals.floorEntry(low);
        if (entry != null && entry.getValue() >= low) {
            low = Math.min(low, entry.getKey());
            high = Math.max(high, entry.getValue());
            intervals.remove(entry.getKey());
        }

        entry = intervals.ceilingEntry(low);
        while (entry != null && entry.getKey() <= high) {
            high = Math.max(high, entry.getValue());
            intervals.remove(entry.getKey());
            entry = intervals.ceilingEntry(low);
        }

        intervals.put(low, high);*/
    }

    public static boolean findNumber(int x) {
        Map.Entry<Integer, Integer> entry = intervals.floorEntry(x);
        if (entry != null && entry.getValue() >= x) {
            return true;
        }
        return false;
    }



}
