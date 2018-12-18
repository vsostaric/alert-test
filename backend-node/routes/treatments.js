var express = require('express');
var router = express.Router();

function checkForAlerts(treatment) {
    return [];
}

function findTreatments() {
    return [
        {
            "id": 10,
            "name": "treatment1",
            "medicines": []
        },
        {
            "id": 11,
            "name": "treatment2",
            "medicines": [
                {
                    "id": 22,
                    "code": "0002-3229",
                    "name": "Olumiant"
                },
                {
                    "id": 23,
                    "code": "0002-3230",
                    "name": "Evista"
                }
            ]
        }
    ];
}

function saveTreatment(treatment) {
    return [
        {
            "id": 10,
            "name": "treatment1",
            "medicines": []
        },
        {
            "id": 11,
            "name": "treatment2",
            "medicines": [
                {
                    "id": 22,
                    "code": "0002-3229",
                    "name": "Olumiant"
                },
                {
                    "id": 23,
                    "code": "0002-3230",
                    "name": "Evista"
                }
            ]
        },
        {
            "id": 13,
            "name": "string",
            "medicines": [
                {
                    "id": 21,
                    "code": "0002-3230",
                    "name": "Evista"
                }
            ]
        },
        {
            "id": 14,
            "name": "string",
            "medicines": [
                {
                    "id": 21,
                    "code": "0002-3230",
                    "name": "Evista"
                }
            ]
        }
    ]
}

router.post('/checkForAlerts', function (req, res, next) {

    const treatment = req.body;
    res.send(checkForAlerts(treatment));

});

router.post('/findTreatments', function (req, res, next) {
    res.send(findTreatments())
});

router.post('/saveTreatment', function (req, res, next) {
    treatment = req.body;
    treatments = saveTreatment(treatment);
    res.send(treatments);
});

module.exports = router;