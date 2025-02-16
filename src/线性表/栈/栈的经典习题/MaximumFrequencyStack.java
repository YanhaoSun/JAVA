package 线性表.栈.栈的经典习题;

import java.util.HashMap;
import java.util.Stack;

/**
 * 力扣895
 * hard
 */
public class MaximumFrequencyStack {
    HashMap<Integer, Integer> valToFreq = new HashMap<>();
    HashMap<Integer, Stack<Integer>> freqToVals = new HashMap<>();
    int maxFreq = 0;
    public MaximumFrequencyStack() {

    }

    public void push(int val) {
        int freq = valToFreq.getOrDefault(val, 0)+1;
        valToFreq.put(val, freq);
        freqToVals.putIfAbsent(freq, new Stack<>());
        freqToVals.get(freq).push(val);
        maxFreq = Math.max(maxFreq, freq);
    }

    public int pop() {
        int res = freqToVals.get(maxFreq).pop();
        valToFreq.put(res, valToFreq.get(res)-1);
        if (freqToVals.get(maxFreq).isEmpty()){
            maxFreq--;
        }
        return res;
    }
}
