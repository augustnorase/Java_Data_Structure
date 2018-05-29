package DS01;

import java.util.Scanner;

public class MainClass_01_201300402 {
	public static void main(String[] args) {	// 메인 메소드  
		Scanner sc = new Scanner(System.in);	// Scanner 선언 
		int menu = 0, bagsize;	// menu를 0으로 초기화시키고 bagsize도 선언 
		
		System.out.println("<<프로그램을 시작합니다>>");	// 안내문 출력 
		System.out.print("+ 가방에 들어갈 총 코인의 수를 입력하시오 : ");	// 안내문 출력 
		bagsize = sc.nextInt();	// bagsize에 int 값 넣음 
		ArrayBag bag = new ArrayBag(bagsize);	// ArrayBag의 사용자가 최대값을 넣는 생성자 
		
		while(menu != 9){	// 9가 입력되면 종료되는 while문 
			System.out.println("+ 메뉴를 선택하세요 1:add | 2:remove | 3:print | 4:search | 9:exit");	// 안내문 출력 
			menu = sc.nextInt();	//	menu에 int 값을 넣음 
			switch(menu){	// switch문 시작 
			case 1:	// 만약 menu가 1이라면 
				System.out.print("코인의 액수를 입력하세요 : ");	// 안내문 출력
				bag.add(sc.nextInt());	// add 메소드 구현 
				break;	// 다시 처음으로 돌아가기 위해 break
			case 2:	// 만약 menu가 2라면 
				System.out.print("코인의 액수를 입력하세요 : ");	// 안내문 출력 
				bag.remove(sc.nextInt());	//	remove 메소드 구현 
				break;	// 다시 처음으로 돌아가기 위해 break
			case 3:	// 만약 menu가 3이라면 
				bag.print();	// print 메소드 구현 
				break;	// 다시 처음으로 돌아가기 위해 break
			case 4: // 만약 menu가 4라면 
				System.out.print("코인의 액수를 입력하세요 : ");	// 안내문 출력 
				bag.frequentCoin(sc.nextInt());	// frequentCoin 메소드 구현 
				break;	// 다시 처음으로 돌아가기 위해 break
			case 9:	// 만약 menu가 9라면 
				System.out.println("<<9가 입력되어 종료합니다.>>");	// 안내문 출력 
				bag.print();	// print 메소드 구현 
				System.out.print("<<프로그램을 종료합니다.>>");	// 안내문 출력 
				break;	// 종료 
			}
		}
		
	}
}
