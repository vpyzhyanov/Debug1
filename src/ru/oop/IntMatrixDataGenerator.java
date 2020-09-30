package ru.oop;

import java.util.Random;

/**
 * Генератор данных для матрицы целых чисел
 */
public class IntMatrixDataGenerator implements MatrixDataGenerator<Integer>
{
    @Override
    public Integer getInitValue()
    {
        return 0;
    }

    @Override
    public Integer generateValue()
    {
        return new Random().nextInt(100);
    }
}
