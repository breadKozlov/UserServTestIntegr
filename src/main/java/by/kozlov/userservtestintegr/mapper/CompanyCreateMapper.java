package by.kozlov.userservtestintegr.mapper;


import by.kozlov.userservtestintegr.dto.CompanyCreateDto;
import by.kozlov.userservtestintegr.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyCreateMapper implements Mapper <CompanyCreateDto, Company>{
    @Override
    public Company mapFrom(CompanyCreateDto object) {
        return Company.builder()
                .name(object.getName())
                .build();
    }
}
