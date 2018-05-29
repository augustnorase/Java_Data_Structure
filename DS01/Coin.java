package DS01;

public class Coin {
	private int value;	// value 값 선언 

	public Coin(int aValue){	// Coin의 생성자 생성 
		value = aValue;	// 사용자가 입력한 aValue의 값은 value가 됨 
	}
	
	public int value(){	// value의 게터 
		return value;	
	}
}
