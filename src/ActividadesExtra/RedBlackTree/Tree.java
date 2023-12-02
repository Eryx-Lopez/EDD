package ActividadesExtra.RedBlackTree;

public class Tree {
    public final boolean RED = true;
    public final boolean BLACK = false;
    private static NodeRB nullNode;
    private NodeRB current;
    private NodeRB parent;
    private NodeRB header;
    private NodeRB grand;
    private NodeRB great;

    //INITIALIZE NULL NODE
    static
    {
        nullNode = new NodeRB(0);
        nullNode.left = nullNode;
        nullNode.right = nullNode;
    }

    //HEADER NODE
    public Tree(int header){
        this.header = new NodeRB(header);
        this.header.left = nullNode;
        this.header.right = nullNode;
    }

    //METHODS
    public void removeAll(){
        header.right = nullNode;
    }
    public boolean isEmpty(){
        return header.right == nullNode;
    }

    private void flipColors(int newData)
    {
        // Flips colors
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;


        if (parent.color == RED) {
            grand.color = RED;

            if (newData < grand.data && grand.data != newData && newData < parent.data)
                parent = rotate( newData, grand );  // Start dbl rotate
            current = rotate(newData, great );
            current.color = BLACK;
        }

        // change the color of the root node with BLACK
        header.right.color = BLACK;
    }

    private NodeRB rotateLeft(NodeRB node2){
        NodeRB node1 = node2.left;
        node2.left = node1.right;
        node1.right = node2;
        return node1;
    }

    private NodeRB rotateRight(NodeRB node1){
        NodeRB node2 = node1.right;
        node1.right = node2.left;
        node2.left = node1;
        return node2;
    }

    private NodeRB rotate(int newData, NodeRB parent){
        if(newData < parent.data){
            return parent.left = newData < parent.left.data ? rotateLeft(parent.right) : rotateRight(parent.right);
        }else {
            return parent.right = newData < parent.right.data ? rotateLeft(parent.right) : rotateRight(parent.right);
        }
    }

    public int nodesInTree(){
        return nodesInTree(header.right);
    }
    private int nodesInTree(NodeRB node){
        if(node == nullNode){
            return 0;
        }else{
            int size = 1;
            size = size + nodesInTree(node.left);
            size = size + nodesInTree(node.right);
            return size;
        }
    }
    public boolean searchNode(int value){
        return searchNode(header.right,value);
    }
    private boolean searchNode(NodeRB node, int value){
        boolean check = false;
        while ((node != nullNode) && check != true){
            int nodeValue = node.data;
            if(value < nodeValue){
                node = node.left;
            } else if (value > nodeValue) {
                node = node.right;
            }else{
                check = true;
                break;
            }
            check = searchNode(node, value);
        }
        return check;
    }

    public void insertNode(int newData){
        current = parent = grand = header;
        nullNode.data = newData;

        while(current.data != newData) {
            great = grand;
            grand = parent;
            parent = current;

            //if newData < current
            // current points left
            // else point to right

            current = newData < current.data ? current.left : current.right;
            if ((current.left.color == RED && current.right.color) == RED) {
                flipColors(newData);
            }
        }
        if(current != nullNode){
            return;
        }

        current = new NodeRB(newData, nullNode, nullNode);

        if (newData < parent.data) {
            parent.left = current;
        }
        else {
            parent.right = current;
        }
        flipColors(newData);
    }


    //ORDERS

    public void preorderTraversal(){
        preorderTraversal(header.right);
    }
    private void preorderTraversal(NodeRB node){
        if(node != nullNode){
            String color = "Red";
            if (node.color == BLACK) {
                color = "Black";
            }
                System.out.println(node.data + " " + color);
                preorderTraversal(node.left);
                preorderTraversal(node.right);
            }
    }

    public void inorderTraversal(){
        inorderTraversal(header.right);
    }
    private void inorderTraversal(NodeRB node){
        if(node != nullNode){
            inorderTraversal(node.left);
            String color = "Red";
            if (node.color == BLACK){
                color = " Black";
            }
            System.out.println(node.data + " " + color);
            inorderTraversal(node.right);
        }
    }
    public void postorderTraversal(){
        postorderTraversal(header.right);
    }
    private void postorderTraversal(NodeRB node){
        if( node!= nullNode){
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            String color = "Red";
            if(node.color == BLACK){
                color = "Black";
            }
            System.out.println(node.data + " " + color);
        }

    }
}
