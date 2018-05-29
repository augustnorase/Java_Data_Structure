package DS05;

public class Stack {
    private String[] stack;	// 스택을 배열로 선언 
    private int size;	// 사이즈 선언 
    private int maxSize;	// maxSize 선언 
    
    Stack() {	// 스택 생성자 
        //TODO
    	this.maxSize = 5;	// 스택의 maxSize는 5 
    	this.stack = new String[maxSize];	// 스택의 사이즈 
    	this.size = -1;	
    	// 사이즈 초기값은 -1로 선언. 값이 들어가면 0번째 값이 해당 값을 가리키게 만들어야 하기 때문에 -1로 선언. 
    }

    public void push(String string) {	// 스택에 push하는 메소드 
        //TODO
    	if(this.isFull()){	// 만약 사이즈가 가득 찬 상황이라면 
    		resize();	// resize 해줌 
    	}
    	else{	// 그게 아니라면 
    		this.size++;	// 먼저 사이즈를 1 늘려주고 
    		this.stack[size] = string;	// 해당 스택 사이즈에 들어갈 값은 입력한 값 
    	}
    }

    public String pop() {	// 스택에서 pop하는 메소드 
        //TODO
    	String current = null;	// 스택에서 pop한 값을 저장해두어야 하기 때문에 current를 null로 초기화시켜 선언해둠 
    	if(!isEmpty()){	// 만약 비어있는 값이 아니라면 
    		current = stack[size];	// current에 pop할 값을 넣어주고 
    		this.stack[size] = null;	// 해당 값은 null 시킴 
    		this.size--;	// 사이즈는 1 줄여줌 
    	}
    	return current;	// current를 리턴 
    }

    public String peek() {	// 스택에서 peek하는 메소드 
        String current = null;	// 일단 리턴시켜줄 때 사용할 변수가 있어야 하기 때문에 null로 초기화 시켜줌 
        if(!isEmpty()){	// 만약 비어있는 값이 아니라면 
        	current = stack[size];	// current에 현재 size의 값을 넣어줌 
        }
        return current;	// current를 리턴 
    }

    public boolean isEmpty() {	// 비어있을 경우의 메소드  	
        //TODO
    	return this.size < 0;	// size가 -1일 때의 경우 
    }

    public boolean isFull() {	// 가득 차 있을 때의 메소드 
        //TODO
    	return this.size + 1 == this.maxSize;	// size의 초기값이 -1이기 때문에 1을 더해줌 
    }

    private void resize() {	// 리사이즈 해주는 메소드 
        String[] newStack = new String[maxSize * 2];	// 스택의 maxSize를 두 배로 늘려줌 
        System.arraycopy(stack, 0, newStack, 0, maxSize); // 메모리를 복사합니다.
        stack = newStack;	// 새로운 스택을 스택으로 할당 
        maxSize *= 2;	// maxSize는 두 배 
    }
    
}
