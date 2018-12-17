package my_exceptions;

public class ZeroAndOneFactorialException extends FactorialException {

    @Override
    public String toString() {

        return "Число 1 - это факториал числа 0 или 1.";
    }
}
