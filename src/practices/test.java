package practices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class test {
    public static void main(String[] args) {
        String[] input = new String[]{"Ownership",
                "Deliver Results",
                "Bias for Action", "Dive Deep",
                "Invent and Simplify",
                "Are Right, A Lot", "Have Backbone",
                "Earn Trust",
                "Insist On Highest Standards", "Learn and Be Curious",
                "Think Big",
                "Customer Obsession",
                "Deliver Results",
                "Dive Deep",
                "Frugality",
                "Bias for Action",
                "Deliver Results",
                "Have Backbone",
                "Earn Trust",
                "Insist On Highest Standards",
                "Invent and Simplify",
                "Think Big",
                "Deliver Results",
                "Ownership",
                "Ownership",
                "Deliver Results",
                "Dive Deep"};
        methodA(input);
    }

    public static HashMap<String, Integer> methodA(String[] input) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String in: input){
            map.put(in, map.getOrDefault(in, 0)+1);
        }
        int count = 0;
//        for (Map.Entry<String, Integer> lpMap: map.entrySet()){
//            count++;
//            System.out.println(count+"  Lp = "+lpMap.getKey()+", 数量 = "+lpMap.getValue());
//        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for (Map.Entry<String, Integer> lpMap: list){
            count++;
            System.out.println(count+", 数量 = "+lpMap.getValue()+",  Lp = "+lpMap.getKey());
        }
        return map;
    }
}