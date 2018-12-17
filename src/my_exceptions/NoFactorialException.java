package my_exceptions;

public class NoFactorialException extends FactorialException {

    @Override
    public String toString() {

        return "Введенное число не является факториалом.";
    }
}
