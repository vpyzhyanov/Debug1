package ru.oop;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Matrix<Integer> matrix = Matrix.generate(3, 5, new IntMatrixDataGenerator());
        System.out.println("Сгенерирована матрица:");
        matrix.print();
        System.out.println("Максимальный элемент: " + matrix.max());
        System.out.println("Минимальный элемент: " + matrix.min());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координаты для выделения части матрицы");
        System.out.println("Координата x левого верхнего угла:");
        int i1 = scanner.nextInt();
        System.out.println("Координата y левого верхнего угла:");
        int j1 = scanner.nextInt();
        System.out.println("Координата x правого нижнего угла:");
        int i2 = scanner.nextInt();
        System.out.println("Координата y правого нижнего угла:");
        int j2 = scanner.nextInt();

        Matrix<Integer> partition = matrix.partition(i1, j1, i2, j2);
        System.out.println("Вы выбрали следующую часть матрицы:");
        partition.print();

        Matrix<Integer> transposed = matrix.transpose();
        System.out.println("Транспонированная матрица:");
        transposed.print();

        Matrix<Double> doubleMatrix = Matrix.generate(3, 5, new DoubleMatrixDataGenerator());
        System.out.println("Сгенерирована матрица:");
        doubleMatrix.print();
        System.out.println("Максимальный элемент: " + doubleMatrix.max());
        System.out.println("Минимальный элемент: " + doubleMatrix.min());
    }
}
