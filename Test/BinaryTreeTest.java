import Actividad14.Node;
import Actividad14.Tree;
import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest {
    @Test
    public void addTest(){
        Tree tree = new Tree();
        Node node = new Node(5);
        tree.add(node.getData());

        Assert.assertEquals(5, node.getData());
    }
    @Test
    public void searchTest(){
        Tree tree = new Tree();
        tree.add(9);
        tree.add(8);
        tree.add(7);
        tree.add(6);
        tree.add(5);
        Assert.assertEquals(true, tree.exists(8));
        Assert.assertEquals(true, tree.exists(5));
        Assert.assertEquals(false, tree.exists(2));
    }

}
