package DAY_25;

import java.util.*;
import java.util.*;

public class Q3 {
    // Method to reconstruct the queue
    public static int[] reconstructQueue(int[] height, int[] in_fronts) {
        int n = height.length;
        // Creating a 2D array to store people's heights and the number of people in front of them
        int[][] people = new int[n][2];


        for (int i = 0; i < n; i++)
        {
            people[i][0] = height[i];  // Storing height
            people[i][1] = in_fronts[i];  // Storing number of people in front
        }

        // Sorting people array by their heights and, if height is the same, by in_fronts in ascending order
        Arrays.sort(people, new Comparator<int[]>()
        {

            public int compare(int[] a, int[] b)
            {
                if (a[0] == b[0])
                {
                    return a[1] - b[1];
                } else
                {
                    return b[0] - a[0];
                }
            }
        });

        // Using a list to store the reconstructed queue
        List<int[]> result = new ArrayList<>();

        // Reconstructing the queue
        for (int[] person : people) {
            result.add(person[1], person);
        }

        // Converting the list back to an array
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            output[i] = result.get(i)[0];
        }

        // Returning the reconstructed queue
        return output;
    }

    // Main method to test the reconstruction
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length: ");
        int n = sc.nextInt();

        // Arrays to store heights and number of people in front
        int[] heights = new int[n];
        int[] in_front = new int[n];
        System.out.println("enter the height of person");
        for(int i=0;i<n;i++)
        {
            heights[i] = sc.nextInt();
        }
        System.out.println("enter the infront person");
        for(int i=0;i<n;i++)
        {
            in_front[i] = sc.nextInt();
        }

        // Reconstructing the queue
        int[] actualOrder = reconstructQueue(heights, in_front);

        // Printing the actual order of the queue
        System.out.println("Actual order:");
        for (int height : actualOrder) {
            System.out.println(height + " ");
        }
    }
}
