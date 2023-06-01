package by.kozlov.userservtestintegr.validator;

public interface Validator<T> {

    ValidationResult isValid(T object);
}
