package DS07;

public class Tree {
	private String element;
	private Tree leftChild;
	private Tree rightChild;
	/*
	 * 필요한 각 요소들을 선언할 것. 원리는 연결리스트와 비슷하다. 들어갈 값을 element에 넣고, 좌우인 leftChild, rightChild를 선언해줄 것 
	 */
	public Tree(){	// Tree의 생성자. 
		this.leftChild = null;
		this.rightChild = null;
		this.element = null;
	}
	
	/*
	 * 전부 null로 선언된 생성자는 트리 노드만 생성할 뿐이며, 값을 넣어주기 위해서는 메인 클래스에서 세터로 따로 넣을 것 
	 */
	
	public Tree(String element, Tree leftChild, Tree rightChild){	// Tree의 생성자 2 
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.element = element;
	}
	
	/*
	 * 각자의 값을 갖는 생성자. 만약 아래에 노드가 없는 것을 표시하고 싶다면 leftChild나 rightChild에 null을 넣어주어야 함.
	 */
	
	public boolean hasLeftChild(){	// leftChild가 있는지 없는지를 판단하는 메소드 
		return this.leftChild != null;	
	}
	
	public boolean hasRightChild(){	// rightChild가 있는지 없는지를 판단하는 메소드 
		return this.rightChild != null; 
	}
	
	public boolean isLeaf(){	// 아래에 가지가 있는지 없는지를 판단하는 메소드 
		return this.leftChild == null && this.rightChild == null;
	}
	
	public int height(){	// 높이를 리턴하는 메소드 
		int leftHeight = 0;	// leftHeight를 구하기 위해 초기값을 0으로 설정 
		if(this.hasLeftChild()){	// 만약 leftChild가 있는 상태라면 
			leftHeight = this.leftChild.height();	// 재귀 형식으로 leftChild가 없을 때까지 반복할 것 
		}
		int rightHeight = 0;	// rightHeigt도 위와 동일한 방식으로 구함 
		if(this.hasRightChild()){
			rightHeight = this.rightChild.height();
		}
		if(leftHeight > rightHeight){	// 만약 leftHeight 값이 더 큰 구조라면 
			return leftHeight + 1;	// leftHeight에 root인 1을 더해서 리턴 
		}
		else{
			return rightHeight + 1;	// 그게 아닐 경우에는 이걸 리턴. 값이 같을 경우에도 이 경우로 나감 
		}
	}
	
	public int numberOfNodes(){	// 노드의 수를 구하는 메소드 
		int numberOfLeftNodes = 0;	// 값을 0으로 초기화 
		if(this.hasLeftChild()){	// 만약 leftChild가 존재한다면 
			numberOfLeftNodes = this.leftChild.numberOfNodes();	// 재귀 형식으로 반복할 것 
		}
		int numberOfRightNodes = 0;	// 이것도 동일한 방식 
		if(this.hasRightChild()){
			numberOfRightNodes = this.rightChild.numberOfNodes();
		}
		
		return(1+numberOfLeftNodes + numberOfRightNodes);	// 그렇게 해서 다 구한 값을 root와 더해서 리턴시킴 
	}
	
	/*
	 * numberOfNodes()와 height()를 구하는 메소드의 기본적인 아이디어는 비슷하다. 
	 * 0으로 초기화시킨 변수에 재귀 방식으로 하나씩 늘려가며 값을 늘려줄 것 
	 */
	
	public String element(){	// element의 게터 
		return this.element;
	}
	
	public void setElement(String anElement){	// element의 세터 
		this.element = anElement;
	}
	
	public Tree rightChild(){	// rightChild의 게터 
		return this.rightChild;
	}
	
	public void setRightChild(Tree rightChild){	// RightChild의 세터 
		this.rightChild = rightChild;
	}
	
	public Tree leftChild(){	// leftChild의 게터 
		return this.leftChild;
	}
	
	public void setLeftChild(Tree leftChild){	// leftChild의 세터 
		this.leftChild = leftChild;
	}
	
	public void inorder(Tree root){	// inorder 방식을 구하는 메소드 
		if(root != null){	// 만약 root가 null이 아니라면 
			inorder(root.leftChild());	// 일단 왼쪽부터 구하고 
			System.out.print(root.element() +" ");	// root를 구한 뒤 
			inorder(root.rightChild());	// 오른쪽을 구할 것 
		}
	}
	
	/*
	 * inorder 방식은 기본적으로 왼쪽 자식을 구하고, 그 부모를 구한 뒤, 오른쪽 자식을 구하는 방식으로 흘러간다. 
	 * 그리고 root가 null이 아닐 때까지 내려가기 때문에 어떤 방식이든 가장 아래까지 내려간 뒤 다시 역순으로 올라오는 구조를 가짐 
	 */
	
	public void preorder(Tree root){	// preorder 방식을 구하는 메소드 
		if(root != null){	// 만약 root가 null이 아니라면 
			System.out.print(root.element() + " ");	// root를 구한 뒤 
			preorder(root.leftChild());	// 왼쪽을 구하고 
			preorder(root.rightChild());	// 오른쪽을 구할 것 
		}
	}
	
	/*
	 * preorder는 다른 두 방식과 다르게 맨 위에서부터 시작하는 방식.
	 * 가장 먼저 부모들을 구하고, 왼쪽 자식들을 전부 구한 뒤, 오른쪽 자식들을 구하는 방식이다. 
	 */
	
	public void postorder(Tree root){	// postorder 방식을 구하는 메소드 
		if(root != null){	// 만약 root가 null이 아니라면 
			postorder(root.leftChild());	// 왼쪽을 구한 뒤 
			postorder(root.rightChild());	// 바로 오른쪽을 구하고 
			System.out.print(root.element() + " ");	// root를 구할 것 
		}
	}
	
	/*
	 * postorder는 왼쪽을 구하고, 바로 오른쪽을 구한 뒤 root로 올라가는 방식. 가장 위에 있는 root는 제일 마지막에 구할 것 
	 */
}
