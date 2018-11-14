package app.controller;

import app.model.rule.dao.DomainRuleDAO;
import app.model.rule.dao.DomainRuleParams;
import app.model.rule.dao.DomainRuleTypeDAO;
import app.service.DomainRuleService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/domainrules")
public class DomainRulesController {

    private DomainRuleService domainRuleService;

    public DomainRulesController(DomainRuleService domainRuleService) {
        this.domainRuleService = domainRuleService;
    }

    @PostMapping(value="/fetchDomainRules",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<DomainRuleDAO>> fetchDomainRules() {
        return ResponseEntity.ok(domainRuleService.fetchDomainRules());
    }


    @PostMapping(value = "/fetchDomainRuleTypes",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<DomainRuleTypeDAO>> fetchDomainRuleTypes() {
        return ResponseEntity.ok(domainRuleService.fetchDomainRuleTypes());

    }

    @PostMapping(value="/fetchEmptyDomainRuleParams",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<DomainRuleParams>> fetchEmptyDomainRuleParams(
            @RequestBody DomainRuleTypeDAO domainRuleTypeDAO) {
        return ResponseEntity.ok(
        domainRuleService
                .fetchEmptyDomainRuleParams(domainRuleTypeDAO));
    }

    @PostMapping(value = "/saveDomainRule",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<DomainRuleDAO> saveDomainRule(
            @RequestBody DomainRuleDAO domainRuleDAO) {
        return ResponseEntity.ok(domainRuleService.saveDomainRule(domainRuleDAO));
    }


}
