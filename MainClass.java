/*
 * Работа с исключениями
 * 
 * 
 */
package java2.lesson2;

import java.util.InputMismatchException;

/**
 *
 * @author @author Gerasimov V. Gerasim
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //justMethod();
        //throw new Exception(); // тут ошибка компиляци
        //String [][] sTable = new String [ 4 ][ 4 ];
        String [][] sTable = {
            //{" 0"," 1"," 2"," 3"}, //закоментировать строку для MyArraySizeException
            {" 4"," 5"," 6"," 7"}, //добавить любой не числовой символ к элементу
            {" 8"," 9","10","11"}, // для MyArrayDataException
            {"12","13","14","15"}
        };
        int sum = 0;
        try {
            sum = checkArray (sTable);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
            
        } finally {
            System.out.println("sum:"+sum);
        }
        
    }
    
    /**
     * Проверка разерности 2D-массива
     * @param table ожидается массив 4х4 если размер отличается то выбрасывается исключение
     * @throws MyArraySizeException 
     */
    public static int checkArray(String [][] table) throws MyArraySizeException, MyArrayDataException {
        //проверяю размерность 2D массива
        if ((table.length != 4) || (table[1].length != 4)){
            throw new MyArraySizeException(table.length, table[0].length, "");
        }
        //проверка преобразования чисел (за одно и вывод массива)
        int sum = 0;//сумма цифр массива
        String cell;
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                cell = table[row][col];
                System.out.print(cell + "\t");
                try {
                    sum += Integer.parseInt(cell.trim());//удаляю пробелы и преобразую в int
                } catch (NumberFormatException e){
                    System.out.println("не число!");
                    throw new MyArrayDataException(row, col,cell);
                }
            }
            System.out.println();
        }
        //System.out.println("sum:"+sum);
        return sum;
    }
    
    //Для прототипов, желательно писать какие исключения выбрасывает метод
    //   для информации программисту-читателю
    //В боевых проектах, через throws указываются исключения которые
    //  выбрасываются в методе, но НЕ перехватываются в нём
    //Исключения которые перехватывает метод, не указываются в throws
    /**
     * 
     * @throws ArithmeticException
     * @throws ArrayIndexOutOfBoundsException 
     */
    public static void justMethod () throws ArithmeticException, ArrayIndexOutOfBoundsException {
        int a , b ;
        try {
            //деление на Ноль
            a = 1 ;
            b = 10 / a ;
            //Размер массива
            int[] c = {1,2,3};
            c[42] = 99;
            System . out . println ( "Это сообщение не будет выведено в консоль" );
        } catch ( ArithmeticException e ) {
            e . printStackTrace ();//вывод списка исключений
            System . out . println ( "Деление на ноль" );
         } catch (ArrayIndexOutOfBoundsException e){
            e . printStackTrace ();//вывод списка исключений
            System . out . println ( "Выход за пределы массива" );
         } finally {
            System . out . println ( "FINALLY" );
         }
            
        
        
        System . out . println ( "Завершение работы" );
    }
}
