package by.kozlov.userservtestintegr.validator;

import by.kozlov.userservtestintegr.dto.UserCreateDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Component
public class CreateUserValidator implements Validator<UserCreateDto> {

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidationResult isValid(UserCreateDto object) {
        var validationResult = new ValidationResult();
        if (object.getName().isEmpty()) {
            validationResult.add(Error.of("invalid.name", "Name is invalid"));
        }
        if (object.getSurname().isEmpty()) {
            validationResult.add(Error.of("invalid.surname", "Surname is invalid"));
        }
        if (object.getEmail().isEmpty()) {
            validationResult.add(Error.of("invalid.email", "Email is invalid"));
        }
        if (object.getCompany().getName().isEmpty()) {
            validationResult.add(Error.of("invalid.company", "Company is invalid"));
        }
        return validationResult;
    }

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }
}
