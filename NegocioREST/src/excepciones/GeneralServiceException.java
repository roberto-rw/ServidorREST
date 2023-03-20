package excepciones;

public class GeneralServiceException extends RuntimeException{
    public GeneralServiceException(String message){
        super(message);
    }
}
