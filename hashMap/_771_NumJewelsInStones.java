package leetcode.hashMap;

import java.util.*;

/**
 * @author baikal on 2019-07-22
 * @project Algorithm
 */
public class _771_NumJewelsInStones {
    public static int numJewelsInStones(String J, String S) {
        if (J == null || S == null) {
            return 0;
        }
        if (J.equals("") || S.equals("")) return 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int count = 0;
        char[] jCharArray = J.toCharArray();
        for (int i = 0; i < jCharArray.length; i++) {
            hashMap.put(jCharArray[i], i);
        }
        char[] sCharArray = S.toCharArray();
        for (int i = 0; i < sCharArray.length; i++) {
            if (hashMap.get(sCharArray[i]) != null) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String J = "aA";
//        String S = "aAAbbbb";
        String S = "";
        System.out.println(numJewelsInStones(J, S));
    }
}
