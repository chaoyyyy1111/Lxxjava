public class HomeWork {
    public static boolean find(int[][] array,int target) {
        for (int i = 0; i < array.length ; i++) {
            int left = 0;
            int right = array[0].length-1;
            while(left <= right) {
                int mid = (left+right)>>>1;
                if(array[i][mid] > target ) {
                    right = mid - 1;
                } else if(array[i][mid] < target) {
                    left = mid + 1;
                } else {
                    return true;
                }
            }
        }
    return false;
    }
    public static void printMatrix(int [][] matrix) {
        if (matrix.length % 2 == 0) {
            for (int i = 0; i < matrix.length / 2; i++) {
                for (int j = i; j <= matrix.length - 1 - i; j++) {
                    System.out.print(matrix[i][j] + ",");
                }
                for (int j = i + 1; j <= matrix.length - 1 - i; j++) {
                    System.out.print(matrix[j][matrix.length - 1 - i] + ",");
                }
                for (int j = matrix.length - 2 - i; j >= i; j--) {
                    System.out.print(matrix[matrix.length - 1 - i][j] + ",");
                }
                for (int j = matrix.length - 2 - i; j >= i + 1; j--) {
                    System.out.print(matrix[j][i] + ",");
                }
            }
        } else {
            for (int i = 0; i < matrix.length / 2 + 1; i++) {
                for (int j = i; j <= matrix.length - 1 - i; j++) {
                    System.out.print(matrix[i][j] + ",");
                }
                for (int j = i + 1; j <= matrix.length - 1 - i; j++) {
                    System.out.print(matrix[j][matrix.length - 1 - i] + ",");
                }
                for (int j = matrix.length - 2 - i; j >= i; j--) {
                    System.out.print(matrix[matrix.length - 1 - i][j] + ",");
                }
                for (int j = matrix.length - 2 - i; j >= i + 1; j--) {
                    System.out.print(matrix[j][i] + ",");
                }
            }
        }
    }
        public static void main(String[] args) {
        int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrix(array);
    }

}
