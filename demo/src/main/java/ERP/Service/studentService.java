package ERP.Service;

import ERP.Entity.Student;
import ERP.Repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class studentService {

    private final StudentRepository studentRepository;

    public studentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudentByUserId(Long userId) {
        return studentRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student getStudentByRollNo(String rollNo) {
        return studentRepository.findByRollNo(rollNo)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
