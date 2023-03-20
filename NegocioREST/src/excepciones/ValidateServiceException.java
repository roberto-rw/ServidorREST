package excepciones;

public class ValidateServiceException extends RuntimeException{
    public ValidateServiceException(String message){
        super(message);
    }
}
