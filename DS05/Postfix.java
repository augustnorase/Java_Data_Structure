package DS05;

public class Postfix {
    private String infix;	// 사람들이 사용하는 기본적인 식을 저장하기 위한 변수 infix 선언 
    private StringBuilder postfix;	// 컴퓨터가 사용하는 식인 postfix를 만들기 위한 스트링빌더 변수 선언 

    public Postfix(String string) {	// Postfix 생성자 
        infix = string;	// 입력한 값은 infix에 넣어줌 
        postfix = new StringBuilder();	// postfix는 스트링빌더로 생성 
        infixToPostfix(0);	
        // 처음부터 읽을 수 있도록 (아래 반복문에서 처음부터 length만큼 읽기 위해 0으로 초기화 한다.)
    }
    
    private int infixToPostfix(int index) {		// infix에서 postfix를 만들기 위한 메소드 
        StringBuilder num = new StringBuilder();	// num은 새로운 스트링빌더 
        Stack operationStack = new Stack();	// 스택 선언 
        for (int i = index; i < infix.toCharArray().length; ++i) {	
        	// 입력받은 index부터 현재 문자열의 길이까지 반복. 위의 생성자에서 0으로 선언했기에 처음부터 시작함. 
            char ch = infix.charAt(i);	// infix에 들어있는 i번째의 값을 ch에 넣음. 
            // 예를 들어 coding일 경우 charAt(0)은 c가 들어감 
            String peek = operationStack.peek();	// peek 선언. 쓰지는 않음.
            switch (ch) {	// ch 스위치문 
                case '(':	// ch가 ( 일 경우 
                    i = infixToPostfix(i+1);	// 재귀적으로 i값에 새로 넣어줄 뿐, postfix에는 괄호가 들어가지 않기 때문에 push하지는 않는다. 
                    break;	// 탈출 
                case ')':	// ch가 ) 일 경우 
                    makePostfix(num.toString());	// 숫자를 가져오는 과정 
                    while (!operationStack.isEmpty()) {	// 스택이 비어있을 때까지 
                        makePostfix(operationStack.pop());	// 스택에 있는 연산자를 pop
                    }
                    return i;	// )는 연산자도 아니고 스택에 들어가서는 안되기 때문에 push하지 않고 현재 값인 i를 리턴해줌 
                case '*':	// ch가 * 일 경우 
                    //TODO
                	
                	makePostfix(num.toString());	
                	// 숫자를 가져오는 과정. 만약 여기서 사용자가 임의의 숫자를 넣을 경우 연산자 앞의 숫자는 그 숫자가 들어감 
                    num = new StringBuilder();	// 새로운 스트링빌더 선언. 만약 위의 라인과 순서가 바뀌면 에러뜸 
                    while (!operationStack.isEmpty()) {	// 스택이 비어있을 때까지  
                    	
                    	String op = operationStack.pop();	// 스택에 있는 연산자를 pop 
                    	if(op == "*" || op == "/" || op == "%"){	// 만약 그 연산자가 우선순위가 높은 연산자일 경우에 
                    		makePostfix(op);	// makePostfix로 해당 연산자를 보냄 
                    	}
                    	
                    	else{	// 그게 아닐 경우에는 
                    		operationStack.push(op);	// 평범하게 스택에 push 함 
                    		break;	// 탈출 
                    	}
                    }
                    operationStack.push("*");	// 스택에 *를 push 함 
                    break;	// 탈출 
                    
                case '/':	// ch가 / 일 경우 
                    // '/'는 연산 순위가 '*'와 같기 때문에 코드 동일. 주석은 스킵함 
                	makePostfix(num.toString());
                	num = new StringBuilder();
                	while (!operationStack.isEmpty()){
                		String op = operationStack.pop();
                		if(op == "*" || op == "/" || op == "%"){
                			makePostfix(op);
                		}
                		else{
                			operationStack.push(op);
                			break;
                		}
                	}
                	operationStack.push("/");
                    break;
                   
                case '%':	// ch가 % 일 경우 
                    // %의 우선 순위는 잘 모르겠습니다만 일단 곱하기 나누기와 동일하다고 가정했습니다.
                	makePostfix(num.toString());
                	num = new StringBuilder();
                	while (!operationStack.isEmpty()){
                		String op = operationStack.pop();
                		if(op == "*" || op == "/" || op == "%"){
                			makePostfix(op);
                		}
                		else{
                			operationStack.push(op);
                			break;
                		}
                	}
                	operationStack.push("%");
                    break;
                    
                case '+':	// ch가 + 일 경우 
                    makePostfix(num.toString());	// 숫자를 가져오는 과정 
                    num = new StringBuilder();	// 새로운 스트링빌더 선언 
                    while (!operationStack.isEmpty()) {	// 스택이 비어있을 때까지  
                    	makePostfix(operationStack.pop());	// makePostfix에 pop이 된 값을 넣어줌 
                    }
                    operationStack.push("+");	// 스택에는 다시 push를 넣고 
                    break;	// 탈출 
                    
                case '-':	// '-'는 '+'와 동일하기 때문에 주석은 스킵함 
                    makePostfix(num.toString());
                    num = new StringBuilder();
                    while (!operationStack.isEmpty()) {
                        makePostfix(operationStack.pop());
                    }
                    operationStack.push("-");
                    break;
                // 숫자를 넣는 과정 
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    num.append(ch);	
                    // 숫자일 경우에는 그냥 ch에 더해줌. 숫자는 연산자가 아니기 때문에 스택에 들어가지 않음.
                    // num에만 넣어주며, num에 들어간 숫자는 위의 makePostfix(num.toString())에서 꺼내져 사용됨 
                    break;
                // 띄어쓰기나 탭, 다음 칸으로 넘어가는 경우 
                case ' ':
                case '\t':
                case '\n':
                    break;	// 탈출 
                default:	// 그 이외 
                    System.out.println("[ 올바르지 않은 입력입니다. : " + ch + " ]");	// 안내문 출력 
                    break;	// 탈출 
            }
        }

        makePostfix(num.toString());	// 숫자를 가져오는 과정 
        while (!operationStack.isEmpty()) {	// 스택이 비어있을 때까지  
            makePostfix(operationStack.pop());	// 스택에 있는 것을 pop하여 makePostfix에 넣어줌 
        }
        return infix.toCharArray().length;	// infix의 길이를 리턴 
    }

    private void makePostfix(String string) {	// postfix 형식으로 연산자를 추가해 줄 메소드  
        if (!"".equals(string)) {	// 아무런 값을 입력한 게 아니라면  
            postfix.append(string).append(" ");	// postfix에 입력한 string을 뒤에 추가해줌 
        }
    }

    public double calculate() {	// 계산하는 메소드. 나누기 때문에 double로 선언 
        Stack valueStack = new Stack();	// 새로운 스택 생성 
        StringBuilder num = new StringBuilder();	// num은 스트링빌더로 

        double result;	// 나누는 값이 있으니 int가 아니라 double로 선언 
        for (int i = 0; i < postfix.toString().toCharArray().length; ++i) {	// 처음부터 postfix의 길이까지 반복하는 반복문 
            char ch = postfix.charAt(i);	// postfix의 i번째 문자를 ch에 넣어줌 
            switch (ch) {	// ch 스위치문 
                case '*': {		// *일 경우 
                    //TODO
                	String b = valueStack.pop();	// 스택에서 pop하여 b에 넣어줌 
                    String a = valueStack.pop();	// 스택에서 pop하여 a에 넣어줌 
                    a = Double.toString(Double.parseDouble(a) * Double.parseDouble(b));	// 두 개 값을 곱한 뒤 
                    valueStack.push(a);	// 곱한 값을 스택에 넣음 
                    break;	// 탈출 
                }
                case '/': {
                    //TODO
                	String b = valueStack.pop();	// 스택에서 pop하여 b에 넣음 
                    String a = valueStack.pop();	// 스택에서 pop하여 a에 넣음 
                    a = Double.toString(Double.parseDouble(a) / Double.parseDouble(b));	// 두 값을 나눈 뒤 
                    valueStack.push(a);	// 그 값을 스택에 넣음 
                    break;	// 탈출 
                }
                case '+': {	// 더하기일 경우 
                    String b = valueStack.pop();	// 스택에서 pop하여 b에 저장 
                    String a = valueStack.pop();	// 스택에서 pop하여 a에 저장 
                    a = Double.toString(Double.parseDouble(a) + Double.parseDouble(b)); // pop한 값을 더하여 a에 저장 
                    valueStack.push(a);	// a를 스택에 push함 
                    break;	// 탈출 
                }
                case '-': {	// 빼기일 경우 
                    String b = valueStack.pop();	// 스택에서 pop하여 b에 저장 
                    String a = valueStack.pop();	// 스택에서 pop하여 a에 저장
                    a = Double.toString(Double.parseDouble(a) - Double.parseDouble(b));	// pop한 값을 빼 a에 저장 
                    valueStack.push(a);	// a를 스택에 push함 
                    break;	// 탈출 
                }
                case '%': {	// 나머지 연산의 경우  
                    String b = valueStack.pop();	// 스택에서 pop하여 b에 저장 
                    String a = valueStack.pop();	// 스택에서 pop하여 a에 저장
                    a = Double.toString(Double.parseDouble(a) % Double.parseDouble(b));	// pop한 값을 빼 a에 저장 
                    valueStack.push(a);	// a를 스택에 push함 
                    break;	// 탈출 
                }
                // 숫자의 경우 
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '.':
                    num.append(ch);	// 숫자는 바로 num에 넣어줌 
                    break;
                case ' ':
                    if (!num.toString().equals("")) {	// 만약 num의 값이 공백이 아니라면 
                        valueStack.push(num.toString());	
                        // valueStack에 숫자를 push해줌
                        // 연산자 뿐만이 아니라 숫자를 빼내 계산해줘야 하기 때문에 숫자를 스택에 넣어줄 필요가 있음 
                        num = new StringBuilder();	// num에는 새로운 스트링빌더 선언 
                    }
                    break;	// 탈출 
                default:	// 그 이외의 경우들에는 
                    break;	// 바로 탈출 
            }
        }

        result = Double.valueOf(valueStack.pop());	// 결과 값에는 마지막 남은 결과 값을 pop하여 넣어줌 
        return result;	// 결과값 리턴 
    }


    public String getInfix() {	// infix의 게터 
        return infix;
    }

    public String getPostfix() {	//	postfix의 게터 
        return postfix.toString();	// toString 안 써주면 주소값을 리턴함 
    }

}
