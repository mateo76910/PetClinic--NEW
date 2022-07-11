package tutorial.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Visits")
public class Visit extends BaseEntity{
    @Column(name="date")
    private LocalDate date;
    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name="pet_id")
    private Pet pet;
}
