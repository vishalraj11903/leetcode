package amzn;

import java.util.*;

// Abstract Locker class
abstract class Locker {
    int size;

    public Locker(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    // Abstract method to be implemented by each locker class
    public abstract void occupy();
    public abstract void vacate();
}

// Concrete Locker class
class StandardLocker extends Locker {
    boolean isOccupied;

    public StandardLocker(int size) {
        super(size);
        this.isOccupied = false;
    }

    @Override
    public void occupy() {
        this.isOccupied = true;
    }

    @Override
    public void vacate() {
        this.isOccupied = false;
    }

    public boolean isEmpty() {
        return !isOccupied;
    }
}

// Package class
class Package {
    int size;

    public Package(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}

// PickupLocation class
class PickupLocation {
    // A SortedMap to hold queues of lockers by size (sorted by locker size)
    private SortedMap<Integer, Queue<Locker>> lockerQueues;
    // A Map to track the used lockers by box ID
    private Map<String, Locker> usedLockers;

    public PickupLocation(List<Locker> lockers) {
        lockerQueues = new TreeMap<>();
        usedLockers = new HashMap<>();

        // Populate lockerQueues based on locker size
        for (Locker locker : lockers) {
            lockerQueues.putIfAbsent(locker.getSize(), new LinkedList<>());
            lockerQueues.get(locker.getSize()).offer(locker);
        }
    }

    // Find the best locker for a package based on its size
    public Locker findBestLocker(Package pkg, String boxId) {
        // Iterate through the sorted locker sizes
        for (Map.Entry<Integer, Queue<Locker>> entry : lockerQueues.entrySet()) {
            int lockerSize = entry.getKey();
            Queue<Locker> lockerQueue = entry.getValue();

            // Find the first available locker that fits the package
            if (!lockerQueue.isEmpty() && lockerSize >= pkg.getSize()) {
                Locker locker = lockerQueue.poll();  // Get the locker from the queue
                locker.occupy();  // Mark the locker as occupied
                usedLockers.put(boxId, locker);  // Track the used locker by boxId
                return locker;  // Return the best locker found
            }
        }
        return null;  // No suitable locker found
    }

    // Release a locker when a package is picked up or returned
    public void releaseLocker(String boxId) {
        Locker locker = usedLockers.get(boxId);
        if (locker != null) {
            locker.vacate();  // Mark the locker as free
            lockerQueues.get(locker.getSize()).offer(locker);  // Return the locker to the corresponding queue
            usedLockers.remove(boxId);  // Remove the box ID from the used lockers map
        }
    }
}

public class LockerManagementSystem {
    public static void main(String[] args) {
        // Create lockers of different sizes
        List<Locker> lockers = new ArrayList<>();
        lockers.add(new StandardLocker(5));
        lockers.add(new StandardLocker(10));
        lockers.add(new StandardLocker(15));
        lockers.add(new StandardLocker(20));

        // Create pickup location with these lockers
        PickupLocation pickupLocation = new PickupLocation(lockers);

        // Create some packages
        Package smallPackage = new Package(5);
        Package mediumPackage = new Package(12);
        Package largePackage = new Package(18);

        // Try finding lockers for the packages
        Locker lockerForSmallPackage = pickupLocation.findBestLocker(smallPackage, "box1");
        System.out.println("Small package placed in locker of size: " + (lockerForSmallPackage != null ? lockerForSmallPackage.getSize() : "No locker available"));

        Locker lockerForMediumPackage = pickupLocation.findBestLocker(mediumPackage, "box2");
        System.out.println("Medium package placed in locker of size: " + (lockerForMediumPackage != null ? lockerForMediumPackage.getSize() : "No locker available"));

        Locker lockerForLargePackage = pickupLocation.findBestLocker(largePackage, "box3");
        System.out.println("Large package placed in locker of size: " + (lockerForLargePackage != null ? lockerForLargePackage.getSize() : "No locker available"));

        // Free lockers when packages are picked up
        pickupLocation.releaseLocker("box1");
        pickupLocation.releaseLocker("box2");

        // Trying again for the small package after freeing up lockers
        lockerForSmallPackage = pickupLocation.findBestLocker(smallPackage, "box4");
        System.out.println("Small package placed in locker of size: " + (lockerForSmallPackage != null ? lockerForSmallPackage.getSize() : "No locker available"));
    }
}
