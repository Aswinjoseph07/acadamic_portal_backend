package ERP.Repository;

import ERP.Entity.Timetable;
import ERP.enums.DayOfWeek;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {

    List<Timetable> findByDepartmentAndSemesterAndDayOfWeek(
            String department,
            int semester,
            DayOfWeek dayOfWeek
    );

    Optional<Timetable> findByDepartmentAndSemesterAndDayOfWeekAndHour(
            String department,
            int semester,
            DayOfWeek dayOfWeek,
            int hour
    );
}

