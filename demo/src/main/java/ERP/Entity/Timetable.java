package ERP.Entity;

import ERP.enums.DayOfWeek;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "timetable",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {
                        "department", "semester", "day_of_week", "hour"
                })
        }
)
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String department;
    private int semester;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week")
    private DayOfWeek dayOfWeek;

    private int hour;
    private String subjectName;

    @ManyToOne
    @JoinColumn(name = "staff_user_id", nullable = false)
    private User staff;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // getters & setters
}

