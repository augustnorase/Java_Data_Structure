package DS02;

public class Node {
	
	private int coin;	// 코인을 int로 선언. 노드의 값을 나타내게 됨 
	private Node next;	// 노드 클래스로 next를 선언. 노드의 다음 노드를 나타내게 됨 

	public Node(){	// 비어있는 생성자. 
		
	}
	
	public Node(int coin){	// 코인만을 입력 값으로 받는 생성자 
		this.coin = coin;	// coin 값을 받고 
		this.next = null;	// 입력값이 없는 next는 null로 
	}
	
	public Node(int coin, Node node){	// 코인값과 node를 받는 생성자 
		this.coin = coin;	// 코인 값을 받고 
		this.next = node;	// 노드도 받음 
	}


	public void setNext(Node node){	// 노드의 다음 노드를 받는 세터 
		this.next = node;	// 입력받은 노드를 노드의 next로 대입시킴 
	}

	public int coin(){	// coin의 게터 
		return this.coin;
	}
	
	public Node next(){	// next의 게터 
		return this.next;
	}
//	
	public void print(){	//	현재 노드의 값을 알 수 있도록 내부 메소드를 생성 
		if(next != null){	// 다음 노드가 존재하지 않을 때까지 
			System.out.print(coin + " -> ");	// 코인 값을 출력 
			next.print();	// 재귀적으로 다음 노드가 존재하지 않을 때까지 반복문처럼 돌림 
		}
		else{	// 그게 아니라면 (코인 값이 하나라면 ) 
			System.out.print(coin);	// 현재 코인값만 출력함 
		}
	}
}
