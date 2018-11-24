/*
 * Исключение Array Data Exception - данные в ячейке массива не соответсвуют ожидаемым
 * 
 * 
 */
package java2.lesson2;

/**
 *
 * @author info
 */
public class MyArrayDataException extends Exception {

    /**
     * Creates a new instance of <code>MyArrayDataException</code> without
     * detail message.
     */
    public MyArrayDataException() {
    }

    /**
     * Constructs an instance of <code>MyArrayDataException</code> with the
     * specified detail message.
     *
     * @param row - строка с "неправильным" элементом
     * @param col - колонка с "неправильным" элементом
     * @param msg the detail message.
     */
    public MyArrayDataException(int row, int col, String msg) {
        super("Array Data Exception. Element:"+"["+row+"]"+"["+col+"] is not an Integer. "+"Element:"+msg);
    }
}
