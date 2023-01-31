package pl.camp.micro.book.store.validators;

import pl.camp.micro.book.store.exceptions.UserValidationException;

public class UserDataValidator {

    public static void validateLogin(String login) {
        String regexp = "^.{5,}$";
        if(!login.matches(regexp)) {
            throw new UserValidationException();
        }
    }

    public static void validatePassword(String password) {
        String regexp = "^.{5,}$";
        if(!password.matches(regexp)) {
            throw new UserValidationException();
        }
    }
}
