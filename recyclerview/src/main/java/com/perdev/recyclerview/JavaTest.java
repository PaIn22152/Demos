package com.perdev.recyclerview;

import java.util.*;

/**
 * Project    demos-git
 * Path       com.perdev.recyclerview
 * Date       2019/12/02 - 16:01
 * Author     Payne.
 * About      类描述：
 */
public class JavaTest {

    private static void test(int i) {
        switch (i) {
            case 0:

                break;
            case 1:

                break;
            default:

                break;
        }


    }


    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums) {
            int num = 1;
            if (hashMap.containsKey(i)) {
                num = hashMap.get(i) + 1;
            }
            hashMap.put(i, num);
        }
        int res = Integer.MIN_VALUE;
        int lastNum = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> tem : hashMap.entrySet()) {
            if (lastNum < tem.getValue()) {
                res = tem.getKey();
                lastNum = tem.getValue();
            }
        }
        return res;
    }


//    public int reverseBits(int n) {
//        Integer i = Integer.bitCount(n);
//    }


    public static void main(String[] args) {
        int n = 11;
        int n1 = n << 1;
        System.out.println(n1);
    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n >> 1 > 0) {
            if (n % 2 == 1) {
                res++;
            }
            n = n >> 1;
        }
        if (n % 2 == 1) {
            res++;
        }
        return res;

    }

    public int singleNumber(int[] nums) {
        int n = 0;
        for (int i : nums) {
            n = n ^ i;
        }
        return n;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            if (res == 0) {
                res = head.val;
            } else {
                res = res * 2 + head.val;
            }

            head = head.next;
        }
        return res;
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        int tem;
        for (int left = 1; left < 9; left++) {
            tem = left;
            for (int right = left + 1; right <= 9; right++) {
                tem = tem * 10 + right;
                if (tem >= low && tem <= high) {
                    res.add(tem);
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    private static String g() {

        return "";
    }

//    private char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

    HashSet<Character> vowels;

    private boolean isVowel(char c) {
        if (vowels == null) {
            vowels = new HashSet<>();
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');
            vowels.add('A');
            vowels.add('E');
            vowels.add('I');
            vowels.add('O');
            vowels.add('U');
        }
        return vowels.contains(c);
    }

    //"race car"
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        char tem = '0';
        while (left < right) {
            if (isVowel(tem)) {
                char c = chars[right];
                if (isVowel(c)) {
                    chars[right] = tem;
                    chars[left] = c;
                    tem = '0';
                    right--;
                    left++;
                } else {
                    right--;
                }
            } else {
                char c = chars[left];
                if (isVowel(c)) {
                    tem = c;
                } else {
                    left++;
                }
            }
        }
        return new String(chars);
    }

    public String reverseVowels2(String s) {
        List<Integer> pos = new ArrayList<>();
        List<Character> letter = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isVowel(chars[i])) {
                pos.add(i);
                letter.add(chars[i]);
            }
        }
        for (int i = 0; i < pos.size(); i++) {
            chars[pos.get(i)] = letter.get(pos.size() - 1 - i);
        }
        return new String(chars);

    }

    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int num = n / 3;
        int r = n % 3;
        if (r == 0) {
            return (int) Math.pow(3, num);
        }
        if (r == 1) {
            return (int) Math.pow(3, num - 1) * 4;
        } else //r==2
        {
            return (int) Math.pow(3, num) * 2;
        }
    }

    public int integerBreak2(int n) {
        switch (n) {
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 4;
            case 5:
                return 6;
            default:
                return integerBreak6(n);
        }

    }

    private int integerBreak6(int n) {
        List<Integer> list = new ArrayList<>();
        while (n >= 6) {
            list.add(3);
            n -= 3;
            if (n == 5) {
                list.add(3);
                list.add(2);
            }
            if (n == 4) {
                list.add(4);
            }
            if (n == 3) {
                list.add(3);
            }
        }
        int res = 1;
        for (int i : list) {
            res *= i;
        }
        return res;
    }


    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char tem = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tem;
        }
    }


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int tem = head.val;
        head.val = head.next.val;
        head.next.val = tem;
        head.next.next = swapPairs(head.next.next);
        return head;
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> last = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || i == j) {
                    list.add(1);
                } else {
                    list.add(last.get(j - 1) + last.get(j - 2));
                }

            }
            res.add(list);
            last.clear();
            last.addAll(list);
        }
        return res;

    }


    public List<Integer> getRow2(int rowIndex) {
        rowIndex++;
        List<Integer> last = new ArrayList<>();
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || i == j) {
                    list.add(1);
                } else {
                    list.add(last.get(j - 1) + last.get(j - 2));
                }

            }
            last.clear();
            last.addAll(list);
        }
        return last;
    }


    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= rowIndex; i++) {
            if (i == 1 || i == rowIndex) {
                res.add(1);
            } else {
                res.add(getI(rowIndex, i));
            }
        }
        return res;
    }

    private Integer getI(int rowIndex, int num) {
        if (num == 1 || num == rowIndex) {
            return 1;
        } else return getI(rowIndex - 1, num - 1) + getI(rowIndex - 1, num);
    }


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        ListNode last = null;
        for (int i = 0; i < list.size(); i++) {
            ListNode tem = new ListNode(list.get(i));
            tem.next = last;
            last = tem;
        }
        return last;
    }


    public ListNode reverseList2(ListNode head) {
        ListNode l1 = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tem = new ListNode(curr.val);
            tem.next = l1;
            l1 = tem;
            curr = curr.next;
        }
        return l1;
    }

    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


}
