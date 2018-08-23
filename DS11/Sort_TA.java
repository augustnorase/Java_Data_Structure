package DS11;

public class Sort_TA {
    private int[] dataSet;
    private int[] bucket;
    private int size;
    // 보고서는 시간이 왜 차이나는지에 대해서
    // 일단 주석은 코드 하나하나를 설명하는 쪽으로 하고, 원리 등의 설명은 보고서에 그림으로 설명하겠습니다.

    void initDataSet(String dataSet) {  // 데이터 세팅 메소드
        String dataset[] = dataSet.split(" ");  // 입력된 dataSet을 잘라 dataset[] 배열에 넣을 것
        this.size = dataset.length; // 사이즈 선언
        this.dataSet = new int[this.size];  // dataSet과 bucket는 size 크기만큼의 배열을 선언
        this.bucket = new int[this.size];
        for (int i = 0; i < this.size; i++) {   // dataSet에 데이터를 넣는 반복문
            this.dataSet[i] = Integer.parseInt(dataset[i]);
        }
    }
    
    int getSize() {
        return this.size;
    }   // 사이즈의 getter

    void bubbleSort() { // bubbleSort() 메소드
        // 수업 때의 pdf와 해당 코드가 어떻게 다른지를 보고서에 쓸 것
	//TODO
        for(int i = 1; i < size; i++){  // 1부터 size까지 1씩 늘려주며 반복
            for(int j = size - 1; j > i; j--){  // size - 1에서 시작해 j가 i와 같을 때까지 j를 1씩 줄임
                if(dataSet[j] < dataSet[j - 1]){    // 만약 [j] 번째의 요소가 [j - 1]의 요소보다 작다면
                    swap(j, j - 1); // 그 두개를 스왑시켜줌

                }
            }
        }
    }

    void insertionSort() {  // 삽입 정렬 메소드
        // 달라진 이유가 무엇인지
	//TODO
        for(int i = 1; i < dataSet.length; i++){    // 1부터 dataset의 사이즈만큼 반복하며
            int key = dataSet[i];   // key에 dataSet[i]를 저장. 미리 while문 밖에서 선언해두지 않으면 값을 상싫해버림
            int temp = i - 1;   // temp에는 i - 1을 저장. 아래 while문에서 탈출 or 순서를 나타낼 때 쓰는 변수

            while(temp >= 0 && dataSet[temp] > key){    // temp가 0보다 크거나 같을 때 and dataSet[temp]의 크기가 key보다 클 때
                dataSet[temp] = dataSet[temp + 1];  // temp 번째의 값을 temp + 1 번째 값에 넣어줌
                temp = temp - 1;    // temp는 1 감소
            }
            dataSet[temp] = key;    // temp + 1 번째 값에는 key가 들어감
        }
    }

    void mergeSort(int begin, int end) {    // 머지 소트 메소드. 이 메소드는 merge와 copyArray를 이용하기만 함
	//TODO
        if(end - begin < 2){    // 값이 하나일 때를 의미
            return ;    // 이 경우는 소트 돌려질 필요도 없음
        }
        int middle = (begin + end) / 2; // 가운데 값을 정의
        mergeSort(begin, middle);   // 처음부터 중간까지 재귀적으로 실행
        mergeSort(middle, end); // 중간부터 끝까지 재귀적으로 실행
        merge(begin, middle, end);  // 병합시킬 것
        copyArray(begin, end);  // 값을 카피

    }

    private void merge(int begin, int middle, int end) {    // 병합시키는 메소드
	//TODO
        int i = begin;  // begin은 i에 저장. 여기서 begin은 보통 0을 의미
        int j = middle; // middle은 j에 저장.
        for(int k = begin; k < end; k++){   // begin에서 end까지 반복
            if(i < middle && (j >= end || dataSet[i] <= dataSet[j])){
                // begin이 middle보다 작을 때 and j가 end보다 크거나 같을 때 or dataSet[i]가 dataSet[j]보다 작거나 같을 때
                bucket[k] = dataSet[i]; // dataSet[i]를 bucket[k]에 넣을 것
                i = i + 1;  // i는 1 증가
            }
            else{
                bucket[k] = dataSet[j]; // dataSet[j]를 bucket[k]에 넣을 것
                j = j + 1;  // j는 1 증가
            }
        }
    }

    private void copyArray(int begin, int end) {    // Array를 복사시키는 메소드
	//TODO
        for(int k = begin; k < end; k++){   // begin부터 시작해 end까지 돌며 bucket[] 배열을 dataSet[]에 복사
            dataSet[k] = bucket[k];
        }
    }
    // 퀵소트는 pivot 앞에는 pivot보다 작은 값이 오고 pivot 뒤에는 pivot보다 큰 값들이 오도록 리스트를 둘로 분할

    void quickSort(int left, int right) {   // 퀵소트
	//TODO
        if(left < right){   // 만약 left가 right보다 크면
            int p = partition(left, right); // left와 right를 나눠 p에 저장
            quickSort(left, p - 1); // 재귀적으로 실행
            quickSort(p + 1, right);
        }
    }

    int partition(int l, int r) {   // 나눠주는 메소드
	//TODO
        int left = l;   // left는 l로
        int right = r;  // right는 r로

        int pivot = (left + right) / 2; // left와 right의 중간값을 pivot으로 지정

        while(left < right){    // left가 right보다 작은 동안
            while((dataSet[left] < dataSet[pivot]) && (left < right))
                // dataSet[left]가 dataSet[pivot]보다 작은 동안 && left가 right보다 작은 동안
                left++; // left를 1씩 증가
            while((dataSet[right] >= dataSet[pivot]) && (left < right))
                // dataSet[right]가 dataSet[pivot]보다 크거나 같은 동안 && left가 right보다 작은 동안
                right--;    // right를 1씩 감소

            if(left < right){   // 만약 left가 right보다 작다면
                swap(left, right);  // 그 둘을 스왑시킴
            }
        }

        swap(pivot, right); // pivot과 right를 스왑

        return left;    // left 리턴
    }

    void swap(int index1, int index2) { // 스왑시키는 메소드
        int temp = dataSet[index1];
        dataSet[index1] = dataSet[index2];
        dataSet[index2] = temp;
    }
}

