package DS08;

public class BinaryNode {
    private String value;
    private BinaryNode parent;
    private BinaryNode left;
    private BinaryNode right;

    BinaryNode() {
    }

    BinaryNode(String value) {
        this.value = value;
    }

    public int level() {
        if (parent == null) {
            return 1;
        }
        return parent.level() + 1;
    }

    public int height() {
        int heightOfLeftNodes = 0;
        if (hasLeft()) {
            heightOfLeftNodes = this.left.height();
        }
        int heightOfRightNodes = 0;
        if(hasRight()) {
            heightOfRightNodes = this.right.height();
        }

        return heightOfLeftNodes > heightOfRightNodes ? heightOfLeftNodes+1: heightOfRightNodes+1;
    }

    public int numberOfNodes() {
        int numberOfLeftNodes = 0;
        if (hasLeft()) {
            numberOfLeftNodes = this.left.numberOfNodes();
        }
        int numberOfRightNodes = 0;
        if (hasRight()) {
            numberOfRightNodes = this.right.numberOfNodes();
        }
        return numberOfLeftNodes + numberOfRightNodes + 1;
    }

    public String getValue() {
        return value;
    }

    public void setLeft(BinaryNode left) {
        if (left != null) {
            this.left = left;
            this.left.parent = this;
        }
    }

    public void setRight(BinaryNode right) {
        if (right != null) {
            this.right = right;
            left.parent = this;
        }
    }

    public BinaryNode getLeft() {
        return this.left;
    }

    public BinaryNode getRight() {
        return this.right;
    }

    public boolean hasLeft() {
        return this.left != null;
    }

    public boolean hasRight() {
        return this.right != null;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

}
