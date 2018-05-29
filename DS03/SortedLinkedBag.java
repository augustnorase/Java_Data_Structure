package DS03;

public class SortedLinkedBag implements SortedLinkedBagInterface{
	private Node head;	// Node 클래스의 변수로 head를 선언 
	private int size, maxSize;	// 사이즈를 나타낼 size, 최대 크기를 나타낼 maxSize를 선언 
	
	public SortedLinkedBag(int maxSize) {	// SortedLinkedBag의 생성자 
		head = new Node();	// 새로운 노드를 head에 대입 
		this.maxSize = maxSize;	// 입력받는 maxSize를 maxSize에 대입 
		this.size = 0;	//	size의 초기값은 0으로 
	}


	public void max(int cycleSize){	// 최대값을 구하는 메소드 
		int max = Integer.MIN_VALUE;	// max의 초기값은 최소값으로 선언 
		int count = 0;	// count의 초기값은 0으로 
		Node node = head.next();	// Node 클래스의 변수 node에 head의 다음값을 저장 
		while(count < cycleSize && node != null){	//	count가 변수로 입력받은 cycleSize보다 작을 때 and 노드의 다음 값이 없을 때까지 
			if(max < node.coin()){	// 만약 max가 node의 값보다 작다면 
				max = node.coin();	// node의 값을 max에 저장 
			}
			node = node.next();	// 다음 노드를 반복하여 찾음 
			count++;	// 카운트 1 증가 
		}
		
		
	}

	
	public boolean add(int price) {	// 값을 입력시 올림차순에 따라 그 수가 맞는 위치에 들어가도록 하는 메소드
		if(isFull()){	// 만약 가득 차있는 상태라면 
			return false;	 // false 리턴 
		}

		Node first_node = head;	// first_node에 head를 대입 
		Node newNode = new Node(price);	// 값을 입력받고 새롭게 생성되는 노드 
	
		if(head == null || head.coin() > price){	//  만약 head 값이 null인 상태이거나 (값이 비어있는 상황) head의 값이 입력받은 값보다 클 경우 
			newNode.setNext(head);	// 새로운 노드의 next는 head 
			head = newNode;	// head에는 새로운 노드를 할당 
		}
		else{	// 그게 아니라면 
			while(first_node.next() != null && first_node.next().coin() < price){	
				// first_node의 다음 값이 비어있을 때까지(끝까지) and
				// first_node의 다음 노드의 값이 price보다 작을 경우 
				first_node = first_node.next();	// 다음 노드를 반복하여 찾음 
			}
			
			newNode.setNext(first_node.next());	// 새로운 노드의 next는 fist_node의 next 
			first_node.setNext(newNode);	// first_node의 다음 값으로는 새로운 노드 
		}
		
		size++;	// size를 1 증가시킴 
		return true;	// true 리턴 
	}
	
	// 아래는 리스트 테스트를 위한 메소드 
	public void print(){
			head.next().print();
		
	}
	
	public boolean isFull() {	// 연결리스트가 가득 차 있는 상태인지 확인하는 메소드 
		return size == maxSize;	// 가득 차 있는 상황이라고 말해줌 
	}

}
