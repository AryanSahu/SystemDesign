package com.study.coding.ds;

public class BinarySearch {

    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};



    }



    //Search Insert Position
        public int searchInsert(int[] nums, int target) {
            int start = 0;
            int end = nums.length-1;

            while (start <= end) {
                int mid = start + (end-start)/2;
                if (nums[mid] == target) return mid;
                else if (nums[mid] < target)
                    start=mid+1;
                else end = mid-1;
            }

            return start;
        }




     //Find First and Last Position of Element in Sorted Array
        public int[] searchRange(int[] nums, int target) {

            int[] result = new int[2];
            result[0] = searchFirst(nums, target);
            result[1] = searchLast(nums, target);

            return result;
        }

        // binary search to find the first occurrence of the target
        private int searchFirst(int[] nums, int target){
            int left = 0; // left index
            int right = nums.length - 1; // right index
            int index = -1; // index of the first occurrence

            while(left <= right){

                int mid = left + (right - left) / 2; // calculate the mid index

                if(nums[mid] == target){
                    index = mid; // update index of the first occurrence
                    right = mid - 1; // search in the left half
                }

                else if(nums[mid] < target){
                    left = mid + 1; // search in the right half
                }
                else{
                    right = mid - 1; // search in the left half
                }
            }

            return index;
        }

        // binary search to find the last occurrence of the target
        private int searchLast(int[] nums, int target){
            int left = 0; // left index
            int right = nums.length - 1; // right index
            int index = -1; // index of the last occurrence

            while(left <= right){

                int mid = left + (right - left) / 2; // calculate the mid index

                if(nums[mid] == target){
                    index = mid; // update index of the last occurrence
                    left = mid + 1; // search in the right half
                }

                else if(nums[mid] < target){
                    left = mid + 1; // search in the right half
                }
                else{
                    right = mid - 1; // search in the left half
                }
            }

            return index;
        }


    public int searchInSortedRotatedArray(int[] nums, int target) {

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

    private static void findMinimuminSortedArray() {
        int nums[] = {4,5,6,7,0,1,2};

        int left=0;
        int right=nums.length-1;

        while(left<right)
        {

            int mid=left+(right-left)/2;

            System.out.println(mid);

            if(nums[mid-1]>nums[mid])
            {
                System.out.println("Min element is "+nums[mid]);
            }
            else if(mid>0&& nums[mid]>=nums[left] && nums[mid] > nums[right])
            {
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }

        }


        System.out.println(nums[left]);
    }


    public boolean Search2DMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if ( target > matrix[i][j] ) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
    private static void binarysearch() {
        int arr[]={1,2,3,4,5,6,7,8,9,10};

        int left=0;
        int right=arr.length-1;
        int target=9;

        while(left<right)
        {

            int mid=(left+(right-left)/2);

            if(arr[mid]==target)
            {

                System.out.println("Target found at index "+(mid+1));
                break;
            }
            else if(arr[mid]<target)
            {
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }

        }
    }


}
