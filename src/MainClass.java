import my_exceptions.FactorialException;
import my_exceptions.NoFactorialException;
import my_exceptions.OutOfDiapasonException;
import my_exceptions.ZeroAndOneFactorialException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/***
 *  Программа для определения числа по его факториалу
 */

public class MainClass {

    public static void main(String[] args) {

        try( BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) ) ) {

            while( true ) {

                System.out.println( "Введите число:" );
                String text = reader.readLine();
                if( text.equals( "exit" ) ) {

                    break;
                }
                try {

                    BigInteger n = new BigInteger( text );
                    int startValue = getStartValue( n );
                    System.out.println( "Число " + n + " - это факториал числа " + startValue + "." );
                } catch ( NumberFormatException e ) {

                    System.out.println( "Ошибка! Неверный формат ввода." );
                } catch ( FactorialException e ) {

                    System.out.println( e.toString() );
                }
            }
        } catch ( IOException e ) {

            e.printStackTrace();
        }
    }

    public static int getStartValue( BigInteger factorial ) throws FactorialException { // определяем искомое число

        if( factorial.compareTo( new BigInteger( "0" ) ) <= 0 ) {

            throw new NoFactorialException();
        } else if( factorial.compareTo( new BigInteger( "1" ) ) == 0 ) {

            throw new ZeroAndOneFactorialException();
        } else {

            BigInteger n = new BigInteger( "1" );
            BigInteger result = new BigInteger( "1" );
            while ( true ) {

                if( n.compareTo( new BigInteger( "2000" ) ) > 0 ) {

                    throw new OutOfDiapasonException();
                }
                result = result.multiply( n );
                if( result.compareTo( factorial ) > 0 ) {

                    throw new NoFactorialException();
                } else if( result.compareTo( factorial ) == 0 ) {

                    return n.intValue();
                }
                n = n.add( new BigInteger( "1" ) );
            }
        }
    }
}
