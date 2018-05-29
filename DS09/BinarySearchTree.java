package DS09;

public class BinarySearchTree {
    BinaryNode root;	// BinaryNode를 사용하기 위한 변수 선언 

    BinarySearchTree() {	//	BinarySearchTree 생성자 선언 
        this.root = null;	// 일단 기본적으로는 null로 지정 
    }
    
    void insertNode(BinaryNode root, BinaryNode node) {	// 노드를 삽입하는 메소드. 여기에서 root는 검사할 노드, node는 넣을 노드
        //TODO
    	if(this.root == null){	// 만약 root가 null일 때. 트리가 비어있을 때를 의미 
    		this.root = node;	// node를 root에 넣어줌 
    		return ;	// 메소드 종료 
    	}
    	
    	if(root.getValue() < node.getValue()){	// 넣을 노드가 root 노드보다 크다면 
    		if(root.hasRight()){	// 만약 오른쪽에 값이 있다면 
    			insertNode(root.getRight(), node);	// 재귀적으로 실행해줄 것 
    		} else{	// 그 이외의 경우 
    			root.setRight(node);	// root의 오른쪽에 node를 세팅. 
    			node.setParent(root);	// node와 root의 관계를 연결해줄 것 
    		}
    		// 넣을 노드가 root 노드보다 크다는 전제하에 실행되기 때문에 재귀적으로 값을 찾아 오른쪽으로 값을 넣을 것
    	} 
    	else{	// left의 경우도 right와 원리는 동일. 
    		if(root.hasLeft()){	
    			insertNode(root.getLeft(), node);
    		} else{
    			root.setLeft(node);
    			node.setParent(root);
    		}
    	}
    }
    
    
    BinaryNode findNode(BinaryNode x, int value, boolean toDelete) {	// 노드를 찾는 메소드. x는 확인하려는 노드, value는 찾으려는 값 
        //TODO
    	if(x != null && x.getValue() != value){	// 만약 노드가 null이 아니거나 x의 값이 value가 아닐 때 
    		if(x.getValue() < value){	// 값이 크므로 오른쪽으로 갈 것 
    			return findNode(x.getRight(), value, toDelete); // 재귀적으로 오른쪽으로 갈 것 
    		}
    		else{
    			return findNode(x.getLeft(), value, toDelete);	// 재귀적으로 왼쪽으로 갈 것 
    		}
    	}
    	
    	else if(x != null && x.getValue() == value){ // 값을 찾은 경우 
    		if(toDelete){	// 만약 참이라면
    			BinaryNode target = deleteNode(x);	// deleteNode 메소드를 통해 target에 노드 전달 
    			return target;	// target 리턴 
//    			deleteNode(x);
//    			return x; // 도 됨 
    		}
    		else{	// 그 이외의 경우 
    			return x;	// x 리턴할 것 
    		}
    	}
    	return null;	// null 리턴 
    		
    }

    

    BinaryNode treeMinimum(BinaryNode node) {	// node를 기준으로 가장 작은 노드를 반환
        //TODO
    	if(node.hasLeft()){	// 기본적으로 왼쪽에는 작은 값이 들어감 
    		return treeMinimum(node.getLeft());	// 때문에 왼쪽으로 찾아갈수록 작은 값을 찾게됨 
    	}
//    	while(node.hasLeft()){	// 수업시간에 말씀해주셔서 써봤습니다.
//    		node = node.getLeft();
//    	}
    	
    	return node;	// 노드 리턴 
    }
    
    BinaryNode deleteNode(BinaryNode z) {	// 삭제하는 메소드 
        if(!z.hasLeft()) { // 이 상황에서는 그냥 옮겨 심기만 하면 됨 
           transplant(z, z.getRight());	// transplant는 z.getRight() 위치의 node를 z 위치로 이동하기 때문에 
           return z;
        }
        else if(!z.hasRight()) {	// left와 마찬가지 
           transplant(z, z.getLeft());
           return z;
        }
        else { // 노드가 2개인 경우
        	BinaryNode temp = treeMinimum(z.getRight());	// 오른쪽에서 가장 작은 노드.
        	// 삭제하는 경우에 대체할 수 있는 노드로는 보통 두 가지 경우가 존재
        	// 1. 오른쪽에서 가장 작은 노드
        	// 2. 왼쪽에서 가장 큰 노드
        	if(temp.getParent() != z){	// temp의 부모가 z가 아닐 경우 
        		transplant(temp, temp.getRight());	// temp.getRight() 위치의 노드를 temp 위치로 이동시킬 것 
        		temp.setRight(z.getRight());	// temp의 오른쪽으로는 z.getRight()를 넣을 것 
        		temp.getRight().setParent(temp);	// temp 오른쪽의 부모로는 temp를 지정 
        	}
        	
        	transplant(z, temp);	// temp 위치의 노드를 z 위치로 이동시킬 것 
        	temp.setLeft(z.getLeft());	// temp의 왼쪽으로는 z.getLeft()를 넣을 것 
        	temp.getLeft().setParent(temp);	// temp 왼쪽의 부모로는 temp를 지정 
        	return z;	// z 리턴 
        }
    	  
    	
    	
    }
    
    
    void transplant(BinaryNode des, BinaryNode source) {	// source 위치의 노드를 des 위치로 이동시켜주는 메소드 
        //TODO
    	if(!des.hasParent()){	// des가 부모가 없을 때. 여기에서는 root를 의미함
    		this.root = source;	// 간단하게 source를 root로 지정해줄 것 
    	}
    	else if(des == des.getParent().getLeft()){	// des의 부모를 그 부모의 왼쪽 자식의 값을 비교한다는 건 연결관계를 확인한다는 것 
    		des.getParent().setLeft(source);	// des의 부모 기준에서 왼쪽 자식에 source 값을 넣을 것 
    	}
    	else{	// 그 이외의 경우 
    		des.getParent().setRight(source);	// des의 부모 기준에서 오른쪽 자식에 source 값을 넣을 것 
    	}
    	
    	if(source != null){	// 이 경우는 source가 null이 아닌 한(거의 대부분의 경우) 실행되는 경우
    		source.setParent(des.getParent());	// source의 부모를 des의 부모로 세팅할 것
    		// 위의 조건문에서 des는 곧 source와 동일한 노드를 지시하고 있다는 걸 기억할 것
    	}
    }

    void printTree(BinaryNode node, int depth) {	// 프린트해주는 메소드 
        //TODO
    	if(node != null){	// 만약 node가 null이 아니라면 
    		for(int i = 0; i < depth; i++){	// depth까지 반복
    			System.out.print("\t");	// 간격을 넓혀줌 
    		}
    		System.out.println(node.getValue());	// node값을 출력해줄 것 
    		printTree(node.getLeft(), depth + 1);	// depth를 하나씩 늘리면서 재귀적으로 실행(왼쪽으로) 
    		printTree(node.getRight(), depth + 1);	// depth를 하나씩 늘리면서 재귀적으로 실행(오른쪽으로)
    	}
    }
    
    BinaryNode getRoot() {	// root의 게터
        return this.root;
    }
    
}
