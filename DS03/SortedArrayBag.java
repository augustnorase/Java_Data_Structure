package DS03;

public class SortedArrayBag implements SortedArrayBagInferface{

	private Coin coins[];	// Coin 클래스의 변수로 coins[] 배열을 선언 
	private int size, maxSize;	// 사이즈를 나타낼 size, 최대 사이즈를 나타낼 maxSize를 선언 
	
	public SortedArrayBag(int totalcoin) {	// SortedArrayBag의 생성자
		this.maxSize = totalcoin;	// maxSize는 입력받은 totalcoin의 값 
		this.coins = new Coin[totalcoin];	// 배열의 크기도 선언 
		this.size = 0;	// size는 0으로 초기화 
	}


	public void max(int cycleSize){	// 최대값을 구하는 메소드 
		int max = Integer.MIN_VALUE;	// max 값은 최소값으로 초기화시킴 
		for(int i = 0; i < cycleSize; i++){	// 0부터 입력받은 값까지 돌면서
			if(max < coins[i].value()){	// 만약 i번째의 coin값이 max보다 작다면 
				max = coins[i].value();	// max 값에 coins[i] 번째 값을 넣음 
			}
		}
	}


	public void add(int price) {	//	값을 입력시 올림차순에 따라 그 수가 맞는 위치에 들어가도록 하는 메소드 
		if(isFull()){	// 만약 가득 차 있는 상황이라면 
			System.out.println("배열이 가득 차 있는 상황입니다.");	// 안내문 출력 
		}
		
		Coin newCoin = new Coin(price);	// 새로운 코인에 대한 선언 
		this.coins[size] = newCoin;	// size가 0인 상태일 때의 코인 값 
		
		for(int i = 0; i < size; i++){	// 0부터 size까지 돌면서 
			if(price < coins[i].value()){	// 만약 입력받은 price가 coins[i] 값보다 작다면 
				for(int j = size - 1; j >= i; j--){	// 현재 사이즈에서 1을 뺀 값(배열은 0부터 시작하기 때문에)부터 j가 i보다 크거나 같을 때까지 j를 하나씩 줄여나감 
					coins[j + 1] = coins[j];	// 뒤에서부터 i에 들어갈 공간을 확보해주는 방법 
				}
				coins[i] = newCoin;	// 비어있는 i에는 새로운 코인을 넣어줌 
				break;	// 탈출 
			}
			else{	// 그게 아니라면 
				coins[size] = newCoin;	// 마지막에 새로운 코인을 넣어줌 
			}
		}
		size++;	// size 1증가 
	}
	// 아래는 배열 테스트를 위한 print() 메소드 
	public void print(){
		for(int i = 0; i < size ; i++){
			System.out.print(coins[i].value() +" -> ");
		}
		System.out.println("끝입니다.");
	}
	
	public boolean isFull() {	// 가득 차 있는 상황에 대한 메소드 
		return size == maxSize;	// 가득 차 있는 상황이라고 말해줌 
	}

}
