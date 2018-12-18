var express = require('express');
var router = express.Router();

var treamentsService = require('../services/treatments.service');

router.post('/checkForAlerts', function (req, res, next) {

    const treatment = req.body;
    res.send(treamentsService.checkForAlerts(treatment));

});

router.post('/findTreatments', function (req, res, next) {
    treamentsService.findTreatments().then((treatments) => {
        res.send(treatments);
    });
});

router.post('/saveTreatment', function (req, res, next) {
    let treatment = req.body;
    treamentsService.saveStudy(study);
    res.send(treatment);
});

module.exports = router;