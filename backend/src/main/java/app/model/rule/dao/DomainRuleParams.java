package app.model.rule.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "domain_rule_params")
public class DomainRuleParams {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq_dom_rule_params")
    @SequenceGenerator(name = "id_seq_dom_rule_params", sequenceName = "domain_rule_params_seq_id", allocationSize = 1)
    private Long id;

    private String key;

    private String value;


}
