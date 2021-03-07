package id.bmri.introduction.be.day2.beintroductionday2.model.response;

import id.bmri.introduction.be.day2.beintroductionday2.model.Person;
import lombok.Data;

import java.util.Date;

@Data
public class StudentDto extends Person {
    private Long id;
    private Integer grade;
    private String major;
    private boolean isDelete;
    private Date createdAt;

    public StudentDto(Long id, Integer grade, String major, boolean isDelete, Date createdAt, Integer age, String name) {
        this.id = id;
        this.grade = grade;
        this.major = major;
        this.isDelete = isDelete;
        this.createdAt = createdAt;
        super.setAge(age);
        super.setName(name);
    }

    public StudentDto() {
    }
}
