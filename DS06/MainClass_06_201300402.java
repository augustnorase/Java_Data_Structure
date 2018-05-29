package DS06;

import java.util.Scanner;

public class MainClass_06_201300402 {
	/* 메인 클래스는 주석을 달지 않아도 되지만 출력의 예에 맞춰 약간 수정한 부분이 있기에
	 * 그 부분만 주석을 달도록 하겠습니다.
	*/
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        CircularArrayQueue queue = new CircularArrayQueue();
        System.out.println(" :: Program Start :: ");
        System.out.println("[ Start to Input Character. ]");
        String string;
        while (true) {
            System.out.print("- Please Input Character : ");
            string = scanner.nextLine();
            if ("!".equals(string)) {
                System.out.println("[End to Input Character]");
                queue.removes(queue.size());
                break;
            }
            switch (string) {
                case "#":
                    System.out.println("[Size] The Queue has " + queue.size() + " of Element(s).");
                    break;
                case "/":
                    System.out.println("[Queue] <Front> " + queue.printQueue() + "<Rear> ");
                    break;
                case "^":
                    System.out.println("[Front] The First Element is '" + queue.front() + "'. ");
                    break;
                case "-":
                    String dequeue = queue.deQueue();
                    try{	// 출력의 예에서는 시작하자마자 -를 입력. 이 같은 처리가 없을 경우 NullPointerException 에러가 뜨면서 강제 종료되기에 예외처리 실행
                    	if (!dequeue.equals(""))
                        System.out.print("");	// -의 경우는 안내문 출력이 되지만 숫자를 통해 제거하는 경우는 출력이 안되기 때문에
                    							// 안내문을 전부 deQueue 메소드에 내장
                    							// 메인 클래스 내에 안내문을 새롭게 써서 처리하는 방법도 있지만
                    							// 저 같은 경우는 removes 메소드도 deQueue 메소드를 사용하는 방식으로 실현했기 때문에
                    							// 내장하는 방식을 택했습니다.
                    }
                    catch(NullPointerException e){	// 그냥 예외처리만 해주면 나머지는 deQueue의 isEmpty()가 처리해줌               	
                    }
                   
                    break;
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    System.out.println(string + " Of Element(s) will be Deleted");
                    queue.removes(Integer.parseInt(string));
                    break;
                default:
                    if (queue.enQueue(string))
                        System.out.println("[Enqueue] The Inserted Element is " + string + ".");
                    break;
            }

        }
        System.out.println("\n :: Program End :: ");
    }
    
}
