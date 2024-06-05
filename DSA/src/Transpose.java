import java.util.Arrays;

public class Transpose {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},{4,5,6},{7,8,9}
        };
        for (int[] ele : transpose(matrix))
            System.out.println(Arrays.toString(ele));

    }

    static int[][] transpose (int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] transpose = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

}
