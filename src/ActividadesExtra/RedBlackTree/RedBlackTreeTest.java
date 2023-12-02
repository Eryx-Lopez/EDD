package ActividadesExtra.RedBlackTree;

import org.junit.Assert;
import org.junit.Test;

public class RedBlackTreeTest {
    @Test
    public void insertNodeTest(){
        Tree tree = new Tree(Integer.MIN_VALUE);
        NodeRB node = new NodeRB(19);
        tree.insertNode(node.data);

        Assert.assertEquals(19, node.data);
    }
    @Test
    public void searchNodeTest(){

    }
    @Test
    public void getNodesInTreeTest(){
        Tree tree = new Tree(Integer.MIN_VALUE);
        tree.insertNode(19);
        tree.insertNode(1);
        tree.insertNode(12);
        tree.insertNode(14);
        tree.insertNode(15);
        tree.insertNode(16);


        Assert.assertEquals(6, tree.nodesInTree());

    }
    @Test
    public void isEmptyTest(){
        Tree tree = new Tree(Integer.MIN_VALUE);
        tree.insertNode(19);
        tree.insertNode(9);

        Assert.assertEquals(false, tree.isEmpty());

    }
    @Test
    public void removeAllTest(){
        Tree tree = new Tree(Integer.MIN_VALUE);
        tree.insertNode(19);
        tree.insertNode(9);
        tree.removeAll();

        Assert.assertEquals(true, tree.isEmpty());
        Assert.assertEquals(0, tree.nodesInTree());
    }
}
