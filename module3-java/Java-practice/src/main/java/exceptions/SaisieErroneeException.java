package exceptions;

import java.util.NoSuchElementException;

public class SaisieErroneeException extends NoSuchElementException {
    public SaisieErroneeException() {
        super();
    }

    public SaisieErroneeException(String s) {
        super(s);
    }
}
