package ERP.Service;

import ERP.Entity.Result;
import ERP.Repository.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    private final ResultRepository resultRepository;

    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public List<Result> getPublishedResults(Long studentId, int semester) {
        return resultRepository
                .findByStudentIdAndSemesterAndPublishedTrue(studentId, semester);
    }

    public Result saveResult(Result result) {
        return resultRepository.save(result);
    }
}

