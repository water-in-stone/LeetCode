package leetcode.array;

import java.util.*;

/**
 * @author baikal on 2019-03-08
 * @project Algorithm
 * 把每1个素数对应1个字母，计算它们的乘积，作为key放入到HashMap中
 */
public class _49_GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<Integer, ArrayList<String>> hashMap = new HashMap<>();
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        for (String s : strs) {
            int primeProduct = 1;
            for (Character c : s.toCharArray()) {
                primeProduct *= primes[c - 'a'];
            }
            ArrayList<String> strArr = hashMap.get(primeProduct);
            if (strArr != null) {
                strArr.add(s);
            } else {
                ArrayList<String> newStrArr = new ArrayList<>();
                newStrArr.add(s);
                hashMap.put(primeProduct, newStrArr);
                res.add(newStrArr);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] strArr = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> res = groupAnagrams(strArr);
        System.out.println(res);
    }
}
