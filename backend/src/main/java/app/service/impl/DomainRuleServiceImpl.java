package app.service.impl;

import app.model.Medicine;
import app.model.rule.dao.DomainRuleDAO;
import app.model.rule.dao.DomainRuleParams;
import app.model.rule.dao.DomainRuleTypeDAO;
import app.repository.rule.DomainRuleRepository;
import app.repository.rule.DomainRuleTypeRepository;
import app.service.DomainRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DomainRuleServiceImpl implements DomainRuleService {

    private DomainRuleRepository domainRuleRepository;

    private DomainRuleTypeRepository domainRuleTypeRepository;

    @Autowired
    public DomainRuleServiceImpl(
            DomainRuleRepository domainRuleRepository,
            DomainRuleTypeRepository domainRuleTypeRepository) {
        this.domainRuleRepository = domainRuleRepository;
        this.domainRuleTypeRepository = domainRuleTypeRepository;
    }

    @Override
    public Set<DomainRuleDAO> fetchDomainRuleForMedicines(Set<Medicine> medicines) {
        return domainRuleRepository.findAllByMedicineIn(medicines);
    }

    @Override
    public List<DomainRuleDAO> fetchDomainRuleForMedicine(Medicine medicine) {
        return domainRuleRepository.findAllByMedicine(medicine);
    }

    @Override
    public List<DomainRuleDAO> fetchDomainRules() {
        return domainRuleRepository.findAll();
    }

    @Override
    public DomainRuleDAO saveDomainRule(DomainRuleDAO domainRuleDAO) {

        return domainRuleRepository.save(domainRuleDAO);
    }

    @Override
    public List<DomainRuleTypeDAO> fetchDomainRuleTypes() {
        return domainRuleTypeRepository.findAll();
    }

    @Override
    public List<DomainRuleParams> fetchEmptyDomainRuleParams(DomainRuleTypeDAO domainRuleTypeDAO) {

        Collection<String> typeParams = domainRuleTypeRepository.getTypeParams(domainRuleTypeDAO.getId());

        if (CollectionUtils.isEmpty(typeParams)) {
            return new ArrayList<>();
        }

        return typeParams.stream()
                .map(typeParam -> {
                    DomainRuleParams ruleParam = new DomainRuleParams();
                    ruleParam.setKey(typeParam);
                    return ruleParam;
                })
                .collect(Collectors.toList());

    }

}
