import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    // Linear Search Method
    public static int linearSearch(int[] array, int target) {
        int iterations = 0; // Counting iterations
        for (int i = 0; i < array.length; i++) {
            iterations++; // Incrementing iteration count
            if (array[i] == target) {
                System.out.println("Linear search iterations: " + iterations);
                return i; // Returns index of found element
            }
        }
        System.out.println("Linear search iterations: " + iterations);
        return -1; // Target not found
    }

    // Recursive Binary Search Method
    public static int recursiveBinarySearch(int[] array, int target, int left, int right, int iterations) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            iterations++;
            if (array[mid] == target) {
                System.out.println("Binary search iterations: " + iterations);
                return mid;
            }
            if (array[mid] < target) {
                return recursiveBinarySearch(array, target, mid + 1, right, iterations);
            } else {
                return recursiveBinarySearch(array, target, left, mid - 1, iterations);
            }
        }
        System.out.println("Binary search iterations: " + iterations);
        return -1; // Target not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Error Handling for array size
        int n = 0;
        while (n <= 0) {
            try {
                System.out.println("Enter number of elements in array (should be a positive integer):");
                n = scanner.nextInt();
                if (n <= 0) {
                    System.out.println("Please enter a positive integer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
                scanner.next(); // Clear the invalid input
            }
        }

        int[] array = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter target number to search:");
        int target = scanner.nextInt();

        // Linear Search
        int linearResult = linearSearch(array, target);
        System.out.println(linearResult == -1 ? "Target not found by linear search." :
                "Target found by linear search at index: " + linearResult);

        // Binary Search (Array must be sorted)
        Arrays.sort(array);
        int binaryResult = recursiveBinarySearch(array, target, 0, array.length - 1, 0);
        System.out.println(binaryResult == -1 ? "Target not found by binary search." :
                "Target found by binary search at index: " + binaryResult);

        scanner.close();
    }
}