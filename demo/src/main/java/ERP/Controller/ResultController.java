package ERP.Controller;


import ERP.Entity.Result;
import ERP.Service.ResultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    // STUDENT
    @GetMapping("/student/{studentId}")
    public List<Result> getResults(
            @PathVariable Long studentId,
            @RequestParam int semester
    ) {
        return resultService.getPublishedResults(studentId, semester);
    }

    // STAFF
    @PostMapping("/upload")
    public Result uploadResult(@RequestBody Result result) {
        return resultService.saveResult(result);
    }
}

