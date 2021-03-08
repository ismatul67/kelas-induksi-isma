package id.bmri.introduction.be.day2.beintroductionday2.controller;
import id.bmri.introduction.be.day2.beintroductionday2.Service.impl.StudentServiceImpl;
import id.bmri.introduction.be.day2.beintroductionday2.model.request.StudentRequest;
import id.bmri.introduction.be.day2.beintroductionday2.model.request.StudentSearchMajorAndGradeRequest;
import id.bmri.introduction.be.day2.beintroductionday2.model.response.StudentDto;
import id.bmri.introduction.be.day2.beintroductionday2.util.Response;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/student")
@RestController
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    @PostMapping("v1/check-ok")
    public ResponseEntity checkOk(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("v1/check-error")
    public ResponseEntity checkError(){
        return new ResponseEntity<>(HttpStatus.GATEWAY_TIMEOUT);
    }
    @PostMapping("v1/create")
    public ResponseEntity<Response> saveStudent(@RequestBody StudentRequest studentRequest){
        Response response;

        if (StringUtils.isEmpty(studentRequest.getName())){
            response = new Response(null, "Name is required", false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);            }
        if (studentRequest.getAge()==null || studentRequest.getAge()==0){
            response = new Response(null, "Age is required", false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);              }
        if (studentRequest.getGrade()==null || studentRequest.getGrade()==0){
            response = new Response(null, "Grade is required", false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);              }
        if (StringUtils.isEmpty(studentRequest.getMajor())){
            response = new Response(null, "Major is required", false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }


        Boolean isCreated = studentService.create(studentRequest);
        response = new Response(null, "Success to submit a new student", isCreated);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("v1/search-students-by-major-and-grade")
    public ResponseEntity<Response> getStudentsByMajorAndGrade(@RequestBody StudentSearchMajorAndGradeRequest studentSearch){
        return doSearchMajorAndGrade(studentSearch);
    }

    @GetMapping("v1/get-students")
    public ResponseEntity<Response> getStudents(){
        List<StudentDto> studentDtos = studentService.findAll();
        Response response = new Response(studentDtos, "Here your data", true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("v1/get-student/{name}")
    public ResponseEntity<Response> getStudentByName(@PathVariable String name){
        StudentDto studentDto;
        Response response;
        if (StringUtils.isNotEmpty(name)) {
            studentDto = studentService.getStudentByName(name);

            if (ObjectUtils.isNotEmpty(studentDto)){
                response = new Response( studentDto,"Here your data", true);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }else {
                response = new Response("Data not found", null,false);
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        }else{
            response = new Response(null, "Name is required", false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("v1/search-students-by-grade")
    public ResponseEntity<Response> getStudentsByGrade(@RequestParam Integer grade){
        List<StudentDto> studentDtoList;
        Response response;
        if (grade!=0) {
            studentDtoList = studentService.getStudentsByGrade(grade);

            if (!studentDtoList.isEmpty()){
                response = new Response( studentDtoList,"Here your data", true);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }else {
                response = new Response("Data not found", null,false);
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        }else{
            response = new Response(null, "Grade is required", false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("v1/search-students-by-major")
    public ResponseEntity<Response> getStudentsByMajor(@RequestParam String major){
        List<StudentDto> studentDtoList;
        Response response;
        if (StringUtils.isNotEmpty(major)) {
            studentDtoList = studentService.getStudentsByMajor(major);

            if (!studentDtoList.isEmpty()){
                response = new Response( studentDtoList,"Here your data", true);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }else {
                response = new Response("Data not found", null,false);
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        }else{
            response = new Response(null, "Major is required", false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<Response> doSearchMajorAndGrade(StudentSearchMajorAndGradeRequest studentSearch){
        Response response;
        if (studentSearch.getGrade()==null || studentSearch.getGrade()==0){
            response = new Response(null, "Grade is required", false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);            }
        if (StringUtils.isEmpty(studentSearch.getMajor())){
            response = new Response(null, "Major is required", false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        List<StudentDto> studentDtos = studentService.getStudentsByGradeAndMajor(studentSearch);

        if (studentDtos.isEmpty()){
            response = new Response(null, "Data not found", false);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }else {
            response = new Response(studentDtos, "Here your data", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }



}
