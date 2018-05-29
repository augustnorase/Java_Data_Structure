package DS01;

public class ArrayBag {
	private static final int DEFAULT_MAX_SIZE = 100;	// 생성자에 최대값의 크기를 입력하지 않았을 경우 이 크기로 최대값이 되도록 초기화. 변경할 수 없게 final 선언 
	private Coin coins[];	// Coin 배열 선언  
	private int size;	// size 선언 
	private int maxsize; // maxsize 선언 
	
	public ArrayBag(){	// 최대값이 입력되지 않는 기본적인 생성자 
		this.maxsize = DEFAULT_MAX_SIZE;	// 위에서 설명한대로 최대값은 100이 됨 
		this.coins = new Coin[DEFAULT_MAX_SIZE];	// 배열의 크기도 선언 
		this.size = 0;	// size는 0으로 초기화시킴 
	}
	
	public ArrayBag(int totalcoin){	// 사용자가 최대값을 입력하는 생성자 
		this.maxsize = totalcoin;	// 사용자가 입력한대로 최대값이 들어감 
		this.coins = new Coin[totalcoin];	// 배열의 크기도 마찬가지 
		this.size = 0;	// size는 0으로 초기화시킴 
	}
	
	public int sum(){	// 합을 구할 메소드 
		int sum = 0;	// sum은 0으로 초기화시킴 
		for(int i = 0; i < size; i++){	// 0부터 size까지 반복하며 1씩 증가시키는 for문 
			sum = sum + coins[i].value();	// coin[i]에 들어있는 값을 하나씩 sum에 더함 
		}
		return sum;	// 반복이 끝나면 총합 리턴시킴  
	}
	
	public boolean isEmpty(){	// 비어있는지에 대한 여부를 구하기 때문에 boolean 값으로 선언 
		return size == 0;	// size가 0인지에 대한 여부 
	}
	
	public boolean isFull(){	// 가득차있는지에 대한 여부를 구하기 때문에 boolean 값으로 선언 
		return(this.size == this.maxsize);	// 현재 크기와 최대값이 같은지에 대한 여부 
	}
	
	public void add(int price){	// 배열에 값을 추가하는 메소드 
		if(isFull()){	// 만약 배열이 가득 차있는 상황이라면 
			System.out.println("배열이 가득 차있는 상황입니다.");	// 이거 출력 
		}
		
		Coin newCoin = new Coin(price);	// 값을 입력한대로 새로운 코인으로 추가 
		try{	// 이 줄에서 에러가 발생하기 때문에 try catch문 시작 
			this.coins[size] = newCoin;	// newCoin을 coins[size] 배열에 추가 
			}
		catch(ArrayIndexOutOfBoundsException e){	// 에러 처리 
			System.out.println("다시 메뉴를 선택해주세요.");	// 다시 메뉴 선택으로 돌아가게 함 
		}
		size++;	// 끝나면 사이즈를 하나 늘려줌 
	}
	
	public void remove(int price){	// 배열의 값을 제거하는 메소드 
		if(isEmpty()){	// 만약 비어있다면 
			System.out.print("배열이 비어있고 ");	// 이거 출력 
		}
		if(!doesContain(price)){	// 만약 존재하지 않는 값이라면 
			System.out.println("그런 값은 존재하지 않습니다.");	// 이거 출력 
		}
		
		for(int i = 0; i < size; i++){	// 0부터 현재 size까지 반복하며 1씩 늘리는 for문 
			if(coins[i].value() == price){	// 만약 사용자가 입력한 값을 Coin 배열에서 찾으면 
				coins[i] = coins[i+1];	// 해당 코인을 제거 
				System.out.println(price+" 코인이 삭제되었습니다.");	// 그리고 안내문 출력 
				this.size--;	// 사이즈는 한 개 줄임 
			}
		}
	}
	
	public boolean doesContain(int price){	// 해당 값이 존재하는 지에 대한 메소드 
		boolean found = false;	// found의 초기값은 false로 설정 
		for(int i = 0 ; i < this.size ; i++){	// 0부터 현재 size까지 반복하며 1씩 늘리는 for문 
			if(this.coins[i].value() == price){	// 만약 값을 찾게 되면 
				found = true;	// found는 true가 됨 
			}
		}
		return found;	// found 리턴 
		
	}
	
	public int frequentCoin(int price){	// 해당 배열에서 코인이 몇 개 존재하는지에 대한 메소드 
		int frequencyCount = 0;	// frequencyCount는 0으로 초기화 
		for(int i = 0; i < this.size ; i++){	// 0부터 현재 size까지 반복하며 1씩 늘리는 for문 
			if(coins[i].value() == price){	// 만약 입력한 값과 같은 값의 동전을 발견하면 
				frequencyCount++;	// frequencyCount를 1씩 늘림 
			}
		}
		System.out.println(price+" 코인은 " +frequencyCount+"개 존재합니다.");	// 그리고 안내문 출력 
		return frequencyCount;	// frequencyCount 리턴 
	}
	
	public void print(){	// 사용자에게 현재 배열에 들어있는 정보들을 보여주는 메소드 
		int max = 0;	// max를 0으로 초기화, max는 print에서만 사용하는 기능이기 때문에 메소드 구현보다는 print 내부에 직접 실현 
		System.out.println("총 코인의 개수 " +this.size);	// 현재 코인의 개수는 size만으로 간단하게 나타낼 수 있음. 
		for(int j = 0; j < this.size ; j++){	//	필요없는 출력이지만 사용자의 편의를 위한 반복문. 현재 들어있는 값이 뭔지 출력해줌 
			System.out.println(j+1+"번째 코인의 값은 "+coins[j].value()+"입니다.");	// 배열은 0부터 시작하기 때문에 사용자의 편의를 위해 1을 더해줌 
		}
		for(int i = 0; i < this.size ; i++){	// 0부터 현재 size까지 반복하며 1씩 늘리는 for문 
			if(coins[i].value() > max){	// 만약 coins[i]의 값이 max보다 크다면 
				max = coins[i].value();	// 해당 값은 max가 됨. 이 과정을 반복하며 가장 큰 코인의 값을 탐색 
			}
		}
		System.out.println("가장 큰 코인 : "+max);	// 안내문 출력 
		System.out.println("코인의 합 : "+sum());	// 코인의 합 출력 
	}

	public Coin[] getCoins() {	// Coin의 게터 
		return coins;
	}
	public void setCoins(Coin[] coins) {	// Coin의 세터 
		this.coins = coins;
	}
	public int getSize() {	//	size의 게터 
		return size;
	}
	public void setSize(int size) {	// size의 세터 
		this.size = size;
	}
	public int getMaxsize() {	// maxsize의 게터 
		return maxsize;
	}
	public void setMaxsize(int maxsize) {	// maxsize의 세터 
		this.maxsize = maxsize;
	}
	
	
}
