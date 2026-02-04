package ERP.Controller;

import ERP.Entity.Fee;
import ERP.Service.FeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fees")
public class FeeController {

    private final FeeService feeService;

    public FeeController(FeeService feeService) {
        this.feeService = feeService;
    }

    @GetMapping("/student/{studentId}")
    public Fee getFee(
            @PathVariable Long studentId,
            @RequestParam int semester
    ) {
        return feeService.getFee(studentId, semester);
    }

    @PostMapping("/save")
    public Fee saveFee(@RequestBody Fee fee) {
        return feeService.saveFee(fee);
    }
}

