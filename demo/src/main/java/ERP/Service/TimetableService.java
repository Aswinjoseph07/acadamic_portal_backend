package ERP.Service;

import ERP.Entity.Timetable;
import ERP.enums.DayOfWeek;
import ERP.Repository.TimetableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableService {

    private final TimetableRepository timetableRepository;

    public TimetableService(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }

    public List<Timetable> getDailyTimetable(
            String department,
            int semester,
            DayOfWeek dayOfWeek
    ) {
        return timetableRepository
                .findByDepartmentAndSemesterAndDayOfWeek(
                        department, semester, dayOfWeek
                );
    }

    public Timetable getTimetableSlot(
            String department,
            int semester,
            DayOfWeek dayOfWeek,
            int hour
    ) {
        return timetableRepository
                .findByDepartmentAndSemesterAndDayOfWeekAndHour(
                        department, semester, dayOfWeek, hour
                )
                .orElseThrow(() -> new RuntimeException("Timetable slot not found"));
    }
}

