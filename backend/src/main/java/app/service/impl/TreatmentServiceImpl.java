package app.service.impl;

import app.model.Alert;
import app.model.Treatment;
import app.model.rule.DomainRule;
import app.model.rule.RuleFactory;
import app.model.rule.dao.DomainRuleDAO;
import app.repository.TreatmentRepository;
import app.service.DomainRuleService;
import app.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TreatmentServiceImpl implements TreatmentService {

    private TreatmentRepository treatmentRepository;

    private DomainRuleService domainRuleService;

    private RuleFactory ruleFactory;

    @Autowired
    public TreatmentServiceImpl(
            TreatmentRepository treatmentRepository,
            DomainRuleService domainRuleService,
            RuleFactory ruleFactory) {
        this.treatmentRepository = treatmentRepository;
        this.domainRuleService = domainRuleService;
        this.ruleFactory = ruleFactory;
    }

    @Override
    public Treatment saveTreatment(Treatment treatment) {
        return this.treatmentRepository.save(treatment);
    }

    @Override
    public List<Treatment> findTreatments() {
        return treatmentRepository.findAll();
    }

    @Override
    public List<Alert> checkForAlerts(Treatment treatment) {

        List<Alert> alerts = new ArrayList<>();

        Set<DomainRuleDAO> rulesDao =
                domainRuleService.fetchDomainRuleForMedicines(treatment.getMedicines());
        Set<DomainRule> rules = ruleFactory.getDomainRules(rulesDao);

        rules.forEach(rule -> {
            Alert alert = rule.check(treatment);
            if(alert != null) {
                alerts.add(alert);
            }
        });

        return alerts;
    }
}
