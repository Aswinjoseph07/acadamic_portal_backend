package ERP.Controller;


import ERP.Entity.Student;
import ERP.Service.studentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final studentService studentService;

    public StudentController(studentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/profile/{userId}")
    public Student getProfile(@PathVariable Long userId) {
        return studentService.getStudentByUserId(userId);
    }
}

