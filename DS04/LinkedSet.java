package DS04;

public class LinkedSet implements LinkedSetInterface {
	private int size;	// 사이즈를 저장할 변수 선언 
	private Node head;	// Node 클래스를 쓰기 위해 변수 선언 

	public LinkedSet() {	// LinkedSet의 생성자 
		this.size = 0;	// 사이즈는 0으로 초기화 
		this.head = new Node();	// head도 새로운 노드로 초기화 
	}

	@Override
	public int size() {	// size의 게터 
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public boolean add(String letters){	// 리스트에 문자열을 더해주는 메소드 
		Node node = head;	// head를 node에 대입 
		if(!contains(letters)){	// 만약 입력받은 문자가 없을 경우 
			while(node.next() != null){	// 끝까지 탐색 (node의 다음값이 null일 때까지)
			node = node.next();	// node의 다음을 node로 대입하며 끝까지 반복 
			}
		node.setNext(new Node(letters));	// 그리고 마지막에 새로운 문자를 넣음 
		size++;	// 사이즈는 1 증가 
		return true;	// true 리턴 
		}
		else{	// 입력받은 문자가 있을 경우 
			return false;	// false 리턴 
		}
		
	}
	
	@Override
	public boolean contains(String letters) {	// 입력받은 문자가 리스트 내에 있는지 검사하는 메소드 
		Node node = head;	// head를 node에 대입 
		while(node.next() != null){	// 끝까지 탐색 
			node = node.next();	// node의 다음을 node로 대입하며 끝까지 반복 
			if(node.string().equals(letters)){	// 만약 입력받은 문자를 발견했다면 
				return true;	// true 리턴 
			}
		}
		return false;	// 없으면 false 리턴 
	}

	@Override
	public String remove(String letters) {	// 입력받은 문자를 제거하는 메소드 
		Node node = head.next();	// 전후를 정의하기 위해 앞으로 오는 노드 node와 
		Node prev = head;			// 뒤로 따라오는 노드 prev를 정의 
		boolean found = false;	// 위치를 찾기위한 불리언 값 
		while(node.next() != null && !found){	// 끝까지 탐색 && found가 true일 때까지 
			if(node.string().equals(letters)){	// 만약 리스트에서 입력받은 문자를 발견하면 
				found = true;	// found는 true가 되고 반복문 탈출 
			}
			else{	// 그 이외의 경우는 
				prev = node;	// 다음 값으로 넘어가기 위해 node를 prev에 대입 
				node = node.next();	// 다음 값으로 넘어감 
			}
		}
		
		if(!found){	// 값을 삭제하는 과정 
			// 이 아래는 7줄은 만약 삭제할 값이 제일 마지막에 있을 경우 실행되는 코드 
			Node clearNode = node(size);	// 삭제할 노드 
			Node prevNode = node(size - 1);	// 삭제할 노드의 이전 노드 
			if(clearNode.string().equals(letters)){	// 만약 입력받은 값을 갖고 있는 노드를 발견한다면 
				prevNode.setNext(null);	// prev 노드를 통해 다음 노드의 값을 삭제함 
				this.size--;	// 사이즈 1 줄여줌 
				return letters;	// letters 리턴 
			}
			else{	// 그 이외의 경우는 
				System.out.println("그런 건 없습니다.");	// 값을 찾지 못했다는 안내문 출력 
			}
			
		}
		
		// 이 아래는 마지막 이외의 경우 
		else{	// 	그렇지 않다면 
			if(node == this.head){	// 만약 head가 node라면
				this.head = this.head.next();	// head의 다음은 head
			}
			else{	// 그렇지 않다면 
				prev.setNext(node.next());	// 노드의 다음 노드를 prev의 다음 노드로 세팅시킴 
			}
		}
		
		this.size--;	// 사이즈 1 줄임 
		return letters;	// letters 리턴 
	}
	

	@Override
	public void clear() {	// 리스트의 값을 전부 제거하는 메소드 
		Node clearNode = node(0);	// node 메소드를 이용해 0부터 시작해서 
		clearNode.setNext(null);	// 그 뒤의 값들은 전부 null로 바꿔버림 
		this.size = 0;	// 사이즈도 0으로 
		
	}

	@Override
	public void print() {	// 값을 출력하기 위한 print 메소드 
		System.out.println(this);	// 현재 클래스에 있는 값들을 출력. 이렇게만 하고 끝낼 시에는 메모리값이 출력되기 때문에 아래의 toString 메소드 추가 
		
	}
	@Override
	public String toString(){	// 제대로 된 값을 출력하기 위해 toString 메소드 실현 
		String str = "[ ";	// 일단 [ ] 형식으로 출력하기 위해 str에 [ 넣음 
		Node temp = head;	// Node 클래스 선언 
		while(temp != null){	// 내부에 있는 값을 하나씩 넣어주기 위해 끝까지 탐색 
			str += temp.string() + " ";	// str에 값을 하나씩 넣어줌 
			temp = temp.next();	// 다음 노드로 진행 
		}
		str += "]";	// 마지막으로 ]를 넣어 [ ] 형식 완성 
		return str ;	// str 리턴 
		
	}
	
	Node node(int index){	// 현재 노드의 위치를 알 수 있는 node 메소드 
		Node temp = head;	// head 선언 
		for(int i = 0; i < index; i++){	// 입력받은 인덱스만큼 진행하는 반복문 
			temp = temp.next();	// 입력받은 인덱스만큼 다음 노드로 진행함 
		}
		return temp;	// temp 리턴 
	}

}
