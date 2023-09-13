package com.study.coding.ds;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenericArrayProblems {






        public static void main(String[] args) {
            String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
            List<List<String>> groupedAnagrams = groupAnagrams(strs);

            for (List<String> group : groupedAnagrams) {
                System.out.println(group);
            }
        }

        public static List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> anagramGroups = new HashMap<>();

            for (String str : strs) {
                int[] arr = new int[26]; // Character frequency array
                for (char c : str.toCharArray()) {
                    arr[c - 'a']++;
                }

                StringBuilder keyBuilder = new StringBuilder();
                for (int count : arr) {
                    keyBuilder.append(count).append("#");
                }
                String key = keyBuilder.toString();

                if (!anagramGroups.containsKey(key)) {
                    anagramGroups.put(key, new ArrayList<>());
                }

                anagramGroups.get(key).add(str);
            }

            return new ArrayList<>(anagramGroups.values());
        }




    public static void main2(String[] args) {















        //Input: s = "anagram", t = "nagaram"

 // sorting o  n log (n)



        String s1="anagram";
        String s2="nagaram";

        int arr[]=new int[26];

        int s1Sum=0;
        int s2Sum=0;
        for(int i=0;i<s1.length();i++)
        {
          int index= s1.charAt(i)-'a';
          arr[index]++;
        }

        for(int i=0;i<s1.length();i++)
        {
            int index= s1.charAt(i)-'a';
            arr[index]--;
        }






    }



    public static  String addBinary(String a, String b)
    {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1)
        {
            if(i >= 0)
                carry += a.charAt(i--) - '0';
            if(j >= 0)
                carry += b.charAt(j--) - '0';
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }





    public static int[] reverseArray(int arrayInput[])
    {
        if(arrayInput.length<=1)
        {
            return arrayInput;
        }


        int tempArray[]=new int[arrayInput.length];
        int index=0;
        for(int i=arrayInput.length-1;i>=0;i--)
        {

            tempArray[index]=arrayInput[i];
            index++;
        }

        return tempArray;
    }


}
