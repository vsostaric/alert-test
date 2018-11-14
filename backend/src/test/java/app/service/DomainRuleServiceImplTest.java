package app.service;

import app.model.rule.dao.DomainRuleParams;
import app.model.rule.dao.DomainRuleTypeDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainRuleServiceImplTest {

    private DomainRuleService domainRuleService;

    @Autowired
    public void setDomainRuleService(
            DomainRuleService domainRuleService) {
        this.domainRuleService = domainRuleService;
    }

    @Test
    public void testFetchEmptyDomainRuleParams() {

        DomainRuleTypeDAO type = domainRuleService.fetchDomainRuleTypes().get(0);
        List<DomainRuleParams> emptyDomainParams = domainRuleService.fetchEmptyDomainRuleParams(type);

        assertThat(emptyDomainParams).isNotEmpty();

    }

}
