package DFS_回溯算法.回溯算法;

import java.util.LinkedList;
import java.util.List;

public class n位二进制数的所有可能 {
    List<String> res = new LinkedList<>();
    public List<String> generateBinaryNumber(int n){
        StringBuilder track = new StringBuilder();
        int[] path = new int[2];
        path[0] = 0;
        path[1] = 1;
        backTrack(track, path, n);
        return res;
    }
    public void backTrack(StringBuilder track, int[] path, int length){
        if (track.length()==length){
            res.add(track.toString());
            return;
        }
        for (int i=0; i<path.length; i++){
            track.append(path[i]);
            backTrack(track, path, length);
            track.deleteCharAt(track.length()-1);
        }
    }

    public static void main(String[] args) {
        n位二进制数的所有可能 a = new n位二进制数的所有可能();
        List<String> res = a.generateBinaryNumber(3);
        System.out.println(res);
    }
}
