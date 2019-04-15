import java.util.Comparator;
import java.util.PriorityQueue;


public class Solution {
    private int count = 1;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void Insert(Integer num) {
        if((count & 1) == 0){//偶数
            //当数据总数为偶数时把新数据加入最小堆。
            //不是直接加入最小堆，而是先加入最大堆，再把最大堆的最大数字拿出来插入最小堆。
            maxHeap.offer(num);
            int filteredMax = maxHeap.poll();
            minHeap.offer(filteredMax);
        }else {
            minHeap.offer(num);
            int filteredMin = minHeap.poll();
            maxHeap.offer(filteredMin);
        }
        count++;
    }

    public Double GetMedian() {
        Double d;
        if((count & 1) == 0){
            d = new Double ((maxHeap.peek() + minHeap.peek())/2.0);//必须是2.0
        }else {
            d = new Double(minHeap.peek());
        }
        return  d;
    }
}
