let express = require('express');
let router = express.Router();

let domainRulesService = require('../services/domainrules.service');

router.post('/fetchDomainRules', function (req, res, next) {

    const domainRules = domainRulesService.fetchDomainRules();
    res.send(domainRules);

});

router.post('/fetchDomainRuleTypes', function (req, res, next) {

    const domainRuleTypes = domainRulesService.fetchDomainRuleTypes();
    res.send(domainRuleTypes);

});

router.post('/fetchEmptyDomainRuleParams', function (req, res, next) {

    const domainRuleType = req.body;

    const domainRuleParams = domainRulesService.fetchDomainRuleParams(domainRuleType);
    res.send(domainRuleParams);

});

router.post('/saveDomainRule', function (req, res, next) {

    let domainRule = req.body;

    domainRule = domainRulesService.saveDomainRule(domainRule);
    res.send(domainRule);

});

module.exports = router;