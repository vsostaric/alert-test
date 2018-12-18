function fetchDomainRules() {
    return [
        {
            "id": 10,
            "medicine": {
                "id": 23,
                "code": "0002-3230",
                "name": "Evista"
            },
            "study": {
                "id": 10,
                "title": "ISBN: 2331 Dream within a Dream"
            },
            "domainRuleTypeDAO": {
                "id": 10,
                "type": "effectivity_change"
            },
            "domainRuleParams": [
                {
                    "id": 10,
                    "key": "isDiminish",
                    "value": "true"
                },
                {
                    "id": 11,
                    "key": "amountOfChange",
                    "value": "25"
                },
                {
                    "id": 12,
                    "key": "medicineCausingChange",
                    "value": "22"
                }
            ]
        },
        {
            "id": 11,
            "medicine": {
                "id": 21,
                "code": "0002-3230",
                "name": "Evista"
            },
            "study": {
                "id": 10,
                "title": "ISBN: 2331 Dream within a Dream"
            },
            "domainRuleTypeDAO": {
                "id": 10,
                "type": "effectivity_change"
            },
            "domainRuleParams": [
                {
                    "id": 13,
                    "key": "amountOfChange",
                    "value": "12"
                },
                {
                    "id": 14,
                    "key": "isDiminish",
                    "value": "true"
                },
                {
                    "id": 15,
                    "key": "medicineCausingChange",
                    "value": "19"
                }
            ]
        }
    ];
}

function fetchDomainRuleTypes() {
    return [
        {
            "id": 10,
            "type": "effectivity_change"
        },
        {
            "id": 11,
            "type": "toxicity_possible"
        }
    ]
}

function fetchDomainRuleParams(domainRuleType) {

    return {
        "id": 11,
        "type": "toxicity_possible"
    };

}

function saveDomainRule(domainRule) {
    return domainRule;
}

module.exports = {
    fetchDomainRules: fetchDomainRules,
    fetchDomainRuleTypes: fetchDomainRuleTypes,
    fetchDomainRuleParams: fetchDomainRuleParams,
    saveDomainRule: saveDomainRule
}