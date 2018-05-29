package DS10;

public interface Heap extends PriorityQueue {
    // 인터페이스도 생략합니다
    void heapify(int index);
    void buildHeap();
}
