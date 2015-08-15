import java.util. *;

public class SpiralMatrix {
    /**
     * 1. clearer to use 4 variables (left, right, top, bottom)
     * 2. edge checks are necessary, otherwise for example, 
     *    single row matrix [1], 1 will be added twice
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        int m = matrix.length;
        if (m == 0) return result;
        int n = matrix[0].length;
        int top, bottom, left, right, i, j, c;
        top = left = i = j  = 0;
        bottom = m -1;
        right = n-1;
        c = m * n;
        while (c > 0) {
            // top row
            for (j = left; j <= right && c > 0; j++, c--) result.add(matrix[top][j]);
            top++;
            // right column
            for (i = top; i <= bottom && c > 0; i++, c--) result.add(matrix[i][right]);
            right--;
            // bottom row
            for (j = right; j >= left && c > 0; j--, c--) result.add(matrix[bottom][j]);
            bottom--;
            // left column
            for (i = bottom; i >= top && c > 0; i--, c--) result.add(matrix[i][left]);
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }
}
