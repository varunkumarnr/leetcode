class MedianFinder {
    MedianFinder medianFinder; 
    PriorityQueue<Integer> left; 
    PriorityQueue<Integer>  right;
    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (left.isEmpty() || num <= left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }

        // Balance heaps so that either both have equal size or left has one more element
        if (left.size() > right.size() + 1) {
            right.offer(left.poll());
        } else if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }


    
    public double findMedian() {
        int n = left.size() + right.size(); 
        if(left.size() >right.size()) {
           return left.peek();
        } else{
            return (left.peek() + right.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */