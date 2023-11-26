package Actividad14;

public class Tree {
    private Node root;

    public Tree(){

    }
    public boolean exists(int search){
        return exists(root, search);
    }

    private boolean exists (Node n, int search){
        if (n == null){
            return false;
        }
        if (n.getData() == search){
            return true;
        }else if (search < n.getData()){
            return exists(n.getLeft(), search);
        }else{
            return exists(n.getRight(), search);
        }
    }

    private void add(Node father, int data){
        if (data > father.getData()){
           if (father.getRight() == null){
               father.setRight(new Node(data));
           }else {
               add(father.getRight(), data);
           }
        }else{
            if (father.getLeft() == null){
                father.setLeft(new Node(data));
            }else {
                add(father.getLeft(), data);
            }
        }
    }
    public void add(int dato) {
        if (this.root == null) {
            this.root = new Node(dato);
        } else {
            this.add(this.root, dato);
        }
    }
    private void preorder(Node n) {
        if (n != null) {
            System.out.println(n.getData());
            preorder(n.getLeft());
            preorder(n.getRight());
        }
    }

    private void inorder(Node n) {
        if (n != null) {
            inorder(n.getLeft());
            System.out.println(n.getData());
            inorder(n.getRight());
        }
    }

    private void postorder(Node n) {
        if (n != null) {
           postorder(n.getLeft());
           postorder(n.getRight());
           System.out.println(n.getData());
        }
    }
    public void postorder() {
        this.postorder(this.root);
    }

    public void preorder() {
        this.preorder(this.root);
    }

    public void inorder() {
        this.inorder(this.root);
    }



}
