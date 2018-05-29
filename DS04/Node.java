package DS04;

public class Node {
    private String string;	// string 선언 
    private Node next;	// Node 클래스의 next 선언 

    public Node() {	// 아무런 값도 받지 않는 생성자. 
    }

    public Node(String string) {	// string을 변수로 받는 생성자 
        this.string = string;	// string만 저장하고 
        this.next = null;	// next는 받지 않음. 
    }
    
    public Node(String string, Node node){	// string과 node를 받는 생성자 
		this.string = string;	// string과 
		this.next = node;		// node를 동시에 받음 
	}

    public void setNext(Node node) {	//	node의 next를 지정하는 생성자. 
        this.next = node;	// 입력된 노드를 next로 입력 
    }
    public String string() {	// string의 게터 
        return this.string;
    }

    public Node next() {	// next의 게터 
        return this.next;
    }
    
}