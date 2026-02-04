package ERP.Controller;


import ERP.Entity.Timetable;
import ERP.enums.DayOfWeek;
import ERP.Service.TimetableService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timetable")
public class TimetableController {

    private final TimetableService timetableService;

    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @GetMapping("/daily")
    public List<Timetable> getDailyTimetable(
            @RequestParam String department,
            @RequestParam int semester,
            @RequestParam DayOfWeek day
    ) {
        return timetableService.getDailyTimetable(department, semester, day);
    }
}
