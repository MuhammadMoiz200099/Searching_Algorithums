package Searches;

import java.util.Scanner;

/**
 *
 *
 * @author Muhammad Moiz
 *
 */

public class SaddlebackSearch {

    private static int[] find(int arr[][], int row, int col, int key) {

        int ans[] = {-1, -1};
        if (row < 0 || col >= arr[row].length) {
            return ans;
        }
        if (arr[row][col] == key) {
            ans[0] = row;
            ans[1] = col;
            return ans;
        }
        else if (arr[row][col] > key) {
            return find(arr, row - 1, col, key);
        }
        return find(arr, row, col + 1, key);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[][];
        int i, j, rows = sc.nextInt(), col = sc.nextInt();
        arr = new int[rows][col];
        for (i = 0; i < rows; i++) {
            for (j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int ele = sc.nextInt();
        int ans[] = find(arr, rows - 1, 0, ele);
        System.out.println(ans[0] + " " + ans[1]);
        sc.close();
    }

}
