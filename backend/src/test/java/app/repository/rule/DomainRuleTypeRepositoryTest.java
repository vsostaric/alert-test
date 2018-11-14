package app.repository.rule;

import app.model.rule.dao.DomainRuleTypeDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DomainRuleTypeRepositoryTest {

    private DomainRuleTypeRepository domainRuleTypeRepository;

    @Autowired
    public void setDomainRuleRepository(
            DomainRuleTypeRepository domainRuleTypeRepository) {
        this.domainRuleTypeRepository = domainRuleTypeRepository;
    }

    @Test
    public void testGetTypeParams() {

        DomainRuleTypeDAO type = domainRuleTypeRepository.findAll().get(0);
        Collection<String> params = domainRuleTypeRepository.getTypeParams(type.getId());

        assertThat(params).isNotEmpty();
    }

}
