package by.kozlov.userservtestintegr.dto;

import by.kozlov.userservtestintegr.entity.Company;
import lombok.*;
import org.springframework.stereotype.Component;



@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCreateDto {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private CompanyCreateDto company;
}
