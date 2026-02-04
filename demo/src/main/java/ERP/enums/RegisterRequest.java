package ERP.enums;

import ERP.Entity.Student;
import ERP.Entity.User;

public class RegisterRequest {

    private User user;
    private Student student;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

