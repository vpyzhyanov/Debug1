package ru.oop;

/**
 * Генератор данных для матрицы.
 * Нужен для инициализации матрицы и генерации случайных значений
 */
public interface MatrixDataGenerator<T>
{
    /**
     * Начальное значение
     */
    T getInitValue();

    /**
     * Сгенерировать случайное значение
     */
    T generateValue();
}
