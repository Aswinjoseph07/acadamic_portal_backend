package ERP.Repository;

import ERP.Entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findByStudentIdAndSemesterAndPublishedTrue(
            Long studentId,
            int semester
    );
}
