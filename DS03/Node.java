package DS03;

public class Node {
    private int coin;
    private Node next;

    public Node() {
    }

    public Node(int coin) {
        this.coin = coin;
        this.next = null;
    }

    public void setNext(Node node) {
        this.next = node;
    }
    public int coin() {
        return this.coin;
    }

    public Node next() {
        return this.next;
    }
    
    public void print(){	
		if(next != null){	 
			System.out.print(coin + " -> ");	
			next.print();	
		}
		else{	
			System.out.print(coin);	
		}
	}
}

