package app.model;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq_treat")
    @SequenceGenerator(name = "id_seq_treat", sequenceName = "treatment_seq_id", allocationSize = 1)
    private Long id;

    private String name;

    @Nullable
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "treatment_medicines",
            joinColumns =
                    {@JoinColumn(name = "id_treatment", referencedColumnName = "id")},
            inverseJoinColumns =
                    {@JoinColumn(name = "id_medicine", referencedColumnName = "id")})
    private Set<Medicine> medicines;

    @Override
    public String toString() {
        return "Treatment{" +
                "id=" + id +
                '}';
    }
}
