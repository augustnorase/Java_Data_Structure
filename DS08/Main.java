package DS08;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 트리 실습을 시작하겠습니다. ===");
        System.out.print("> 문자열을 입력해주세요. : ");
        String string = scanner.nextLine();
        System.out.println();
        System.out.print("> 정렬을 정해주세요.\n" + "아래의 선택이 아닌 경우 inorder 로 선택됩니다.\n"+
                "1: inorder 2:pre order, 3: post order 4: level order : ");
        int order = scanner.nextInt();
        System.out.println();
        BinaryTree binaryTree = makeTree(string, order);

        while (true) {
            System.out.println("1: 문자열 입력 2: order 변경 3: 값 확인");
            System.out.print("4: 트리 확인 9: 나가기 : ");
            int num = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (num) {
                case 1:
                    System.out.print("> 문자열을 입력해주세요. : ");
                    string = scanner.nextLine();
                    binaryTree = makeTree(string, order);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("> 정렬을 정해주세요.\n" + "아래의 선택이 아닌 경우 inorder 로 선택됩니다.\n"+
                            "1: inorder 2:pre order, 3: post order 4: level order :");
                    order = scanner.nextInt();
                    binaryTree = makeTree(string, order);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("트리의 값을 확인합니다. : ");
                    System.out.println(binaryTree.getValue());
                    System.out.println();
                    break;
                case 4:
                    System.out.println("트리의 모양을 확인합니다. : ");
                    binaryTree.print();
                    System.out.println();
                    break;
                case 9:
                    System.out.println("=== 트리 실습을 완료하였습니다. ===");
                    return ;
            }
        }
    }

    private static BinaryTree makeTree(String string, int order) {
        switch (order) {
            case 2:
                return new BinaryTree(string, "preOrder");
            case 3:
                return new BinaryTree(string, "postOrder");
            case 4:
                return new BinaryTree(string, "levelOrder");
            default:
                return new BinaryTree(string, "inorder");
        }
    }

}
