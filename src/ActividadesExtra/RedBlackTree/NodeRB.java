package ActividadesExtra.RedBlackTree;

public class NodeRB {

    int data;
    boolean color; //true if red, false if black

    NodeRB left;
    NodeRB right;
    NodeRB root;

    public NodeRB(int data) {
        this.data = data;
    }

    public NodeRB(int data, NodeRB left, NodeRB right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.color = false; //black
    }
}
