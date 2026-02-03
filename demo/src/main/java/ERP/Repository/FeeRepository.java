package ERP.Repository;

import ERP.Entity.Fee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeeRepository extends JpaRepository<Fee, Long> {

    Optional<Fee> findByStudentIdAndSemester(Long studentId, int semester);
}

