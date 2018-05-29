package DS02;

public class LinkedBag implements LinkedBagInterface{	// LinkedBagInterface 인터페이스를 받음 
	private int size;	//	size 선언 
	private int maxSize;	// maxSize 선언 
	
	private Node head;	// Node 클래스, head 선언 
	
	public LinkedBag(int maxSize){	// LinkedBag의 생성자 
		head = new Node();	// 새로운 노드를 head에 대입 
		this.maxSize = maxSize;	// 입력받는 maxSize를 maxSize에 대입 
		this.size = 0;	// size의 초기값은 0으로 
	}
	
	public boolean add(int coin){	//	노드를 추가하는 메소드. 메인 메소드에서 if로 받기 때문에 boolean으로 작성
		if(isFull()){	// 만약 노드가 가득 차있는 상황이라면 
			return false;	// false 처리. 
		}
		Node node = head;	// head를 node에 대입 
		while(node.next() != null){	// 노드의 다음 노드가 null값이 될 때까지(노드의 다음 노드가 존재하지 않을 때까지)
			node = node.next();	// 다음 노드를 반복해서 찾음. 
		}
		node.setNext(new Node(coin));	//	기존 노드의 다음 노드로 coin 값이 입력된 새로운 노드를 넣음 
		size++;	// 사이즈를 한 개 늘림 
		return true;	// 메인 메소드에서 불러올 수 있도록 true 리턴 
	}
	
//	public boolean remove(int coin){	// 마찬가지로 메인 메소드에서 if로 받기 때문에 boolean으로 작성 
//		if(isEmpty()){	// 만약 노드가 비어있는 상황이라면 
//			return false;	// false 처리.
//		}
//		Node node = head.next();	// node는 head 노드 다음을 의미 
//		Node prev = head;	// prev는 head 노드를 나타냄 
//		boolean found = false;	// found의 초기값은 false로 
//		// 1. 삭제할 노드를 찾는 과정 
//		while(node.next() != null && !found){	// 노드의 다음 노드가 존재하지 않을 때까지 and found가 true일 때까지 
//			if(node.coin() == coin){	// 만약 Linkedlist를 돌면서 입력된 coin의 값을 발견하면 
//				found = true;	// found = true가 되며 반복문 탈출 
//			}
//			else{	// 그렇지 않다면 
//				prev = node;	//	node를 prev에 대입하며 계속해서 앞으로 나가며 
//				node = node.next();	// 다음 노드를 호출 
//			}
//		}
//		// 2. 노드를 삭제하는 과정 
//		if(!found){	// 만약 found가 true라면 
//			return false;	//	false 리턴 
//		}
//		else{	//	그렇지 않다면 
//			if(node == this.head){	// 만약 head가 node라면 
//				this.head = this.head.next();	// head의 다음은 head 
//			}
//			else{	// 그렇지 않다면 
//				prev.setNext(node.next());	// 노드의 다음 노드를 prev의 다음 노드로 세팅시킴 
//			}
//			this.size--;	// 사이즈 감소 
//			return true;	// true 리턴 
//		}
//	}
	
	// 더 간단하게 
	public boolean remove(int coin) {
        if (isEmpty()) {
            return false;
        }
        Node node = head.next();
        Node prev = head;
        while (node != null) {
            if (node.coin() == coin) {
                prev.setNext(node.next());
                --size;
                return true;
            }
            prev = node;
            node = node.next();
        }

        return false;
    }
	
	public int frequencyOf(int coin){	//	몇 개가 들어있는지를 세는 메소드 
		Node node = this.head.next();	// node에 head.next()를 대입 
		int frequency = 0;	// frequency를 0으로 초기화 
		while(node != null){	// 노드의 다음 노드가 존재하지 않을 때까지 반복 
			if(node.coin() == coin){	// 만약 node의 값이 coin일 경우는 
				frequency++;	// frequency를 1 증가시킴 
			}
		node = node.next();		// 다음 노드로 넘어감 
			
		}
		return frequency;	// frequency 리턴 
	}
	
	public int sum(){	// 노드 값의 총합을 구하는 메소드 
		Node node = head.next();	// node에 head.next()를 대입 
		int sum = 0;	// sum을 0으로 초기화 
		while(node != null){	// 노드의 다음 노드가 존재하지 않을 때까지 반복 
			sum = sum + node.coin();	// sum에 값을 하나씩 더해나감 
			node = node.next();	// 그리고 다음 노드로 진행 
		}
		return sum;	// sum 리턴 
	}
	
	public int max(){	// 가장 큰 값을 구하는 메소드 
		Node node = head.next();	// node에 head.next()를 대입 
		int max = Integer.MIN_VALUE;	// max를 가장 작은 값으로 초기화 
		while(node != null){	// 노드의 다음 노드가 존재하지 않을 때까지 반복 
			if(node.coin() > max){	// 만약 현재의 max보다 더 큰 값을 발견한다면 
				max = node.coin();	// max에 그 값을 대입 
			}
			node = node.next();	// 다음 노드로 진행 
		}
		return max;	// max 리턴 
	}
	
	public void print(){	// 값들을 보여주는 메소드 
		if(isEmpty()){	// 만약 비어있는 상황이라면 
			System.out.println("EMPTY");	// EMPTY 출력 
		}
		else{	// 그게 아니라면 
			head.next().print();	// 재귀적으로 계속 print() 메소드를 반복 호출
		}
	}
	
	public boolean isEmpty(){	// 비어있는 상태에 대한 boolean 메소드 
		return size == 0;	// 비어있는 상태를 바로 리턴함 
	}
	
	public boolean isFull(){	// 가득찬 상황에 대한 boolean 메소드 
		return size == maxSize;	// 가득차있는 상태를 바로 리턴시킴 
	}
	
	public boolean contains(int coin){	// 입력받은 coin값이 연결리스트 내부에 존재하는지 여부에 대한 boolean 메소드 
		Node node = head.next();	// node에 head.next()를 대입 
		while(node != null){	// 노드의 다음 노드가 존재하지 않을 때까지 
			if(node.coin() == coin){	// 만약 입력받은 값과 같은 값을 발견한다면 
				return true;	// true 리턴 
			}
			node = node.next();	// 다음 노드로 진행 
		}
		return false;	// false 리턴 
	}
	
	
	
	public boolean add(int index, int coin){	// 넣을 위치를 찾아 값을 넣는 메소드 
		if(size < index){	// 만약 입력한 index가 현재 사이즈보다 크다면 
			return false;	// false 리턴 
		}
		Node first_node = node(index - 1);	// 첫 번째 노드는 입력받은 인덱스 노드의 앞에 위치하는 노드 
		Node second_node = first_node.next();	// 두 번째 노드는 첫 번째 노드의 다음 노드 
		Node newNode = new Node(coin);	// 새로운 노드는 값을 입력받은 노드 
		first_node.setNext(newNode);	// 첫 번째 노드 다음으로 새로운 노드를 넣음 
		newNode.setNext(second_node);	// 그리고 새로운 노드 다음으로는 두 번째 노드를 넣음 
		size++;	// 사이즈 하나 증가 
		return true;	// true 리턴 
	}
	
	Node node(int index){	//	현재 메소드의 위치를 파악할 수 있는 메소드 추가. 
		Node node = head;	// node에 head를 대입 
		for(int i = 0; i < index; i++){	// 입력받은 index 값까지 반복하며 돌면서 
			node = node.next();	// 다음 노드를 호출함 
		}
		return node;	// 그렇게 출력된 노드를 리턴시킴 
	}
	
	public boolean removeMax(){	// 가장 큰 값을 제거하는 메소드 
		return remove(max());	// 간단하게 max() 메소드에서 리턴한 값을 remove 메소드로 제거시킴 
	}
	
	public int[] removeAll(){	// 내부 값을 전부 제거하는 메소드 
		int[] coins = new int[size];	// 현재 사이즈 크기의 배열을 생성 
		Node node = head.next();	// 노드에 head.next()를 대입 
		int index = 0;	// index의 초기값은 0으로 
		
		for(index = 0; index < size; index++){	// 현재 size까지 반복 
			coins[index] = node.coin();	// 현재 들어있는 코인 값들을 coins 배열에 넣으면서 index를 1씩 증가시킴 
			node = node.next();	// 그 다음 노드로 진행 
			
		}
		Node deleteNode = node(0);	// node 메소드를 이용해 0부터 시작해서 
		deleteNode.setNext(null);	// 그 뒤의 메소드는 전부 null로 바꿔버림 
		this.size = 0;	// 사이즈는 0으로
		return coins;	// coin은 메인 메소드에서 볼 수 있도록 리턴시킴 
	}
	
	
	public void resize(int maxSize){	// 노드의 사이즈를 재설정하는 메소드
		Node node = head.next();	// node에는 head.next()를 대입 
		if(this.size > maxSize){	// 만약 입력받은 maxSize가 현재 사이즈보다 작다면 
			Node deletedNode = node(maxSize);	// node 메소드를 이용해 maxSize 뒤의 노드들은 
			deletedNode.setNext(null);	// 전부 null로 바꿔버림 
			this.maxSize = size;	// size를 maxSize에 대입 
		}
		else{	// 그게 아니라면 
			this.maxSize = maxSize;	// 입력받은 값대로 사이즈를 바꿈 
		}
	}

	public int size() {	// 사이즈의 게터 
		return size;
	}

	public int maxSize() {	// maxSize의 게터 
		return maxSize;
	}
	
}
