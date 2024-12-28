/*Nama : Mufid Bahaudin Nugroho
 * NIM : 22106050021
 */

import java.util.Scanner;

class Matrix {
    private int[][] matrix;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new int[rows][cols];
    }

    public void setElement(int row, int col, int value) {
        this.matrix[row][col] = value;
    }

    public void rowWiseTraversal() {
        System.out.println("Row-wise traversal:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void columnWiseTraversal() {
        System.out.println("Column-wise traversal:");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }

    public void rotateClockwise() {
        System.out.println("Clockwise rotation:");
        int[][] rotated = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotated[j][rows - 1 - i] = matrix[i][j];
            }
        }
        printMatrix(rotated, cols, rows);
    }

    public void transpose() {
        System.out.println("Transpose matrix:");
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        printMatrix(transposed, cols, rows);
    }

    private void printMatrix(int[][] mat, int rowCount, int colCount) {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class Matrix2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize a 3x3 matrix with some values
        Matrix matrix = new Matrix(3, 3);
        int[][] values = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix.setElement(i, j, values[i][j]);
            }
        }

        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. Row-wise traversal");
            System.out.println("2. Column-wise traversal");
            System.out.println("3. Clock-wise rotate matrix");
            System.out.println("4. Transpose matrix");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    matrix.rowWiseTraversal();
                    break;
                case 2:
                    matrix.columnWiseTraversal();
                    break;
                case 3:
                    matrix.rotateClockwise();
                    break;
                case 4:
                    matrix.transpose();
                    break;
                case 5:
                    System.out.println("Keluar dari program");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan invalid, silakan coba lagi!");
            }
        }
    }
}
