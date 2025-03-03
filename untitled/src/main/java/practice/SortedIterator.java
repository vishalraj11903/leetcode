package practice;
import java.util.*;


public class SortedIterator implements Iterator {

    private PriorityQueue<Pair> heap;
    SortedIterator(List<List<Integer>> lists) {
        this.heap = new PriorityQueue<>((a, b) -> a.value - b.value);
        populateHeap(lists);
    }

    private void populateHeap(List<List<Integer>> lists) {
        for (int i = 0; i < lists.size(); ++i) {
            heap.add(new Pair(lists.get(i).get(0), lists.get(i).iterator()));
        }
    }

    @Override
    public Integer next() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Empty");
        }

        Pair min = heap.poll();
        if (min.iterator.hasNext()) {
            heap.add(new Pair(min.iterator.next(), min.iterator));
        }
        return min.value;
    }

    @Override
    public boolean hasNext() {
        return !heap.isEmpty();
    }

    class Pair {
        int value;
        Iterator<Integer> iterator;

        Pair(int value, Iterator<Integer> iterator) {
            this.value = value;
            this.iterator = iterator;
        }
    }

    public static void main(String... args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 4, 5, 8, 9));
        list.add(Arrays.asList(3, 4, 4, 6));
        list.add(Arrays.asList(0, 2, 8));
        SortedIterator obj = new SortedIterator(list);
        while (obj.hasNext()) {
            System.out.print(obj.next() + " ");
        }
    }
}