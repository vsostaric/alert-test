package app.model.rule.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq_study")
    @SequenceGenerator(name = "id_seq_study", sequenceName = "study_seq_id", allocationSize = 1)
    private Long id;

    private String title;

}
