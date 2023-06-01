package by.kozlov.userservtestintegr.mapper;

import by.kozlov.userservtestintegr.dto.UserCreateDto;
import by.kozlov.userservtestintegr.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreateMapper implements Mapper <UserCreateDto, User>{

    private final CompanyCreateMapper companyCreateMapper;

    @Override
    public User mapFrom(UserCreateDto object) {
        return User.builder()
                .id(object.getId())
                .name(object.getName())
                .surname(object.getSurname())
                .email(object.getEmail())
                .company(companyCreateMapper.mapFrom(object.getCompany()))
                .build();
    }
}
