package errors;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponse {
    Map<String, String> fieldErrors;
    String generalMessage;

    public ErrorResponse(){
        this.fieldErrors = new HashMap<>();
        this.generalMessage = "Validation error";
    }

    public void addFieldError(String field, String message){
        this.fieldErrors.put(field, message);
    }

    public boolean hasErrors(){
        return !this.fieldErrors.isEmpty();
    }

    public Map<String, String> getFieldErrors(){
        return this.fieldErrors;
    }

    public String getGeneralMessage(){
        return this.generalMessage;
    }
}