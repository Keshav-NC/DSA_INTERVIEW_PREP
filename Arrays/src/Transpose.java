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
        int[][] t = new int[matrix.length][matrix.length];
        for (int row=0;row<matrix.length;row++) {
            for (int col=0;col<matrix[row].length;col++) {
                t[col][row] = matrix[col][row];
            }
        }
        return t;
    }
}
