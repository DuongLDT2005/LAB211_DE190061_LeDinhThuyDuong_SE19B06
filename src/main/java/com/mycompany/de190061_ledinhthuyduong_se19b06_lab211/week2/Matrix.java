/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.de190061_ledinhthuyduong_se19b06_lab211.week2;

/**
 *
 * @author DELL
 */
public class Matrix {

    private int rows, cols;
    private int[][] matrix;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new int[rows][cols];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void printMatrix(Matrix m) {
        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j <m.cols; j++) {
                System.out.print("[" + m.matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    public Matrix additionMatrix(Matrix other) {
        if (this.rows == other.rows && this.cols == other.cols) {
            Matrix result = new Matrix(rows, cols);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result.matrix[i][j] = this.matrix[i][j] + other.matrix[i][j];
                }
            }
            return result;
        } else {
            throw new IllegalArgumentException("Matrix dimensions do not match");
        }
    }

    public Matrix subtractionMatrix(Matrix other) {
        if (this.rows == other.rows && this.cols == other.cols) {
            Matrix result = new Matrix(this.rows, this.cols);
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.cols; j++) {
                    result.matrix[i][j] = this.matrix[i][j] - other.matrix[i][j];
                }
            }
            return result;
        } else {
            throw new IllegalArgumentException("Matrix dimensions do not match");
        }
    }

    public Matrix multiplicationMatrix(Matrix other) {
        if (this.cols == other.rows) {
            Matrix result = new Matrix(this.rows, other.cols);
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < other.cols; j++) {
                    for (int k = 0; k < this.cols; k++) {
                        result.matrix[i][j] += this.matrix[i][k] * other.matrix[k][j];
                    }
                }
            }
            return result;
        } else {
            throw new IllegalArgumentException("The number of columns of matrix A does not equal the number of rows of matrix B");
        }
    }
}
