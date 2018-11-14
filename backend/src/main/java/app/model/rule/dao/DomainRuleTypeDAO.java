package app.model.rule.dao;

import lombok.Data;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "domain_rule_type")
public class DomainRuleTypeDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq_dom_rule_type")
    @SequenceGenerator(name = "id_seq_dom_rule_type", sequenceName = "domain_rule_type_seq_id", allocationSize = 1)
    private Long id;

    private String type;

}
