package ERP.Service;

import ERP.Entity.User;
import ERP.Entity.Student;
import ERP.Repository.StudentRepository;
import ERP.enums.RegisterRequest;
import ERP.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;

    public AuthService(UserRepository userRepository,
                       StudentRepository studentRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
    }

    // REGISTER (User + Student)
    public Student register(User user, Student student) {

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RuntimeException("Roll number already exists");
        }

        // save user
        User savedUser = userRepository.save(user);

        // link student with user
        student.setUser(savedUser);
        student.setRollNo(user.getUsername());

        return studentRepository.save(student);
    }

    // LOGIN (Return Student Details)
    public Student login(String rollNo, String password) {

        User user = userRepository.findByUsername(rollNo)
                .orElseThrow(() -> new RuntimeException("Invalid roll number"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return studentRepository.findByUserId(user.getId())
                .orElseThrow(() -> new RuntimeException("Student profile not found"));
    }
}


