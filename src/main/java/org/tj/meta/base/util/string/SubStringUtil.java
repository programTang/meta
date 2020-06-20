package org.tj.meta.base.util.string;

import org.springframework.util.StringUtils;

import java.util.*;

public class SubStringUtil {


    /**
     * 判断一个str是否是在完全循环重复的某个最小子串（不包括自身），如果是则返回重复了几次；否则-1
     * “abccabccabccabccabcc” 返回 5
     * 分成左右两个子串，如果左右重复，继续分，直到不重复。
     * 如果左右不重复，
     * @param str
     * @return
     */
    public int getSubStringNum(String str){
        if (StringUtils.isEmpty(str) || str.length() <= 1){
            return -1;
        }
        return getViolenceSubStringNums(str);
    }

    /**
     * 暴力求解 从子串=1开始递增
     * 时间复杂度 n的平方
     * @param str
     * @return
     */
    public int getViolenceSubStringNums(String str){
        for (int i = 1; i <= str.length()/2; i++) {
            //i 代表子串长度，最长是字符串一半长度
            String subStr = str.substring(0, i);
//            System.out.println(subStr);
//            System.out.println("i:"+i);
            int j = i;
            for (; j < str.length(); j+=i) {
//                System.out.println("j:"+j);
                if ((j+i) >str.length() || !subStr.equals(str.substring(j, j+i))){
                    break;
                }
            }
            if (j == str.length()){
                System.out.println("循环子串："+ subStr);
                return j/i;
            }
        }
        return -1;
    }


    /**
     * 3. 无重复字符的最长子串: "pwwkew" -> "wke","abcabcbb" -> "abc"
     * 类似于滑块往右滑动，依次比较滑块长度，保留比较大的值
     * @param str 字符串
     * @return 最长子串的长度
     */
    public int lengthOfLongestSubString(String str ){
        if (str == null){
            return 0;
        }
        //存放子串每个字符的位置
//        Map<Character,Integer> charIndexMap = new HashMap<>();
        //队列 存放滑块
        Queue<Character> queue = new LinkedList();
//        int left = 0, right = 0;
        int length = 0;
        for (int i = 0; i < str.length(); i++) {
            Character character = str.charAt(i);
//            if (charIndexMap.containsKey(character)){
            if (queue.contains(character)){
                //"abcd"->b，那么应该将左指针移到b的下一位c，移除ab，同时记录长度。
                //当前子串长度
//                int currentLength =  (right-left)+1;
                int currentLength = queue.size();
                //将 b前面的包含b 都出队
                while (!queue.poll().equals(character));
                queue.add(character);

//                Character character1 = queue.poll();
                //左指针移到b的下一位
//                left = charIndexMap.get(character)+1;
                //左指针前面的出队
//                que
                //
//                charIndexMap.put(character, i);
                length = length > currentLength?length:currentLength;
            }else {
                //加到map里，同时 right 指向该位置
//                charIndexMap.put(character, i);
                //入队
                queue.add(character);
//                right = i;
            }
        }
//        int currentLength =  (right-left)+1;
        int currentLength = queue.size();
        length = length > currentLength?length:currentLength;
        return length;
    }

    public int lengthOfLongestSubstringMap(String str) {
        if (str == null || "".equals(str)){
            return 0;
        }
        //存放子串每个字符的位置
        Map<Character,Integer> charIndexMap = new HashMap<>();
        int left = 0, right = 0;
        int length = 0;
        for (int i = 0; i < str.length(); i++) {
            Character character = str.charAt(i);
            if (charIndexMap.containsKey(character) && left <= charIndexMap.get(character) && charIndexMap.get(character) >= right){
                //"abcd" 包含了b，并且b处在滑块中，那么应该从 cd 往右移。同时记录长度,left应该跳到 b 的下一位
                //当前子串长度
                int currentLength =  (right-left)+1;
                left = charIndexMap.get(character)+1;
                charIndexMap.put(character, i);
                length = length > currentLength?length:currentLength;
            }else {
                //加到map里，同时 right 指向该位置
                charIndexMap.put(character, i);
                right = i;
            }
        }
        int currentLength =  (right-left)+1;
        length = length > currentLength?length:currentLength;
        return length;
    }

//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length(), ans = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int end = 0, start = 0; end < n; end++) {
//            char alpha = s.charAt(end);
//            if (map.containsKey(alpha)) {
//                start = Math.max(map.get(alpha), start);
//            }
//            ans = Math.max(ans, end - start + 1);
//            map.put(s.charAt(end), end + 1);
//        }
//        return ans;
//    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){}

        ListNode(int x) { val = x; }

        ListNode add(int x){
            ListNode listNode = new ListNode(x);
            this.next = listNode;
            return this.next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 != null){
            return l2;
        }
        if(l2 == null && l1 != null){
            return l1;
        }
        if(l1 ==null && l1 == null){
            return null;
        }
        //处理首节点
        int val = l1.val + l2.val;
        int jinwei = 0;
        if(val >= 10){
            val = val%10;
            jinwei = 1;
        }
        ListNode sumNode = new ListNode(val);
        ListNode nextNode = new ListNode();
        sumNode.next = nextNode;
        while(l1.next != null || l2.next != null || jinwei == 1){
            val = getVal(l1.next) + getVal(l2.next) + jinwei;
            if(val >= 10){
                val = val%10;
                jinwei = 1;
            }else{
                jinwei = 0;
            }
//            nextNode = new ListNode(val);
            nextNode.val = val;
            if(l1.next != null){
                l1 = l1.next;
            }
            if(l2.next != null){
                l2 = l2.next;
            }
            nextNode.next = new ListNode();
            nextNode = nextNode.next;
        }
        //去掉尾结点
        ListNode listNode = sumNode;
        while (listNode.next != nextNode){
            listNode = listNode.next;
        }
        listNode.next = null;
        return sumNode;
    }

    public int getVal(ListNode node){
        if(node == null){
            return 0;
        }
        return node.val;
    }


    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     *
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if(s == null) return false;
        if(s.length()<2) return true;
        //左右指针遍历s
        for(int left=0,right = s.length()-1;left < right; ){
            int leftC = s.charAt(left);
            int rightC = s.charAt(right);

            if(!isCharOrNumber(leftC)){
                left++;
                continue;
            }
            if(!isCharOrNumber(rightC)){
                right--;
                continue;
            }
            //左右都是字母或数组
            if(!equalsChar(leftC, rightC)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    boolean isCharOrNumber(int c){
        if((97<=c && c<=122)
                ||(65<=c && c<=90)
                ||(48<=c && c<=57)){
            return true;
        }
        return false;
    }

    boolean equalsChar(int a, int b){
        //只要其中一个是数字 要绝对相等
        if((48<=a && a<=57) || (48<=b && b<=57)){
            return a==b;
        }
        return a==b || Math.abs(a-b)==32;
    }

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 123
     * 取余，减去余数/10，相当于移除最右位，直到当前值小于10
     * 依次放到数组里，后续取出
     * @param x
     * @return
     */
    public int reverse(int x) {
        boolean negtive = false;
        if (x<0){
            if (x == Integer.MIN_VALUE){
                return 0;
            }
            x = Math.abs(x);
            negtive = true;
        }
        List<Integer> list = new ArrayList<>();

        while (x>=10){
            int right = x%10;
            list.add(right);
            x = (x-right)/10;
        }
        //处理第一位
        list.add(x);
        int reserve = 0;
        for (int i = 0; i < list.size(); i++) {
            reserve += list.get(i)*(Math.pow(10, list.size()-i-1));
            if (reserve >= Integer.MAX_VALUE){
                return 0;
            }
        }
        return negtive?-reserve:reserve;
    }



    public static void main(String[] args) {
//        System.out.println(new SubStringUtil().getSubStringNum("ababababab"));
//        System.out.println(new SubStringUtil().getSubStringNum("a"));
//        System.out.println(new SubStringUtil().getSubStringNum("aaaaa"));
//        System.out.println(new SubStringUtil().lengthOfLongestSubString("aaaaa"));
//        System.out.println(new SubStringUtil().lengthOfLongestSubString("a"));
//        System.out.println(new SubStringUtil().lengthOfLongestSubString("ababababab"));
//        System.out.println(new SubStringUtil().lengthOfLongestSubString("aabaab!bb"));
//        System.out.println(new SubStringUtil().lengthOfLongestSubstringMap("aabaab!bb"));
//        ListNode l1 = new ListNode(2);
//        l1.add(4).add(3);
//        ListNode l2 = new ListNode(5);
//        l2.add(6).add(4);
//        System.out.println(new SubStringUtil().addTwoNumbers(l1, l2));
//        Character character = new Character('a');
//        System.out.println((int)character);
//        System.out.println((int)'z');
//        System.out.println((int)'A');
//        System.out.println((int)'Z');
//        System.out.println((int)'0');
//        System.out.println((int)'1');
//        System.out.println((int)'9');
//        System.out.println(new SubStringUtil().isPalindrome("race a car"));

//        System.out.println(l1);
//        System.out.println(l1.next.next);
        System.out.println(new SubStringUtil().reverse(-2147483648));
    }


}
