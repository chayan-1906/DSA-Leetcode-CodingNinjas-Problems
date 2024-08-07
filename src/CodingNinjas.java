import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public class CodingNinjas {

    public static void deleteMiddle(Stack<Integer> inputStack, int N) {
        int i = 0;
        while (i < N / 2) {
            i++;
        }
        inputStack.removeElementAt(i);
    }

    public static int[] sumOfEvenOdd(long num, int evenSum, int oddSum) {
        while (num != 0) {
            if (num % 2 == 0) {
                evenSum += num % 10;
            } else {
                oddSum += num % 10;
            }
            num /= 10;
        }
        System.out.println("evensum = " + evenSum + "oddsum = " + oddSum);
        return new int[]{evenSum, oddSum};
    }

    public static void moveZerosToLeft(int[] arr, int n) {

    }

    public static long findFact(int n) {
        if (n == 1) return 1;
        return (n * findFact(n - 1)) % 1000000007;
    }

    public static long fibonacci(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static long sumOrProduct(int n, int q) {
        long ans = 0;
        // Write your code here
        if (q == 1) {
            // sum
            ans = fibonacci(n);
        } else if (q == 2) {
            // product
            ans = findFact(n);
        }
        return ans;
    }

    public static int firstMissing(int[] arr, int n) {
        /*Arrays.sort ( arr );
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<> ( );
        for (int integer : arr) {
            if (integer > 0) hashSet.add ( integer );
        }
        for (int i = 0; i < hashSet.size ( ); i++) {
            if (!hashSet.contains ( i + 1 )) return i + 1;
        }
        return hashSet.size ( ) + 1;*/
        // Alternative Approach with O(n)
        Arrays.sort(arr);
        int x = 1;
        for (int integer : arr) if (integer == x) ++x;
        return x;
    }

    public static int findDuplicate(ArrayList<Integer> arr, int n) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (count.containsKey(arr.get(i))) {
                count.put(arr.get(i), count.get(arr.get(i)) + 1);
            } else {
                count.put(arr.get(i), 1);
            }
            /*for (int j = i + 1; j < n; j++) {
                if (arr.toArray ( )[ i ] == arr.toArray ( )[ j ]) {
                    return (int) arr.toArray ( )[ i ];
                }
            }*/
        }
        for (Entry<Integer, Integer> entry : count.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value > 1) return key;
        }
        return -1;
    }

    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {
        int firstIndex = arr.indexOf(k);
        int lastIndex = arr.lastIndexOf(k);
        /*int firstIndex = -1, lastIndex = -1;
        for (int i = 0; i < n; i++) {
            if (arr.get ( i ) == k) {
                firstIndex = i;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr.get ( i ) == k) {
                lastIndex = i;
            }
        }*/
        return new int[]{firstIndex, lastIndex};
    }

    public static int binarySearch(int[] arr, int x) {
        int last = arr.length - 1;
        return bSearch(arr, 0, last, x);
    }

    public static int bSearch(int[] arr, int first, int last, int key) {
        if (first <= last) {
            int mid = first + (last - first) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] > key) return bSearch(arr, first, mid - 1, key);
            else return bSearch(arr, mid + 1, last, key);
        }
        return -1;
    }

    /*public static Pair findFirstLastPosition(ArrayList<Integer> arr, int n, int x) {
        Pair pair = new Pair();
        pair.first = arr.indexOf(x);
        pair.second = arr.lastIndexOf(x);
        return pair;
    }*/

    public static ArrayList<Integer> findSimilarity(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m) {
        int intersection = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer item : arr1) {
            if (map.containsKey(item)) map.put(item, map.get(item) + 1);
            else map.put(item, 1);
        }
        for (Integer item : arr2) {
            if (map.containsKey(item)) map.put(item, map.get(item) + 1);
            else map.put(item, 1);
        }
        for (Integer value : map.values()) {
            if (value > 1) intersection++;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(intersection);
        arrayList.add(map.keySet().size());
        return arrayList;
    }

    public static void reverseArray(ArrayList<Integer> arr, int m) {
        for (int i = m + 1, j = 0; i < arr.size(); i++, j++) {
            if (i <= m + (arr.size() - m) / 2) {
                int temp = arr.get(i);
                arr.set(i, arr.get(arr.size() - j - 1));
                arr.set((arr.size() - j - 1), temp);
            }
        }
        System.out.println(Arrays.toString(arr.toArray()));
    }

    public static int findUnique(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int j : arr) {
            if (map.containsKey(j)) map.put(j, map.get(j) + 1);
            else map.put(j, 1);
        }
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(map);
            if (value == 1) return key;
        }
        return -1;
    }

    public static int sumOfMaxMin(int[] arr, int n) {
        int smallest = arr[0];
        int largest = arr[arr.length - 1];
        for (int j : arr) {
            if (j < smallest) smallest = j;
            if (j > largest) largest = j;
        }
        return smallest + largest;
    }

    public static void rotateArrayKSteps(int[] arr, int kSteps) {
//		System.out.println ( kSteps + " -- " + Arrays.toString ( arr ) );
        while (kSteps != 0) {
            int firstElement = arr[0];
            for (int i = 0; i < arr.length; i++) {
//				System.out.println ( "first: " + firstElement );
                if (i == arr.length - 1) {
                    arr[i] = arr[arr.length - 1];
                } else {
                    arr[i] = arr[i + 1];
                }
//				System.out.println ( kSteps + " -- " + Arrays.toString ( arr ) );
            }
            arr[arr.length - 1] = firstElement;
//			System.out.println ( kSteps + " -- " + Arrays.toString ( arr ) );
            kSteps--;
        }
    }

    public static int findPosition(ArrayList<Integer> arr, int n, int k) {
        if (arr.size() == 1) {
            return k == arr.get(0) ? 0 : -1;
        }
        int midEle = arr.get(arr.size() / 2);
        int leftMidEle = arr.get(arr.size() / 2 - 1);
        int rightMidEle = arr.get(arr.size() / 2 + 1);
        if (midEle == k) {
            return arr.size() / 2;
        } else if (leftMidEle < midEle && rightMidEle > midEle) {
            return binSearch(arr, 0, arr.size() / 2, k);
        } else if (leftMidEle < midEle && rightMidEle < midEle) {
            System.out.println("ds");
            if (rightMidEle > leftMidEle && k <= leftMidEle) {
                System.out.println("fjkg");
                return binSearch(arr, 0, arr.indexOf(leftMidEle), k);
            } else if (k <= rightMidEle) {
                System.out.println("qoe");
                return binSearch(arr, arr.indexOf(rightMidEle), arr.size() - 1, k);
            }
        }
        return -1;
    }

    public static int binSearch(ArrayList<Integer> arr, int first, int last, int key) {
        if (first <= last) {
            int mid = first + (last - first) / 2;
            if (arr.get(mid) == key) return mid;
            else if (arr.get(mid) > key) return binSearch(arr, first, mid - 1, key);
            else return binSearch(arr, mid + 1, last, key);
        }
        return -1;
    }

    public static int findMajority(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            if (map.containsKey(j)) map.put(j, map.get(j) + 1);
            else map.put(j, 1);
        }
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value > Math.floor(arr.length)) return key;
        }
        return -1;
    }

    public static boolean checkPalindrome(String str) {
        char[] chars = str.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length; i++) {
//			System.out.println ( chars );
            if (!(chars[i] >= 'a' && chars[i] <= 'z')) {
                chars[i] = ' ';
            }
        }
        str = String.valueOf(chars).replaceAll(" ", "");
        System.out.println("str = " + str);
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
//		System.out.println ( "str == " + str );
        return true;
    }

    public static void setZeros(int[][] matrix) {
        // TODO: Try with arraylist
    }

    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer integer : arr) {
            if (hashMap.containsKey(integer)) {
                hashMap.put(integer, hashMap.get(integer) + 1);
            } else {
                hashMap.put(integer, 1);
            }
        }
        System.out.println(hashMap);

        for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value > Math.floor(arr.size() / 3.0)) arrayList.add(key);
        }
        return arrayList;
    }

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int[] result = new int[2];
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (Integer integer : arr) {
            if (hashMap.containsKey(integer)) {
                hashMap.put(integer, hashMap.get(integer) + 1);
            } else {
                hashMap.put(integer, 1);
            }
        }
        for (int i = 1; i <= arr.size(); i++) {
            if (!hashMap.containsKey(i)) {
                result[0] = i;
                break;
            }
        }
        for (int i = 1; i <= arr.size(); i++) {
            if (hashMap.containsKey(i) && hashMap.get(i) > 1) {
                result[1] = i;
                break;
            }
        }
        return result;
    }

    public static int[] findArraySum(int[] a, int[] b) {
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        for (int element : a) num1.append(element);
        for (int element : b) num2.append(element);
        int intNum1 = Integer.parseInt(num1.toString());
        int intNum2 = Integer.parseInt(num2.toString());
        Integer intResult = intNum1 + intNum2;
        StringBuilder result = new StringBuilder();
        result.append(intResult);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (intResult != 0) {
            arrayList.add(intResult % 10);
            intResult /= 10;
        }
        Collections.reverse(arrayList);
        int[] resultArray = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            resultArray[i] = arrayList.get(i);
        }
        return resultArray;
    }

    public static int nthFibonacciNumber(int n) {
        int t1 = 0;
        int t2 = 1;
        int t3;
        for (int i = 1; i <= n; i++) {
            t3 = t1 + t2;
            t1 = t2;
            t2 = t3;
//			System.out.println ( t3 + " " );
        }
        return (int) (t1 % (1e9 + 7));
    }

    public static Node findMiddle(Node head) {
        int nodeCount = 0;
        Node node = head;
        while (node != null) {
            nodeCount++;
            node = node.next;
        }
        node = head;
        for (int i = 0; i < nodeCount / 2; i++) {
            node = node.next;
        }
        return node;
    }

    public static int[] nextGreater(int[] array, int n) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = -1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    result[i] = array[j];
                    break;
                }
            }
        }
        result[array.length - 1] = -1;
        return result;
    }

    public static void pushZerosAtEnd(ArrayList<Integer> arrayList) {
        int noOfNonZeroes = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) != 0) {
                arrayList.set(noOfNonZeroes, arrayList.get(i));
                noOfNonZeroes++;
            }
            System.out.println(arrayList);
        }
        // fill all the rest indices with 0
        while (noOfNonZeroes < arrayList.size()) {
            arrayList.set(noOfNonZeroes, 0);
            noOfNonZeroes++;
        }
        System.out.println(arrayList);
    }

    public static long maxSubarraySum(int[] array, int n) {
        /* Kadane's Algo */
        if (array.length == 0) return 0;
        long maxSum = array[0];
        long maxEnding = array[0];
        for (int i = 1; i < array.length; i++) {
            maxEnding = Math.max(maxEnding + array[i], array[i]);
            maxSum = Math.max(maxSum, maxEnding);
        }
        return Math.max(maxSum, 0);
    }

    public static ArrayList<Integer> maximumsumSubarray(int n, int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int maxEnding = array[0];
        int maxSum = array[0];
        for (int i = 1; i < array.length; i++) {
            maxEnding = Math.max(maxEnding + array[i], array[i]);
            if (maxEnding == maxEnding + array[i]) {
                arrayList.add(maxEnding);
            } else if (maxEnding == array[i]) {
                arrayList.clear();
                arrayList.add(array[i]);
            }
            maxSum = Math.max(maxSum, maxEnding);
        }
        // TODO: ASKED IN GFG CHAT
        System.out.println("maxSum = " + maxSum);
        return arrayList;
    }

    public static int totalSalary(int basic, char grade) {
        double salary;
        double hra = (double) basic * 20 / 100;
        double da = (double) basic * 50 / 100;
        int allowance = 0;
        if (grade == 'A') allowance = 1700;
        else if (grade == 'B') allowance = 1500;
        else allowance = 1300;
        double pf = (double) basic * 11 / 100;
        salary = basic + hra + da + allowance - pf;
        System.out.println("basic = " + basic + " hra = " + hra + " da = " + da + " allowance = " + allowance + " " + "pf = " + pf);
        return (int) Math.round(salary);
    }

    public static int minSubarraySum(ArrayList<Integer> arrayList, int n, int k) {
        int minSum;
        int currentSum = 0;
        /* sum of first k elements */
        for (int i = 0; i < k; i++) currentSum += arrayList.get(i);
        minSum = currentSum;
        System.out.println("currentSum = " + currentSum);

        for (int i = k; i < arrayList.size(); i++) {
            currentSum = currentSum + arrayList.get(i) - arrayList.get(i - k);
            System.out.println("currentSum = " + currentSum);
            minSum = Math.min(minSum, currentSum);
        }
        return minSum;
    }

    public static int majorityElement(ArrayList<Integer> arrayList) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer integer : arrayList) {
            if (hashMap.containsKey(integer)) {
                hashMap.put(integer, hashMap.get(integer) + 1);
            } else {
                hashMap.put(integer, 1);
            }
        }
        System.out.println(hashMap);
        for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value > Math.floor(arrayList.size() / 2)) {
                return key;
            }
        }
        return -1;
    }

    public static ArrayList<Integer> countTheNumber(ArrayList<Integer> arrayList, int n, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer integer : arrayList) {
            if (hashMap.containsKey(integer)) hashMap.put(integer, hashMap.get(integer) + 1);
            else hashMap.put(integer, 1);
        }
        for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value >= arrayList.size() / k) result.add(key);
        }
        return result;
    }

    public static int[] rotateArray(int[] arr, int n) {
        int firstElement = arr[0];
        for (int i = 0; i < arr.length - 1; i++) arr[i] = arr[i + 1];
        arr[arr.length - 1] = firstElement;
        return arr;
    }

    public static int arrayEquilibriumIndex(int[] array) {
        int rightSum = 0;
        for (int element : array) rightSum += element;

        int leftSum = 0;
        for (int i = 0; i < array.length; i++) {
            rightSum -= array[i];
            if (leftSum == rightSum) return i;
            leftSum += array[i];
            // System.out.println ( "leftsum = " + leftSum + ", rightsum = " + rightSum );
        }
        return -1;
    }

    public static ArrayList<Integer> findEquilibriumIndices(int[] sequence) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int rightSum = 0;
        for (int element : sequence) rightSum += element;

        int leftSum = 0;
        for (int i = 0; i < sequence.length; i++) {
            rightSum -= sequence[i];
            if (leftSum == rightSum) {
                arrayList.add(i);
            }
            leftSum += sequence[i];
            // System.out.println ( "leftsum = " + leftSum + ", rightsum = " + rightSum );
        }
        return arrayList;
    }

    public static String removeConsecutiveDuplicates(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = 0; i < string.length() - 1; i++) {
            if (string.charAt(i) == string.charAt(i + 1)) {
                stringBuilder.replace(i + 1, i + 2, " ");
            }
        }
        return stringBuilder.toString().replaceAll(" ", "");
    }

    public static String removeConsecutive(StringBuilder stringBuilder) {
        String string = stringBuilder.toString();
        for (int i = 0; i < stringBuilder.length() - 1; i++) {
            if (string.charAt(i) == string.charAt(i + 1)) {
                stringBuilder.replace(i + 1, i + 2, " ");
            }
        }
        return stringBuilder.toString().replaceAll(" ", "");
    }

    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(inOrder(root, new ArrayList<>()));
        lists.add(preOrder(root, new ArrayList<>()));
        lists.add(postOrder(root, new ArrayList<>()));
        return lists;
    }

    public static List<Integer> preOrder(BinaryTreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.data);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
        return list;
    }

    public static List<Integer> inOrder(BinaryTreeNode root, List<Integer> list) {
        if (root != null) {
            inOrder(root.left, list);
            list.add(root.data);
            inOrder(root.right, list);
        }
        return list;
    }

    public static List<Integer> postOrder(BinaryTreeNode root, List<Integer> list) {
        if (root != null) {
            postOrder(root.left, list);
            postOrder(root.right, list);
            list.add(root.data);
        }
        return list;
    }

    public static int uniqueElement(ArrayList<Integer> arrayList) {
        /*HashMap<Integer, Integer> hashMap = new HashMap<> ( );
        for (Integer integer : arrayList) {
            if (hashMap.containsKey ( integer ))
                hashMap.put ( integer, hashMap.get ( integer ) + 1 );
            else
                hashMap.put ( integer, 1 );
        }
        for (Entry<Integer, Integer> entry : hashMap.entrySet ( )) {
            Integer key = entry.getKey ( );
            Integer value = entry.getValue ( );
            if (value == 1) return key;
        }*/
        return uniqueElementBinarySearch(arrayList, 0, arrayList.size() - 1);
    }

    public static int uniqueElementBinarySearch(ArrayList<Integer> arrayList, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            if (mid % 2 == 0) { // mid --> even index
                if (Objects.equals(arrayList.get(mid), arrayList.get(mid + 1)))
                    return uniqueElementBinarySearch(arrayList, mid + 1, right);
                else return uniqueElementBinarySearch(arrayList, left, mid);
            } else {    // mid --> odd index
                if (Objects.equals(arrayList.get(mid), arrayList.get(mid + 1)))
                    return uniqueElementBinarySearch(arrayList, left, mid);
                else return uniqueElementBinarySearch(arrayList, mid + 1, right);
            }
        }
        return arrayList.get(left);
    }

    public static ArrayList<Integer> findDuplicates(int[] arr, int n) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer integer : arr) {
            if (hashMap.containsKey(integer)) hashMap.put(integer, hashMap.get(integer) + 1);
            else hashMap.put(integer, 1);
        }
        for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value > 1) arrayList.add(key);
        }
        if (arrayList.isEmpty()) arrayList.add(-1);
        return arrayList;
    }

    public static ArrayList<Integer> sqsorted(ArrayList<Integer> arrayList) {
        ArrayList<Integer> sqArrayList = new ArrayList<>();
        for (Integer integer : arrayList)
            sqArrayList.add((int) Math.pow(integer, 2));
        Collections.sort(sqArrayList);
        return sqArrayList;
    }

    public static String multiplyStrings(String a, String b) {
        long longA = Long.parseLong(a);
        long longB = Long.parseLong(b);
        return String.valueOf(longA * longB);
    }

    public static int findPrice(BinaryTreeNode root) {
        if (root.left == null) return root.data;
        return findPrice(root.left);
    }

    public static long reverseNumber(long n) {
        long reversedNumber = 0;
        while (n != 0) {
            reversedNumber = reversedNumber * 10 + n % 10;
            n = n / 10;
        }
        return reversedNumber;
    }

    public static int findPeak(int n, ArrayList<Integer> arrayList) {
        int peakEle = arrayList.get(0);
        for (int i = 1; i < arrayList.size() - 1; i++) {
            peakEle = arrayList.get(i);
            if (arrayList.get(i - 1) < peakEle && peakEle > arrayList.get(i + 1)) return peakEle;
        }
        return peakEle;
    }

    public static int findSecondLargest(int n, int[] array) {
        int largest = Integer.MIN_VALUE;
        for (int j : array) {
            if (largest < j) largest = j;
        }
        int secondLargest = Integer.MIN_VALUE;
        for (int j : array) {
            if (largest != j && secondLargest < j) secondLargest = j;
        }
        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }

    public static int bestInsertPos(int[] array, int n, int m) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(m + " " + array[i]);
            if (m <= array[i]) return i;
        }
        return array.length;
    }

    public static int noOfLeafNodes(BinaryTreeNode root) {
        return getLeafCount(root);
    }

    public static int getLeafCount(BinaryTreeNode root) {
        if (root == null) return 0;
        else if (root.left == null && root.right == null) return 1;
        else return getLeafCount(root.left) + getLeafCount(root.right);
    }

    public static ArrayList<Integer> preorderTraversal(BinaryTreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        return preOrder(root, arrayList);
    }

    public static ArrayList<Integer> preOrder(BinaryTreeNode root, ArrayList<Integer> list) {
        if (root != null) {
            list.add(root.data);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
        return list;
    }

    public static boolean findWord(String s, String w) {
        int wordCount = s.split(" ").length;
        ArrayList<String> words = new ArrayList<>(Arrays.asList(s.split(" ")).subList(0, wordCount));
        for (String word : words) {
            if (word.contentEquals(w)) return true;
        }
        return false;
    }

    public static LinkedListNode deleteNode(LinkedListNode head, int pos) {
        LinkedListNode currentNode = head;
        if (head == null || head.next == null) return null;
        if (pos == 0) {
            head = head.next;
            return head;
        }
        for (int i = 0; i < pos - 1; i++) {
            if (currentNode.next == null) return head;
            currentNode = currentNode.next;
        }
        if (currentNode.next.next != null) currentNode.next = currentNode.next.next;
        else currentNode.next = null;
        return head;
    }

    public static int linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) if (arr[i] == x) return i;
        return -1;
    }

    public static int duplicateNumber(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer integer : arr) {
            if (hashMap.containsKey(integer)) hashMap.put(integer, hashMap.get(integer) + 1);
            else hashMap.put(integer, 1);
        }
        for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value >= 2) return key;
        }
        return -1;
    }

    public static ArrayList<Integer> printArrayAfterKOperations(ArrayList<Integer> arrayList, int n, int k) {
        /*int mx = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            for (Integer integer : arrayList) {
                if (mx < integer) mx = integer;
            }
            for (int j = 0; j < arrayList.size ( ); j++)
                arrayList.set ( j, mx - arrayList.get ( j ) );
            mx = Integer.MIN_VALUE;
        }
        return arrayList;*/
        if (k == 0) return arrayList;

        ArrayList<Integer> soln = new ArrayList<>();
        // Finding maxm element value in Arr[].
        int maxm = Collections.max(arrayList);
        // Finding minm element value in Arr[].
        int minm = Collections.min(arrayList);

        // If K is odd, then all array will be transformed to maxm - Arr[i].
        if (k % 2 != 0) {
            for (int i = 0; i < n; i++)
                soln.add(maxm - arrayList.get(i));
            return soln;
        }
        // Else if K is even, then all array will be transformed to minm - Arr[i].
        else {
            for (int i = 0; i < n; i++)
                soln.add(arrayList.get(i) - minm);
            return soln;
        }
    }

    /*public static ArrayList<Integer> sortBinaryArray(ArrayList<Integer> arr, int n) {
        pushZerosAtEnd ( arr );
        Collections.reverse ( arr );
        return arr;
    }*/

    public static ArrayList<Integer> postorderTraversal(BinaryTreeNode root) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList = postOrder(root, arrayList);
        return (ArrayList<Integer>) arrayList;
    }

    public static int[] findRepeatingAndMissingNumbers(int[] nums) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) hashMap.put(num, hashMap.get(num) + 1);
            else hashMap.put(num, 1);
        }
        System.out.println(hashMap);
        for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value >= 2) result[0] = key;
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!hashMap.containsKey(i)) {
                result[1] = i;
            }
        }
        return result;
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        while (n != 1) {
            if (n % 2 != 0) return false;
            n /= 2;
        }
        return true;
    }

    public static void divideByFour(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) / 4 == 0) arr.set(i, -1);
            else arr.set(i, arr.get(i) / 4);
        }
//		System.out.println ( arr );
    }

    public static int findNode(LinkedListNode head, int n) {
        LinkedListNode currentNode = head;
        for (int i = 0; currentNode != null; i++) {
            if (currentNode.data == n) return i;
            currentNode = currentNode.next;
        }
        return -1;
    }

    public static int occursOnce(int[] arr, int n) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int j : arr) {
            if (hashMap.containsKey(j)) hashMap.put(j, hashMap.get(j) + 1);
            else hashMap.put(j, 1);
        }
        for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 1) return key;
        }
        return -1;
    }

    public static boolean isPerfectSquare(long n) {
        long sqrt = (long) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    public static ArrayList<Integer> valueEqualToIndices(int[] numArray, int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] == i) arrayList.add(numArray[i]);
        }
        if (arrayList.isEmpty()) arrayList.add(-1);
        return arrayList;
    }

    public static int findCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') return 1; // upper case
        else if (ch >= 'a' && ch <= 'z') return 1;   // lower case
        else return -1; // not alphabet
    }

    public static Stack<Integer> pushAtBottom(Stack<Integer> myStack, int x) {
        insertAtBottom(myStack, x);
        return myStack;
    }

    public static void insertAtBottom(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }
        int topElement = stack.pop();
        insertAtBottom(stack, x);
        stack.push(topElement);
    }

    public static String convertString(String string) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList(string.split(" ")));
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            word = word.substring(0, 1).toUpperCase() + word.substring(1);
            stringBuilder.append(word).append(" ");
        }
        string = stringBuilder.toString();
        return string;
    }

    public static int compareVersions(String a, String b) {
        String[] levels1 = a.split("\\.");
        String[] levels2 = b.split("\\.");
        int maxLen = Math.max(levels1.length, levels2.length);
        for (int i = 0; i < maxLen; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) return compare;
        }
        return 0;
    }

    public static int[] countEvenOdd(int[] arr, int n) {
        int countOdd = 0, countEven = 0;
        for (int j : arr) {
            if (j % 2 == 0) countEven++;
            else countOdd++;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int element : arr) {
            if (hashMap.containsKey(element)) hashMap.put(element, hashMap.get(element) + 1);
            else hashMap.put(element, 1);
        }
        countOdd = 0;
        countEven = 0;
        for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value % 2 == 0) countEven++;
            else countOdd++;
        }
        return new int[]{countOdd, countEven};
    }

    public static void printDivisors(int num) {
        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) divisors.add(i);
        }
        for (int divisor : divisors)
            System.out.print(divisor + " ");
    }

    public static Boolean isPalindrome(String s) {
        StringBuilder reversed = new StringBuilder(s).reverse();
        System.out.println(reversed);
        return reversed.toString().contentEquals(s);
    }

    public static int removeDuplicates(ArrayList<Integer> arrayList, int n) {
        /// for an unsorted array
        /*HashSet<Integer> hashSet = new HashSet<> ( arrayList );
        return hashSet.size ( );*/

        /// for a sorted array
        for (int i = 0; i < arrayList.size() - 1; i++) {
            if (Objects.equals(arrayList.get(i), arrayList.get(i + 1))) {
                arrayList.remove(i + 1);
                i--;
            }
        }
        return arrayList.size();
    }

    public static void printReverse(LinkedListNode root) {
        if (root == null) return;
        printReverse(root.next);
        System.out.print(root.data + " ");
    }

    public static Node deleteMiddle(Node head) {
        if (head == null || head.next == null) return null;
        if (head.next.next == null) return head.next;
        Node fastPtr = head.next;
        Node slowPtr = head;
        Node previousNode = head;
        while (fastPtr != null && fastPtr.next != null) {
            previousNode = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        previousNode.next = slowPtr.next;
        return head;
    }

    public static Node insert(Node head, int n, int pos, int val) {
        /// single linked list
        if (head == null) return head;
        Node newnode = new Node(val);
        Node currentNode = head;
        if (pos == 0) {
            newnode.next = head;
            head = newnode;
            return head;
        }
        for (int i = 0; i < pos - 1 && currentNode.next != null; i++)
            currentNode = currentNode.next;
        currentNode.next = newnode;
        newnode.next = currentNode.next;
        return head;
    }

    public static DoublyLinkedListNode insert(int k, int val, DoublyLinkedListNode head) {
        DoublyLinkedListNode currentNode = head;
        DoublyLinkedListNode newnode = new DoublyLinkedListNode(val);
        if (k == 0) {
            newnode.next = head;
            head = newnode;
            return head;
        }
        for (int i = 0; i < k - 1 && currentNode.next != null; i++)
            currentNode = currentNode.next;
        newnode.next = currentNode.next;
        newnode.prev = currentNode;
        currentNode.next = newnode;
        return head;
    }

    // TODO: THINK LOGIC
    public static Node insert(int k, int val, Node head) {
        /// circular linked list
        return head;
    }

    public static void printCircularSingleLinkedList(Node head) {
        if (head != null) {
            Node currentNode = head;
            while (currentNode.next != head && currentNode.next != null) {
                System.out.print(currentNode.data + " --> ");
                currentNode = currentNode.next;
            }
            System.out.println(currentNode.data + " --> head");
        } else {
            System.out.println("null...");
            System.out.println("Empty Linked List");
        }
    }

    public static Node removeKthNodeFromEnd(Node head, int K) {
        Node.printSingleLinkedList(head);
        if (head == null || K == 0) return head;
        Node firstPtr = head;
        Node secondPtr = head;
        Node previousPtr = head;
        for (int i = 1; i < K && firstPtr != null; i++) firstPtr = firstPtr.next;
        if (firstPtr == null) return head;
        while (firstPtr.next != null) {
            previousPtr = secondPtr;
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }
        System.out.println(previousPtr.data);
        if (secondPtr == head && previousPtr == head) {
            head = secondPtr.next;
            Node.printSingleLinkedList(head);
            return head;
        }
        previousPtr.next = secondPtr.next;
        Node.printSingleLinkedList(head);
        return head;
    }

    public static Node cloneLL(Node head) {
        HashMap<Node, Node> hashMap = new HashMap<>();
        for (Node currentNode = head; currentNode != null; currentNode = currentNode.next)
            hashMap.put(currentNode, new Node(currentNode.data));
        for (Node currentNode = head; currentNode != null; currentNode = currentNode.next) {
            Node cloneCurrentNode = hashMap.get(currentNode);
            cloneCurrentNode.next = hashMap.get(cloneCurrentNode.next);
            cloneCurrentNode.random = hashMap.get(cloneCurrentNode.random);
        }
        return hashMap.get(head);
    }

    public static boolean detectAndRemoveCycle(Node head) {
        if (head == null || head.next == null) return false;
        Node slowPtr = head;
        Node fastPtr = head.next;
        /// finding loop
        while (slowPtr != fastPtr) {
            if (fastPtr == null || fastPtr.next == null) return false;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        /// loop found, removing it
        slowPtr = head;
        while (slowPtr != fastPtr.next) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        fastPtr.next = null;
        return true;
    }

    public static Node reverseLinkedList(Node head) {
        Node currentNode = head;
        Node previousNode = null;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    public static boolean detectCycle(Node head) {
        if (head == null || head.next == null) return false;
        Node slowPtr = head;
        Node fastPtr = head.next;
        while (slowPtr != fastPtr) {
            if (fastPtr == null || fastPtr.next == null) return false;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return true;
    }

    public static Node firstLoopNode(Node head) {
        if (head == null || head.next == null) return null;
        Node slowPtr = head;
        Node fastPtr = head.next;
        while (slowPtr != fastPtr) {
            if (fastPtr == null || fastPtr.next == null) return null;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        slowPtr = head;
        while (slowPtr != fastPtr.next) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        return fastPtr.next;
    }

    //	https://www.codingninjas.com/codestudio/problems/unique-sorted-list_2420283?leftPanelTab=2
    // TODO: SUBMIT IN 2x BOOSTER
    public static Node uniqueSortedList(Node head) {
        if (head == null || head.next == null) return head;
        Node currentNode = head;
        Node previousNode;
        while (currentNode.next != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
            if (previousNode.data == currentNode.data) {
                previousNode.next = currentNode.next;
                currentNode = previousNode;
            }
        }
        return head;
    }

    public static void intersections(int[] array1, int[] array2) {
        LinkedHashMap<Integer, Integer> hashMap1 = new LinkedHashMap<>();
        /*LinkedHashMap<Integer, Integer> hashMap2 = new LinkedHashMap<> ( );
        for (Integer integer : array1) hashMap1.put ( integer, hashMap1.getOrDefault ( integer, 0 ) + 1 );
        for (Integer integer : array2) hashMap2.put ( integer, hashMap2.getOrDefault ( integer, 0 ) + 1 );
        for (Entry<Integer, Integer> entry1 : hashMap1.entrySet ( )) {
            Integer key1 = entry1.getKey ( );
            Integer value1 = entry1.getValue ( );
            for (Entry<Integer, Integer> entry2 : hashMap2.entrySet ( )) {
                Integer key2 = entry2.getKey ( );
                Integer value2 = entry2.getValue ( );
                if (Objects.equals ( key1, key2 )) {
                    int nTimes = Math.min ( value1, value2 );
                    for (int i = 0; i < nTimes; i++) System.out.print ( key1 + " " );
                }
            }
        }*/
        for (Integer integer : array2) hashMap1.put(integer, hashMap1.getOrDefault(integer, 0) + 1);
        for (Integer integer : array1) {
            if (hashMap1.containsKey(integer)) {
                hashMap1.put(integer, hashMap1.get(integer) - 1);
                if (hashMap1.get(integer) == 0) hashMap1.remove(integer);
                System.out.print(integer + " ");
            }
        }
    }

    public static Node sortList012(Node head) {
        /// segregate 0, 1, 2
        if (head == null || head.next == null) return head;
        Node start0 = null, end0 = null, start1 = null, end1 = null, start2 = null, end2 = null;
        Node currentNode = head;
        while (currentNode != null) {
            int data = currentNode.data;
            System.out.println(end0);
            if (data == 0) {
                if (start0 == null) start0 = end0 = currentNode;
                else {
                    end0.next = currentNode;
                    end0 = end0.next;
                }
            } else if (data == 1) {
                if (start1 == null) start1 = end1 = currentNode;
                else {
                    end1.next = currentNode;
                    end1 = end1.next;
                }
            } else if (data == 2) {
                if (start2 == null) start2 = end2 = currentNode;
                else {
                    end2.next = currentNode;
                    end2 = end2.next;
                }
            }
            currentNode = currentNode.next;
        }
        if (start0 != null && start1 == null && start2 == null) {
            /// only 0s, no 1s & 2s
            return start0;
        }
        if (start0 == null && start1 != null && start2 == null) {
            /// only 1s, no 0s & 2s
            return start1;
        }
        if (start0 == null && start1 == null && start2 != null) {
            /// only 2s, no 0s & 1s
            return start2;
        }
        if (start0 != null && start1 != null && start2 == null) {
            /// only 0s & 1s, no 2s
            end0.next = start1;
            start1.next = null;
            return start0;
        }
        if (start0 != null && start1 == null && start2 != null) {
            /// only 0s & 2s, no 1s
            end0.next = start2;
            start2.next = null;
            return start0;
        }
        if (start0 == null && start1 != null && start2 != null) {
            /// only 1s & 2s, no 0s
            end1.next = start2;
            start2.next = null;
            return start1;
        }
        end0.next = start1;
        end1.next = start2;
        end2.next = null;
        return start0;
    }

    public static Node mergeSortLL(Node head) {
        if (head == null || head.next == null) return head;
        Node middleNode = findMiddleNode(head);
        Node secondHead = middleNode.next;
        middleNode.next = null; // ends first sublist
        Node finalHead1 = mergeSortLL(head);
        Node finalHead2 = mergeSortLL(secondHead);
        return merge(finalHead1, finalHead2);
    }

    public static Node findMiddleNode(Node head) {
        Node slowPtr = head;
        Node fastPtr = head.next;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public static Node merge(Node head1, Node head2) {
        Node mergedNode = new Node(0);
        Node currentNode = mergedNode;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                currentNode.next = head1;
                head1 = head1.next;
            } else {
                currentNode.next = head2;
                head2 = head2.next;
            }
            currentNode = currentNode.next;
        }
        while (head1 != null) {
            currentNode.next = head1;
            head1 = head1.next;
            currentNode = currentNode.next;
        }
        while (head2 != null) {
            currentNode.next = head2;
            head2 = head2.next;
            currentNode = currentNode.next;
        }
        return mergedNode.next;
    }

    public static void sortZeroesAndOne(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer integer : arr) hashMap.put(integer, hashMap.getOrDefault(integer, 0) + 1);
        int noOf0s = 0, noOf1s = 0;
        for (Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (key == 0) noOf0s = value;
            else noOf1s = value;
        }
        Arrays.fill(arr, 0, noOf0s, 0);
        Arrays.fill(arr, noOf0s, arr.length, 1);
    }

    public static Node sortLL(Node head) {
        if (head == null || head.next == null) return head;
        Node middleNode = findMiddleNode(head);
        Node secondHead = middleNode.next;
        middleNode.next = null;
        Node finalHead1 = sortLL(head);
        Node finalHead2 = sortLL(secondHead);
        return mergeNode(finalHead1, finalHead2);
    }

    private static Node mergeNode(Node head, Node secondHead) {
        Node mergedNode = new Node(-1);
        Node currentNode = mergedNode;
        while (head != null && secondHead != null) {
            if (head.data < secondHead.data) {
                currentNode.next = head;
                head = head.next;
            } else {
                currentNode.next = secondHead;
                secondHead = secondHead.next;
            }
            currentNode = currentNode.next;
        }
        while (head != null) {
            currentNode.next = head;
            currentNode = currentNode.next;
            head = head.next;
        }
        while (secondHead != null) {
            currentNode.next = secondHead;
            currentNode = currentNode.next;
            secondHead = secondHead.next;
        }
        return mergedNode.next;
    }

    // https://www.codingninjas.com/codestudio/problems/pair-sum_1171154
    // TODO: ASK PRIYANSH
    public static int pairSum(int[] array, int n, int target) {
        if (array.length == 0) return -1;
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer integer : array) {
            count += hashMap.getOrDefault(target - integer, 0);
            hashMap.put(integer, hashMap.getOrDefault(integer, 0) + 1);
        }
        return count == 0 ? -1 : count;
    }

    public static List<int[]> pairSum(int[] array, int sum) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<int[]> arrayList = new ArrayList<>();
        for (Integer integer : array) {
            int count = hashMap.getOrDefault(sum - integer, 0);
            while (count > 0) {
                int[] pair = new int[2];
                pair[0] = Math.min(integer, sum - integer);
                pair[1] = Math.max(integer, sum - integer);
                arrayList.add(pair);
                count--;
            }
            hashMap.put(integer, hashMap.getOrDefault(integer, 0) + 1);
        }
        arrayList.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(Arrays.toString(arrayList.get(i)));
        }
        return arrayList;
    }

    public static int[] subarraySum(int[] array, long sum) {
        HashMap<Long, Integer> hashMap = new HashMap<>();
        long prefixSum = 0L;
        int start = -1;
        int end = -1;
        for (int i = 0; i < array.length; i++) {
            prefixSum += array[i];
            if (prefixSum == sum) {
                start = 0;
                end = i;
                return new int[]{start, end};
            }
            if (array[i] == sum) return new int[]{i, i};
            if (hashMap.containsKey(prefixSum - sum)) {
                start = hashMap.get(prefixSum - sum) + 1;
                end = i;
            }
            hashMap.put(prefixSum, i);
        }
        return new int[]{start, end};

        /** Testcase Dry Run --> {-1, 0, -1, 0}, sum = 0
         * -1: i = 0, prefixSum = -1, hashmap.containsKey(-1) --> false, hashmap.put(-1, 0)
         * 0: i = 1, prefixSum = -1, hashmap.containsKey(-1) --> false, hashmap.put(-1, 1)
         * -1: i = 2, prefixSum = -2, hashmap.containsKey(-2) --> false, hashmap.put(-2, 2)
         * 0: i = 3, prefixSum = -2, hashmap.containsKey(-2) --> false, hashmap.put(-2, 3)
         */
    }

    public static int countSubarrays(int n, int[] array) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        for (Integer integer : array) {
            prefixSum += integer;
            if (prefixSum == 0) count++;
            if (hashMap.containsKey(prefixSum)) count += hashMap.get(prefixSum);
            System.out.println("count = " + count);
            hashMap.put(prefixSum, hashMap.getOrDefault(prefixSum, 0) + 1);
            System.out.println(hashMap);
        }
        return count;

        /** Testcase Dry Run --> {1, 0, -1, 0, 1} 4 subarrays with zero sum
         *  1: i = 0, prefixSum = 1, hashmap.contains(1) --> false, hashmap.put(1,0)
         *  0: i = 1, prefixSum = 1, hashmap.contains(1) --> true, count++ // 1
         *  -1: i = 2, prefixSum = 0, count++ // 2
         *  0: i = 3, prefixSum = 0, count++ // 3
         *  1: i = 4, prefixSum = 1, hashmap.contains(1) --> true, count++ // 4
         */

        /** Testcase Dry Run --> {-1, 1, 0, 1} 3 subarrays with zero sum
         *  -1: i = 0, prefixSum = -1, hashmap.contains(-1) --> false, hashmap.put(-1,1)
         *  1: i = 1, prefixSum = 0, count++ // 1, hashmap.contains(0) --> false, hashmap.put(0,1)
         *  0: i = 2, prefixSum = 0, count++ // 2, hashmap.contains(0) --> true, count++ // 3, hashmap.put(0,2)
         *  1: i = 3, prefixSum = 1, hashmap.contains(1) --> false, hashmap.put(1,1)
         */

        /** Testcase Dry Run --> {-1, 0, 1, -1} 4 subarrays with zero sum
         *  -1: i = 0, prefixSum = -1, hashmap.contains(-1) --> false, hashmap.put(-1,1)
         *  0: i = 1, prefixSum = -1, hashmap.contains(-1) --> true, count = 0 + 1 = 1, hashmap.put(-1,2)
         *  1: i = 2, prefixSum = 0, count++ // 2, hashmap.contains(0) --> false, hashmap.put(0,1)
         *  -1: i = 3, prefixSum = -1, hashmap.contains(-1) --> true, count = 2 + 2 = 4 hashmap.put(-1,3)
         */
    }

    public static int zeroPairSum(int n, int[] array) {
        LinkedHashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        int count = 0;
        for (Integer integer : array) {
            if (hashMap.containsKey(-integer)) count += hashMap.get(-integer);
            hashMap.put(integer, hashMap.getOrDefault(integer, 0) + 1);
        }
        return count;

        /**
         * Testcase Dry Run --> {0, 2, -4, 1, -1, 2, -3, 1, -2, -1, 2}
         * 0: i = 0, hashmap.contains(0) --> false, count = 0, hashmap.put(0,1)
         * 2: i = 1, hashmap.contains(-2) --> false, count = 0, hashmap.put(2,1)
         * -4: i = 2, hashmap.contains(4) --> false, count = 0, hashmap.put(-4,1)
         * 1: i = 3, hashmap.contains(-1) --> false, count = 0, hashmap.put(1,1)
         * -1: i = 4, hashmap.contains(1) --> false, count = 1, hashmap.put(-1,1)
         * 2: i = 5, hashmap.contains(-2) --> false, count = 1, hashmap.put(2,2)
         * -3: i = 6, hashmap.contains(3) --> false, count = 1, hashmap.put(-3,1)
         * 1: i = 7, hashmap.contains(-1) --> true, count = 2, hashmap.put(1,2)
         * -2: i = 8, hashmap.contains(2) --> true, count = 4, hashmap.put(-2,1)
         * -1: i = 9, hashmap.contains(1) --> true, count = 6, hashmap.put(-1,2)
         * 2: i = 10, hashmap.contains(-2) --> true, count = 7 hashmap.put(2,3)
         */
    }

    // https://www.codingninjas.com/codestudio/problems/longest-subarray-with-zero-sum_6783450
    // TODO: SUBMIT IN 2x BOOSTER, PARTIALLY ACCEPTED
    public static int getLongestZeroSumSubarrayLength(int[] array) {
        LinkedHashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        int prefixSum = 0;
        int maxLen = 0;
        int start = -1;
        int end = -1;
        int fStart = -1;
        int fEnd = -1;
        for (int i = 0; i < array.length; i++) {
            int integer = array[i];
            prefixSum += integer;
            if (prefixSum == 0) {
                start = 0;
                end = i;
            } else if (hashMap.containsKey(prefixSum)) {
                start = hashMap.get(prefixSum) + 1;
                end = i;
            }
            if (start != -1) {
                maxLen = Math.max(maxLen, end - start + 1);
                if (maxLen == end - start + 1) {
                    fStart = start;
                    fEnd = end;
                }
            }
            hashMap.put(prefixSum, i);
        }
        System.out.println("maxLen = " + maxLen + " start = " + fStart + " end = " + fEnd);
        return maxLen;
    }

    public static int getLongestSubarray(int[] array, int sum) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int prefixSum = 0;
        int start;
        int end;
        int maxLen = 0;
        for (int i = 0; i < array.length; i++) {
            prefixSum += array[i];
            if (prefixSum == sum) {
                start = 0;
                end = i;
                maxLen = Math.max(maxLen, end - start + 1);
            }
            if (hashMap.containsKey(prefixSum - sum)) {
                start = hashMap.get(prefixSum - sum) + 1;
                end = i;
                if (start != -1) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }
            }
            if (prefixSum != sum && !hashMap.containsKey(prefixSum))
                hashMap.put(prefixSum, i);
        }
        return maxLen;
    }

    public static int lengthOfLongestSubarray(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int prefixSum = 0;
        int start, end;
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == 0) {
                start = 0;
                end = i;
                maxLen = Math.max(maxLen, end - start + 1);
            }
            if (hashMap.containsKey(prefixSum)) {
                start = hashMap.get(prefixSum) + 1;
                end = i;
                maxLen = Math.max(maxLen, end - start + 1);
            }
            if (prefixSum != 0 && !hashMap.containsKey(prefixSum))
                hashMap.put(prefixSum, i);
        }
        return maxLen;
    }

    //	https://www.codingninjas.com/codestudio/problems/sort-an-array-of-0s-1s-and-2s_892977
    // TODO: PARTIALLY ACCEPTED, https://www.youtube.com/watch?v=tp8JIuCXBaU WATCH THIS VIDEO
    public static void sortArray012(ArrayList<Integer> arrayList, int n) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (Integer integer : arrayList) {
            if (integer == 0) count0++;
            else if (integer == 1) count1++;
            else if (integer == 2) count2++;
        }
        int i = 0;
        while (count0 > 0) {
            arrayList.add(i++, 0);
            count0--;
        }
        while (count1 > 0) {
            arrayList.add(i++, 1);
            count1--;
        }
        while (count2 > 0) {
            arrayList.add(i++, 2);
            count2--;
        }
    }

    public static void mergeSort(int[] arr, int n) {
        mergeSortSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSortSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSortSort(arr, start, mid);
            mergeSortSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int[] array, int start, int mid, int end) {
        int n1 = mid - start + 1, n2 = end - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        for (int i = 0; i < leftArray.length; i++) leftArray[i] = array[start + i];
        for (int i = 0; i < rightArray.length; i++) rightArray[i] = array[mid + 1 + i];
        int i = 0, j = 0, k = start;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) array[k++] = leftArray[i++];
            else array[k++] = rightArray[j++];
        }
        while (i < n1) array[k++] = leftArray[i++];
        while (j < n2) array[k++] = rightArray[j++];
    }

    public static ArrayList<String> generatePermutations(String string) {
        ArrayList<String> arrayList = new ArrayList<>();
        findPermutations(arrayList, string, 0);
        return arrayList;
    }

    private static void findPermutations(ArrayList<String> arrayList, String string, int i) {
        if (i == string.length() - 1) {
            arrayList.add(string);
            return;
        }
        for (int j = i; j < string.length(); j++) {
            string = swap(string, i, j);
            findPermutations(arrayList, string, i + 1);
            string = swap(string, j, i);
        }
    }

    private static String swap(String string, int j, int i) {
        char temp;
        char[] charArray = string.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(4);
        arrayList1.add(10);
        arrayList1.add(3);
        arrayList1.add(5);
        arrayList1.add(1);

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(1);
        arrayList2.add(3);
        arrayList2.add(5);
        arrayList2.add(4);
        arrayList2.add(6);
        arrayList2.add(13);
        arrayList2.add(10);
        arrayList2.add(9);
        arrayList2.add(8);
        arrayList2.add(15);
        arrayList2.add(17);

        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(-2);
        stack.push(9);
        stack.push(-7);
        stack.push(3);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        arrayList.add(-2);
        arrayList.add(3);
        arrayList.add(-1);
        arrayList.add(8);

        Node head = new Node(2);
//		head.next = head;
        Node temp1 = new Node(2);
        Node temp2 = new Node(1);
        Node temp3 = new Node(0);
        Node temp4 = new Node(0);
        Node temp5 = new Node(0);
        head.next = temp1;
        temp1.next = temp2;
        temp2.next = temp3;
        temp3.next = temp4;
        temp4.next = temp5;

//		System.out.println ( maximumsumSubarray ( 2, new int[]{1, 2, 5, -7, 2, 3} ) );  // [1, 2, 5]
//		System.out.println ( maximumsumSubarray ( 2, new int[]{-2, -3, -4, 1} ) );  // [1]
//		System.out.println ( maximumsumSubarray ( 2, new int[]{-3, 1, 2, 3, -4, 6, -9} ) );  // [1, 2, 3, -4, 6]
//		System.out.println ( maximumsumSubarray ( 2, new int[]{-4, -3, -2, -1} ) );  // [-1]

//		System.out.println ( totalSalary ( 10000, 'A' ) );  // 17600
//		System.out.println ( totalSalary ( 4567, 'B' ) );   // 8762
//		System.out.println ( totalSalary ( 1500, 'B' ) );   // 3885
//		System.out.println ( totalSalary ( 5000, 'C' ) );   // 9250

//		System.out.println ( minSubarraySum ( arrayList, arrayList.size ( ), 3 ) );

//		System.out.println ( arrayEquilibriumIndex ( new int[]{1, 7, 3, 6, 5, 6} ) );   // 3
//		System.out.println ( arrayEquilibriumIndex ( new int[]{1, 2, 2, 9, 3, 2} ) ); // 4
//		System.out.println ( arrayEquilibriumIndex ( new int[]{1, 2, 3, 4} ) ); // -1

//		System.out.println ( removeConsecutive ( new StringBuilder ( "aabccba" ) ) );   // abcba
//		System.out.println ( removeConsecutive ( new StringBuilder ( "xxxyyyzwwzzz" ) ) );    // xyzwz

//		System.out.println ( uniqueElement ( arrayList ) );

//		System.out.println ( findDuplicates ( new int[]{0, 2, 1, 2, 3}, 5 ) );  // 2
//		System.out.println ( findDuplicates ( new int[]{3, 2, 1, 3, 2, 1, 5}, 7 ) );  // 1 2 3
//		System.out.println ( findDuplicates ( new int[]{0, 1, 2}, 3 ) );  // -1

//		System.out.println ( convertString ( "I love programming" ) );  // I Love Programming
//		System.out.println ( convertString ( "they are playing cricket" ) );    // They Are Playing Cricket
//		System.out.println ( convertString ( "good to see you" ) ); // Good To See You
//		System.out.println ( convertString ( "why you are confused" ) ); //  Why You Are Confused
//		System.out.println ( convertString ( "Its a good day to be here" ) ); // Its A Good Day to Be Here
//		System.out.println ( convertString ( "go and do your work" ) ); //  Go And Do Your Work

//		System.out.println ( sqsorted ( arrayList ) );

//		System.out.println ( compareVersions ( "1.23.45", "1.23.456" ) );   // -1
//		System.out.println ( compareVersions ( "10.2.2", "10.2.2" ) );  // 0
//		System.out.println ( compareVersions ( "1.2.4", "1.2.3" ) );  // 1
//		System.out.println ( compareVersions ( "1.0.0", "1" ) );  // 0
//		System.out.println ( compareVersions ( "123.45", "123" ) );  // 1
//		System.out.println ( compareVersions ( "2.2", "1.8" ) );  // 1
//		System.out.println ( compareVersions ( "2.9.9", "1.3.5" ) );  // 1
//		System.out.println ( compareVersions ( "1.1.1.1.1", "1.2" ) );  // 1
//		System.out.println ( compareVersions ( "1.0.1", "2" ) );

//		System.out.println ( reverseNumber ( 10400 ) ); // 401
//		System.out.println ( reverseNumber ( 12345 ) ); // 54321
//		System.out.println ( reverseNumber ( 1000 ) ); // 1
//		System.out.println ( reverseNumber ( 7654321 ) ); // 1234567

//		System.out.println ( findSecondLargest ( 6, new int[]{12, 1, 35, 10, 34, 1} ) );    // 34
//		System.out.println ( findSecondLargest ( 5, new int[]{10, 10, 10, 10, 10} ) );    // -1
//		System.out.println ( findSecondLargest ( 7, new int[]{7, 8, 8, 1, 4, 3} ) );    // 7

//		System.out.println ( bestInsertPos ( new int[]{1, 2, 4, 7}, 4, 9 ) );   // 4
//		System.out.println ( bestInsertPos ( new int[]{2, 5, 7}, 3, 1 ) );   // 0

//		System.out.println ( findWord ( "abaa ba", "abaa" ) );  // Yes
//		System.out.println ( findWord ( "coding is fun", "not" ) );  // No

//		System.out.println ( linearSearch ( new int[]{2, 13, 4, 1, 3, 6, 28}, 3 ) );    // 4
//		System.out.println ( linearSearch ( new int[]{7, 8, 5, 9, 5}, 5 ) );    // 2

//		System.out.println ( duplicateNumber ( new int[]{0, 3, 1, 5, 4, 3, 2} ) );  // 3

//		System.out.println ( printArrayAfterKOperations ( arrayList, 4, 2 ) );  // 15 10 5 0

//		System.out.println ( Arrays.toString ( findRepeatingAndMissingNumbers ( new int[]{1, 2, 3, 4, 4, 5} ) ) );

//		System.out.println ( isPowerOfTwo ( 16 ) );
//		System.out.println ( isPowerOfTwo ( 3 ) );
//		System.out.println ( isPowerOfTwo ( 6 ) );
//		System.out.println ( isPowerOfTwo ( 8 ) );

//      divideByFour ( arrayList );

//		moveZerosToLeft ( new int[]{1, 2, 0, 0, 1}, 5 );    // 0 0 1 2 1
//		moveZerosToLeft ( new int[]{1, 0, 0}, 3 );    // 0 0 1
//		moveZerosToLeft ( new int[]{1, 2, 3, 4, 5}, 5 );    // 1 2 3 4 5
//		moveZerosToLeft ( new int[]{0, -1, -1, 1}, 4 );    // 0 -1 -1 1
//		moveZerosToLeft ( new int[]{0, 0, 0, -2}, 4 );    // 0 0 0 2
//		moveZerosToLeft ( new int[]{-8, 9, 0, 0}, 4 );    // 0 0 -8 9
//		moveZerosToLeft ( new int[]{-8, 0, 0, 0, 1}, 5 );    // 0 0 0 -8 1

//		System.out.println ( isPalindrome ( "racecar" ) );  // true

//      System.out.println ( removeDuplicates ( arrayList, arrayList.size ( ) ) );

//		System.out.println ( addOneToNumber ( arrayList ) );
//		System.out.println ( addOneToNumber ( arrayList2 ) );

//		insert ( 2, 4, head );

//		removeKthNodeFromEnd ( head, 1 );

//		System.out.println ( maxFrequencyNumber ( 3, new int[]{4, -5, 1} ) );

//		intersections ( new int[]{1, 2, 2, 2, 3, 3}, new int[]{1, 2, 3, 3, 3} );   // {1, 2, 3, 3}

//		sortList012 ( head );

//		sortZeroesAndOne ( new int[]{1, 1, 0, 0, 1, 0} );

//		pairSum ( new int[]{1, 2, 3, 4, 5}, 5 );    // [2,3], [1,4]
//		pairSum ( new int[]{2, -6, 2, 5, 2}, 4 );   // [2,2], [2,2], [2,2]
//		pairSum ( new int[]{-4, 7, -3, 4, -8, 4, 4, 0, -6, -7, 6, 9, 3, 5, 4, -1, -1, -6, -9, 0, 9, -3, 8, 5, 2, 6, 2, 0, 9, -4, -3, 0, 0, 8, 4}, -7 );   // [2,2], [2,2], [2,2]

//		System.out.println ( countSubarrays ( 4, new int[]{-1, 0, 1, -1} ) );

//		System.out.println ( zeroPairSum ( 11, new int[]{0, 2, -4, 1, -1, 2, -3, 1, -2, -1, 2} ) );

//		getLongestZeroSumSubarrayLength ( new int[]{1, 0, -1, 1} ); // 3
//		getLongestZeroSumSubarrayLength ( new int[]{1, 1} ); // 0
//		getLongestZeroSumSubarrayLength ( new int[]{-5, 5, -5, 5, -5} ); // 4
//		getLongestZeroSumSubarrayLength ( new int[]{1, 45, 22, 0, 10, -37, 37, 29, 23, 2, 9, 0, 2, 15, 49, 6, 27, 25, 35, 50, 39, 1, 42, 49, 20, 33, 28, 40, 26, 14, 38, 26, 25, 16, 49} ); // 2

//		System.out.println ( getLongestSubarray ( new int[]{2, 3, 5}, 5 ) );    // 2
//		System.out.println ( getLongestSubarray ( new int[]{-1, 1, 1}, 1 ) );    // 3
//		System.out.println ( getLongestSubarray ( new int[]{1, 1, 1}, 4 ) );    // 0
//		System.out.println ( getLongestSubarray ( new int[]{-50, 0, 52}, 2 ) );    // 3
//		System.out.println ( getLongestSubarray ( new int[]{-10, 8, 2, -2}, -2 ) );    // 4

//		System.out.println ( nextSmallerElement ( arrayList, 3 ) );

//		mergeSort ( new int[]{3, 5, 2, 9, 0}, 5 );

//		System.out.println ( firstMissing ( new int[]{3, 2, -6, 1, 0}, 5 ) );   // 4
//		System.out.println ( firstMissing ( new int[]{1, 2, 0}, 3 ) );  // 3
//		System.out.println ( firstMissing ( new int[]{3, 4, -1, 1}, 4 ) );  //  2
//		System.out.println ( firstMissing ( new int[]{7, 8, 9, 11, 12}, 5 ) );  // 1

//		System.out.println ( recursiveProduct ( 10, 20 ) );

//		System.out.println ( getMinimumAnagramDifference ( "except", "accept" ) );
//		System.out.println ( getMinimumAnagramDifference ( "aa", "bb" ) );

//		System.out.println ( Arrays.toString ( anagramMapping ( 5, new int[]{10, 20, 30, 40, 50}, new int[]{20, 10, 40, 50, 30} ) ) );

//		System.out.println ( leftRotate ( "codingninjas", 3 ) );    // ingninjascod
//		System.out.println ( rightRotate ( "codingninjas", 3 ) );    // jascodingnin
//		System.out.println ( leftRotate ( "c", 1 ) );    // c
//		System.out.println ( rightRotate ( "c", 1 ) );    // c
//		System.out.println ( leftRotate ( "ce", 7 ) );    // c
//		System.out.println ( rightRotate ( "ce", 7 ) );    // c

//		System.out.println ( shortestCompletingWord ( "1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"} ) );

//		System.out.println ( missingNumber ( new int[]{1, 2, 4, 5}, 5 ) );  // 3
//		System.out.println ( missingNumber ( new int[]{1, 2, 3}, 4 ) );  // 4

//		System.out.println ( nthFibonacci ( 6 ) );  // 8

//		System.out.println ( firstUniqueCharacter ( "palindromemordnilap" ) );  // 10
//		System.out.println ( firstUniqueCharacter ( "notunique" ) );    // 2
//		System.out.println ( firstUniqueCharacter ( "caaabbc" ) );  // -1

//		System.out.println ( squareRoot ( 111111 ) );   // 333

//        System.out.println(groupPhoto(new int[]{2, 1, 3, 1, 4})); // 7
//        System.out.println(groupPhoto(new int[]{3, 1, 2})); // 5
//        System.out.println(groupPhoto(new int[]{2, 7, 8, 1})); // 10
//        System.out.println(groupPhoto(new int[]{1, 1, 2, 1, 2, 1})); // 3
//        System.out.println(groupPhoto(new int[]{4, 1, 1, 4})); // 8
//        System.out.println(groupPhoto(new int[]{19, 16, 8, 7, 12, 19, 10})); // 38

//        System.out.println(Arrays.toString(stockSpan(new int[]{13, 15, 12, 14, 16, 8, 6, 4, 10, 30}))); // 1 2 1 2 5 1 1 1 1 4 10
//        System.out.println(Arrays.toString(stockSpan(new int[]{10, 20, 30, 40})));  // 1 2 3 4
//        System.out.println(Arrays.toString(stockSpan(new int[]{40, 30, 20, 10})));  // 1 1 1 1
//        System.out.println(Arrays.toString(stockSpan(new int[]{30, 20, 25, 28, 27, 29})));  // 1 1 2 3 1 5
//        System.out.println(Arrays.toString(stockSpan(new int[]{18, 12, 13, 14, 11, 16})));  // 1 1 2 3 1 5
//        System.out.println(Arrays.toString(stockSpan(new int[]{60, 10, 20, 40, 35, 30, 50, 70, 65})));  // 1 1 2 3 1 1 6 8 1
//        System.out.println(Arrays.toString(stockSpan(new int[]{60, 70, 80, 100, 90, 75, 80, 120})));  // 1 2 3 4 1 1 2 8
//        System.out.println(Arrays.toString(stockSpan(new int[]{10, 10, 10, 10})));  // 1 1 1 1

//        System.out.println(Arrays.toString(buildMinHeap(new int[]{9, 3, 2, 6, 7})));    // 2, 3, 9, 6, 7
//        System.out.println(Arrays.toString(buildMinHeap(new int[]{1, 3, 2, 4})));    // 1, 3, 2, 4
//        System.out.println(Arrays.toString(buildMinHeap(new int[]{1, 3, 5, 4, 6})));    // 1, 3, 5, 4, 6
//        System.out.println(Arrays.toString(buildMinHeap(new int[]{8, 9, 0})));  // 0 9 8

//        System.out.println(buildHeap(arrayList1, arrayList1.size()));
//        System.out.println(buildHeap(arrayList2, arrayList2.size()));

//        System.out.println(MinToMaxHeap(6, new int[]{1, 2, 3, 6, 7, 8}));   // 8, 7, 3, 6, 2, 1
//        System.out.println(MinToMaxHeap(6, new int[]{1, 2, 3, 4, 5, 6}));   // 6, 5, 4, 2, 3, 1
//        System.out.println(MinToMaxHeap(6, new int[]{3, 5, 6, 7, 9, 12, 7}));

//        System.out.println(heapSort(arrayList, arrayList.size()));
    }

    public static int josephus(int n, int k) {
        return findSurvivor(n, k) + 1;
    }

    public static int findSurvivor(int n, int k) {
        if (n == 1) return 0;
        return (findSurvivor(n - 1, k) + k) % n;
    }

    public static String reverseStringSentence(String str) {
        String[] words = str.split(" ");
        for (int i = 0; i < words.length / 2; i++) {
            String temp = words[i];
            words[i] = words[words.length - i - 1];
            words[words.length - 1 - i] = temp;
        }
        str = "";
        for (String word : words) str += word + " ";
        return str;
    }

    public static int findCharacterCase() {
        Scanner scanner = new Scanner(System.in);
        char ch = scanner.next().charAt(0);
        if (ch >= 'A' && ch <= 'Z') return 1;
        else if (ch >= 'a' && ch <= 'z') return 0;
        else return -1;
    }

    public static StringBuilder replaceSpaces(StringBuilder str) {
        str = new StringBuilder(str.toString().replaceAll(" ", "@40"));
        return str;
    }

    public static boolean checkSubset(int[] arr1, int[] arr2, int n, int m) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int integer : arr1)
            hashMap.put(integer, hashMap.getOrDefault(integer, 0) + 1);
        for (int integer : arr2) {
            if (hashMap.containsKey(integer)) {
                hashMap.put(integer, hashMap.get(integer) - 1);
                if (hashMap.get(integer) == 0) hashMap.remove(integer);
            } else return false;
        }
        return true;
    }

    public static int recursiveProduct(int m, int n) {
        int small = Math.min(m, n);
        int large = Math.max(m, n);
        return calculateProductRecursively(large, small);
    }

    public static int calculateProductRecursively(int large, int small) {
        int MOD = 1000000007;
        if (small == 0) return 0;
        return large + calculateProductRecursively(large, small - 1) % MOD;
    }

    public static List<Integer> printSeries(int n, int k) {
        List<Integer> arrayList = new ArrayList<>();
        generateSeries(arrayList, n, k);
        return arrayList;
    }

    public static void generateSeries(List<Integer> arrayList, int n, int k) {
        arrayList.add(n);
        if (n <= 0) return;
        generateSeries(arrayList, n - k, k);
        arrayList.add(n);
    }

    public static int getMinimumAnagramDifference(String str1, String str2) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < str1.length(); i++) {
            Character character = str1.charAt(i);
            hashMap.put(character, hashMap.getOrDefault(character, 0) + 1);
        }
        System.out.println(hashMap);
        for (int i = 0; i < str2.length(); i++) {
            Character character = str2.charAt(i);
            if (hashMap.containsKey(character)) {
                hashMap.put(character, hashMap.get(character) - 1);
                if (hashMap.get(character) == 0) hashMap.remove(character);
            }
        }
        for (Entry<Character, Integer> entry : hashMap.entrySet()) {
            Integer value = entry.getValue();
            sum += value;
        }
        return sum;
    }

    public static boolean isAnagram(String str1, String str2) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            Character character = str1.charAt(i);
            hashMap.put(character, hashMap.getOrDefault(character, 0) + 1);
        }
        for (int i = 0; i < str2.length(); i++) {
            Character character = str2.charAt(i);
            if (hashMap.containsKey(character)) {
                hashMap.put(character, hashMap.get(character) - 1);
                if (hashMap.get(character) == 0) hashMap.remove(character);
            }
        }
        return hashMap.isEmpty();
    }

    public static int[] anagramMapping(int n, int[] a, int[] b) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] answer = new int[a.length];
        for (int i = 0; i < b.length; i++) hashMap.put(b[i], i);
        System.out.println(hashMap);
        for (int i = 0; i < a.length; i++) answer[i] = hashMap.get(a[i]);
        return answer;
    }

    public static String removeAllOccurrencesOfChar(String input, char c) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == c)
                input = input.replaceAll(String.valueOf(input.charAt(i)), "");
        }
        return input;
    }

    public static char firstNonRepeating(String str) {
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character character = str.charAt(i);
            hashMap.put(character, hashMap.getOrDefault(character, 0) + 1);
        }
        for (Entry<Character, Integer> entry : hashMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value == 1) return key;
        }
        return (char) -1;
    }

    public static String leftRotate(String str, int d) {
        if (str.length() == 1) return str;
        if (d > str.length()) d %= str.length();
        String s = str + str;
        s = s.substring(d, str.length() + d);
        return s;
    }

    public static String rightRotate(String str, int d) {
        if (str.length() == 1) return str;
        if (d > str.length()) d %= str.length();
        return str.substring(str.length() - d) + str.substring(0, str.length() - d);
    }

    public static boolean isCircular(Node head) {
        if (head == null || head.next == head) return true;
        Node slowPtr = head;
        Node fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr && slowPtr == head) return true;
        }
        return false;
    }

    public static int squareRoot(int a) {
        int left = 0, right = a;
        int sqrt = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long midSq = (long) mid * mid;
            if (midSq == a) return mid;
            else if (midSq > a) right = mid - 1;
            else {
                sqrt = mid;
                left = mid + 1;
            }
        }
        return sqrt;
    }

    public static int missingNumber(int[] array, int N) {
        boolean[] boolArray = new boolean[N + 1];
        Arrays.fill(boolArray, false);
        for (int integer : array) {
            System.out.println(integer);
            boolArray[integer] = true;
        }
        System.out.println(Arrays.toString(boolArray));
        for (int i = 1; i < boolArray.length; i++) {
            if (!boolArray[i]) return i;
        }
        return 0;
    }

    public static int nthFibonacci(int N) {
        int t1 = 0, t2 = 1;
        int t3 = t2;
        for (int i = 0; i < N - 1; i++) {
            t3 = t1 + t2;
            t1 = t2;
            t2 = t3;
        }
        return t3;
    }

    // https://www.codingninjas.com/codestudio/problems/occurrence-of-x-in-a-sorted-array_630456
    // TODO: SUBMIT IN 2x BOOSTER
    public static int countOccurrences(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        int firstOccur = -1, lastOccur = -1;
        // find first occurrence
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                firstOccur = mid;
                right = mid - 1;
            } else if (arr[mid] > x) right = mid - 1;
            else if (arr[mid] < x) left = mid + 1;
        }

        // find last occurrence
        left = 0;
        right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                lastOccur = mid;
                left = mid + 1;
            } else if (arr[mid] > x) right = mid - 1;
            else if (arr[mid] < x) left = mid + 1;
        }
        return firstOccur == -1 && lastOccur == -1 ? 0 : lastOccur - firstOccur + 1;
    }

    public static int firstUniqueCharacter(String s) {
        HashMap<Character, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (hashMap.containsKey(character)) {
                ArrayList<Integer> arrayList = hashMap.get(character);
                arrayList.add(i + 1);
                hashMap.put(character, arrayList);
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i + 1);
                hashMap.put(character, arrayList);
            }
        }
        System.out.println(hashMap);
        for (Entry<Character, ArrayList<Integer>> e : hashMap.entrySet()) {
            Character k = e.getKey();
            ArrayList<Integer> v = e.getValue();
            if (v.size() == 1) return v.get(0);
        }
        return -1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int groupPhoto(int[] a) {
//		System.out.println ( Arrays.toString ( a ) );
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        int secondMaxIndex = 0;
        int secondMax = Integer.MIN_VALUE;
        // find max height
        for (int i = 0; i < a.length; i++) {
            int height = a[i];
            if (a[maxIndex] <= height) {
                maxIndex = i;
                if (max == height) {
                    secondMaxIndex = maxIndex;
                    secondMax = max;
                } else max = height;
            }
        }
        if (secondMax != max) {
            for (int i = 0; i < a.length; i++) {
                int height = a[i];
                if (maxIndex != i && secondMax <= a[i]) {
                    secondMaxIndex = i;
                    secondMax = height;
                }
            }
        }
//		System.out.println ( "maxIndex = " + maxIndex );
//		System.out.println ( "max = " + max );
//		System.out.println ( "secondMaxIndex = " + secondMaxIndex );
//		System.out.println ( "secondMax = " + secondMax );

        if (a[0] == max) {
            swap(a, a.length - 1, secondMaxIndex);
//			System.out.println ( "if " + Arrays.toString ( a ) );
        } else if (a[a.length - 1] == max) {
            swap(a, 0, secondMaxIndex);
//			System.out.println ( "else if " + Arrays.toString ( a ) );
        } else {
            // if terminal heights are not max
            // if a[0] >= a[length-1] swap max with a[length-1]
            // else swap max with a[0]
            boolean firstGreater = a[0] >= a[a.length - 1];
            if (firstGreater) {
                // swap max height with first height
                swap(a, a.length - 1, maxIndex);
            } else {
                // swap max height with last height
                swap(a, 0, maxIndex);
            }
//			System.out.println ( "else " + Arrays.toString ( a ) );
        }
        return a[0] + a[a.length - 1];
    }

    public static int searchInRotatedSorted(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[left] < arr[mid]) {
                // left array sorted
                if (arr[left] <= key && key < arr[mid]) right = mid - 1;
                else if (arr[left] == key) return left;
                else left = mid + 1;
            } else {
                // right array sorted
                if (arr[mid] < key && key <= arr[right]) left = mid + 1;
                else if (arr[right] == key) return right;
                else right = mid - 1;
            }
        }
        return -1;
    }

    // https://www.codingninjas.com/codestudio/problems/find-the-single-element_6680465
    // TODO: ASKED IN GFG CHAT
    public static int getSingleElement(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (left == right) return arr[left];
            if (mid % 2 == 0) {
                if (arr[mid] == arr[mid + 1]) left = mid + 2;
                else right = mid;
            } else {
                if (arr[mid] == arr[mid - 1]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    // https://www.codingninjas.com/codestudio/problems/allocate-books_1089560
    // TODO: SUBMIT IN 2x BOOSTER
    public static int allocateBooks(ArrayList<Integer> arr, int n, int m) {
        if (arr.size() < m) return -1;
        int sum = 0, max = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
            max = Math.max(max, arr.get(i));
        }
        int low = max, high = sum, minPages = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isFeasible(arr, m, mid)) {
                minPages = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        return minPages;
    }

    private static boolean isFeasible(ArrayList<Integer> arr, int m, int mid) {
        int sum = 0, requiredStudents = 1;
        for (int i = 0; i < arr.size(); i++) {
            if (sum + arr.get(i) > mid) {
                requiredStudents++;
                sum = arr.get(i);
            } else sum += arr.get(i);
        }
        return requiredStudents <= m;
    }

    public static double squareRootDecimal(long n, int precision) {
        long low = 0, high = n;
        double sqrt = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long midSq = mid * mid;
            if (n == midSq) {
                sqrt = mid;
                break;
            } else if (n > midSq) {
                low = mid + 1;
                sqrt = mid;
            } else high = mid - 1;
        }
        double increment = 0.1;
        for (int i = 0; i < precision; i++) {
            while (sqrt * sqrt <= n) sqrt += increment;
            sqrt -= increment;
            increment /= 10;
        }
        return sqrt;
    }

    public static double median(int[] a, int[] b) {
        int begin = 0, end = a.length;
        int n1 = a.length, n2 = b.length;
        while (begin <= end) {
            int i1 = begin + (end - begin) / 2;
            int i2 = (n1 + n2 + 1) / 2 - i1;

            int max1 = (i1 == 0) ? Integer.MIN_VALUE : a[i1 - 1];
            int max2 = (i2 == 0) ? Integer.MIN_VALUE : b[i2 - 1];
            int min1 = (i1 == n1) ? Integer.MAX_VALUE : a[i1];
            int min2 = (i2 == n2) ? Integer.MAX_VALUE : b[i2];

            if (max1 <= min2 && max2 <= min1) {
                if ((n1 + n2) % 2 == 0)
                    return ((double) Math.max(max1, max2) + (double) Math.min(min1, min2)) / 2;
                else return Math.max(max1, max2);
            } else if (max1 > min2) end = i1 - 1;
            else begin = i1 + 1;
        }
        return -1;
    }

    // https://www.codingninjas.com/codestudio/problems/stock-span_99652
    // TODO: SUBMIT IN 2x BOOSTER
    public static int[] stockSpan(int[] price) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[price.length];
        Arrays.fill(result, 1);
        for (int i = 1; i < price.length; i++) {
            stack.push(i - 1);
            while (!stack.isEmpty() && price[stack.peek()] < price[i]) stack.pop();
            if (!stack.isEmpty()/* && price[stack.peek()] > price[i]*/)
                result[i] = i - stack.peek();
            else result[i] = i + 1;
        }
        return result;
    }

    // https://www.codingninjas.com/codestudio/problems/reversing-a-queue_982934
    // TODO: SUBMIT IN 2x BOOSTER
    public static java.util.Queue<Integer> reverseQueue(java.util.Queue<Integer> q) {
        // Write your code here.
        java.util.Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty()) stack.push(q.remove());
        while (!stack.isEmpty()) q.add(stack.pop());
        return q;
    }

    public static java.util.Queue<Integer> reverseElements(java.util.Queue<Integer> q, int k) {
        // Write your code here.
        Stack<Integer> stack = new Stack<>();
        java.util.Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) stack.push(q.remove());
        while (!stack.isEmpty()) queue.add(stack.pop());
        while (!q.isEmpty()) queue.add(q.remove());
        return queue;
    }

    public static TreeNode<Integer> buildBinaryTree(ArrayList<Integer> inorder, ArrayList<Integer> preorder) {
        LinkedHashSet<Integer> inorderHashSet = new LinkedHashSet<>(inorder);
        return constructTreePreorderInorder(inorderHashSet, preorder, 0, inorder.size(), new AtomicInteger(0));
    }

    public static TreeNode<Integer> constructTreePreorderInorder(
            LinkedHashSet<Integer> inorderHashSet,
            ArrayList<Integer> preorder,
            int inorderStart,
            int inorderEnd,
            AtomicInteger preIndex) {
        if (inorderStart > inorderEnd) return null;
        TreeNode<Integer> root = new TreeNode<>(preorder.get(preIndex.getAndIncrement()));
        int inIndex = -1;
        for (Integer item : inorderHashSet) {
            if (Objects.equals(item, root.data)) {
                inIndex++;
                break;
            }
            inIndex++;
        }
        root.left = constructTreePreorderInorder(inorderHashSet, preorder, inorderStart, inIndex - 1, preIndex);
        root.right = constructTreePreorderInorder(inorderHashSet, preorder, inIndex + 1, inorderEnd, preIndex);
        return root;
    }

    // https://www.codingninjas.com/codestudio/problems/level-order-traversal_796002
    // TODO: SUBMIT IN 2x BOOSTER
    public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) return new ArrayList<>();
        java.util.Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                BinaryTreeNode current = queue.remove();
                arrayList.add(current.data);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
        return arrayList;
    }

    public static void leftView(TreeNode<Integer> root) {
        if (root == null) return;
        java.util.Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode current = queue.remove();
                if (i == 0) System.out.print(current.data + " ");
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
    }

    // https://www.codingninjas.com/codestudio/problems/is-height-balanced-binary-tree_975497
    // TODO: SUBMIT IN 2x BOOSTER
    public static boolean isBalancedBT(BinaryTreeNode root) {
        if (root == null) return true;
        return height(root) != -1;
    }

    public static int height(BinaryTreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = height(root.right);
        if (rightHeight == -1) return -1;
        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : Math.max(leftHeight, rightHeight) + 1;
    }

    // https://www.codingninjas.com/codestudio/problems/right-view_764605
    // TODO: SUBMIT IN 2x BOOSTER
    public static ArrayList<Integer> printRightView(BinaryTreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) return arrayList;
        java.util.Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                BinaryTreeNode current = queue.remove();
                if (i == count - 1) arrayList.add(current.data);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
        return arrayList;
    }

    static long nodeLevel(BinaryTreeNode root, int node) {
        java.util.Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        long level = 1;
        while (!queue.isEmpty()) {
            int count = queue.size();
            level++;
            for (int i = 0; i < count; i++) {
                BinaryTreeNode current = queue.remove();
                if (Objects.equals(current.data, node)) return level;
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
        return level;
    }

    static int[] buildMinHeap(int[] heap) {
        for (int i = heap.length / 2 - 1; i >= 0; i--) minHeapify(heap, i);
        return heap;
    }

    static void minHeapify(int[] heap, int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;
        if (left < heap.length && heap[left] < heap[smallest]) smallest = left;
        if (right < heap.length && heap[right] < heap[smallest]) smallest = right;
        if (smallest != i) {
            swap(heap, i, smallest);
            minHeapify(heap, smallest);
        }
    }

    static void swapHeap(int[] arr, int i, int smallest) {
        int temp = arr[i];
        arr[i] = arr[smallest];
        arr[smallest] = temp;
    }

    static int parent(int i) {
        return (i - 1) / 2;
    }

    static int leftChild(int i) {
        return 2 * i + 1;
    }

    static int rightChild(int i) {
        return 2 * i + 2;
    }

    static ArrayList<Integer> buildHeap(ArrayList<Integer> arrayList, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--)
            maxHeapify(arrayList, arrayList.size(), i);
        return arrayList;
    }

    static void maxHeapify(ArrayList<Integer> arrayList, int n, int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;
        if (left < n && arrayList.get(left) > arrayList.get(largest)) largest = left;
        if (right < n && arrayList.get(right) > arrayList.get(largest)) largest = right;
        if (largest != i) {
            swapArrayList(arrayList, i, largest);
            maxHeapify(arrayList, n, largest);
        }
    }

    static void swapArrayList(ArrayList<Integer> arrayList, int i, int j) {
        int temp = arrayList.get(i);
        arrayList.set(i, arrayList.get(j));
        arrayList.set(j, temp);
    }

    static ArrayList<Integer> MinToMaxHeap(int n, int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) maxHeapifyFromArray(arr, i);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int j : arr) arrayList.add(j);
        return arrayList;
    }

    static void maxHeapifyFromArray(int[] arr, int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;
        if (left < arr.length && arr[left] > arr[largest]) largest = left;
        if (right < arr.length && arr[right] > arr[largest]) largest = right;
        if (largest != i) {
            swapHeap(arr, i, largest);
            maxHeapifyFromArray(arr, largest);
        }
    }

    static ArrayList<Integer> heapSort(ArrayList<Integer> arrayList, int n) {
        buildMaxHeap(arrayList);
        for (int i = arrayList.size() - 1; i >= 1; i--) {
            swapArrayList(arrayList, 0, i);
            maxHeapify(arrayList, i, 0);
        }
        return arrayList;
    }

    static ArrayList<Integer> buildMaxHeap(ArrayList<Integer> arrayList) {
        for (int i = (arrayList.size() - 2) / 2; i >= 0; i--)
            maxHeapify(arrayList, arrayList.size(), i);
        return arrayList;
    }

    // TODO: SUBMIT IN 2x BOOSTER
    public static boolean findInMatrix(int x, ArrayList<ArrayList<Integer>> arr) {
        int i = 0, j = arr.get(0).size() - 1;
        while (i < arr.size() && j >= 0) {
            if (arr.get(i).get(j) == x) return true;
            else if (arr.get(i).get(j) > x) j--;
            else i++;
        }
        return false;
    }

    static boolean searchElement(int[][] MATRIX, int target) {
        int R = MATRIX.length, C = MATRIX[0].length;
        int i = 0, j = C - 1;
        while (i < R && C >= j) {
            if (MATRIX[i][j] == target) return true;
            else if (MATRIX[i][j] < target) j--;
            else i++;
        }
        return true;
    }

    public int searchInRotatedSortedArray(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[left] < nums[mid]) {
                // left array sorted
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else if (nums[left] == target) return left;
                else left = mid + 1;
            } else {
                // right array sorted
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else if (nums[right] == target) return right;
                else right = mid - 1;
            }
        }
        return -1;

        /**
         * Testcase Dry Run --> {5, 1, 2, 3, 4}, target = 1
         * left = 0, right = 4, mid = 2: 2 ≠ target
         * left = 0, right = 1, mid = 2: 2 ≠ target
         */
    }

    static class Queue {
        static Queue next;
        static Queue head;
        static Queue tail;
        int data;

        Queue() {
            // Implement the Constructor
            head = tail = null;
        }

        Queue(int data) {
            this.data = data;
            next = null;
        }

        /*----------------- Public Functions of Queue -----------------*/

        boolean isEmpty() {
            // Implement the isEmpty() function
            return head == null;
        }

        void enqueue(int data) {
            // Implement the enqueue() function
            Queue newnode = new Queue(data);
            if (head == null) {
                head = tail = newnode;
                return;
            }
            next = newnode;
            tail = newnode;
        }

        int dequeue() {
            // Implement the dequeue() function
            if (head == null) return -1;
            int dequeuedData = head.data;
            head = next;
            if (head == null) tail = null;
            return dequeuedData;
        }

        int front() {
            // Implement the front() function
            return head != null ? head.data : -1;
        }
    }

    public static class MinHeap {
        int[] heap;
        int heapSize;

        // Constructor for the class.
        MinHeap() {
            // Write your code here.
            heapSize = 0;
            heap = new int[100000];
        }

        // Implement the function to heapify the heap.
        void heapify(int i) {
            // Write your code here.
            int lt = 2 * i + 1;
            int rt = 2 * i + 2;
            int smallest = i;
            if (lt < heapSize && heap[lt] < heap[smallest]) smallest = lt;
            if (rt < heapSize && heap[rt] < heap[smallest]) smallest = rt;
            if (smallest != i) {
                swap(i, smallest);
                heapify(smallest);
            }
        }

        // Implement the function to insert 'val' in the heap.
        void insert(int val) {
            // Write your code here.
            heap[heapSize] = val;
            int i = heapSize;
            heapSize++;
            while (i != 0 && heap[parent(i)] > heap[i]) {
                int tmp = heap[i];
                heap[i] = heap[parent(i)];
                heap[parent(i)] = tmp;

                i = parent(i);
            }
        }

        // Implement the function to remove minimum element.
        void removeMin() {
            // Write your code here.
            if (heapSize == 1) {
                heapSize--;
                return;
            }
            heap[0] = heap[heapSize - 1];
            heapSize--;
            heapify(0);
        }

        // Implement the function to return minimum element.
        int minElement() {
            // Write your code here.
            return heap[0];
        }

        void swap(int i, int j) {
            int tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }
    }

    // https://www.codingninjas.com/codestudio/problems/circular-queue_1170058
    // TODO: SUBMIT IN 2x BOOSTER
    class CircularQueue {
        int[] array;
        int currentSize, capacity, front, rear;

        // Initialize your data structure.
        public CircularQueue(int n) {
            capacity = n;
            array = new int[capacity];
            currentSize = 0;
            front = 0;
            rear = capacity - 1;
        }

        /*
           Enqueues 'X' into the queue. Returns true if it gets pushed into the stack,
           and false otherwise.
        */
        public boolean enqueue(int value) {
            // Write your code here.
            if (currentSize == capacity) return false;
            rear = (rear + 1) % capacity;
            array[rear] = value;
            currentSize++;
            return true;
        }

        /*
          Dequeues top element from queue. Returns -1 if the stack is empty, otherwise
          returns the popped element.
        */
        public int dequeue() {
            // Write you code here.
            if (currentSize == 0) return -1;
            int dequeuedData = array[front];
            front = (front + 1) % capacity;
            currentSize--;
            return dequeuedData;
        }
    }

    public class StackUsingQueue {
        // Define the data members.
        java.util.Queue<Integer> queue1 = new LinkedList<>();
        java.util.Queue<Integer> queue2 = new LinkedList<>();

        public StackUsingQueue() {
            // Implement the Constructor.
        }

        /*----------------- Public Functions of Stack -----------------*/

        public int getSize() {
            // Implement the getSize() function.
            return queue1.size();
        }

        public boolean isEmpty() {
            // Implement the isEmpty() function.
            return queue1.isEmpty();
        }

        public void push(int element) {
            // Implement the push(element) function.
            queue2.add(element);
            while (!queue1.isEmpty()) queue2.add(queue1.remove());
            while (!queue2.isEmpty()) queue1.add(queue2.remove());
        }

        public int pop() {
            // Implement the pop() function.
            return !isEmpty() ? queue1.remove() : -1;
        }

        public int top() {
            // Implement the top() function.
            return queue1 != null && !queue1.isEmpty() ? queue1.peek() : -1;
        }
    }

    public class QueueUsingStack {
        // Define the data members(if any) here.
        java.util.Stack<Integer> stack1 = new Stack<>();
        java.util.Stack<Integer> stack2 = new Stack<>();

        QueueUsingStack() {
            // Initialize your data structure here.
        }

        void enQueue(int val) {
            // Implement the enqueue() function.
            while (!stack1.isEmpty()) stack2.push(stack1.pop());
            stack1.push(val);
            while (!stack2.isEmpty()) stack1.push(stack2.pop());
        }

        int deQueue() {
            // Implement the dequeue() function.
            return stack1.isEmpty() ? -1 : stack1.pop();
        }

        int peek() {
            // Implement the peek() function here.
            return stack1.isEmpty() ? -1 : stack1.peek();
        }

        boolean isEmpty() {
            // Implement the isEmpty() function here.
            return stack1.isEmpty();
        }
    }
}
