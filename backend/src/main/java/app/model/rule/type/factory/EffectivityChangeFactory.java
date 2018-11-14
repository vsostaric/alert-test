package app.model.rule.type.factory;

import app.model.rule.DomainRule;
import app.model.rule.dao.DomainRuleDAO;
import app.model.rule.type.AbstractDomainRule;
import app.model.rule.type.EffectivityChange;
import app.repository.MedicineRepository;
import app.service.BeanUtil;

import java.math.BigDecimal;
import java.util.Map;

public class EffectivityChangeFactory extends AbstractDomainRuleFactory {

    @Override
    public DomainRule getDomainRule(DomainRuleDAO domainRuleDAO) {

        Map<String, String> params =
                getDomainRuleParamsMap(domainRuleDAO.getDomainRuleParams());

        AbstractDomainRule rule = new EffectivityChange();
        ((EffectivityChange) rule).setDiminish(
                Boolean.valueOf(params.get("isDiminish")));
        ((EffectivityChange) rule).setAmountOfChange(
                new BigDecimal(params.get("amountOfChange")));
        ((EffectivityChange) rule).setMedicineCausingChange(
                BeanUtil.getBean(MedicineRepository.class)
                        .findById(Long.valueOf(params.get("medicineCausingChange"))).orElse(null)
        );

        rule.setMedicineAffected(domainRuleDAO.getMedicine());

        return rule;
    }
}
