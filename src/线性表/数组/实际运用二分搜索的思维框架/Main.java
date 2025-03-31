package 线性表.数组.实际运用二分搜索的思维框架;

import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main {
    public static int MathChallenge(int num) {
        // code goes here
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used;
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;
        int[] nums = new int[n];
        for (int i=0; i<n; i++){
            nums[i] = digits[i]-'0';
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backTrack(nums, res, track, used);
        int[] resultArray = new int[res.size()];
        for (int i=0; i<res.size(); i++){
            List<Integer> temp = res.get(i);
            int tempDig = 0;
            for (int a: temp){
                tempDig = tempDig*10+a;
            }
            resultArray[i] = tempDig;
        }
        Arrays.sort(resultArray);
        for (int a: resultArray){
            if (a>num){
                return a;
            }
        }
        return -1;
    }
    public static void backTrack(int[] nums, List<List<Integer>> res, LinkedList<Integer> track, boolean[] used){
        if (track.size()==nums.length){
            res.add(new LinkedList<Integer>(track));
            return;
        }
        for (int i=0; i<nums.length; i++){
            if (used[i]){
                continue;
            }
            if (i>0 && nums[i]==nums[i-1] && !used[i-1]){
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backTrack(nums, res, track, used);
            track.removeLast();
            used[i] = false;
        }
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        if (s.hasNextLine()){
            String input = s.nextLine();
            int num = 0;
            try{
                num = Integer.parseInt(input);
            } catch (NumberFormatException e){
                System.out.print("");
                return;
            }
            int result = MathChallenge(num);
            // ih903y7lb
            String token = "txlfwm4q512";
            String resultString = String.valueOf(result);
            for (char ch : token.toCharArray()){
                resultString = resultString.replace(String.valueOf(ch), "--"+ch+"--");
            }
            System.out.print(resultString);
        } else {
            System.out.print("No input");
        }
        // System.out.print(MathChallenge(s.nextLine()));
    }

}
