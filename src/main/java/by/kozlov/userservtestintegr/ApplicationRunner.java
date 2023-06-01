package by.kozlov.userservtestintegr;

import by.kozlov.userservtestintegr.dto.CompanyCreateDto;
import by.kozlov.userservtestintegr.dto.UserCreateDto;
import by.kozlov.userservtestintegr.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationRunner {
    public static void main(String[] args) {

        var context = SpringApplication.run(ApplicationRunner.class, args);
        var userService = context.getBean(UserService.class);
        var company = new CompanyCreateDto(1,"Nestle");
        var user = new UserCreateDto(1,"Pavel","Kozlov","Kiiller@tut.by",company);
        System.out.println(userService.create(user));
    }

}
