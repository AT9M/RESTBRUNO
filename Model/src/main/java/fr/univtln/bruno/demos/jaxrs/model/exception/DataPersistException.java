package fr.univtln.bruno.demos.jaxrs.model.exception;

public class DataPersistException extends Exception {
    public DataPersistException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
