package ActividadesExtra.HackerRank;

import java.util.ArrayList;
import java.util.List;

public class StringQueries {
    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        for (String query : queries){
            int index = 0;
            for(String list : stringList){
                if(query.equals(list))
                index++;
            }
            result.add(index);
        }
        return result;
    }


}
