package ERP.Controller;

import ERP.Entity.Attendance;
import ERP.Entity.Student;
import ERP.Entity.Timetable;
import ERP.Entity.User;
import ERP.enums.AttendanceStatus;
import ERP.Service.AttendanceService;
import ERP.Service.studentService;
import ERP.Service.TimetableService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/attendance")
@CrossOrigin
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    // MARK ATTENDANCE
    @PostMapping("/mark")
    public Attendance markAttendance(@RequestBody Attendance attendance) {
        return attendanceService.markAttendance(attendance);
    }

    // GET STUDENT ATTENDANCE
    @GetMapping("/student/{studentId}")
    public List<Attendance> getAttendanceByStudent(@PathVariable Long studentId) {
        return attendanceService.getAttendanceByStudent(studentId);
    }
}


