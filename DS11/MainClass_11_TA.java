package DS11;

public class MainClass_11_TA {
    public static void main(String args[]){
        IO_Manager_TA io = new IO_Manager_TA(); // 파일을 읽어오는 부분
        Sort_TA sort = new Sort_TA();   // 정렬 알고리즘이 들어있는 부분
        long start, end;    // 숫자는 int 형보다는 long으로 잡는다
        System.out.println("Start to Compare Each Sorting Methods Performance");
        System.out.println("================BubbleSort_O(n^2)================");
        sort.initDataSet(io.readData());    // 파일을 읽어들임
        start = System.currentTimeMillis(); // 시작시간
        sort.bubbleSort();  // 버블소트 시작
        end = System.currentTimeMillis();   // 끝나는 시간
        System.out.println("Taken Time(ms) : " + (end-start));  // 걸린 시간

        System.out.println("================InsertionSort_O(n^2)================");
        sort.initDataSet(io.readData());
        start = System.currentTimeMillis();
        sort.insertionSort();
        end = System.currentTimeMillis();
        System.out.println("Taken Time(ms) : " + (end-start));

        System.out.println("================MergeSort_O(nlog2(n))================");
        sort.initDataSet(io.readData());
        start = System.currentTimeMillis();
        sort.mergeSort(0,sort.getSize());
        end = System.currentTimeMillis();
        System.out.println("Taken Time(ms) : " + (end-start));

        System.out.println("================QuickSort_O(nlog2(n))================");
        sort.initDataSet(io.readData());
        start = System.currentTimeMillis();
        sort.quickSort(0, sort.getSize()-1);
        end = System.currentTimeMillis();
        System.out.println("Taken Time(ms) : " + (end-start));

    }

}
