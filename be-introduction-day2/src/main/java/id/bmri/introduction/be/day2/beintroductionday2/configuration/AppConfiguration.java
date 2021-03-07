package id.bmri.introduction.be.day2.beintroductionday2.configuration;

import id.bmri.introduction.be.day2.beintroductionday2.Service.StudentServiceImpl;
import id.bmri.introduction.be.day2.beintroductionday2.model.response.StudentDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class AppConfiguration {

    @Bean(name = "student")
    public StudentDto studentDto() {
        return new StudentDto((long) 1, 12, "Science",true, new Date(), 23, "Isma");
    }

    @Bean(name="students")
    public List<StudentDto> students (){
        List<StudentDto> studentDtos = new ArrayList<>();
        studentDtos.add(studentDto());
        return studentDtos;
    }

}
