package processor;

import java.util.Scanner;

class Matrix {
    int x;
    int y;
    double[][] matrix;

    public Matrix(int x, int y) {
        this.x = x;
        this.y = y;
        this.matrix = new double[x][y];
    }

    public double getMatrix(int x, int y) {
        return matrix[x][y];
    }

    public void setMatrix(int x, int y, double number) {
        this.matrix[x][y] = number;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            renderMenu();
            int inputChoice = scanner.nextInt();
            switch (inputChoice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    addMatrix();
                    break;
                case 2:
                    multiplyMatrixByConstant();
                    break;
                case 3:
                    multiplyMatrixByMatrix();
                    break;
                case 4:
                    transpositionMatrix();
                    break;
                case 5:
                    matrixDeterminant();
                    break;
                case 6:
                    matrixInverse();
                    break;
                default:
                    break;
            }
        } while (true);
    }

    protected static void renderMenu() {
        System.out.println("\n1. Add matrices\n" +
                "2. Multiply matrix by a constant\n" +
                "3. Multiply matrices\n" +
                "4. Transpose matrix\n" +
                "5. Calculate a determinant\n" +
                "6. Inverse matrix\n" +
                "0. Exit");
        System.out.print("Your choice: ");
    }

    protected static void addMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter size of first matrix: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        Matrix matrix1 = new Matrix(x,y);

        System.out.print("\nEnter first matrix: \n");

        double inputNumber;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                inputNumber = scanner.nextDouble();
                matrix1.setMatrix(i,j,inputNumber);
            }
        }

        System.out.print("\nEnter size of second matrix: ");
        x = scanner.nextInt();
        y = scanner.nextInt();

        Matrix matrix2 = new Matrix(x,y);

        System.out.print("\nEnter second matrix: \n");

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                inputNumber = scanner.nextDouble();
                matrix2.setMatrix(i, j, inputNumber);
            }
        }

        System.out.print("\nThe result is: \n");

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                inputNumber = matrix1.getMatrix(i, j) + matrix2.getMatrix(i, j);
                System.out.print(inputNumber + " ");
            }
            System.out.print("\n");
        }
    }

    protected static void multiplyMatrixByConstant() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter size of matrix: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        Matrix matrix = new Matrix(x,y);

        double inputNumber;

        System.out.print("\nEnter matrix: \n");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                inputNumber = scanner.nextDouble();
                matrix.setMatrix(i,j,inputNumber);
            }
        }

        System.out.print("\nEnter constant: ");
        int multiply = scanner.nextInt();
        double temp;

        System.out.print("\nThe result is:\n");

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                temp = multiply * matrix.getMatrix(i,j);
                System.out.print(temp + " ");
            }
            System.out.print("\n");
        }
    }

    protected static void multiplyMatrixByMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter size of first matrix: ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        Matrix matrix1 = new Matrix(x1,y1);

        System.out.print("\nEnter first matrix: \n");

        double inputNumber;

        for (int i = 0; i < x1; i++) {
            for (int j = 0; j < y1; j++) {
                inputNumber = scanner.nextDouble();
                matrix1.setMatrix(i,j,inputNumber);
            }
        }

        System.out.print("\nEnter size of second matrix: ");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        Matrix matrix2 = new Matrix(x2,y2);

        System.out.print("\nEnter second matrix: \n");

        for (int i = 0; i < x2; i++) {
            for (int j = 0; j < y2; j++) {
                inputNumber = scanner.nextDouble();
                matrix2.setMatrix(i, j, inputNumber);
            }
        }

        System.out.print("\nThe result is: \n");

        double[][] answer = matrixMultiplication(matrix1.matrix, matrix2.matrix, x1, y1, y2);

        for (int i = 0; i < x1; i++) {
            for (int j = 0; j < y2; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.print("\n");
        }

        System.out.print("\n\n");
    }

    public static double[][] matrixMultiplication(double[][] firstmatrix, double[][] secondmatrix, int r1, int c1, int c2){
        double[][] answer = new double[r1][c2];


        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c2; j++){
                for(int k = 0; k < c1; k++){
                    answer[i][j] += firstmatrix[i][k] * secondmatrix[k][j];
                }
            }
        }

        return answer;
    }

    public static void transpositionMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line\n" +
                "Your choice");
        int choice = scanner.nextInt();

        System.out.print("\nEnter matrix size: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        Matrix matrix = new Matrix(x,y);

        double inputNumber;

        System.out.print("\nEnter matrix: \n");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                inputNumber = scanner.nextDouble();
                matrix.setMatrix(i,j,inputNumber);
            }
        }

        switch (choice) {
            case 1:
                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        System.out.print(matrix.getMatrix(j,i) + " ");
                    }
                    System.out.print("\n");
                }
                break;
            case 2:
                for (int i = x - 1; i >= 0; i--) {
                    for (int j = y - 1; j >= 0; j--) {
                        System.out.print(matrix.getMatrix(j,i) + " ");
                    }
                    System.out.print("\n");
                }
                break;
            case 3:
                for (int i = 0; i < x; i++) {
                    for (int j = y - 1; j >= 0; j--) {
                        System.out.print(matrix.getMatrix(i,j) + " ");
                    }
                    System.out.print("\n");
                }
                break;
            case 4:
                for (int i = x - 1; i >= 0; i--) {
                    for (int j = 0; j < y; j++) {
                        System.out.print(matrix.getMatrix(i,j) + " ");
                    }
                    System.out.print("\n");
                }
                break;
            default:
                break;
        }
    }

    public static void matrixDeterminant() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter size of matrix: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        Matrix matrix = new Matrix(x,y);

        double inputNumber;

        System.out.print("\nEnter matrix: \n");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                inputNumber = scanner.nextDouble();
                matrix.setMatrix(i,j,inputNumber);
            }
        }

        System.out.print("\nThe result is:\n" + matrixFuncDet(matrix.matrix));
    }

    public static void matrixInverse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter size of matrix: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        Matrix matrix = new Matrix(x,y);

        double inputNumber;

        System.out.print("\nEnter matrix: \n");
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                inputNumber = scanner.nextDouble();
                matrix.setMatrix(i,j,inputNumber);
            }
        }

        if (matrixFuncDet(matrix.matrix) != 0) {
            matrix.matrix = inverse(matrix.matrix);

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    System.out.print(matrix.getMatrix(i, j) + " ");
                }
                System.out.print("\n");
            }
        } else {
            System.out.print("\nThis matrix doesn't have an inverse.\n");
        }
    }

    public static double matrixFuncDet (double[][] matrix) {
        double temporary[][];
        double result = 0;

        if (matrix.length == 1) {
            result = matrix[0][0];
            return (result);
        }

        if (matrix.length == 2) {
            result = ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
            return (result);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            temporary = new double[matrix.length - 1][matrix[0].length - 1];

            for (int j = 1; j < matrix.length; j++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if (k < i) {
                        temporary[j - 1][k] = matrix[j][k];
                    } else if (k > i) {
                        temporary[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }

            result += matrix[0][i] * Math.pow (-1, (double) i) * matrixFuncDet (temporary);
        }
        return (result);
    }

    private static double[][] inverse(double[][] matrix) {
        double[][] inverse = new double[matrix.length][matrix.length];

        // minors and cofactors
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                inverse[i][j] = Math.pow(-1, i + j)
                        * matrixFuncDet(minor(matrix, i, j));

        // adjugate and determinant
        double det = 1.0 / matrixFuncDet(matrix);
        for (int i = 0; i < inverse.length; i++) {
            for (int j = 0; j <= i; j++) {
                double temp = inverse[i][j];
                inverse[i][j] = inverse[j][i] * det;
                inverse[j][i] = temp * det;
            }
        }

        return inverse;
    }

    private static double[][] minor(double[][] matrix, int row, int column) {
        double[][] minor = new double[matrix.length - 1][matrix.length - 1];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; i != row && j < matrix[i].length; j++)
                if (j != column)
                    minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
        return minor;
    }

}
