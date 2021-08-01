package com.aamer.springsecurity.student;

import com.aamer.springsecurity.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private static List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Anna James"),
            new Student(3, "Dean Jones")
    );

    @GetMapping
    // has_role, has_anyRole, has_authority, has_anyAuthority can be used along with preAuthorize.
    // for this annotation to work, use @EnableGlobalMethodSecurity(prePostEnabled = true) in the ApplicationSecurityConfig class instead of antMatchers
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents() {
        return STUDENTS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student_write')")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println(student.getStudentName()+ " added");
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student_write')")
    public void deleteStudent(@PathVariable Integer studentId) {
        System.out.println(studentId + "delete Student Called");
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student_write')")
    public void updateStudent(@PathVariable Integer studentId, @RequestBody Student student) {
        System.out.println(String.format("%s %s", studentId, student) + "Put student called") ;
    }
}
