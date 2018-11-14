package app.model.rule;

import app.model.rule.dao.DomainRuleDAO;
import app.model.rule.type.factory.AbstractDomainRuleFactory;
import app.model.rule.type.factory.EffectivityChangeFactory;
import app.model.rule.type.factory.ToxicityPossibleFactory;
import app.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RuleFactory {

    public Set<DomainRule> getDomainRules(Set<DomainRuleDAO> domainRuleDAO) {
        return domainRuleDAO.stream()
                .map(rule -> this.getDomainRule(rule))
                .collect(Collectors.toSet());
    }

    private DomainRule getDomainRule(DomainRuleDAO domainRuleDAO) {
        return getFactory(domainRuleDAO).getDomainRule(domainRuleDAO);
    }

    private AbstractDomainRuleFactory getFactory(DomainRuleDAO domainRuleDAO) {
        if ("effectivity_change".equals(domainRuleDAO.getDomainRuleTypeDAO().getType())) {
            return new EffectivityChangeFactory();
        } else if("toxicity_possible".equals(domainRuleDAO.getDomainRuleTypeDAO().getType())) {
            return new ToxicityPossibleFactory();
        }

        return null;
    }

}
