package _30_01_2023.mockClasses.stub;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException() {
        super("No such customer found!");
    }
}