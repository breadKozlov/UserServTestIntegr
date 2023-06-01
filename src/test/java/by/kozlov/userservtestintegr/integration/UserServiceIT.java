package by.kozlov.userservtestintegr.integration;

import by.kozlov.userservtestintegr.ApplicationRunner;
import by.kozlov.userservtestintegr.dto.CompanyCreateDto;
import by.kozlov.userservtestintegr.dto.UserCreateDto;
import by.kozlov.userservtestintegr.entity.User;
import by.kozlov.userservtestintegr.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = ApplicationRunner.class)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class UserServiceIT {

    @Autowired
    private UserService userService;

    @Test
    void createUser() {

        var company = new CompanyCreateDto(1,"Nestle");
        var user = new UserCreateDto(1,"Pavel","Kozlov","Kiiller@tut.by",company);
        assertEquals(user.getId(),userService.create(user));
        var listUsers = userService.getUsers();
        assertThat(listUsers).hasSize(1);
        var listCompanies = listUsers.stream().map(it -> it.getCompany().getName()).toList();
        assertThat(listCompanies).contains("Nestle");
    }

}
