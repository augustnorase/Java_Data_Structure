package DS06;

public class CircularArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private String[] elements;
   /*
    * 각 변수들에 대한 선언 전체 사이즈를 표시할 maxSize, 삭제할 위치를 표시할 front, 현재 들어갈 위치를 표시할 rear, 배열 elements를 선언합니다.
    */

    CircularArrayQueue() {	// 생성자 
	/*
	TODO
	*/
    	this.maxSize = 10;	// 전체 사이즈는 10으로 표시 
    	this.elements = new String[maxSize];	// elements 사이즈의 전체 크기 
    	this.front = 0;	// front 값 초기화 
    	this.rear = 0;	// rear 값 초기화 
    }

    public boolean enQueue(String string) {	// 큐에 집어넣는 메소드 
	/*
 	기본 아이디어는 처음에 불리언 값 하나를 false로 선언 후, 만약 큐에 값을 집어넣는데 성공했을 때 queue에 true를 삽입
 	만약 값을 집어넣는데 실패했을 경우는 false 값이 그대로 리턴됨.
	*/
    	boolean queue = false;	// 불리언 값 하나를 생성하고 false로 초기화 시켜줌 
    	if(isFull()){	// 만약 full일 경우 
    		System.out.println("ERROR : 큐가 꽉 차서 삽입이 불가능합니다.");	// 안내문 출력 
    	}
    	else{
    		this.rear = (this.rear + 1) % this.maxSize;	// 원형큐이기 때문에 나머지 값을 연산해주어야 함.
    		// 나머지 값을 연산해주지 않을 경우에는 원형큐라는 개념 자체를 무시하게 되며 front 혹은 rear 값이 계속 증가하며 에러뜸
    		// 그리고 동시에 rear 값을 하나씩 증가시켜주기도 함.
    		this.elements[this.rear] = string;	// 입력된 값을 배열에 넣음.
    		return queue = true; // true를 위에서 선언한 불리언 값에 넣음 
    	}
		return queue;	// 결과에 따라서 다른 불리언 값을 리턴함 
    }

    public String deQueue() {	// 큐에서 삭제하는 메소드
	/*
	기본적인 아이디어는 front 값을 이용해 맨 앞에 있는 값들을 삭제하는 것.
	front 값을 하나씩 증가시키며 해당 위치에 있는 값들을 삭제시킴
	*/
    	String frontElement = null;		// 삭제한 값을 임시적으로 넣기 위해 String 변수 선언 
    	if(!isEmpty()){	// 만약 비어있지 않을 경우 
    		this.front = (this.front + 1) % this.maxSize;	// EnQueue 때와 마찬가지로 나머지 연산으로 계산해줌
    		frontElement = this.elements[this.front];	// 그리고 삭제할 값을 frontElement에 삽입
    		this.elements[this.front] = null;	// 가장 앞에 있는 값 삭제 
    		System.out.println("[Dequeue] 삭제된 원소는 '"+ frontElement + "'입니다.");	// 삭제에 대한 안내문 출력 
    		
    	}
    	else if(isEmpty()){	// 만약 큐가 비어있을 경우는 
    		System.out.println("ERROR : 큐에 원소가 없습니다.");	// 안내문 출력 
    	}

    	return frontElement;	// frontElement 리턴 
    }

    public void removes(int i) {	// 숫자를 입력받아 그만큼 삭제하는 메소드 
	/*
	그냥 간단하게 입력받은 수만큼 반복문을 돌려 deQueue() 시켜줌
	*/
    	for(int j = 0; j < i; j++){	// j값을 0부터 하나씩 늘려주며 입력받은 수만큼 deQueue() 시켜줌 
    		deQueue();	
    		
    	}
    }

    public StringBuilder printQueue() {	// 큐의 값을 print 해주는 메소드 
	/*
	간편하게 더해주기 위해 StringBuilder로 선언해줄 것. 이걸 모르고 계속 삽질하다가 조교님께 찾아갔다...
	*/ 
    	StringBuilder k = new StringBuilder();	// 메소드 내부에 선언해줄 것.
    	// 처음 변수 선언하는 곳에 선언해주면 계속 값이 초기화되면서 a b c -> a b c a b c -> a b c a b c a b c 처럼 출력됨 
    	for(int i = front + 1; i != (rear+1); i = (i+1) % this.maxSize){	
    		// 간단하게 front부터 시작해서 rear까지 반복. 원형큐이기 때문에 단순하게 i++ 해버리면 에러뜸 
    		k.append(this.elements[i] + " ");	// StringBuilder에 값을 하나씩 더해줄 것
    		
    	}
    	return k;	// k 리턴. 이 return 때문에 계속 해맸다... 
    }

    public String front() {	// 맨 앞의 값을 출력해주는 메소드 
	/*
	맨 앞에 있는 원소를 구하기는 쉬움. 항상 맨 앞에 있는 값은 front + 1 이기 때문에 그대로 써주면 된다.
	*/
    	return elements[front + 1];	// 위에서 설명한대로 
    }

    public int size() {	// 사이즈를 출력해주는 메소드. 
	/*
	원형으로 되어 있는 메소드이기 때문에 계산해주지 않으면 당장은 에러가 안 뜰지라도 삭제하고 넣고 반복하다보면 언젠가는 반드시 에러뜬다.
	그리고 시험에 나와서 기본적인 아이디어는 맞았지만 정확하게는 쓰지 못했다... 또르륵...
	*/
    	if(this.front <= this.rear){	// 평범한 상황에서의 사이즈. 일반적인 상황에서는 rear가 front 보다 값이 크거나 같다
    		// 이 상황에서는 그냥 값이 크거나 같은 rear에서 front를 빼주면 사이즈가 나오기 때문에 아래와 같이 간단하게 실행 가능하다. 
    		int a = this.rear - this.front;	// rear에서 front를 빼서 a에 넣어줌 
    		System.out.println(a);	// a 출력 
    		return a;	// a 리턴 
    	}
    	else{	// 그 이외의 경우. 평범한 큐에서는 등장하지 않는 경우지만 원형큐이기 때문에 필요한 조치. 
    		// 원형큐이기 때문에 삭제를 반복한 횟수에 따라 front가 rear 값을 초과하는 경우가 생김.
    		return (this.rear + this.maxSize) - this.front;	// rear에 큐의 최대 사이즈를 더한 뒤 front를 빼줌
    	}
    }

    public boolean isEmpty() {	// 원형큐가 비어있을 경우 
	/*
	TODO
	*/
    	return this.front == this.rear;	// 그냥 front와 rear가 같은 경우는 무조건 Empty이다.
    }

    public boolean isFull() {	// 원형큐가 가득 차 있는 경우 
	/*
	비어있는 경우와는 다르게 가득 차 있는 경우는 rear에 대해 나머지 연산 실행 후, front와 비교해줘야 함.
	일단 원형큐이기 때문에 나머지 연산을 실행하며, 사이즈가 8이라고 할 경우 rear는 elements[7]이 최대이기 때문에 나머지가 0이 되는 경우를 계산해줘야함.
	*/
    	int nextRear = (this.rear + 1) % this.maxSize;	
    	// 위에서 말한 것처럼 최대 사이즈가 8인 원형큐에서 rear의 값이 7일 경우 nextRear의 값은 0이 된다.
    	return nextRear == this.front;	// 그리고 만약 front가 0인 상황이라면 현재 이 큐는 가득 차있는 상황 
    }

}



