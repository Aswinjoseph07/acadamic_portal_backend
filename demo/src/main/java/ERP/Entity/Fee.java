package ERP.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "fees",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {
                        "student_id", "semester"
                })
        }
)
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    private int semester;
    private Double totalAmount;
    private Double paidAmount;
    private Double dueAmount;
    private String status;
    private LocalDate lastPaymentDate;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // getters & setters
}

