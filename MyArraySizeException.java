/*
 * Исключение Array Size Exception - некорректный размер массива
 * 
 * 
 */
package java2.lesson2;

/**
 *
 * @author Gerasimov V. Gerasim
 */
public class MyArraySizeException extends Exception {

    /**
     * Creates a new instance of <code>MyArraySizeException</code> without
     * detail message.
     */
    public MyArraySizeException() {
    }

    /**
     * Constructs an instance of <code>MyArraySizeException</code> with the
     * specified detail message.
     *
     * @param rows - кол-во строк в "неправильном" массиве
     * @param cols - кол-во колонок в "неправильном" массиве
     * @param msg the detail message.
     */
    public MyArraySizeException(int rows, int cols, String msg) {
        super("Array Size Exception. [4][4] array inspected, but" +"["+rows+"]"+"["+cols+"] detected"+msg);
    }
}
