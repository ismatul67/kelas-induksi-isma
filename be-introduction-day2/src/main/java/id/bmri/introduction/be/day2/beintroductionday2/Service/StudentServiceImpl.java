package id.bmri.introduction.be.day2.beintroductionday2.Service;

import id.bmri.introduction.be.day2.beintroductionday2.model.request.StudentRequest;
import id.bmri.introduction.be.day2.beintroductionday2.model.request.StudentSearchMajorAndGradeRequest;
import id.bmri.introduction.be.day2.beintroductionday2.model.response.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private List<StudentDto> students;

    @Override
    public boolean create(StudentRequest studentRequest) {
        StudentDto newStudent = new StudentDto();

        Integer lengthBeforeAdd;
        if (students.isEmpty()) {
            newStudent.setId((long) 1);
            lengthBeforeAdd = 0;
        } else {
            newStudent.setId((long) (students.size() + 1));
            lengthBeforeAdd = students.size();
        }

        newStudent.setDelete(false);
        newStudent.setCreatedAt(new Date());
        newStudent.setName(studentRequest.getName());
        newStudent.setAge(studentRequest.getAge());
        newStudent.setGrade(studentRequest.getGrade());
        newStudent.setMajor(studentRequest.getMajor());

        students.add(newStudent);

        if ((lengthBeforeAdd + 1) == students.size()) {
            return true;
        }
        return false;
    }

    @Override
    public List<StudentDto> findAll() {
        return this.students;
    }

    @Override
    public StudentDto getStudentByName(String name) {
        StudentDto findStudent = null;
        for (StudentDto student : students) {
            if (student.getName().compareToIgnoreCase(name) == 0) {
                findStudent = student;
            }
        }

        return findStudent;
    }

    @Override
    public List<StudentDto> getStudentsByGradeAndMajor(StudentSearchMajorAndGradeRequest studentSearchRequest) {
        List<StudentDto> studentList = new ArrayList<>();
        for (StudentDto student : students) {
            if (student.getGrade() == studentSearchRequest.getGrade()) {
                if (student.getMajor().compareToIgnoreCase(studentSearchRequest.getMajor()) == 0) {
                    studentList.add(student);
                }
            }
        }
        return studentList;

    }

    @Override
    public List<StudentDto> getStudentsByGrade(Integer grade) {
        List<StudentDto> studentList = new ArrayList<>();
        for (StudentDto student : students) {
            if (student.getGrade() == grade) {
                    studentList.add(student);
            }
        }
        return studentList;    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        List<StudentDto> studentList = new ArrayList<>();
        for (StudentDto student : students) {
                if (student.getMajor().compareToIgnoreCase(major) == 0) {
                    studentList.add(student);
                }
        }
        return studentList;    }

}
