package id.bmri.introduction.be.day2.beintroductionday2.model.request;

import id.bmri.introduction.be.day2.beintroductionday2.model.Person;
import lombok.Data;

@Data
public class StudentRequest extends Person {
    private Integer grade;
    private String major;
}
