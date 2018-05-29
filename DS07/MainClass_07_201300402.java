package DS07;

public class MainClass_07_201300402 {
	public static void main(String args[]){
		// 메인메소드에 대한 설명은 보고서에서 그림과 함께 설명하도록 하겠습니다. 
		Tree G = new Tree("G", null, null);
		Tree F = new Tree("F", null, null);
		Tree E = new Tree("E", null, null);
		Tree D = new Tree("D", null, null);
		Tree C = new Tree("C", F, G);
		Tree B = new Tree("B", D, E);
		Tree A = new Tree("A", B, C);
		
		System.out.print("inorder : ");
		A.inorder(A);
		System.out.println();
		System.out.print("preorder : ");
		A.preorder(A);
		System.out.println();
		System.out.print("postorder : ");
		A.postorder(A);
		System.out.println();
		System.out.println("현재 높이는 " + A.height() + "입니다.");
		System.out.println("현재 노드의 개수는 " +A.numberOfNodes() + "입니다.");
		
	}
}
