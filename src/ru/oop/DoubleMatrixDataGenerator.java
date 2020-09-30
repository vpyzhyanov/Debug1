package ru.oop;

import java.util.Random;

/**
 * Генератор данных для матрицы вещественных чисел
 */
public class DoubleMatrixDataGenerator implements MatrixDataGenerator<Double> {

    @Override
    public Double getInitValue() {
        return 0d;
    }

    @Override
    public Double generateValue() {
        return new Random().nextDouble() * 100;
    }
}
