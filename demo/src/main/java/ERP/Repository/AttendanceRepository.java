package ERP.Repository;

import ERP.Entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Optional<Attendance> findByStudentIdAndTimetableIdAndDate(
            Long studentId,
            Long timetableId,
            LocalDate date
    );

    List<Attendance> findByStudentId(Long studentId);

    List<Attendance> findByStudentIdAndDateBetween(
            Long studentId,
            LocalDate startDate,
            LocalDate endDate
    );
}

