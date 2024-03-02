package DAY_25;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1
{
    public int[] maxSubsequence(int arr[] , int B)
    {
        int start = 0;// starting point// initially starting and end is at index 0
        int end = 0;// ending point
        int maxoneCount = 0;// maximum caount of 1
        int maxzeroCount = 0;// max count of 0
        int maxLeft =0;// initially maxleft is 0
        int maxRight =0;// max right is 0
        while(end < arr.length)// until  end is smaller than arr.length
        {
            if (arr[end] == 0)// if arr of end is = 0
            {
                maxzeroCount++;// increase maximum count
            }

            // If zeroCount exceeds B, move the left pointer to the right
            while (maxzeroCount > B)// if the count of zero is greater than b
            {
                if (arr[start] == 0)// check starrt of array is 0
                {
                    maxzeroCount--;// then decrease maxzerocount
                }
                start++;// increse start by 1
            }
            if (end - start + 1 > maxoneCount) // here we find the maxlength
            {
                maxoneCount = end - start + 1;
                maxLeft = start;
                maxRight = end;
            }
            // Move the right pointer to the right
            end++;
        }
        // create a list to store maximum count of 1
        List<Integer> result = new ArrayList<>();// create list name as result
        for(int i= maxLeft ;i<= maxRight ;i++)// loop for adding i into list
        {
            result.add(i);
        }
        int resultArray[] = new int[result.size()];
        for(int i=0;i<resultArray.length;i++)// for convrting list into array
        {
            resultArray[i] = result.get(i);// get the value of i and storee in result array
        }
        return resultArray;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the size of array :");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("enter the element of array :");
        for(int i=0;i<size ;i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the value of B :");
        int B = sc.nextInt();
        Q1 maxsequence = new Q1();
        int[] output = maxsequence.maxSubsequence(arr,B);
        for(int i=0 ;i< output.length;i++)
        {
            System.out.println(output[i]);
        }
    }
}
// val+=root->value
