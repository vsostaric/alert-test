package app.repository.rule;

import app.model.rule.dao.DomainRuleTypeDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface DomainRuleTypeRepository extends JpaRepository<DomainRuleTypeDAO, Long> {

    @Query(value = "select key from domain_rule_type_keys where id_type = :ruleTypeId",
            nativeQuery = true)
    Collection<String> getTypeParams(@Param("ruleTypeId") Long domainRuleTypeDAOId);

}
