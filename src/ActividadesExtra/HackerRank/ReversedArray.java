package ActividadesExtra.HackerRank;

import java.util.ArrayList;
import java.util.List;

public class ReversedArray {

    public static List<Integer> reverseArray(List<Integer> a) {
        int arraySize = a.size();
        List<Integer> b = new ArrayList<Integer>();
        for (int i = arraySize - 1; i >= 0; i--) {
            b.add(a.get(i));
        }
        return b;
    }
}
