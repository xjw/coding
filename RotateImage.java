public class RotateImage {
    /**
     * After rotation
     * m[i][j] = m[n-j-1][i]
     *
     * Pay attention to search length ceil(n/2.0) and n/2 !!
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i=0; i<Math.ceil(n/2.0); i++) {
            for (int j=0; j<n/2; j++) {
                int new_i = j;
                int new_j = n-i-1;
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];  //top left = bottom left
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1]; // bottom left  = bottom right
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1]; // bottom right = top right
                matrix[j][n-i-1] = tmp; // top right = top left
            }
        }
    }
}
