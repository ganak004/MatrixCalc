/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixcalculator;

import java.util.Scanner;


/**
 *
 * @author Kezia Ganagenthiran 
 */
public class MatrixCalculator {


    
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        //to see if the user wants to continue using the program
        Boolean cont=true;
        while (cont) {
        //options
        System.out.println("Matrix Calculator");
        System.out.println("What would you like to do?");
        System.out.println("1-Addition");
        System.out.println("2-Subtraction");
        System.out.println("3-Multiplication");
        System.out.println("4-Determinent for 3x3 matrix");
        System.out.println("5-Exit");
        //gets integer input
        int option = scanner.nextInt();
        //using switch to go to the appropriate methods
        switch(option){
            case 1:
                //goes to the addition method
                MatrixCalculator.addition();
                break;
            case 2:
                //goes tot he subtraction method
                MatrixCalculator.subtraction();
                break;
            case 3:
                //goes to the multiplication method
                MatrixCalculator.multiplication();
                break;
            case 4:
                //goes to the determinant method
                MatrixCalculator.determinant();
                break;
            case 5:
                //if the user wants to quit, this will quit the loop and end the program
                cont = false;
                break;
        }
        
        }
    }
    
    public static void addition(){
        Scanner scanner= new Scanner(System.in);
        
        //asks for number of rows and columns to create the array for the matrix to be stored
        System.out.println("For addition the rows and columns need to be the same for each matrix");
        System.out.println("Number of Rows:");
        int row = scanner.nextInt();
        System.out.println("Number of columns:");
        int column = scanner.nextInt();
        
        //calls the create method to create the matrix with the rows and columns entered
        System.out.println("First Matrix:");
        int matrix1[][] = MatrixCalculator.createMatrix(row,column);
        System.out.println("");
        
        
        System.out.println("Second Matrix:");
        int matrix2[][] =MatrixCalculator.createMatrix(row,column);
        System.out.println("");
        
        //addds the matrices and prints it out
        System.out.println("Here is the solution:");
        int addMatrix [][]= new int[row][column];
        for (int i =0; i<row;i++){
            for (int j=0; j<column; j++){
                addMatrix[i][j]=matrix1[i][j]+matrix2[i][j];
                System.out.print( addMatrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        //System.out.println("Here is the solution:");
        //for (int i =0; i< 3;i++){
            //for (int j=0; j<3; j++){
               // System.out.print( addMatrix[i][j] + " ");
            //}
            //System.out.println("");
        //}
        //System.out.println("");
    }
    
    public static void subtraction(){
        Scanner scanner= new Scanner(System.in);
        
        //asks for the number of rows and columns to create teh arrays where teh matrices will be stored
        System.out.println("For addition the rows and columns need to be the same for each matrix");
        System.out.println("Number of Rows:");
        int row = scanner.nextInt();
        System.out.println("Number of columns:");
        int column = scanner.nextInt();
        
        //calling teh create method to tstore teh values of the matrices using teh rows and columns
        //values given 
        System.out.println("First Matrix:");
        int matrix1[][] = MatrixCalculator.createMatrix(row,column);
        System.out.println("");
        System.out.println("Second Matrix:");
        int matrix2[][] =MatrixCalculator.createMatrix(row,column);
        System.out.println("");
        
        //subtracying teh matrices and printind out the answer
        System.out.println("Here is the solution:");
        int subMatrix [][]= new int[row][column];
        for (int i =0; i<row;i++){
            for (int j=0; j<column; j++){
                subMatrix[i][j]=matrix1[i][j]-matrix2[i][j];
                System.out.print( subMatrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        
    }
    
    public static void multiplication(){
        Scanner scanner= new Scanner(System.in);
        //asking for the number of rows and columns for each matrices and creating the
        //matrix arrays 
        System.out.println("First Matrix:");
        System.out.println("Number of Rows:");
        int row1 = scanner.nextInt();
        System.out.println("Number of columns:");
        int column1 = scanner.nextInt();
        int matrix1[][] = MatrixCalculator.createMatrix(row1,column1);
        System.out.println("");
        
        System.out.println("Second Matrix:");
        System.out.println("Number of Rows:");
        int row2 = scanner.nextInt();
        System.out.println("Number of columns:");
        int column2 = scanner.nextInt();
        int matrix2[][] =MatrixCalculator.createMatrix(row2,column2);
        System.out.println("");
        
        //matrix multiolication can only be done if the number of column in the first matrix 
        //is the same as the number of row in second matrix
        if (column1==row2){
            //multiply the matrices
        for (int i=0;i <row1; i++){
            
            for (int k=0;k<column2;k++){
                int value=0;
                for (int j=0; j<column1;j++){
                    int toAdd= ((matrix1[i][j])*(matrix2[j][k]));
                    value=value+ toAdd;
                }   
                System.out.print( value  + " ");
            }
            System.out.println("");
        }   
        }else{
            //error message stating it can not be mulitiplicated
            System.out.println("Can not multiply");
        }
        System.out.println("");
    }
    
    public static void determinant(){
        //calculating determinant for 3 by 3 matrix
        System.out.println("Enter 3x3 matrix:");
        
        //creating teh array matrix
        int matrix[][] = MatrixCalculator.createMatrix(3,3);
        System.out.println("");
        
        //calculating and printing determinant
        int determinantVal = (
                               (matrix[0][0] *(((matrix[1][1])*(matrix[2][2]))-((matrix[1][2])*matrix[2][1]))) 
                              -(matrix[0][1] *(((matrix[1][0])*(matrix[2][2]))-((matrix[1][2])*matrix[2][0])))
                              +(matrix[0][2] *(((matrix[1][0])*(matrix[2][1]))-((matrix[1][1])*matrix[2][0])))
                             ); 
        System.out.println("Determinant:"+ determinantVal);
        
        System.out.println("");
    }
    
    public static int[][] createMatrix(int row, int column){
        Scanner scanner= new Scanner(System.in);   
        //creating teh array to store teh matrix
        int matrix[][]=new int[row][column];
        System.out.println("Enter numbers from left to right");
        //stroing the values in each cell
        for (int i =0; i<row;i++){
            for (int j=0; j<column; j++){
                System.out.println("Enter number:");
                matrix[i][j]=scanner.nextInt();
            }
        }
        //returning the 2d array
        return matrix;
    
    }
}
