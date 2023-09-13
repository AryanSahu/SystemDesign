package com.study.coding.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MatrixAndMaths
{


    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top row
            for (int j = left; j <= right; j++) {
                list.add(matrix[top][j]);
            }
            top++;

            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            // Check if there are more rows to traverse
            if (top <= bottom) {
                // Traverse from right to left along the bottom row
                for (int j = right; j >= left; j--) {
                    list.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // Check if there are more columns to traverse
            if (left <= right) {
                // Traverse from bottom to top along the left column
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        return list;
    }



    public static void main(String[] args)
    {



    }

    private static void squareroot() {
        int num=100;

        int left=1;
        int right=num;

        while (left<right)
        {

            int mid=(left+(right-left))/2;

            if(mid*mid==num)
            {
                System.out.println("Square root is "+mid);
                break;
            } else if (mid*mid>num) {
                right=mid-1;

            }
            else
            {
                left=mid+1;
            }
        }

        System.out.println(Math.round(right));
        System.out.println(left);
    }

    private static int pow(int x,int y)
    {
        if(y==0)
            return 1;
        if(y<0)
            return 1/pow(x,-y);

        if(y%2==1)
            return x*pow(x,y-1);

        return pow(x*x,y/2);

    }

    private static void plusOne() {
        int num[]={99};

        for(int j=num.length-1;j>0;j++)
        {
            int digit=num[j];

            if(digit<9)
            {
                num[j]++;
            }
            else
            {
                num[j]=0;
            }

        }

        int arr[]=new int[3];
        arr[0]=1;

        for (int i:arr
             ) {
            System.out.print(i);
        }
    }

    private static void HappyNumber() {
        HashSet<Integer> visited=new HashSet<>();
        int num=2;
        while(!visited.contains(num)) {

            visited.add(num);
            num = getSum(num);
            if(num==1)
            {
                System.out.println("Happy Number");
                break;
            }


        }
        System.out.println("Not a Happy Number");
    }

    private static int getSum(int num) {
        int sum=0;
        while(num!=0)
        {
            int digit=num%10;
            digit=digit*digit;
            sum=sum+digit;
            num=num/10;
        }
        return sum;
    }


    private static void invertImage() {
        int arr[][]={{1,2,3},{4,5,6},{7,8,9}};

        for(int i=0;i<arr.length;i++)
        {
            for(int j = 0; j< i; j++)
            {
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;

            }

        }

        for(int sa[]:arr)
        {

            reverseMatrixRowWise(sa);

        }

        printMatrix(arr, arr.length, arr[0].length);
    }

    public static void reverseMatrixColumnWise(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int j = 0; j < cols; j++) {
            int start = 0;
            int end = rows - 1;

            while (start < end) {
                // Swap elements within the column
                int temp = matrix[start][j];
                matrix[start][j] = matrix[end][j];
                matrix[end][j] = temp;

                start++;
                end--;
            }
        }
    }

    private static void reverseMatrixRowWise(int arr[])
    {
        int i=0;
        int j=arr.length-1;
        while(i<j)
        {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;

        }
    }

    private static void transposeMatrix(int[][] arr, int[][] transMat, int rows, int cols) {
        for(int i = 0; i< rows; i++)
        {
            for(int j = 0; j< cols; j++)
            {
                transMat[j][i]= arr[i][j];
            }
        }
    }

    private static void printMatrix(int[][] arr,int row,int col) {
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                System.out.print(arr[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
