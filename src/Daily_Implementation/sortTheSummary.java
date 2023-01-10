package Daily_Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
public class sortTheSummary {
    /*
     * Complete the 'groupSort' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    //
    public static List<List<Integer>> groupSort(List<Integer> arr) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int tem = 0;
        //先排序
        for(int i=0; i<arr.size(); i++)
        {
            if(i!=0)
            {
                for(int j=i; j>0; j--)
                {
                    if(arr.get(j)<arr.get(j-1))
                    {
                        tem = arr.get(j);
                        arr.remove(j);
                        arr.add(j-1, arr.get(j-1));
                        arr.remove(j-1);
                        arr.add(j-1, tem);
                    }
                }
            }
        }
        tem = arr.get(0);
        int count = 0;
        //再count frequency
        for(int i=0; i<arr.size(); i++)
        {
            if(arr.get(i)==tem)
            {
                count++;
            }
            else if(arr.get(i)>tem)
            {
                List<Integer> current = new ArrayList<>();
                current.add(tem);
                current.add(count);
                result.add(current);
                tem = arr.get(i);
                count = 1;
            }
            if(i==arr.size()-1)
            {
                List<Integer> current = new ArrayList<>();
                current.add(tem);
                current.add(count);
                result.add(current);
            }
        }
        List<Integer> ttem;
        //再依据frequency排序
        for(int i=0; i<result.size(); i++)
        {
            if(i!=0)
            {
                for(int j=i; j>0; j--)
                {
                    if(result.get(j).get(1)>result.get(j-1).get(1))
                    {
                        ttem = result.get(j);
                        result.remove(j);
                        result.add(j, result.get(j-1));
                        result.remove(j-1);
                        result.add(j-1, ttem);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //sortTheSummary first = new sortTheSummary();
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(3);
        a.add(1);
        a.add(2);
        a.add(1);
        List<List<Integer>> result = groupSort(a);
        for(List<Integer> i: result)
        {
            for(Integer j: i)
            {
                System.out.print(j+" ");
            }
            System.out.println("\n");
        }

        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(3);
        b.add(1);
        b.add(2);
        List<List<Integer>> result_1 = groupSort(b);
        for(List<Integer> i: result_1)
        {
            for(Integer j: i)
            {
                System.out.print(j+" ");
            }
            System.out.println("\n");
        }
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
//                    try {
//                        return bufferedReader.readLine().replaceAll("\\s+$", "");
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                })
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        List<List<Integer>> result = sortTheSummary.groupSort(arr);
//
//        result.stream()
//                .map(
//                        r -> r.stream()
//                                .map(Object::toString)
//                                .collect(joining(" "))
//                )
//                .map(r -> r + "\n")
//                .collect(toList())
//                .forEach(e -> {
//                    try {
//                        bufferedWriter.write(e);
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                });
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
}

