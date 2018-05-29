package DS10;

public interface PriorityQueue {
    // 인터페이스도 생략합니다
    boolean isEmpty();
    boolean isFull();

    void add(int element);
    int max();
    int removeMax();
    int size();
}