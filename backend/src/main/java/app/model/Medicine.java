package app.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq_medicine")
    @SequenceGenerator(name = "id_seq_medicine", sequenceName = "medicine_seq_id", allocationSize = 1)
    private Long id;

    private String code;

    private String name;

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return Objects.equals(id, medicine.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
