package Actividad15;

import java.util.ArrayList;
import java.util.List;

public class Node23{
    public List keys = new ArrayList<>();
    public List<Node23> children = new ArrayList<>();
    public int keyCount;
    public boolean isLeaf() {
        return children == null;
    }

}
