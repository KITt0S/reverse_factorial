package my_exceptions;

public class OutOfDiapasonException extends FactorialException {

    @Override
    public String toString() {

        return "Результат не входит в диапазон чисел от 1 до 2000 включительно.";
    }
}
