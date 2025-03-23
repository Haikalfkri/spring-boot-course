package com.k4ll.springBootCourse.Student.Controller;

import com.k4ll.springBootCourse.Student.Model.Student;
import com.k4ll.springBootCourse.Student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/")
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping("/{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }

}
