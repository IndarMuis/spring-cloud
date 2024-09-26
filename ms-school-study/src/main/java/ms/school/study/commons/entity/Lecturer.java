package ms.school.study.commons.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lecturers")
public class Lecturer extends BaseEntity {

    @Id
    @Column(name = "lecturer_id")
    private String lecturerId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "office_address")
    private String officeAddress;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
}
