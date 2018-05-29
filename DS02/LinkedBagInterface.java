package DS02;

public interface LinkedBagInterface {	// LinkedBag에 대한 인터페이스 
	public int maxSize();	// maxSize() 메소드를 생성할 것 
	public int size();	// size() 메소드를 생성할 것 
	
	public int sum();	// sum() 메소드를 생성할 것 
	public int max();	// max() 메소드를 생성할 것 
	public void print();	// print() 메소드를 생성할 것 
	
	public boolean remove(int coin);	// remove(int coin) 메소드를 생성할 것 
	public boolean add(int coin);	// add(int coin) 메소드를 생성할 것 
	
	public boolean isEmpty();	// isEmpty() 메소드를 생성할 것 
	public boolean isFull();	// isFull() 메소드를 생성할 것 
	public boolean contains(int coin);	// contains(int coin) 메소드를 생성할 것 
	public int frequencyOf(int coin);	// frequencyOf(int coin) 메소드를 생성할 것 
	
	public boolean add(int index, int coin);	// add(int index, int coin) 메소드를 생성할 것 
	public boolean removeMax();	// removeMax() 메소드를 생성할 것 
	public int[] removeAll();	// removeAll() 메소드를 생성할 것 
	public void resize(int maxSize);	// resize(int maxSize) 메소드를 생성할 
}
