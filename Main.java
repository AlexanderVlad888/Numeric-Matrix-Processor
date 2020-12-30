package processor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      menu();


    }
    static void menu() {
        Scanner menu = new Scanner(System.in);
        System.out.println("1. Add matrices\n" +
                "2. Multiply matrix by a constant\n" +
                "3. Multiply matrices\n" +
                "4. Transpose matrix\n" +
                "5. Calculate a determinant\n" +
                "6. Inverse matrix\n" +
                "0. Exit\n" +
                "Your choice: ");
        String choice = "";


                String[] sMenu = menu.nextLine().split("\\s+");
                choice = sMenu[0];
               // choice = Integer.parseInt(sMenu[0]);

            switch (choice) {
                case "1":
                    //choice = "";
                    add();
                    break;
                case "2":
                   // choice = "";
                    multiplyMatrixConstant();
                    break;
                case "3":
                   // choice = "";
                    multiplyMatrices();
                    break;
                case "4":
                    menuTransponse();
                    break;
                case "5":
                    sumDet();
                    break;
                case "6":
                    inverseMatrix();
                    break;
                case "0":
                   // choice = "";
                    exit();
                    break;
                default:
                   // choice = "";
                    System.out.println("Wrong input menu");

            }



    }
    static void menuTransponse(){
        Scanner menutrans = new Scanner(System.in);
        System.out.println("1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line\n" +
                "Your choice: ");
        String tr = "";


        String[] sMenu = menutrans.nextLine().split("\\s+");
        tr = sMenu[0];
        // choice = Integer.parseInt(sMenu[0]);

        switch (tr) {
            case "1":
                //choice = "";
                mainDiagonal();
                break;
            case "2":
                // choice = "";
                sideDiagonal();
                break;
            case "3":
                // choice = "";
                verticalLine();
                break;
            case "4":
                horizontalLine();
                break;

            default:
                // choice = "";
                System.out.println("Wrong input menu");

        }
    }
    static void add() {
        Scanner addMatrix = new Scanner(System.in);
        System.out.println("Enter size of first matrix: ");
        int n1 = addMatrix.nextInt();
        int m1 = addMatrix.nextInt();
        System.out.println("Enter first matrix:\n");
        double[][] a = new double[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                a[i][j] = addMatrix.nextDouble();
            }
        }
        //int digit = addMatrix.nextInt();
        System.out.println("Enter size of second matrix: ");
        int n2 = addMatrix.nextInt();
        int m2 = addMatrix.nextInt();
        System.out.println("Enter second matrix:\n");
        double[][] b = new double[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                b[i][j] = addMatrix.nextDouble();
            }
        }
        if (n1 != n2 || m1 != m2) {
            System.out.println("The operation cannot be performed.");
        } else {
            System.out.println("The result is:");
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m1; j++) {
                    a[i][j] += b[i][j];
                    // a[i][j] *= digit;
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }

        }
        System.out.println();
        menu();
    }
    static void multiplyMatrixConstant() {
        Scanner multipleDigit = new Scanner(System.in);
        System.out.println("Enter size of matrix: \n");
        int n1 = multipleDigit.nextInt();
        int m1 = multipleDigit.nextInt();

        double[][] a = new double[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                a[i][j] = multipleDigit.nextDouble();
            }
        }
        System.out.println("Enter constant: ");
        double digit = multipleDigit.nextDouble();
        System.out.println("The result is:");
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                //a[i][j] += b[i][j];
                a[i][j] *= digit;
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        menu();
    }
    static void multiplyMatrices() {
        Scanner multipleDigit = new Scanner(System.in);
        System.out.println("Enter size of first matrix: \n");
        int n1 = multipleDigit.nextInt();
        int m1 = multipleDigit.nextInt();
        System.out.println("Enter first matrix:\n");
        if (multipleDigit.hasNextInt()) {
            int[][] a = new int[n1][m1];
            try {

                for (int i = 0; i < n1; i++) {
                    for (int j = 0; j < m1; j++) {
                        a[i][j] = multipleDigit.nextInt();
                    }
                }
            } catch (RuntimeException e) {
                System.out.println("Wrong, input first matrix\n" +
                        "The operation cannot be performed.");
                menu();
            }

            System.out.println("Enter size of second matrix: ");
            int n2 = multipleDigit.nextInt();
            int m2 = multipleDigit.nextInt();
            System.out.println("Enter second matrix:\n");
            int[][] b = new int[n2][m2];
            try {

                for (int i = 0; i < n2; i++) {
                    for (int j = 0; j < m2; j++) {
                        b[i][j] = multipleDigit.nextInt();
                    }
                }
            } catch (RuntimeException e) {
                System.out.println("Wrong, input 2\n" +
                        "The operation cannot be performed.");
                menu();
                return;
            }

            if (m1 != n2) {
                System.out.println("The operation cannot be performed.");
            } else if (m1 == n1 && m2 == m1) {
                int[][] c = new int[n1][m2];
                System.out.println("The result is:");
                for (int i = 0; i < n1; i++) {
                    for (int j = 0; j < m2; j++) {
                        for (int k = 0; k < m1; k++) {
                            c[i][j] += a[i][k] * b[k][j];
                        }
                        //a[i][j] += b[i][j];
                        // + a[][] * b;
                        System.out.print(c[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                int[][] c = new int[n1][m2];
                System.out.println("The result is:");
                for (int i = 0; i < n1; i++) {
                    for (int j = 0; j < m2; j++) {
                        for (int k = 0; k < m1; k++) {
                            c[i][j] += a[i][k] * b[k][j];
                        }
                        //a[i][j] += b[i][j];
                        // + a[][] * b;
                        System.out.print(c[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        } else {
            double[][] a = new double[n1][m1];
            try {

                for (int i = 0; i < n1; i++) {
                    for (int j = 0; j < m1; j++) {
                        a[i][j] = multipleDigit.nextDouble();
                    }
                }
            } catch (RuntimeException e) {
                System.out.println("Wrong, input first matrix\n" +
                        "The operation cannot be performed.");
                menu();
            }

            System.out.println("Enter size of second matrix: ");
            int n2 = multipleDigit.nextInt();
            int m2 = multipleDigit.nextInt();
            System.out.println("Enter second matrix:\n");
            double[][] b = new double[n2][m2];
            try {

                for (int i = 0; i < n2; i++) {
                    for (int j = 0; j < m2; j++) {
                        b[i][j] = multipleDigit.nextDouble();
                    }
                }
            } catch (RuntimeException e) {
                System.out.println("Wrong, input 2\n" +
                        "The operation cannot be performed.");
                menu();
                return;
            }

            if (m1 != n2) {
                System.out.println("The operation cannot be performed.");
            } else if (m1 == n1 && m2 == m1) {
                double[][] c = new double[m2][n1];
                System.out.println("The result is:");
                for (int i = 0; i < m2; i++) {
                    for (int j = 0; j < n1; j++) {
                        for (int k = 0; k < m1; k++) {
                            c[i][j] += a[i][k] * b[k][j];
                        }
                        //a[i][j] += b[i][j];
                        // + a[][] * b;
                        System.out.print(c[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                double[][] c = new double[m2][n1];
                System.out.println("The result is:");
                for (int i = 0; i < m2; i++) {
                    for (int j = 0; j < n1; j++) {
                        for (int k = 0; k < m1; k++) {
                            c[i][j] += a[j][k] * b[k][i];
                        }
                        //a[i][j] += b[i][j];
                        // + a[][] * b;
                        System.out.print(c[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }

        System.out.println();
        menu();
    }
    static void mainDiagonal() {
        Scanner transponse = new Scanner(System.in);
        System.out.println("Enter size of matrix: \n");
        int n1 = transponse.nextInt();
        int m1 = transponse.nextInt();
        System.out.println("Enter  matrix:\n");

        double[][] a = new double[n1][m1];
        double[][] trans = new double[m1][n1];
        //while (transponse.hasNextInt()) {
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m1; j++) {
                    a[i][j] = transponse.nextDouble();
                }
            }
        //}
        System.out.println();
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                trans[i][j] = a[j][i];
                System.out.print(trans[i][j] + " ");
            }
            System.out.println();
        }
        menu();
    }
    static void sideDiagonal() {
        Scanner transponse = new Scanner(System.in);
        System.out.println("Enter size of matrix: \n");
        int n1 = transponse.nextInt();
        int m1 = transponse.nextInt();
        System.out.println("Enter  matrix:\n");

        double[][] a = new double[n1][m1];
        double[][] trans = new double[n1][m1];
        //while (transponse.hasNextInt()) {
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                a[i][j] = transponse.nextDouble();
            }
        }
        //}
        System.out.println();
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                trans[i][j] = a[m1 - 1 - j][n1 - 1 - i];
                System.out.print(trans[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        menu();
    }
    static void verticalLine() {
        Scanner transponse = new Scanner(System.in);
        System.out.println("Enter size of matrix: \n");
        int n1 = transponse.nextInt();
        int m1 = transponse.nextInt();
        System.out.println("Enter  matrix:\n");

        double[][] a = new double[n1][m1];
        double[][] trans = new double[n1][m1];
        //while (transponse.hasNextInt()) {
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                a[i][j] = transponse.nextDouble();
            }
        }
        //}
        System.out.println();
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                trans[i][j] = a[i][n1 - 1 - j];
                System.out.print(trans[i][j] + " ");
            }
            System.out.println();
        }
        menu();

    }
    static void horizontalLine() {
        Scanner transponse = new Scanner(System.in);
        System.out.println("Enter size of matrix: \n");
        int n1 = transponse.nextInt();
        int m1 = transponse.nextInt();
        System.out.println("Enter  matrix:\n");

        double[][] a = new double[n1][m1];
        double[][] trans = new double[n1][m1];
        //while (transponse.hasNextInt()) {
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                a[i][j] = transponse.nextDouble();
            }
        }
        //}
        System.out.println();
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                trans[i][j] = a[m1 - 1 - i][j];
                System.out.print(trans[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        menu();
    }
    static void calculateDeterminant() {
        Scanner determinant = new Scanner(System.in);
        System.out.println("Enter size of matrix: ");
        int n1 = determinant.nextInt();
        int m1 = determinant.nextInt();
        System.out.println("Enter matrix:\n");
        double[][] a = new double[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                a[i][j] = determinant.nextDouble();
            }
        }
        switch (n1) {
            case 2:
                System.out.println("The result is:\n " +
                        twoOrderMatrix(a[0][0], a[0][1], a[1][0], a[1][1]));
                break;
            case 3:
                System.out.println("The result is:\n " +
                        threeOrderMatrix(a));
                menu();
                break;
            case 4:
                System.out.println("The result is:\n " +
                        fourOrderMatrix(a));
                menu();
                break;
            case 5:
                System.out.println("The result is:\n " +
                        fiveOrderMatrix(a));
                menu();
                break;
            default:
        }

    }
    static void exit(){

    }
    static double twoOrderMatrix(double a, double b, double c, double d) {
        //System.out.println(a * d - c * b);
        return a * d - c * b;
    }
    static double threeOrderMatrix(double[][]a) {


      /*  System.out.println( a[0][0] * twoOrderMatrix(a[1][1], a[1][2], a[2][1], a[2][2])
                - a[0][1] * twoOrderMatrix(a[1][0], a[1][2], a[2][0], a[2][2])
                + a[0][2] * twoOrderMatrix(a[1][0], a[1][1], a[2][0], a[2][1]));*/
        double minor1 = a[0][0] * twoOrderMatrix(a[1][1], a[1][2], a[2][1], a[2][2]);
        double minor2 = - a[0][1] * twoOrderMatrix(a[1][0], a[1][2], a[2][0], a[2][2]);
        double minor3 = a[0][2] * twoOrderMatrix(a[1][0], a[1][1], a[2][0], a[2][1]);

        return   minor1 + minor2 + minor3;
    }
    static double fourOrderMatrix(double[][]a) {

        double minor1 = a[0][0] * threeOrderMatrix(new double[][] {
                {a[1][1], a[1][2], a[1][3]},
                {a[2][1], a[2][2], a[2][3]},
                {a[3][1], a[3][2], a[3][3]}
        });
        double minor2 = - a[0][1] * threeOrderMatrix(new double[][] {
                {a[1][0], a[1][2], a[1][3]},
                {a[2][0], a[2][2], a[2][3]},
                {a[3][0], a[3][2], a[3][3]}
        });
        double minor3 = a[0][2] * threeOrderMatrix(new double[][] {
                {a[1][0], a[1][1], a[1][3]},
                {a[2][0], a[2][1], a[2][3]},
                {a[3][0], a[3][1], a[3][3]}
        });
        double minor4 = - a[0][3] * threeOrderMatrix(new double[][] {
                {a[1][0], a[1][1], a[1][2]},
                {a[2][0], a[2][1], a[2][2]},
                {a[3][0], a[3][1], a[3][2]}
        });
        return minor1 + minor2 + minor3 + minor4;
    }
    static double fiveOrderMatrix(double[][]a) {
        double minor1 = a[0][0] * fourOrderMatrix(new double[][] {
                {a[1][1], a[1][2], a[1][3], a[1][4]},
                {a[2][1], a[2][2], a[2][3], a[2][4]},
                {a[3][1], a[3][2], a[3][3], a[3][4]},
                {a[4][1], a[4][2], a[4][3], a[4][4]}
        });
        double minor2 = - a[0][1] * fourOrderMatrix(new double[][] {
                {a[1][0], a[1][2], a[1][3], a[1][4]},
                {a[2][0], a[2][2], a[2][3], a[2][4]},
                {a[3][0], a[3][2], a[3][3], a[3][4]},
                {a[4][0], a[4][2], a[4][3], a[4][4]}
        });
        double minor3 = a[0][2] * fourOrderMatrix(new double[][] {
                {a[1][0], a[1][1], a[1][3], a[1][4]},
                {a[2][0], a[2][1], a[2][3], a[2][4]},
                {a[3][0], a[3][1], a[3][3], a[3][4]},
                {a[4][0], a[4][1], a[4][3], a[4][4]}
        });
        double minor4 = - a[0][3] * fourOrderMatrix(new double[][] {
                {a[1][0], a[1][1], a[1][2], a[1][4]},
                {a[2][0], a[2][1], a[2][2], a[2][4]},
                {a[3][0], a[3][1], a[3][2], a[1][4]},
                {a[4][0], a[4][1], a[4][2], a[4][4]}
        });
        double minor5 =  a[0][4] * fourOrderMatrix(new double[][] {
                {a[1][0], a[1][1], a[1][2], a[1][3]},
                {a[2][0], a[2][1], a[2][2], a[2][3]},
                {a[3][0], a[3][1], a[3][2], a[1][3]},
                {a[4][0], a[4][1], a[4][2], a[4][3]}
        });
        return minor1 + minor2 + minor3 + minor4 + minor5;


    }
    static double matrixDet(double[][] a) {
        double temp[][];
        double result = 0;
        int l = 1;
        if (a.length == 1) { //if (matrix.length == 1) {
            result = a[0][0]; //result = matrix[0][0];
            System.out.println("result 1 " + result  + "\n" + "Длина массива 1 " + a.length);
            return result;//return (result);
        }
        if (a.length == 2) {
            result = ((a[0][0] * a[1][1]) - (a[0][1] * a[1][0]));
            //System.out.println("result 2 " + result  + "\n" + "Длина массива 2 " + a.length);
            return result;
        }
        for (int i = 0; i < a[0].length; i++) {
            temp = new double[a.length - 1][a[0].length - 1];
            for (int j = 1; j < a.length ; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    if (k < i) {
                        temp[j - 1][k] = a[j][k];

                    } else if (k > i) {
                        temp[j - 1][k - 1] = a[j][k];

                    }
                }
                //System.out.println();
            }
            result += a[0][i] * matrixDet(temp) * l;
            l *= -1;

        }
        return result;
    }
    static void sumDet() {
        Scanner determinant = new Scanner(System.in);
        System.out.println("Enter size of matrix: ");
        int n1 = determinant.nextInt();
        int m1 = determinant.nextInt();
        System.out.println("Enter matrix:\n");
        double[][] a = new double[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                a[i][j] = determinant.nextDouble();
            }
        }
        System.out.println("The result is:\n " + matrixDet(a));
        //matrixFuncDet(a);
    }
    static void inverseMatrix() {
        Scanner determinant = new Scanner(System.in);
        System.out.println("Enter size of matrix: ");
        int n1 = determinant.nextInt();
        int m1 = determinant.nextInt();
        System.out.println("Enter matrix: ");
        double[][] a = new double[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                a[i][j] = determinant.nextDouble();
            }
        }

        inverseArray(a);

    }
    static void inverseArray(double[][] a) {
        double[][] c = new double[a.length][a.length];
        for (int i = 0; i < a.length ; i++) {
            for (int j = 0; j < a[0].length; j++) {

                double[][] b = new double[a.length - 1][a[0].length - 1];

                for (int k = 0; k < a.length; k++) {
                    for (int l = 0; l < a.length; l++) {
                        if (l < j && k < i) {
                            b[k][l] = a[k][l];
                        } else if (l > j && k < i) {
                            b[k][l - 1] = a[k][l];
                        } else if (l < j && k > i) {
                            b[k - 1][l] = a[k][l];
                        } else if (l > j && k > i) {
                            b[k - 1][l-1] = a[k][l];
                        }

                    }
                }
   /*             for (int k = 0; k < b.length; k++) {
                    for (int l = 0; l < b.length; l++) {
                        System.out.print(b[k][l] + " ");
                    }
                    System.out.println();
                }
                System.out.println();*/

                c[i][j] = matrixDet(b);
            }

        }
       /* for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }*/
        if (matrixDet(a) == 0) {
            System.out.println("This matrix doesn't have an inverse.");
        } else {
            double[][] trans = new double[c.length][c[0].length];
            System.out.println("The result is: \n");
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c[0].length; j++) {
                    trans[i][j] = c[j][i];

                }

            }
            int minus = 1;
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c[0].length; j++) {
                    double reult = Math.pow (-1, (double) i + j) * trans[i][j] / matrixDet(a);
                    System.out.printf("%6.3f ", reult );
                    minus *= -1;

                }
                System.out.println();

            }
        }
       //return matrixDet(a) != 0 ? c[2][2] / matrixDet(a) : 0;
    }

}
/*////////////////\\\\\\\\\\\\\
1 7 7
6 6 4
4 2 1

1 2 3 4 5
4 5 6 4 3
0 0 0 1 5
1 3 9 8 7
5 8 4 7 11
 5*5

2 -1 0
0 1 2
1 1 0

0.396796 -0.214938 0.276735  test 18
5.19655 -2.06983 -0.388886
-3.3797 1.50219 0.159794

2.65 3.54 3.88 8.99
3.12 5.45 7.77 5.56
5.31 2.23 2.33 9.81
1.67 1.67 1.01 9.99
test invers 19
0.397 -0.215  0.277 -0.509
-5.197  2.070  0.389  3.143
-3.380  1.502  0.160  2.048
 0.593 -0.230 -0.003 -0.503

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
    ////////////////\\\\\\\\\\\\\\
    private double det(double matrix[][]){
        int n = matrix.length;
        if(n == 1) return matrix[0][0];
        double ans = 0;
        double newMatrix[][] = new double[n-1][n-1];
        int l = 1;
        for(int i = 0; i < n; ++i){
            int x = 0, y = 0;
            for(int j = 1; j < n; ++j) {
                for(int k = 0; k < n; ++k) {
                    if(i == k) continue;
                    newMatrix[x][y] = matrix[j][k];
                    ++y;
                    if(y == n - 1){
                        y = 0;
                        ++x;
                    }
                }
            }
            ans += l * matrix[0][i] * det(newMatrix);
            l *= (-1);
        }
        return ans;
    }
    ///////////////\\\\\\\\\\\\\\\\\\
    public Matrix Minor(int i, int j) {
        Matrix M = new Matrix(rows - 1, columns - 1);
        int m = 0;
        for (int auxM = 0; auxM < rows; auxM++) {
            if (auxM == i) {
                continue;
            }
            int n = 0;
            for (int auxN = 0; auxN < columns; auxN++) {
                if (auxN == j) {
                    continue;
                }
                M.elements[m][n] = elements[auxM][auxN];
                n++;
            }
            m++;
        }
        return M;
    }

    public double determinant() {
        if (rows == columns) {
            if (rows == 1) {
                return elements[0][0];
            } else if (rows == 2) {
                return elements[0][0] * elements[1][1] - elements[0][1] * elements[1][0];
            }

            double determinant = 0;
            for (int j = 0; j < columns; j++) {
                determinant += Math.pow(-1, j) * elements[0][j] * Minor(0, j).determinant();
            }
            return determinant;
        } else {
            throw new IllegalArgumentException();
        }
    }
 */