import java.util.*;
import java.util.Map.Entry;

public class LeetCode {

    public static int fib(int n) {
        int t1 = 0;
        int t2 = 1;
        int t3;
        for (int i = 0; i < n; i++) {
            t3 = t1 + t2;
            t1 = t2;
            t2 = t3;
        }
        return t1;
    }

    public static int findSpecialInteger(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int j : arr) {
            if (!hashMap.containsKey(j)) hashMap.put(j, 1);
            else hashMap.put(j, hashMap.get(j) + 1);
        }
        System.out.println("Array Length: " + arr.length);
        System.out.println("Hashmap: " + hashMap);
        double requiredOccurrence = (arr.length * (25.00 / 100.00));
        for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Key: " + key + " percentage: " + (float) value / (arr.length - value));
            if (value > requiredOccurrence) return key;
        }
        return -1;
    }

    public static int maxSubarraySumCircular(int[] array) {
        /* linear sum, kadane's algo */
        int maxLinearSum = array[0];
        int maxLinearEnding = array[0];
        for (int i = 1; i < array.length; i++) {
            maxLinearEnding = Math.max(maxLinearEnding + array[i], array[i]);
            maxLinearSum = Math.max(maxLinearSum, maxLinearEnding);
        }

        /* check if array contains all negative elements */
        if (maxLinearSum < 0) return maxLinearSum;

        /* circular sum, modified kadane's algo */
        int minCircularSum = array[0];
        int minCircularEnding = array[0];
        int totalArraySum = array[0];
        for (int i = 1; i < array.length; i++) {
            totalArraySum += array[i];
            minCircularEnding = Math.min(minCircularEnding + array[i], array[i]);
            minCircularSum = Math.min(minCircularSum, minCircularEnding);
        }
        int maxCircularSum = totalArraySum - minCircularSum;
        return Math.max(maxCircularSum, maxLinearSum);
    }

    public static int maxSubArray(int[] array) {
        /* Kadane's Algo */
        int maxEnding = array[0];
        int maxSum = array[0];
        for (int i = 1; i < array.length; i++) {
            maxEnding = Math.max(maxEnding + array[i], array[i]);
            maxSum = Math.max(maxSum, maxEnding);
        }
        return maxSum;
    }

    public static boolean threeConsecutiveOdds(int[] array) {
        if (array.length < 3) return false;
        else {
            if (array.length == 3) {
                return array[0] % 2 != 0 && array[1] % 2 != 0 && array[2] % 2 != 0;
            }
            for (int i = 0; i < array.length - 2; i++) {
                if (array[i] % 2 != 0 && array[i + 1] % 2 != 0 && array[i + 2] % 2 != 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public static int findMaxConsecutiveOnes(int[] array) {
        int maxCons1s = 0;
        int currCons1s = 0;
        for (int element : array) {
            if (element == 1) {
                currCons1s++;
                maxCons1s = Math.max(maxCons1s, currCons1s);
            } else {
                currCons1s = 0;
            }
        }
//		System.out.println ( maxCons1s );
        return maxCons1s;
    }

    public static int maxPower(String s) {
        int maxOccur = 1;
        int currOccur = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                currOccur++;
                maxOccur = Math.max(maxOccur, currOccur);
            } else {
                currOccur = 1;
            }
        }
        return maxOccur;
    }

    public static int alternateDigitSum(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (n != 0) {
            arrayList.add(n % 10);
            n /= 10;
        }
        Collections.reverse(arrayList);
        int result = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (i % 2 == 0) {
                result += arrayList.get(i);
            } else {
                result -= arrayList.get(i);
            }
        }
        return result;
    }

    public static int diagonalSum(int[][] mat) {
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;
        for (int i = 0; i < mat.length; i++) {
            primaryDiagonalSum += mat[i][i];
            secondaryDiagonalSum += mat[i][mat.length - i - 1];
            if (mat.length % 2 != 0 && i == mat.length / 2 && i == mat[i].length / 2) secondaryDiagonalSum -= mat[i][i];
        }
        return primaryDiagonalSum + secondaryDiagonalSum;
    }

    public static LinkedListNode reverseKGroup(LinkedListNode head, int k) {
        LinkedListNode.printSingleLinkedList(head);
        LinkedListNode currentHead = head;
        LinkedListNode next = null;
        LinkedListNode previous = null;
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (currentHead == null) return head;
            currentHead = currentHead.next;
        }
        currentHead = head;
        while (currentHead != null && count < k) {
            next = currentHead.next;
            currentHead.next = previous;
            previous = currentHead;
            currentHead = next;
            count++;
        }
        if (next != null) head.next = reverseKGroup(next, k);
        LinkedListNode.printSingleLinkedList(previous);
        return previous;
    }

    public static Node copyRandomList(Node head) {
        HashMap<Node, Node> hashMap = new HashMap<>();
        for (Node currentNode = head; currentNode != null; currentNode = currentNode.next)
            hashMap.put(currentNode, new Node(currentNode.data));
        for (Node currentNode = head; currentNode != null; currentNode = currentNode.next) {
            Node cloneCurrentNode = hashMap.get(currentNode);
            cloneCurrentNode.next = hashMap.get(currentNode.next);
            cloneCurrentNode.random = hashMap.get(currentNode.random);
        }
        return hashMap.get(head);
    }

    public static void main(String[] args) {
//		System.out.println ( fib ( 2 ) );   // 1
//		System.out.println ( fib ( 3 ) );   // 2
//		System.out.println ( fib ( 4 ) );   // 3

//		System.out.println ( findSpecialInteger ( new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10} ) );

//		System.out.println ( minSubArrayLen ( new int[]{2, 3, 1, 2, 4, 3}, 7 ) );  // 2
//		System.out.println ( minSubArrayLen ( new int[]{1, 4, 4}, 4 ) );  // 1
//		System.out.println ( minSubArrayLen ( new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 11 ) );  // 0
//		System.out.println ( minSubArrayLen ( new int[]{1, 2, 1, 4, 4, 1, 1, 1, 1, 11}, 11 ) );  // 1
//		System.out.println ( minSubArrayLen ( new int[]{1, 2, 1, 4, 4, 1, 1, 1, 1, 11}, 3 ) );  // 2
//		System.out.println ( minSubArrayLen ( new int[]{1, 2, 3, 4, 5}, 11 ) );  // 3

//		System.out.println ( threeConsecutiveOdds ( new int[]{2, 6, 4, 1} ) );  // false
//		System.out.println ( threeConsecutiveOdds ( new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12} ) ); // true
//		System.out.println ( threeConsecutiveOdds ( new int[]{3, 5} ) ); // false
//		System.out.println ( threeConsecutiveOdds ( new int[]{3, 5, 7} ) ); // true
//		System.out.println ( threeConsecutiveOdds ( new int[]{1, 1, 2, 1, 1} ) ); // false

//		System.out.println ( findMaxConsecutiveOnes ( new int[]{1, 1, 0, 1, 1, 1} ) ); // 3
//		System.out.println ( findMaxConsecutiveOnes ( new int[]{1, 0, 1, 1, 0, 1} ) ); // 2

//		System.out.println ( maxPower ( "leetcode" ) ); // 2
//		System.out.println ( maxPower ( "abbcccddddeeeeedcba" ) );  // 5

//		System.out.println ( minSubArrayLen ( new int[]{2, 3, 1, 2, 4, 3}, 7 ) );   // 2
//		System.out.println ( minSubArrayLen ( new int[]{1, 4, 4}, 4 ) );   // 1
//		System.out.println ( minSubArrayLen ( new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 11 ) );   // 0
//		System.out.println ( minSubArrayLen ( new int[]{1, 2, 3, 4, 5}, 11 ) );   // 3

//		System.out.println ( diagonalSum ( new int[][]{
//				{1, 2, 3},
//				{4, 5, 6},
//				{7, 8, 9},
//		} ) ); /// 25
//		System.out.println ( diagonalSum ( new int[][]{
//				{1, 1, 1, 1},
//				{1, 1, 1, 1},
//				{1, 1, 1, 1},
//				{1, 1, 1, 1},
//		} ) ); /// 8
//		System.out.println ( diagonalSum ( new int[][]{
//				{11, 2, 4},
//				{4, 5, 6},
//				{10, 8, -12},
//		} ) ); /// 18
//		System.out.println ( diagonalSum ( new int[][]{{5}} ) ); /// 5

        LinkedListNode head = new LinkedListNode(1);
//		head.next = head;
        LinkedListNode temp1 = new LinkedListNode(2);
        LinkedListNode temp2 = new LinkedListNode(3);
        LinkedListNode temp3 = new LinkedListNode(4);
        LinkedListNode temp4 = new LinkedListNode(5);
//        LinkedListNode temp5 = new LinkedListNode ( 6 );
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
//		temp4.next = temp5;

//		reverseKGroup ( head, 3 );

//		System.out.println ( subarraySum ( new int[]{1, -1, 0}, 0 ) );
//		System.out.println ( subarraySum ( new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0 ) );

//		System.out.println ( findClosestNumber ( new int[]{-4, -2, 1, 4, 8} ) );
//		System.out.println ( findClosestNumber ( new int[]{2, -1, 1} ) );

//		System.out.println ( sortSentence ( "is2 sentence4 This1 a3" ) );
//		System.out.println ( sortSentence ( "Myself2 Me1 I4 and3" ) );
//		System.out.println ( sortSentence ( "pTY1" ) );

//		System.out.println ( checkSubarraySum ( new int[]{23, 2, 6, 4, 7}, 5 ) );

//		System.out.println ( findTheDifference ( "abcd", "abcde" ) );
//		System.out.println ( findTheDifference ( "", "y" ) );

//		System.out.println ( mostCommonWord ( "Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"} ) );
//		System.out.println ( mostCommonWord ( "a.", new String[]{""} ) );

//		System.out.println ( isPowerOfTwo ( 3 ) );  // false
//		System.out.println ( isPowerOfTwo ( 8 ) );  // true
//		System.out.println ( isPowerOfTwo ( 4 ) );  // true

//		System.out.println ( removeDuplicates ( new int[]{1, 1, 2} ) ); /// 2
//		System.out.println ( removeDuplicates ( new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4} ) ); /// 5

//		System.out.println ( reverseOnlyLetters ( "ab-cd" ) );  // dc-ba
//		System.out.println ( reverseOnlyLetters ( "a-bC-dEf-ghIj" ) );  // j-Ih-gfE-dCba
//		System.out.println ( reverseOnlyLetters ( "Test1ng-Leet=code-Q!" ) );   // Qedo1ct-eeLg=ntse-T!

//		System.out.println ( reverseVowels ( "hello" ) );   // holle
//		System.out.println ( reverseVowels ( "leetcode" ) );   // leotcede

//        System.out.println(maxNumberOfBalloons("nlaebolko"));    // 1
//        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));    // 2
//        System.out.println(maxNumberOfBalloons("leetcode"));    // 0

        List<List<String>> paths = new ArrayList<>();
        ArrayList<String> path1 = new ArrayList<>();
        path1.add("jMgaf WaWA");    // key
        path1.add("iinynVdmBz");    // value
        ArrayList<String> path2 = new ArrayList<>();
        path2.add(" QCrEFBcAw");    // key
        path2.add("wRPRHznLWS");    // value
        ArrayList<String> path3 = new ArrayList<>();
        path3.add("iinynVdmBz");    // key
        path3.add("OoLjlLFzjz");    // value
        ArrayList<String> path4 = new ArrayList<>();
        path4.add("OoLjlLFzjz");    // key
        path4.add(" QCrEFBcAw");    // value
        ArrayList<String> path5 = new ArrayList<>();
        path5.add("IhxjNbDeXk");    // key
        path5.add("jMgaf WaWA");    // value
        ArrayList<String> path6 = new ArrayList<>();
        path6.add("jmuAYy vgz");    // key
        path6.add("IhxjNbDeXk");    // value
        paths.add(path1);
        paths.add(path2);
        paths.add(path3);
        paths.add(path4);
        paths.add(path5);
        paths.add(path6);
        System.out.println(destCity(paths));
        /**
         * jMgaf WaWA --> iinynVdmBz --> OoLjlLFzjz --> QCrEFBcAw --> wRPRHznLWS
         * while hashmap.containsKey(value)
         *      array.add(value);
         */
    }

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        for (int num : nums) {
            prefixSum += num;
            if (prefixSum == k) count++;
            if (hashMap.containsKey(prefixSum - k)) count += hashMap.get(prefixSum - k);
            hashMap.put(prefixSum, hashMap.getOrDefault(prefixSum, 0) + 1);
//			hashMap.put ( prefixSum, i );
        }
        return count;
    }

    // https://leetcode.com/problems/find-closest-number-to-zero/
    // Solution: https://leetcode.com/problems/find-closest-number-to-zero/solutions/2661091/c-easy-solution-tc-o-n-sc-o-1/
    // TODO: Internal Error, submit again
    public static int findClosestNumber(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        for (Integer integer : nums) {
            if (integer > 0) a = Math.min(a, integer);
            else b = Math.max(b, integer);
        }
        if (a == Integer.MAX_VALUE) return b;
        else if (b == Integer.MIN_VALUE) return a;
        else if (Math.abs(b) < a) return b;
        else return a;

        /**
         * Testcase Dry Run --> {-4, -2, 1, 4, 8}
         * -4: integer = -4, currentClosest = -4
         * -2: integer = -2, currentClosest = -2
         * 1: integer = 1, currentClosest = 1
         * 4: integer = 4,
         * 8: integer = 8,
         */
    }

    public static LinkedListNode sortList(LinkedListNode head) {
        if (head == null || head.next == null) return head;
        LinkedListNode middleNode = findMiddleNode(head);
        LinkedListNode head2 = middleNode.next;
        middleNode.next = null;
        LinkedListNode finalHead1 = sortList(head);
        LinkedListNode finalHead2 = sortList(head2);
        return merge(finalHead1, finalHead2);
    }

    public static LinkedListNode findMiddleNode(LinkedListNode head) {
        LinkedListNode slowPtr = head;
        LinkedListNode fastPtr = head.next;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public static LinkedListNode merge(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode merged = new LinkedListNode(0);
        LinkedListNode current = merged;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }
        while (head1 != null) {
            current.next = head1;
            head1 = head1.next;
            current = current.next;
        }
        while (head2 != null) {
            current.next = head2;
            head2 = head2.next;
            current = current.next;
        }
        return merged.next;
    }

    public static LinkedListNode partitionK(LinkedListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start < end) {
            int middle = (start + end) / 2;
            LinkedListNode l1 = partitionK(lists, start, middle);
            LinkedListNode l2 = partitionK(lists, middle + 1, end);
            return merge(l1, l2);
        } else return null;
    }

    public static LinkedListNode mergeK(LinkedListNode linkedListNode1, LinkedListNode linkedListNode2) {
        if (linkedListNode1 == null) return linkedListNode2;
        if (linkedListNode2 == null) return linkedListNode1;
        if (linkedListNode1.data < linkedListNode2.data) {
            linkedListNode1.next = mergeK(linkedListNode1.next, linkedListNode2);
            return linkedListNode1;
        } else {
            linkedListNode2.next = mergeK(linkedListNode1, linkedListNode2.next);
            return linkedListNode2;
        }
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1 || n == 2) return true;
        else if (n < 2) return false;
        while (n % 2 == 0 && n != 0) {
            if (n != 2) n = n / 2;
            else n = 0;
        }
        return n == 0;
    }

    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    public static String reverseOnlyLetters(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int i = 0, j = stringBuilder.length() - 1;
        while (i < stringBuilder.length() && i < j) {
            char ithChar = stringBuilder.charAt(i);
            char jthChar = stringBuilder.charAt(j);
            boolean ithLetterCondition = (ithChar >= 'a' && ithChar <= 'z')
                    || (ithChar >= 'A' && ithChar <= 'Z');
            boolean jthLetterCondition = (jthChar >= 'a' && jthChar <= 'z')
                    || (jthChar >= 'A' && jthChar <= 'Z');
            if (ithLetterCondition && jthLetterCondition) {
                char temp = ithChar;
                stringBuilder.setCharAt(i, jthChar);
                stringBuilder.setCharAt(j, temp);
                i++;
                j--;
            } else if (!ithLetterCondition) i++;
            else j--;
        }
        return stringBuilder.toString();
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0];
        int x1 = coordinates[1][0];
        int y0 = coordinates[0][1];
        int y1 = coordinates[1][1];
        int dx = x1 - x0;
        int dy = y1 - y0;
        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            if ((x - x0) * dy != (y - y0) * dx) return false;
        }
        return true;
    }

    public static String reverseVowels(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int i = 0;
        int j = stringBuilder.length() - 1;
        while (i < stringBuilder.length() && i < j) {
            char ithCharacter = stringBuilder.charAt(i);
            char jthCharacter = stringBuilder.charAt(j);
            boolean ithIsVowel = ithCharacter == 'a' || ithCharacter == 'A'
                    || ithCharacter == 'e' || ithCharacter == 'E'
                    || ithCharacter == 'i' || ithCharacter == 'I'
                    || ithCharacter == 'o' || ithCharacter == 'O'
                    || ithCharacter == 'u' || ithCharacter == 'U';
            boolean jthIsVowel = jthCharacter == 'a' || jthCharacter == 'A'
                    || jthCharacter == 'e' || jthCharacter == 'E'
                    || jthCharacter == 'i' || jthCharacter == 'I'
                    || jthCharacter == 'o' || jthCharacter == 'O'
                    || jthCharacter == 'u' || jthCharacter == 'U';
            if (ithIsVowel && jthIsVowel) {
                char temp = ithCharacter;
                stringBuilder.setCharAt(i, jthCharacter);
                stringBuilder.setCharAt(j, temp);
                i++;
                j--;
            } else if (!ithIsVowel) i++;
            else j--;
        }
        return stringBuilder.toString();
    }

    public static double findMedianSortedArrays(int[] array1, int[] array2) {
        if (array1.length == 0 && array2.length == 0) return 0;
        if (array1.length == 0) {
            if (array2.length % 2 == 0)
                return (double) (array2[array2.length / 2 - 1] + array2[array2.length / 2]) / 2;
            else return array2[array2.length / 2];
        } else if (array2.length == 0) {
            if (array1.length % 2 == 0)
                return (double) (array1[array1.length / 2 - 1] + array1[array1.length / 2]) / 2;
            else return array1[array1.length / 2];
        }
        int[] nums1 = array1, nums2 = array2;
        if (array1.length > array2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int left1 = 0, right1 = nums1.length;
        int n1 = nums1.length, n2 = nums2.length;
        while (left1 <= right1) {
            int i1 = left1 + (right1 - left1) / 2;
            int i2 = (n1 + n2 + 1) / 2 - i1;

            int min1 = (i1 == n1) ? Integer.MAX_VALUE : nums1[i1];
            int max1 = (i1 == 0) ? Integer.MIN_VALUE : nums1[i1 - 1];
            int min2 = (i2 == n2) ? Integer.MAX_VALUE : nums2[i2];
            int max2 = (i2 == 0) ? Integer.MIN_VALUE : nums2[i2 - 1];

            if (max1 <= min2 && max2 <= min1) {
                if ((n1 + n2) % 2 == 0) {
                    return ((double) Math.max(max1, max2) + (double) Math.min(min1, min2)) / 2;
                } else return (double) Math.max(max1, max2);
            } else if (max1 > min2) right1 = i1 - 1;
            else left1 = i1 + 1;
        }
        return -1;
    }

    public static int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int balloonCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n')
                hashMap.put(text.charAt(i), hashMap.getOrDefault(text.charAt(i), 0) + 1);
        }
        while (isValidBalloon(hashMap)) {
            balloonCount++;
            hashMap.put('b', hashMap.get('b') - 1);
            hashMap.put('a', hashMap.get('a') - 1);
            hashMap.put('n', hashMap.get('n') - 1);
            hashMap.put('o', hashMap.get('o') - 2);
            hashMap.put('l', hashMap.get('l') - 2);
        }
        return balloonCount;
        /**
         * balloon
         * valid = 1a, 1b, 1n, 2l, 2o
         */
    }

    public static boolean isValidBalloon(HashMap<Character, Integer> hashMap) {
        boolean isValid = false;
        if (hashMap.containsKey('b') && hashMap.containsKey('a')
                && hashMap.containsKey('n') && hashMap.containsKey('l') && hashMap.containsKey('o')) {
            isValid = hashMap.get('b') >= 1 && hashMap.get('a') >= 1
                    && hashMap.get('l') >= 2 && hashMap.get('o') >= 2 && hashMap.get('n') >= 1;
        }
        return isValid;
    }

    public static String destCity(List<List<String>> paths) {
        System.out.println(paths);
        LinkedHashMap<String, String> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < paths.size(); i++)
            hashMap.put(paths.get(i).get(0), paths.get(i).get(1));
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(paths.get(0).get(0));
        String value = paths.get(0).get(1);
        while (hashMap.containsKey(value)) {
            value = hashMap.get(value);
            arrayList.add(value);
        }
        return arrayList.size() == 1 ? paths.get(0).get(1) : arrayList.get(arrayList.size() - 1);
    }

    public boolean kLengthApart(int[] nums, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) if (nums[i] == 1) arrayList.add(i);
        for (int i = 0; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i + 1) - arrayList.get(i) < k + 1) return false;
        }
        return true;
    }

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int integer : arr)
            hashMap.put(integer, hashMap.getOrDefault(integer, 0) + 1);
        HashSet<Integer> hashSet = new HashSet<>(hashMap.values());
        return hashSet.size() == hashMap.size();
    }

    public boolean isPowerOfThree(int n) {
        if (n == 1 || n == 3) return true;
        else if (n < 3) return false;
        while (n % 3 == 0 && n != 0) {
            if (n != 3) n = n / 3;
            else n = 0;
        }
        return n == 0;
    }

    public LinkedListNode mergeKLists(LinkedListNode[] lists) {
        return partitionK(lists, 0, lists.length - 1);
    }

    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        for (Integer integer : nums) hashMap.put(integer, hashMap.getOrDefault(integer, 0) + 1);
        for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 1) sum += key;
        }
        return sum;
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for (List<String> item : items) {
            if (Objects.equals(ruleKey, "color")) {
                if (Objects.equals(item.get(1), ruleValue)) count++;
                System.out.println(ruleKey);
            } else if (Objects.equals(ruleKey, "type")) {
                if (Objects.equals(item.get(0), ruleValue)) count++;
            }
        }
        return count;
    }

    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int largestGap = 0;
        if (nums.length == 1) return 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] > largestGap) largestGap = nums[i + 1] - nums[i];
        }
        return largestGap;
    }

    public int findPeakElement(int[] nums) {
        /*int largestElementIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[ largestElementIndex ] < nums[ i ]) largestElementIndex = i;
        }
        return largestElementIndex;*/
        int first = 0;
        int last = nums.length - 1;
        while (first < last) {
            int mid = (first + (last - first)) / 2;
            if (nums[mid] > nums[mid + 1]) last = mid;
            else first = mid + 1;
        }
        return first;
    }

    public void deleteGivenNode(LinkedListNode node) {
        if (node == null || node.next == null) return;
        LinkedListNode nodeToBeDeleted = node;
        node.next.data = node.data;
        node.next = node.next.next;
    }

    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer integer : nums) {
            if (integer % 2 == 0) hashMap.put(integer, hashMap.getOrDefault(integer, 0) + 1);
        }
        int maxValue = Integer.MIN_VALUE;
        for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            maxValue = Math.max(maxValue, value);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (key % 2 == 0 && value == maxValue) arrayList.add(key);
        }
        if (arrayList.isEmpty()) arrayList.add(-1);
        return arrayList.size() > 1 ? Collections.min(arrayList) : arrayList.get(0);
    }

    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer integer : arr)
            hashMap.put(integer, hashMap.getOrDefault(integer, 0) + 1);
        int result = -1;
        for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (Objects.equals(key, value)) {
                if (Objects.equals(key, value)) {
                    result = Math.max(result, key);
                }
            }
        }
        return result;
    }

    public int arraySign(int[] nums) {
        int countNeg = 0;
        for (Integer integer : nums) {
            if (integer == 0) return 0;
            else if (integer < 0) countNeg++;
        }
        if (countNeg % 2 == 0) return 1;
        else return -1;
    }

    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) count++;
        }
        return count * 100 / s.length();
    }

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i % nums.length]) {
                stack.pop();
            }
            if (stack.isEmpty()) result[i % nums.length] = -1;
            else result[i % nums.length] = stack.peek();
            stack.push(nums[i % nums.length]);
        }
        return result;
    }

    public String reverseWords(String s) {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(s.split(" ")));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder(arrayList.get(i));
            stringBuilder.reverse();
            if (i == arrayList.size() - 1) result.append(stringBuilder);
            else result.append(stringBuilder).append(" ");
        }
        return result.toString();
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return heightDiff(root) != -1;
    }

    public int heightDiff(TreeNode root) {
        if (root == null) return 0;
        int lh = heightDiff(root.left);
        if (lh == -1) return -1;
        int rh = heightDiff(root.right);
        if (rh == -1) return -1;
        return Math.abs(lh - rh) > 1 ? -1 : Math.max(lh, rh) + 1;
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        int maxLength = -1;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                maxLength = Math.max(maxLength, i - hashMap.get(s.charAt(i)) - 1);
            } else {
                hashMap.put(s.charAt(i), i);
            }
        }
        return maxLength;
    }

    public boolean checkIfPangram(String sentence) {
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            hashSet.add(sentence.charAt(i));
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (!hashSet.contains(ch)) return false;
        }
        return true;
    }

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        HashSet<Integer> hashSet3 = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();
        for (int x : nums1) hashSet1.add(x);
        for (int x : nums2) hashSet2.add(x);
        for (int x : nums3) hashSet3.add(x);
        for (int x : hashSet1) {
            if (hashSet2.contains(x) || hashSet3.contains(x)) ans.add(x);
        }
        for (int x : hashSet2) {
            if (hashSet3.contains(x)) ans.add(x);
        }
        return new ArrayList<>(ans);
    }

    static class MyCircularQueue {

        int front, rear, capacity, size;
        int[] array;

        public MyCircularQueue(int k) {
            capacity = k;
            size = 0;
            front = 0;
            rear = capacity - 1;
            array = new int[capacity];
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;
            rear = (rear + 1) % capacity;
            array[rear] = value;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            front = (front + 1) % capacity;
            size--;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : array[front];
        }

        public int Rear() {
            return isFull() ? -1 : array[rear];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

    static class MyQueue {

        int currentSize;

        Stack<Integer> stack1 = new Stack<>();

        Stack<Integer> stack2 = new Stack<>();

        public MyQueue() {
            currentSize = 0;
        }

        public void push(int x) {
            currentSize++;
            stack1.push(x);
        }

        public int pop() {
            currentSize--;
            while (!stack1.empty()) stack2.push(stack1.pop());
            int poppedData = stack2.pop();
            while (!stack2.empty()) stack1.push(stack2.pop());
            return poppedData;
        }

        public int peek() {
            while (!stack1.empty()) stack2.push(stack1.pop());
            int peekData = stack2.peek();
            while (!stack2.empty()) stack1.push(stack2.pop());
            return peekData;
        }

        public boolean empty() {
            return currentSize == 0;
        }
    }
}
