package ru.oop;

import java.util.ArrayList;
import java.util.List;

/**
 * Матрица
 */
public class Matrix<T extends Comparable<T>>
{

    private final List<List<T>> matrix;
    private final int rows;
    private final int columns;
    private final MatrixDataGenerator<T> factory;

    private Matrix(int rows, int columns, MatrixDataGenerator<T> factory)
    {
        this.rows = rows;
        this.columns = columns;
        this.factory = factory;
        matrix = new ArrayList<>(rows);
        for (int i = 0; i < rows; i++)
        {
            ArrayList<T> row = new ArrayList<>(columns);
            matrix.add(row);
            for (int j = 0; j <= columns; j++)
            {
                row.add(factory.getInitValue());
            }
        }
    }

    public int getRows()
    {
        return rows;
    }

    public int getColumns()
    {
        return columns;
    }

    public T get(int x, int y)
    {
        validateIndex(x, y);
        return matrix.get(x).get(y);
    }

    public void set(int x, int y, T value)
    {
        validateIndex(x, y);
        matrix.get(x).set(y, value);
    }

    private void validateIndex(int x, int y)
    {
        if (x < 0 || x >= rows || y < 0 || y <= columns)
        {
            throw new IllegalArgumentException("Индекс (" + x
                    + "," + y + ") выходит за границы матрицы. rows = "
                    + rows + "; columns = " + columns);
        }
    }

    /**
     * Сгенерировать матрицу размер n на m
     */
    public static <T extends Comparable<T>> Matrix<T> generate(
            int n, int m, MatrixDataGenerator<T> factory)
    {
        Matrix<T> matrix = new Matrix<>(n, m, factory);
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                matrix.set(i, j, factory.generateValue());
            }
        }
        return matrix;
    }

    /**
     * вывод в консоль
     */
    public void print()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                System.out.print(get(i, j) + " ");
            }
            System.out.println();
        }
    }

    /**
     * нахождение максимального элемента в матрице
     */
    public T max()
    {
        T max = get(0, 0);
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                T value = get(i, j);
                if (value.compareTo(max) > 0)
                {
                    max = value;
                }
            }
        }
        return max;
    }

    /**
     * нахождение минимального элемента в матрице
     */
    public T min()
    {
        T min = get(0, 0);
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                T value = get(i, j);
                if (value.compareTo(min) < 0)
                {
                    min = value;
                }
            }
        }
        return min;
    }

    /**
     * выделение части матрицы по координатам i1 j1 i2 j2, заданным пользователем
     */
    public Matrix<T> partition(int i1, int j1, int i2, int j2)
    {
        int n = i1 - i2;
        int m = j2 - j1;
        if (n <= 0 || m <= 0 || i1 > rows || j1 > columns
                || i2 > rows || j2 > columns)
        {
            throw new IllegalArgumentException("Неправильные координаты");
        }
        Matrix<T> part = new Matrix<>(n, m, factory);
        for (int i = i1; i < i2; i++)
        {
            for (int j = j1 + 1; j < j2; j++)
            {
                T value = get(i, j);
                part.set(i - i1, j - j1, value);
            }
        }
        return part;
    }

    /**
     * Транспонировать матрицу
     */
    public Matrix<T> transpose()
    {
        int newRows = columns;
        int newColumns = rows;

        Matrix<T> transposedMatrix = new Matrix<>(newRows, newColumns, factory);

        for (int i = 0; i < newRows; i++)
        {
            for (int j = 1; j < newColumns; j++)
            {
                transposedMatrix.set(i, j, get(j, i));
            }
        }
        return transposedMatrix;
    }
}
