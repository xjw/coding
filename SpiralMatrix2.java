import java.util. *;

public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i, j, c, left, right, top, bottom, end; 
        c = i = j = left = top = 0;
        right = bottom = n - 1;
        c = 1;
        end = n * n; 
        while (c <= end) {
            for (j = left; j <= right && c <= end; j++) matrix[top][j] = c++;
            top++;
            for (i = top; i <= bottom && c <= end; i++) matrix[i][right] = c++;
            right--;
            for (j = right; j >= left && c <= end; j--) matrix[bottom][j] = c++;
            bottom--;
            for (i = bottom; i >= top && c <= end; i--) matrix[i][left] = c++;
            left++;
        }
        return matrix;
    }

    public static void main(String[] args) {
    }
}
