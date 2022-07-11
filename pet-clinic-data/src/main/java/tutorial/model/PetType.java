package tutorial.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PetType")
public class PetType extends BaseEntity{

    @Column(name = "name")
    private String name;

}
