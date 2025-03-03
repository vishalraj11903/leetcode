package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String... args) {
        int[] input = {6, 2, 4, -3, 6, 1, 3, -5, -6, 4, -6};
        // int[] input = {8,8,8,8,8,8,8,-8,-8,-8};
        Stack<Integer> trackNumbers = new Stack<>();
        List<Integer> result = new ArrayList<>();
        for (int num : input) {
            if (num > 0) {
                trackNumbers.push(num);
            } else {
                while (!trackNumbers.isEmpty() && trackNumbers.peek() < Math.abs(num)) {
                    trackNumbers.pop();
                }
                if (trackNumbers.isEmpty()) {
                    result.add(num);
                } else if(trackNumbers.peek() == Math.abs(num)) {
                    handleCollision(trackNumbers, num);
                }
            }
        }

        result.addAll(trackNumbers);
        System.out.println(result);
    }

    static void handleCollision(Stack<Integer> trackNumbers, int asteroid) {
        Stack<Integer> backUp = new Stack<>();
        while (!trackNumbers.isEmpty() && asteroid < trackNumbers.peek()) {
            if (Math.abs(asteroid) == trackNumbers.peek()) {
                backUp.push(trackNumbers.pop());
            } else {
                trackNumbers.pop();
            }
        }

        trackNumbers.add(asteroid);
        while (!backUp.isEmpty()) {
            trackNumbers.push(backUp.pop());
        }
    }

}
