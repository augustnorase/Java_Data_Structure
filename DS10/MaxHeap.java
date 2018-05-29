package DS10;

public class MaxHeap implements Heap {
    private int[] heap;
    private int size;
    // Don't add field!!!!!!!
    // Don't add field!!!!!!!
    // Don't add field!!!!!!!
    // Don't add field!!!!!!!

    public MaxHeap() {	// 비어있는 MaxHeap 생성자
        this.heap = new int[10];	// 배열 크기는 10으로
        this.size = 0;	// 초기 사이즈는 0
    }

    private MaxHeap(int[] array, int size) {	// 값을 입력하는 MaxHeap 생성자
        this.heap = array;	// 입력한대로 배열 크기가 들어감
        this.size = size;	// 사이즈도 입력한대로
    }

    @Override
    public boolean isEmpty() {	// 비어있는 상황에 대한 메소드
        return size == 0;	// 사이즈가 0일 때
    }

    @Override
    public boolean isFull() {	// 가득 찬 상황에 대한 메소드
        return size == heap.length;	// 사이즈가 heap의 크기와 같을 때
    }

    @Override
    public void add(int element) {  // 더해주는 메소드
        // TODO : Fill it !!
        if(isFull()){   // 만약 가득찬 상황이라면
            resize();   // resize 시켜줄 것
        }

        heap[size] = element;   // 넣는 것은 간단하게 넣어줍니다. 중요한 건 heapify
        this.size++;    // 사이즈 늘려주고
        buildHeap();    // buildHeap() 시켜줄 것. 이 메소드에 따라 자동으로 정렬됩니다

    }

    @Override
    public int max() {  // 가장 큰 값을 리턴하는 메소드
        // TODO : Fill it !!
        if(isEmpty()){  // 만약 비어있다면
            return 201300402;   // 학번을 리턴합니다
        }
        else{   // 그 이외의 경우는
            return heap[0]; // heap[0]을 리턴할 것. 어차피 buildHeap() 메소드에서 가장 큰 메소드는 위로 올라오기 때문에...
        }
    }

    @Override
    public int removeMax() {    // 가장 큰 값을 제거하는 메소드
        // TODO : Fill it !!
        if(isEmpty()){  // 만약 비어있다면
            return 201300402;   // 학번을 리턴합니다
        }

        int max = heap[0];  // 위에서 설명했듯이 가장 큰 값은 heap[0]. 이걸 max에 저장합니다.
        heap[0] = heap[size - 1];   // 삭제시킬 자리에 다른 요소를 넣습니다. 어차피 아래에서 buildHeap() 시켜주니 현상태에서 순서는 상관 없습니다
        size--; // size 감소
        buildHeap();    // buildHeap() 시켜줍니다
        return max; // max 리턴
    }

    @Override
    public int size() {
        return size;
    }   // 오버라이드된 size()

    public void heapify(int index) {	// heapify는 하나만 돌리지만 buildHeap()에서 반복문으로 연계되어 재귀 방식으로 돌아갑니다
        // TODO : Fill it !!
        int max = index;    // index 값을 max에 할당
        int left = index * 2 + 1;   // 0을 기준으로 합니다. 왼쪽은 1 / 오른쪽은 2
        int right = index * 2 + 2;

        if(left < size && heap[index] < heap[left]){
            // 찾아가는 과정. 만약 heap[0]이 15이고 heap[1]이 38이라면 해당 조건을 만족하고 아래처럼 left가 max로 할당됩니다
            max = left;
        }
        if(right < size && heap[max] < heap[right]){
            // 이 또한 마찬가지로 만약 heap[0]이 15이고 heap[2]가 47이라면 해당 조건을 만족하고 아래처럼 right가 max로 할당됩니다
            max = right;
        }

        if(max != index){   // max와 index가 일치할 경우는 세지 않습니다
            swap(heap, index, max); // 스왑시킬 것. 부모와 자식을 스왑시킨다고 생각하면 됩니다
            heapify(max);   // 재귀 방식으로 실현할 것. 이진트리 형식으로 구성되어 여러 트리를 처리해야 하기 때문에...

        }
    }

    public void buildHeap() {	// buildHeap 메소드는 전체를 heapify 시킬 것
        // TODO : Fill it !!
        for(int i = size / 2 - 1; i >= 0; i--){
            // size에 2를 나누고 -1 시켜서 i에 할당합니다.
            // 간단하게 예를 들자면 사이즈가 3이라 할 때 3 / 2는 1. 여기에서 1을 뺀 값인 0이 i가 되어 아래 heapify()로 들어갑니다.
            heapify(i); // i가 0이라고 했을 때 left 값은 1, right 값은 2가 되어 처리됩니다.
        }
    }

    public boolean increaseKey(int target, int num) {   // 왜 메소드 이름이 increaseKey인지는 모르겠지만... 타겟의 수를 바꿔주는 메소드입니다.
        // TODO : Fill it !!
        boolean found = false;  // boolean 값의 초기값은 false로
        int index = 0;  // 인덱스도 0으로 선언합니다.
        for(int i = 0; i < heap.length; i++){   // 0에서 heap의 크기만큼 반복
            if(heap[i] == target){  // 반복중에 만약 heap[i]의 값이 target과 같다면
                index = i;  // i를 index에 할당합니다.
                found = true;   // found는 true로
            }
        }

        if(found == false){ // 만약 found가 false라면 <찾지 못한 상황일 경우>
            return found;   // found 리턴
        }

        else{   // 그 이외의 경우 <found가 true인 경우>
            heap[index] = num;  // heap[index]에 num을 할당하고
            buildHeap();    // buildHeap() 시켜줍니다.
            found = true;   // found는 true로
            return found;   // found 리턴
        }
    }

    public static int[] heapSort(int[] array, int size) {
        // 해당 메소드에서 실현하는 데는 큰 의미는 없지만... static 형태의 메소드입니다.
        // TODO : Fill it !!
        MaxHeap max = new MaxHeap();    // 생성자로 max를 선언합니다
        int[] temp = new int[size]; // size 크기로 선언된 정수 배열도 선언

        for(int i = 0; i < array.length; i++){  // array의 크기만큼 반복합니다.
            max.add(array[i]);  // MaxHeap()에 값을 추가해줍니다.
        }

        for(int j = 0; j < temp.length; j++){   // 그리고 temp의 크기만큼 반복합니다.
            temp[j] = max.removeMax();  // removeMax는 가장 큰 값을 리턴해주기에 그 값들이 순서대로 temp[j]로 들어가면 자동 정렬됩니다
        }

        return temp;    // 그리고 temp 리턴
    }

    @Override
    public String toString() {  // 출력을 위한 toString 메소드
        StringBuilder stringBuilder = new StringBuilder();  // 스트링빌더 선언
        stringBuilder.append("{ "); // 값은 { } 식으로 출력되기에 처음에는 { 를 넣습니다.
        for (int i = 0; i < size; ++i) {    // 0부터 size까지 반복문
            stringBuilder.append(heap[i]).append(" ");  // heap[i] 값을 넣고 공백도 넣습니다.
        }
        stringBuilder.append("}");  // 끝나면 } 넣을 것

        return stringBuilder.toString();    // 스트링빌더를 리턴합니다.
    }

    private void resize() { // 리사이징 해주는 메소드
        int[] newHeap = new int[this.heap.length*2];    // 사이즈를 두배로 늘려 newHeap에 할당합니다.
        System.arraycopy(this.heap, 0, newHeap, 0, this.heap.length);   // 복사한 뒤
        this.heap = newHeap;    // heap에 할당해줄 것
    }

    private static void swap(int[] array, int i, int j) {   // 스왑해주는 메소드
        int temp = array[i];    // 임시값으로 array[i] 할당
        array[i] = array[j];    // array[j]를 array[i]로 할당해주고
        array[j] = temp;    // 저장해뒀던 temp 값을 array[j]에 할당합니다.
    }
}
