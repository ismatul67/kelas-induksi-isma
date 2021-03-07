package id.bmri.introduction.be.day2.beintroductionday2.model.request;

import lombok.Data;

@Data
public class StudentSearchMajorAndGradeRequest {
    private Integer grade;
    private String major;

    public StudentSearchMajorAndGradeRequest(Integer grade, String major) {
        this.grade = grade;
        this.major = major;
    }

    public StudentSearchMajorAndGradeRequest() {
    }
}
