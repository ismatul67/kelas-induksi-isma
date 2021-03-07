package id.bmri.introduction.be.day2.beintroductionday2.Service;

import id.bmri.introduction.be.day2.beintroductionday2.model.request.StudentRequest;
import id.bmri.introduction.be.day2.beintroductionday2.model.request.StudentSearchMajorAndGradeRequest;
import id.bmri.introduction.be.day2.beintroductionday2.model.response.StudentDto;

import java.util.List;

public interface StudentService {

    public boolean create (StudentRequest studentRequest);
    public List<StudentDto> findAll();
    public StudentDto getStudentByName(String name);
    public List<StudentDto> getStudentsByGradeAndMajor(StudentSearchMajorAndGradeRequest studentSearchRequest);
    public List<StudentDto> getStudentsByGrade(Integer grade);
    public List<StudentDto> getStudentsByMajor(String major);

}
