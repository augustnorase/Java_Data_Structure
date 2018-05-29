package DS08;

public class BinaryTree {
    private BinaryNode root;
    private String order;

    public BinaryTree(String value, String order) {
        this.order = order;
        parse(value);
    }

    private void parse(String value) {
        if ("preOrder".equals(this.order)) {
            parseToPreOrder(value);
        } else if ("postOrder".equals(this.order)) {
            parseToPostOrder(value);
        } else if ("levelOrder".equals(this.order)) {
            parseToLevelOrder(value);
        } else {
            parseToInorder(value);
        }
    }

    private void parseToInorder(String value) {
        // divide half
        if ("".equals(value)) {
            this.root = new BinaryNode();
        } else {
            this.root = makeInorderTree(value);
        }
    }

    private BinaryNode makeInorderTree(String value) {
        if ("".equals(value))
            return null;
        BinaryNode node = new BinaryNode(value.charAt(value.length()/2)+"");
        node.setLeft(makeInorderTree(value.substring(0, value.length()/2)));
        node.setRight(makeInorderTree(value.substring(value.length()/2+1, value.length())));

        return node;
    }

    private void parseToPreOrder(String value) {
        if ("".equals(value)) {
            this.root = new BinaryNode();
        } else {
            this.root = makePreOrderTree(value);
        }
    }

    private BinaryNode makePreOrderTree(String value) {
        if ("".equals(value))
            return null;
        BinaryNode node = new BinaryNode(value.charAt(0)+"");
        node.setLeft(makePreOrderTree(value.substring(1, value.length()/2+1)));
        node.setRight(makePreOrderTree(value.substring(value.length()/2+1, value.length())));

        return node;
    }

    private void parseToPostOrder(String value) {
        if ("".equals(value)) {
            this.root = new BinaryNode();
        } else {
            this.root = makePostOrderTree(value);
        }
    }
    private BinaryNode makePostOrderTree(String value) {
        if ("".equals(value))
            return null;
        BinaryNode node = new BinaryNode(value.charAt(value.length()-1)+"");
        node.setLeft(makePostOrderTree(value.substring(0, value.length()/2)));
        node.setRight(makePostOrderTree(value.substring(value.length()/2, value.length()-1)));

        return node;
    }

    private void parseToLevelOrder(String value) {
        String[] strings = value.split("");
        this.root = new BinaryNode(strings[0]);
        LinkedQueue queue = new LinkedQueue();
        BinaryNode currentNode = this.root;
        for (int i = 1; i < strings.length; ++i) {
            BinaryNode newNode = new BinaryNode(strings[i]);

            if (!currentNode.hasLeft()) {
                currentNode.setLeft(newNode);
                queue.add(currentNode.getLeft());
            } else if (!currentNode.hasRight()) {
                currentNode.setRight(newNode);
                queue.add(currentNode.getRight());
            } else {
                currentNode = queue.remove();
                currentNode.setLeft(newNode);
                queue.add(currentNode.getLeft());
            }
        }
    }

    private String inorder(BinaryNode node) {
        String tree = "";
        if (node != null) {
            tree = inorder(node.getLeft());
            tree += node.getValue();
            tree += inorder(node.getRight());
        }
        return tree;
    }

    private String preOrder(BinaryNode node) {
        String tree = "";
        if (node != null) {
            tree += node.getValue();
            tree += preOrder(node.getLeft());
            tree += preOrder(node.getRight());
        }
        return tree;
    }

    private String postOrder(BinaryNode node) {
        String tree = "";
        if (node != null) {
            tree += postOrder(node.getLeft());
            tree += postOrder(node.getRight());
            tree += node.getValue();
        }
        return tree;
    }

    private String levelOrder(BinaryNode node) {
        LinkedQueue queue = new LinkedQueue();
        queue.add(node);
        StringBuilder tree = new StringBuilder();
        while (!queue.isEmpty()) {
            BinaryNode currentNode = queue.remove();
            tree.append(currentNode.getValue());
            if (currentNode.hasLeft())
                queue.add(currentNode.getLeft());
            if (currentNode.hasRight())
                queue.add(currentNode.getRight());
        }
        return tree.toString();
    }

    public String getValue() {
        String value;
        if ("preOrder".equals(this.order)) {
            value = preOrder(this.root);
        } else if ("postOrder".equals(this.order)) {
            value = postOrder(this.root);
        } else if ("levelOrder".equals(this.order)) {
            value = levelOrder(this.root);
        } else {
            value = inorder(this.root);
        }

        return value;
    }

    public void print() {
        LinkedQueue queue = new LinkedQueue();
        queue.add(this.root);
        int level = this.root.level();
        String interval = "%"+(int)Math.pow(2, this.root.height())+"s";
        StringBuilder tree = new StringBuilder();
        while (!queue.isEmpty()) {
            BinaryNode currentNode = queue.remove();
            if (currentNode != null) {
                if (level < currentNode.level()) {
                    level = currentNode.level();
                    interval = "%" + (int) Math.pow(2, currentNode.height()) + "s";
                    tree.append("\n");
                }
                queue.add(currentNode.getLeft());
                queue.add(currentNode.getRight());

                tree.append(String.format(interval, currentNode.getValue()))
                        .append(String.format(interval, ""));
            } else {
                tree.append(String.format(interval, ""))
                        .append(String.format(interval, ""));
            }
        }
        System.out.println(tree.toString());
    }
}
