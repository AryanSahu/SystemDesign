package com.study.coding.ds;

public class TwoPointerProblem {

    //In an interview, whenever you're given a question where the input array is sorted, here are some super useful things to consider:
    //
    //Binary Search
    //Two (or three) pointers
    //A sliding window
    //Traversing from the right


    public static void main(String[] args) {


        int numbers[]= {2,7,11,15};
        int target = 9;
        twoSum(numbers,target);

    }


    static void twoSum(int[] nums, int target) {

        int l = 0, r = nums.length - 1;

        while (nums[l] + nums[r] != target) {
            if (nums[l] + nums[r] < target) l++;
            else r--;
        }


        System.out.println("Indexes "+l  + "  "+r);
    }

    static boolean isPalindrome(String inputString)
    {

        if(inputString==null)
        {
            throw new IllegalArgumentException("Input can not be Null");
        }

        inputString=inputString.trim();

        if(inputString.isEmpty()|| inputString.length()==1)
        {
            return true;
        }

        int left=0;
        int right=inputString.length()-1;

        while (left<right)
        {
            char leftChar=Character.toLowerCase(inputString.charAt(left));
            char rightChar=Character.toLowerCase(inputString.charAt(right));

            if(!Character.isLetterOrDigit(leftChar))
            {
                left++;
                continue;
            }

            if(!Character.isLetterOrDigit(rightChar))
            {
                right--;
                continue;
            }


            if(leftChar!=rightChar)
                return false;

            left++;
            right--;

        }


      return true;


    }



}
