import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "EmployeeProfile",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = {"employeeId"}),
           @UniqueConstraint(columnNames = {"email"})
       })
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String employeeId;

    @Column(nullable = false, length = 100)
    private String fullName;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(length = 100)
    private String department;

    @Column(length = 100)
    private String jobRole;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Constructors, getters, setters
    public EmployeeProfile() {}

    public EmployeeProfile(String employeeId, String fullName, String email,
                           String department, String jobRole, Boolean active) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.email = email;
        this.department = department;
        this.jobRole = jobRole;
        this.active = active;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and setters...
}
