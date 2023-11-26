package Actividad15;

public class BinaryTree23 {
    Node23 root = new Node23();

    public boolean search(int key) {
        return search(root, key);
    }
    private boolean search(Node23 node, int key) {
        if (node == null) {
            return false;
        }
        int index = 0;
        while (index < node.keyCount && key > node.keys[index]) {
            index++;
        }
        if (index < node.keyCount && key == node.keys[index]) {
            return true;
        } else if (node.isLeaf()) {
            return false;
        } else {
            return search(node.children.get(index), key);
        }
    }
    public void insert(int key) {
        //Para poder insertar un nodo, primero se tiene que buscar, si no esta, se inserta
        if (search(key)) {
            System.out.println("El valor ya existe en el arbol");
            return;
        }
        Node23 newNode = insert(root, key);

        if (newNode != null) {
            Node23 pastRoot = root;
            root = new Node23();
            root.children.set(0, pastRoot);
            root.children.set(1, newNode);
            root.keys.set(0, newNode.keys.get(0));
            root.keyCount = 1;
        }
    }
    private Node23 insert(Node23 node, int key) {
        int index = 0;
        while (index < node.keyCount && key > node.keys[index]) {
            index++;
        }
        if (node.isLeaf()) {
            for (int i = node.keyCount; i > index; i--) {
                node.keys.set(i, node.keys.get(i - 1));
            }
            node.keys.set(index, key);
            node.keyCount++;
            if (node.keyCount > 2) {
                return split(node);
            } else {
                return null;
            }
        } else {
            Node23 newNode = insert(node.children.get(index), key);
            if (newNode != null) {
                for (int i = node.keyCount; i > index; i--) {
                    node.keys.set(i, node.keys.get(i - 1));
                    node.children.set(i + 1, node.children.get(i));
                }
                node.keys.set(index, newNode.keys.get(0));
                node.children.set(index + 1, newNode);
                node.keyCount++;
                if (node.keyCount > 2) {
                    return split(node);
                }
            }
            return null;
        }
    }

    private Node23 split(Node23 node) {
        Node23 newNode = new Node23();
        newNode.keys.set(0, node.keys.get(2));
        node.keys.set(2, 0);
        newNode.children.set(0, node.children.get(2));
        node.children.set(2, null);
        newNode.children.set(1, node.children.get(3));
        node.children.set(3, null);
        node.keyCount = 1;
        newNode.keyCount = 1;
        return newNode;
    }

}
