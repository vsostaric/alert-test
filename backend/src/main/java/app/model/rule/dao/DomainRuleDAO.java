package app.model.rule.dao;

import app.model.Medicine;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "domain_rule")
public class DomainRuleDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq_dom_rule")
    @SequenceGenerator(name = "id_seq_dom_rule", sequenceName = "domain_rule_seq_id", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_medicine")
    private Medicine medicine;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_study")
    private Study study;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_type")
    private DomainRuleTypeDAO domainRuleTypeDAO;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name="id_domain_rule")
    private Set<DomainRuleParams> domainRuleParams;


}
