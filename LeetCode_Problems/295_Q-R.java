import java.util.*;

class MedianFinder {
    private PriorityQueue<Integer> small;  // Max heap
    private PriorityQueue<Integer> large;  // Min heap

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        small.add(num);
        
        // Balance by moving the largest of small to large
        if (!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()) {
            large.add(small.poll());
        }

        // Balance the sizes
        if (small.size() > large.size() + 1) {
            large.add(small.poll());
        } else if (large.size() > small.size()) {
            small.add(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        } else {
            return (small.peek() + large.peek()) / 2.0;
        }
    }
}
