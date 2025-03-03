package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ocean {
    public static void main(String... args) {
        int[] buildings = {1,21,4,3,2,11};

        System.out.println(defaultProblem(buildings));
        System.out.println(variant(buildings));
        System.out.println(variant2(buildings));
    }

    static List<Integer> defaultProblem(int[] buildings) {
        List<Integer> list = new ArrayList<>();
        list.add(buildings.length - 1);
        for (int i = buildings.length - 2; i >= 0; --i) {
            if (buildings[i] > buildings[list.getLast()]) {
                list.add(i);
            }
        }

        Collections.reverse(list);
        return list;
    }

    static int variant(int[] buildings) {
        int count = 1;
        int max = buildings[buildings.length - 1];
        for (int i = buildings.length - 2; i >= 0; --i) {
            if (max < buildings[i]) {
                max = buildings[i];
                count++;
            }
        }

        return count;
    }

    static List<Integer> variant2(int[] building) {
        int leftMax = building[0];
        int rightMax = building[building.length - 1];
        List<Integer> result = new ArrayList<>();
        result.add(leftMax);
        result.add(rightMax);
        int left = 1, right = building.length - 2;
        while (left <= right) {
            if (building[left] < building[right]) {
                if (building[left] > leftMax) {
                    leftMax = building[left];
                    result.add(leftMax);
                }
                left++;
            } else {
                if (building[right] > rightMax) {
                    rightMax = building[right];
                    result.add(rightMax);
                }
                right--;
            }
        }

        return result;
    }
}
