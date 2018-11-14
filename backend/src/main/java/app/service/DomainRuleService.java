package app.service;

import app.model.Medicine;
import app.model.rule.dao.DomainRuleDAO;
import app.model.rule.dao.DomainRuleParams;
import app.model.rule.dao.DomainRuleTypeDAO;

import java.util.List;
import java.util.Set;

public interface DomainRuleService {

    Set<DomainRuleDAO> fetchDomainRuleForMedicines(Set<Medicine> medicines);

    List<DomainRuleDAO> fetchDomainRuleForMedicine(Medicine medicine);

    List<DomainRuleDAO> fetchDomainRules();

    DomainRuleDAO saveDomainRule(DomainRuleDAO domainRuleDAO);

    List<DomainRuleTypeDAO> fetchDomainRuleTypes();

    List<DomainRuleParams> fetchEmptyDomainRuleParams(DomainRuleTypeDAO domainRuleTypeDAO);
}
