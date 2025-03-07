package amzn;

import java.util.*;

public class ToteFilling {
    private static final int TOTE_AREA = 144; // 1 square foot in square inches
    private int currentArea = 0; // Tracks the filled area
    private List<Integer> addedProducts = new ArrayList<>();

    // Method to add a product to the tote
    public boolean addProduct(int sideLength) {
        int productArea = sideLength * sideLength;

        if (currentArea + productArea <= TOTE_AREA) {
            currentArea += productArea;
            addedProducts.add(sideLength);
            System.out.println("Added product: " + sideLength + "x" + sideLength + " inches.");
            if (currentArea == TOTE_AREA) {
                System.out.println("Tote is now 100% full!");
            }
            return true;
        } else {
            System.out.println("Cannot add product " + sideLength + "x" + sideLength + " inches. Not enough space!");
            return false;
        }
    }

    public int getCurrentArea() {
        return currentArea;
    }

    public static void main(String[] args) {
        ToteFilling tote = new ToteFilling();

        int[] products = {6, 6, 4, 2, 3}; // Sample product sizes (sides of squares)

        for (int size : products) {
            if (tote.getCurrentArea() < TOTE_AREA) {
                tote.addProduct(size);
            }
        }

        System.out.println("Final Tote Area: " + tote.getCurrentArea() + " square inches.");
    }
}
