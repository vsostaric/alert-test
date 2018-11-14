package app.repository.rule;

import app.model.Medicine;
import app.model.rule.dao.DomainRuleDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface DomainRuleRepository extends JpaRepository<DomainRuleDAO, Long> {

    List<DomainRuleDAO> findAllByMedicine(Medicine medicine);

    Set<DomainRuleDAO> findAllByMedicineIn(Set<Medicine> medicines);

}
