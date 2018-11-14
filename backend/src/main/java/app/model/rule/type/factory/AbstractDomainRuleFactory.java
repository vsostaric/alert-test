package app.model.rule.type.factory;

import app.model.rule.DomainRule;
import app.model.rule.dao.DomainRuleDAO;
import app.model.rule.dao.DomainRuleParams;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractDomainRuleFactory {

    public abstract DomainRule getDomainRule(DomainRuleDAO domainRuleDAO);

    protected Map<String, String> getDomainRuleParamsMap(Set<DomainRuleParams> params) {

        if (CollectionUtils.isEmpty(params)) {
            return new HashMap<>();
        }

        return params.stream()
                .collect(
                        Collectors.toMap(
                                DomainRuleParams::getKey,
                                DomainRuleParams::getValue)
                );

    }

}
