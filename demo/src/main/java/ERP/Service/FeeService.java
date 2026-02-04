package ERP.Service;

import ERP.Entity.Fee;
import ERP.Repository.FeeRepository;
import org.springframework.stereotype.Service;

@Service
public class FeeService {

    private final FeeRepository feeRepository;

    public FeeService(FeeRepository feeRepository) {
        this.feeRepository = feeRepository;
    }

    public Fee getFee(Long studentId, int semester) {
        return feeRepository
                .findByStudentIdAndSemester(studentId, semester)
                .orElseThrow(() -> new RuntimeException("Fee record not found"));
    }

    public Fee saveFee(Fee fee) {
        return feeRepository.save(fee);
    }
}

