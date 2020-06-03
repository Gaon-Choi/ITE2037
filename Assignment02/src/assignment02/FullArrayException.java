package assignment02;

public class FullArrayException extends Exception {
    public FullArrayException() {
        super("List is full!\n"
                + "Try to expand...\n"
                + "How much will it expand? \n");
    }

    public FullArrayException(String str) {
        super("List is full!\n"
                + "Try to expand...\n"
                + "How much will it expand? \n");
    }
}
