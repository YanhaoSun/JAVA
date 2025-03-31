package BFS算法.BFS算法解题套路框架;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 力扣752
 * medium
 */
public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        HashSet<String> deads = new HashSet<>();
        for (String dead: deadends) deads.add(dead);
        if (deads.contains("0000")){
            return -1;
        }
        String start = "0000";
        HashSet<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (target.equals(cur)) {
                    return step;
                }
                for (String newLock : generateNewLocks(cur)) {
                    if (!visited.contains(newLock) && !deads.contains(newLock)) {
                        queue.offer(newLock);
                        visited.add(newLock);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    public List<String> generateNewLocks(String lock){
        List<String> newLocks = new LinkedList<>();
        for (int i=0; i<lock.length(); i++){
            newLocks.add(plusOne(lock, i));
            newLocks.add(minusOne(lock, i));
        }
        return newLocks;
    }
    public String plusOne(String lock, int index) {
        char[] locks = lock.toCharArray();
        if (locks[index]=='9'){
            locks[index] = '0';
        } else {
            locks[index] += 1;
        }
        return new String(locks);
    }
    public String minusOne(String lock, int index){
        char[] locks = lock.toCharArray();
        if (locks[index]=='0'){
            locks[index] = '9';
        } else {
            locks[index] -= 1;
        }
        return new String(locks);
    }
    public boolean hasDead(String[] deadends, String cur){
        for (String dead: deadends){
            if (dead.equals(cur)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";
        OpenTheLock openTheLock = new OpenTheLock();
        int result = openTheLock.openLock(deadends, target);
        System.out.println(result);
    }
}
