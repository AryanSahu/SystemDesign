package com.study.coding.ds;

import java.util.*;

public class ArraysPractise {

    public static void main(String[] args) {

        String s1="anagram";
        String s2="";

        int arr[]=new int[26];

        for (int i=0;i<s1.length();i++)
        {
            arr[s1.charAt(i)-'a']++;

        }





    }



    public boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {

            Character start = s.charAt(i);
            Character end = s.charAt(j);

            if (!Character.isLetterOrDigit(start)) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(end)) {
                j--;
                continue;
            }

            if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }


    //https://leetcode.com/problems/excel-sheet-column-title/
    public static String convertToTitle(int columnNumber) {
        String result = new String();

        while (columnNumber > 0) {

            columnNumber--;
            char currentChar = (char) (65 + columnNumber % 26);
            result=result+currentChar;

            columnNumber /= 26;
        }

        System.out.println(result);

        return result.toString();
    }



    public static void main1(String[] args) {
        List<Integer> list1 = new ArrayList<>(List.of(1, 3, 5, 7));
        List<Integer> list2 = new ArrayList<>(List.of(2, 4, 6, 8));

        int nums1[]={1,3,5,7};
        int nums2[]={2,4,6,8};

       mergeSortedLists(nums1,nums2);
        // Output: [1, 2, 3, 4, 5, 6, 7, 8]
    }


    public static void mergeSortedLists(int num1[],int num2[])
    {
        int num1Length=num1.length;
        int num2Length=num2.length;

        int sortedArray[]=new int[num1Length+num2Length];

        int i=0;
        int j=0;
        int k=0;

        while(i<num1Length && j<num2Length)
        {
            if (num1[i] < num2[j])
                sortedArray[k++] = num1[i++];
            else sortedArray[k++] = num2[j++];
        }

        while(i<num1Length)
        {
            sortedArray[k++] = num1[i++];
        }

        while(j<num2Length)
        {
            sortedArray[k++] = num2[j++];
        }

        System.out.println(Arrays.toString(sortedArray));



    }



        public int search(int[] nums, int target) {

            int l = 0;
            int r = nums.length - 1;

            while(l<=r){

                int mid = (l+r)/2;

                if(nums[mid] == target){
                    return mid;
                }
                //left sorted
                if(nums[l]<=nums[mid]){
                    if(target > nums[mid] || target < nums[l]){
                        l = mid + 1;
                    }else{
                        r = mid - 1;
                    }
                }else{//right sorted
                    if(target < nums[mid] || target > nums [r]){
                        r = mid - 1;
                    }else{
                        l = mid + 1;
                    }
                }

            }

            return -1;
        }



    public int findMinInRotatedArray(int[] nums)
    {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            if (nums[l] <= nums[r]) {
                return nums[l];
            }

            int mid = (l + r) / 2;
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return 0;
    }


    private static void BinarySearch() {

        int nums[] = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int mid = (i + j) / 2;

            if (nums[mid] == target) {
                System.out.println("Found target at index " + mid);
                break;
            }
           if(target > nums[mid])
           {
               i=mid+1;
           }

            if(target < nums[mid])
            {
                j=mid-1;
            }

        }
    }


    public boolean PermutationInString(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return false;
            }

            int[] s1CharCount = new int[26]; // Count of characters in s1
            int[] windowCharCount = new int[26]; // Count of characters in the sliding window

            // Count characters in s1
            for (char c : s1.toCharArray()) {
                s1CharCount[c - 'a']++;
            }

            int windowSize = s1.length();

            // Initialize the window character count for the first window
            for (int i = 0; i < windowSize; i++) {
                windowCharCount[s2.charAt(i) - 'a']++;
            }

            // Slide the window through s2
            for (int i = windowSize; i <= s2.length(); i++) {
                // Compare character counts in the window with those in s1
                if (Arrays.equals(s1CharCount, windowCharCount)) {
                    return true;
                }

                // Update the window character count by removing the leftmost character and adding the current character
                if (i < s2.length()) {
                    windowCharCount[s2.charAt(i - windowSize) - 'a']--;
                    windowCharCount[s2.charAt(i) - 'a']++;
                }
            }

            return false;
        }



    private static void trappingRainWater() {
        // Find maximum height on both the sides from current
        // now minus the current height with minimum of maximum of both sides

        int  height[] = {4,2,0,3,2,5};


        int maxLeft[]=new int[height.length];
        int maxright[]=new int[height.length];

        int max=Integer.MIN_VALUE;

        for(int i=0;i<height.length;i++)
       {
           max=Math.max(max,height[i]);
           maxLeft[i]=max;

       }
        max=Integer.MIN_VALUE;

        for(int j=height.length-1;j>=0;j--)
        {
            max=Math.max(max,height[j]);
            maxright[j]=max;

        }

        int totalWater=0;
        for(int i=0;i<height.length;i++)
        {
            int minimumOfMaxTowers=Math.min(maxLeft[i],maxright[i]);
            int water=minimumOfMaxTowers-height[i];
            totalWater=totalWater+water;

        }

        System.out.println("Total water collected is "+totalWater);
    }



        public int characterReplacement(String s, int k) {
            int[] charCounts = new int[26]; // Count of each character (A-Z)
            int maxCount = 0; // Maximum character count in the sliding window
            int maxLength = 0; // Length of the longest valid substring
            int windowStart = 0; // Start index of the sliding window

            for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
                char c = s.charAt(windowEnd);
                charCounts[c - 'A']++; // Increment the count of the current character
                maxCount = Math.max(maxCount, charCounts[c - 'A']); // Update max character count

                // Calculate the size of the current window and check if the condition is violated
                // The condition is violated if the size of the window minus the max count is greater than k

                int windowsize=windowEnd - windowStart + 1;
                if ( windowsize- maxCount > k) {
                    charCounts[s.charAt(windowStart) - 'A']--; // Decrement count of the character at windowStart
                    windowStart++; // Slide the window to the right
                }

                // Update the maxLength with the current window size
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            }

            return maxLength;
        }



    public static int longestUniqueSubstringLength(String str) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int max_len = 0;
        int i = 0, j = 0;
        int windowSize;


        while (j < str.length()) {
            char chRight = str.charAt(j);
            mp.put(chRight, mp.getOrDefault(chRight, 0) + 1);
            windowSize = (j - i + 1);

            if (mp.size() == windowSize) {
                max_len = Math.max(max_len, windowSize);
            } else {
                while ( windowSize > mp.size()) {
                    char chLeft = str.charAt(i);
                    mp.put(chLeft, mp.get(chLeft) - 1);

                    if (mp.get(chLeft) == 0) {
                        mp.remove(chLeft);
                    }
                    i++;
                    windowSize--;  // increasing left meaning window size is shrunk.
                }

            }
            j++;
        }

        System.out.println(max_len);
        return max_len;
    }

    private static void maxContainerTwoPointer() {
        int  height[] = {1,8,6,2,5,4,8,3,7};
        int maxArea=Integer.MIN_VALUE;
        int low=0;
        int high=height.length-1;

        while(low<high)
        {
            int width=high-low;
            int h=Math.min(height[low],height[high]);
            int area=h*width;
            maxArea=Math.max(maxArea,area);

            if(height[low]<height[high])
            {
                low++;
            }
            else
            {
                high--;
            }

        }

        System.out.println("Max Area  "+maxArea);
    }

    private static void MaxContainerBF() {
        int  height[] = {1,8,6,2,5,4,8,3,7};
        int maxArea=Integer.MIN_VALUE;

        for(int i=0;i<height.length;i++)
        {

            for(int j=i+1;j<height.length;j++)
            {

                int width=j-i;
                int h=Math.min(height[i],height[j]);
                int area=h*width;
                maxArea=Math.max(maxArea,area);

            }
        }

        System.out.println("Max Area --"+maxArea);
    }


    public int[] twoSum(int[] nums, int target) {


        //[2,7,11,15]

        HashMap<Integer,Integer> set=new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++)
        {

            int complement=target-nums[i];
            if(set.containsKey(complement))
            {
                return new int[]{set.get(complement),i};
            }
            set.put(nums[i],i);

        }

        return new int[]{};

    }






    private static void SortColors() {
        int nums[]={2,0,2,1,1,1,0};

        int redCount=0;
        int whiteCount=0;
        int blueCount=0;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                redCount++;
            } else if (nums[i]==1) {
                whiteCount++;
            }
            else
            {
                blueCount++;
            }
        }

        for(int i=0;i<nums.length;i++)
        {
            if(i<redCount)
            {
                nums[i]=0;

            }
           else  if(redCount<=i && i<whiteCount+redCount)
            {
                nums[i]=1;

            }
            else
            {
                nums[i]=2;
            }

        }


        System.out.println(Arrays.toString(nums));
    }

    private static void StockBuySell3() {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};

        int profit = 0;


        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());


        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {

                maxPriorityQueue.add((prices[i + 1] - prices[i]));
            }
        }

        System.out.println("Profit ------" + (maxPriorityQueue.poll() + maxPriorityQueue.poll()));
    }

    private static void StockBuy1() {
        int[] nums = {7, 1, 5, 3, 6, 4};

        int leftMin = Integer.MAX_VALUE;
        int rightMax = Integer.MIN_VALUE;

        int leftIndex = 0;
        int rightIndex = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < leftMin) {
                leftMin = nums[i];
                leftIndex = i;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > rightMax && i > leftIndex) {
                rightMax = nums[i];

            }
        }


        System.out.println("Min " + leftMin + "Max" + rightMax);

        System.out.println("Profit =" + (rightMax - leftMin));
    }

    private static void sumArray() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 9;

        Map<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0, 1);  // Initialize with cumulative sum 0 appearing once
        int cumulativeSum = 0;
        int count = 0;


        for (int num : nums) {
            cumulativeSum += num;
            if (sumCount.containsKey(cumulativeSum - k)) {
                count += sumCount.get(cumulativeSum - k);
            }
            sumCount.put(cumulativeSum, sumCount.getOrDefault(cumulativeSum, 0) + 1);
        }

        System.out.println(count);
    }

    private static void stockBuySell2() {
        int prices[] = {1, 2, 3, 4, 5};
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                int profit = prices[i] - prices[i - 1];
                maxProfit += profit;
            }
        }

        System.out.println(maxProfit);
    }

    private static void stockBuySell1() {
        int prices[] = {7, 1, 5, 3, 6, 4};

        int rightmax_arr[] = new int[prices.length];
        int max = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            prices[i] = max - prices[i];
            //rightmax_arr[i]=max;

        }

        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int profit = rightmax_arr[i] - prices[i];
            maxProfit = Math.max(maxProfit, profit);
        }

        System.out.println(Arrays.toString(prices));
    }

    private static void LCS() {
        int nums[] = {5, 100, 4, 200, 1, 3, 2};

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);

        }

        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            if (!numSet.contains(nums[i] - 1)) {
                int currentNum = nums[i];
                int currentLength = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }
                maxLength = Math.max(maxLength, currentLength);

            }
        }


        System.out.println("---- maxlength " + maxLength);
    }

    private static void encodeDecode() {
        //Input: [“lint_”,“_code”,“love”,“you”]
        // Output: [“lint”,“code”,“love”,“you”]


        String arr[] = {"lint", "code", "love", "you"};


        String encodedString = "";
        for (String plainString : arr) {


            encodedString += plainString.length() + "#" + plainString;

        }

        System.out.println(encodedString);

        String eString = "22l6#int5#1code4#love3#you";
        int i = 0;
        List<String> list = new ArrayList<>();
        while (i < eString.length()) {
            int len = Character.getNumericValue(eString.charAt(i));
            list.add(eString.substring(i + 2, i + 2 + len));
            i = i + 2 + len;
        }

        System.out.print(list);
    }

    private static void validSudoku() {
        char[][] sudokuBoard = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        HashSet<String> keys = new HashSet<>();

        boolean isValid = true;

        for (int i = 0; i < sudokuBoard.length; i++) {

            for (int j = 0; j < sudokuBoard.length; j++) {

                char cell = sudokuBoard[i][j];

                if (cell != '.') {
                    String rowKey = cell + "_" + i + "_row";
                    String colKey = cell + "_" + j + "_column";
                    String blockKey = cell + "_" + i / 3 + "_" + j / 3 + "_block";
                    if (keys.contains(rowKey) || keys.contains(colKey) || keys.contains(blockKey)) {
                        System.out.println("Not a Valid Sudoku ****");
                        isValid = false;
                        return;
                    }

                    keys.add(rowKey);
                    keys.add(colKey);
                    keys.add(blockKey);


                }


            }

        }


        if (isValid) {
            System.out.println("Is Valid ****");
        }
    }

    private static void productofArray() {
        int nums[] = {1, 2, 3, 4};

        int sum = 1;
        for (int i = 0; i < nums.length; i++) {
            sum *= nums[i];

        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sum / nums[i];

        }

        System.out.println(Arrays.toString(nums));
    }

    public int[] productExceptSelf(int[] nums) {
       int left=1;
       int right=1;

       for(int i=0;i<nums.length;i++)
       {
           nums[i]=left;
           left=left*nums[i];

       }
       for(int j=nums.length;j>0;j--)
       {
           nums[j]=nums[j]*right;
           right=nums[j]*right;
       }

       return nums;

    }


    public static void GroupAnagramsUsingCharArray(String[] args) {

        // Input: strs = ["eat","tea","tan","ate","nat","bat"]
        // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        // extracted();


        List<List<String>> anagramList = new ArrayList<>();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        HashMap<String, List<String>> map = new HashMap<>();

        for (String name : strs) {

            int charArr[] = new int[26];

            for (int i = 0; i < name.length(); i++) {
                int index = name.charAt(i) - 'a';
                charArr[index]++;
            }

            String key = Arrays.toString(charArr);

            if (map.containsKey(key)) {
                map.get(key).add(name);

            } else {
                List a = new ArrayList<>();
                a.add(name);
                map.put(key, a);
            }

        }

        for (Map.Entry a : map.entrySet()) {
            anagramList.add((List<String>) a.getValue());

        }


        System.out.println(anagramList);


    }

    private static void GroupAnagramsUsingMap() {
        List<List<String>> anagramList = new ArrayList<>();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        HashMap<String, List<String>> map = new HashMap<>();

        for (String name : strs) {


            char str[] = name.toCharArray();
            Arrays.sort(str);

            String key = String.valueOf(str);

            if (map.containsKey(key)) {
                map.get(key).add(name);

            } else {
                List a = new ArrayList<>();
                a.add(name);
                map.put(key, a);
            }

        }

        for (Map.Entry a : map.entrySet()) {
            anagramList.add((List<String>) a.getValue());

        }


        System.out.println(anagramList);
    }


}

