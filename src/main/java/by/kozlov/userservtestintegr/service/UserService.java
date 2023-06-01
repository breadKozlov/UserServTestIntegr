package by.kozlov.userservtestintegr.service;

import by.kozlov.userservtestintegr.dto.UserCreateDto;
import by.kozlov.userservtestintegr.entity.User;
import by.kozlov.userservtestintegr.exception.ValidationException;
import by.kozlov.userservtestintegr.mapper.UserCreateMapper;
import by.kozlov.userservtestintegr.validator.CreateUserValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Data
public class UserService {

    private final CreateUserValidator createUserValidator;
    private final UserCreateMapper userCreateMapper;
    private final List<User> users = new ArrayList<>();

    public Integer create(UserCreateDto userDto) {

        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        var userEntity = userCreateMapper.mapFrom(userDto);
        users.add(userEntity);
        return users.stream().filter(it -> it.getId().equals(userEntity.getId())).findFirst().orElseThrow().getId();
    }


}
