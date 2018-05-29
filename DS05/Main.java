package DS05;

import java.util.Scanner;

public class Main {
	// 메인 클래스는 주석 스킵 가능하다고 하셨으니 스킵합니다. 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);	
        System.out.println(" :: 프로그램을 시작합니다. :: ");
        System.out.println("[ 수식 입력을 시작합니다. ]");
        System.out.println("[ Infix 를 postfix 로 ]");
        String string;
        while (true) {

            System.out.print(" > 수식을 입력하시오 : ");
            string = scanner.nextLine();
            if ("!".equals(string))
                break;

            Postfix postfix = new Postfix(string);

            System.out.println("입력 : " + postfix.getInfix());
            System.out.println("postfix : " + postfix.getPostfix());

            System.out.println("계산 결과 : " + postfix.calculate()+"\n");

        }
        System.out.println("[ 수식 입력을 종료합니다. ]");
        System.out.println(" :: 프로그램을 종료합니다. :: ");
    }
}
