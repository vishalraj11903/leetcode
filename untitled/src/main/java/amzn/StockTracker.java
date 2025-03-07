package amzn;

/**
 * New stoack prices are coming every hour, design a data structure to store stock prices
 * and getMaxStock() to get Max stock at price at that instance for last K hours. K will be known since beinning.
 * stock prices may not come every hour.
 */
import java.util.*;

public class StockTracker {
    private final int K;
    private final Queue<Integer> stockPrices;
    private final Deque<Integer> maxDeque;

    public StockTracker(int K) {
        this.K = K;
        this.stockPrices = new LinkedList<>();
        this.maxDeque = new LinkedList<>();
    }

    public void addStockPrice(int price) {
        // Add price to the queue
        stockPrices.offer(price);

        // Maintain decreasing order in maxDeque
        while (!maxDeque.isEmpty() && maxDeque.peekLast() < price) {
            maxDeque.pollLast();
        }
        maxDeque.offerLast(price);

        // Remove the oldest price if we exceed K elements
       /* if (stockPrices.size() > K) {
            int removed = stockPrices.poll();
            if (removed == maxDeque.peekFirst()) {
                maxDeque.pollFirst();
            }
        }*/
    }

    public int getMaxStock() {
        return maxDeque.isEmpty() ? -1 : maxDeque.peekFirst();
    }

    public static void main(String[] args) {
        StockTracker tracker = new StockTracker(3);

        tracker.addStockPrice(5);
        tracker.addStockPrice(3);
        tracker.addStockPrice(8);
        System.out.println(tracker.getMaxStock()); // Output: 8

        tracker.addStockPrice(2);
        System.out.println(tracker.getMaxStock()); // Output: 8

        tracker.addStockPrice(10);
        System.out.println(tracker.getMaxStock()); // Output: 10
    }
}

