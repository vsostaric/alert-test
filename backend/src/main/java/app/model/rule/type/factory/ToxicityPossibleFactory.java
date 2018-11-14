package app.model.rule.type.factory;

import app.model.rule.DomainRule;
import app.model.rule.dao.DomainRuleDAO;
import app.model.rule.type.AbstractDomainRule;
import app.model.rule.type.ToxicityPossible;
import app.repository.MedicineRepository;
import app.service.BeanUtil;

import java.math.BigDecimal;
import java.util.Map;

public class ToxicityPossibleFactory extends AbstractDomainRuleFactory {

    @Override
    public DomainRule getDomainRule(DomainRuleDAO domainRuleDAO) {

        Map<String, String> params =
                getDomainRuleParamsMap(domainRuleDAO.getDomainRuleParams());

        AbstractDomainRule rule = new ToxicityPossible();
        ((ToxicityPossible) rule).setToxicity(
                new BigDecimal(params.get("toxicity")));
        ((ToxicityPossible) rule).setMedicineCausingToxicity(
                BeanUtil.getBean(MedicineRepository.class)
                        .findById(Long.valueOf(params.get("medicineCausingToxicity")))
                        .orElse(null)
        );

        rule.setMedicineAffected(domainRuleDAO.getMedicine());

        return rule;

    }
}
