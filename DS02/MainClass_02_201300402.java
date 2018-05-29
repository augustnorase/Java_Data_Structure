package DS02;

import java.util.Scanner;

public class MainClass_02_201300402 {
	public static void main(String[] args) {	// 메인 메소드 
		Scanner scanner = new Scanner(System.in);	// 사용자 입력을 위한 스캐너 
		int menu = 0, bagSize;	// menu를 0으로 초기화하고, bagSize 정수로 선언 
		System.out.println("<< 프로그램을 시작합니다 >>");	// 안내문 출력 
		System.out.print("+ 가방에 들어갈 총 코인의 개수를 입력하시오 : ");	// 안내문 출력 
		bagSize = scanner.nextInt();	// bagSize에 들어갈 내용은 int 
		while(bagSize < 0){	// bagSize에 음수가 들어간다면(음수로 돌아가는 동안)
			System.out.println("<< 가방의 크기가 음수가 될 수 없습니다. >>");	// 안내문 출력 
			bagSize = scanner.nextInt();	// bagSize에 정수를 입력받음 
		}
		LinkedBag linkedBag = new LinkedBag(bagSize);	// LinkedBag의 생성자에 bagSize를 입력받음 
		
		while(menu != 9){	// menu에 9가 들어오면 종료 
			System.out.println("\n+ 메뉴를 선택하세요\t\t");	// 안내문 출력 
			System.out.println("1:add | 2:remove | 3:print | 4:search | 5:removeAll");	// 안내문 출력 
			System.out.println("6:add index | 7:removeMax | 8:resize | 9:exit");	// 안내문 출력 
			menu = scanner.nextInt();	// menu에는 정수가 들어갈 것 
			
			switch(menu){	// 스위치문 시작 
			case 1: {	// 1번이 입력됬을 때 
				System.out.print("코인의 액수를 입력하세요 : ");	// 안내문 출력 
				int value = scanner.nextInt();	// value에 정수를 입력받음 
				if(linkedBag.add(value)){	// 만약 입력받은 값을 add 시킨다면 
					System.out.println(value + "코인을 넣었습니다.");	// 안내문 출력 
				}
				else{	// 그게 아니라면 
					System.out.println("코인을 넣을 수 없습니다.");	// 안내문 출력 
				}
				break;	// 탈출 
			}
			case 2: {	// 2번이 입력됬을 때 
				System.out.print("코인의 액수를 입력하세요 : ");	// 안내문 출력 
				int value = scanner.nextInt();	// value에 정수를 입력받음 
				if(linkedBag.remove(value)){	// 만약 해당하는 값이 linkedlist에 있다면 remove() 메소드 호출 
					System.out.println(value + "코인이 제거되었습니다.");	// 안내문 출력 
				}
				else{	// 없다면 
					System.out.println(value + "코인이 없습니다.");	// 안내문 출력 
				}
				break;	// 탈출 
			}
			case 3: {	// 3번이 입력됬을 때 
				linkedBag.print();	// print() 메소드 출력  
				break;	// 탈출 
			}
			case 4: {	// 4번이 입력됬을 때 
				System.out.print("코인의 액수를 입력하세요 : ");	// 안내문 출력 
				int value = scanner.nextInt();	// value에 정수를 입력받음 
				System.out.println(value + "코인은 " +linkedBag.frequencyOf(value) +"개 존재합니다.");	// 안내문 출력 
				break;	// 탈출 
			}
			case 5: {	// 5번이 입력됬을 때 
				int[] coins = linkedBag.removeAll();	// coins 배열에 linkedBag의 removeAll() 메소드를 대입 
				System.out.print("[ ");	// [ 를 출력 
				for(int coin : coins){	// foreach 문 
					System.out.print(coin+ " ");	// 코인의 값 출력 
				}
				System.out.println("] ");	// ]를 출력 
				System.out.println("코인들이 제거되었습니다.");	// 안내문 출력 
				break;	// 탈출 
			}
			case 6: {	// 6번이 입력됬을 때 
				System.out.print("코인의 액수를 입력하세요 : ");	// 안내문 출력 
				int value = scanner.nextInt();	// value에 정수값 입력 
				System.out.println("넣을 index를 입력하세요.");	// 안내문 출력 
				int index = scanner.nextInt();	// index에 정수값 입력 
				if(linkedBag.add(index, value)){	// 만약 해당하는 index가 존재한다면 
					System.out.println(value + "코인을 넣었습니다.");	// 코인을 넣음 
				}
				else{	// 없다면 
					System.out.println(value + "코인을 넣을 수 없습니다.");	// 안내문 출력 
				}
				break;	// 탈출 
			}
			case 7: {	// 7번이 입력됬을 때 
				System.out.println("가장 큰 값을 제거합니다 : ");	// 안내문 출력 
				System.out.println(linkedBag.removeMax());	// 가장 큰 값을 제거 
				break;	// 탈출 
			}
			case 8: {	// 8번이 입력됬을 때 
				System.out.println("크기를 입력해주세요.");	// 안내문 출력 
				int size = scanner.nextInt();	// size에 정수를 입력받음 
				System.out.println("크기를 " +size+"로 변경합니다.");		// 안내문 출력 
				linkedBag.resize(size);	// 입력받은 size대로 resize 
				break;	// 탈출 
			}
			case 9 : {	// 9번이 입력됬을 때 
				System.out.println("<< 9가 입력되어 종료합니다. >>");	// 안내문 출력 
				linkedBag.print();	// print() 메소드 출력 
				System.out.println("\n<< 프로그램을 종료합니다. >>");	// 안내문 출력 
				break;	// 탈출 
			}
			case 10 : {
				int value = scanner.nextInt();
				System.out.println(linkedBag.contains(value));
				break;
			}
			default : {	// 그 이외의 값이 입력되면 
				System.out.println("<< 잘못된 입력입니다. >>");	// 안내문 출력 
			}
			}
		}
	}
}
