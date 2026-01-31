package errors;


public class Validations{

    public static void validateName(String name, ErrorResponse errors){
        if(name == null || name.isBlank()){
            errors.addFieldError("name", "Name cannot be empty.");
            return;
        }if(name.length() < 2 || name.length() > 50){
            errors.addFieldError("name", "Name must be between 2 and 50 characters.");
        }if(! name.matches("[A-Za-z ]+")){
            errors.addFieldError("name", "Name can only contain letters and spaces.");
        }
    }

    public static void validateEmail(String email, ErrorResponse errors){
        if(email == null || email.isBlank()){
            errors.addFieldError("email", "Email cannot be empty.");
            return;
        }if(email.length() > 100){
            errors.addFieldError("email", "Email should be max 100 characters long.");
        }
        if(!email.contains("@") || !email.contains(".")){
            errors.addFieldError("email", "Email format is invalid.");
        }
    }
}