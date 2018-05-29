package DS09;

public class BinaryNode {
	
    private int value;
    private BinaryNode parent;
    private BinaryNode left;
    private BinaryNode right;
    
    // 사용할 변수들 각각 선언 

    BinaryNode(int value) {		// BinaryNode의 생성자. 저장할 값과 왼쪽, 오른쪽, 부모에 대한 정보를 갖고 있을 것 
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
    
    // 이하로는 세터, 게터 

    public int getValue() {
        return value;
    }
    
    public void setValue(int value){
    	this.value = value;
    }

    public void setParent(BinaryNode parent) {
        this.parent = parent;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public BinaryNode getParent() {
        return this.parent;
    }

    public BinaryNode getLeft() {
        return this.left;
    }

    public BinaryNode getRight() {
        return this.right;
    }

    public boolean hasParent() {
        return this.parent != null;
    }

    public boolean hasLeft() {
        return this.left != null;
    }

    public boolean hasRight() {
        return this.right != null;
    }

}
