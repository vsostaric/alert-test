var express = require('express');
var router = express.Router();

var treamentsService = require('../services/treatments.service');

router.post('/checkForAlerts', function (req, res, next) {

    const treatment = req.body;
    res.send(treamentsService.checkForAlerts(treatment));

});

router.post('/findTreatments', function (req, res, next) {
    res.send(treamentsService.findTreatments())
});

router.post('/saveTreatment', function (req, res, next) {
    treatment = req.body;
    treatments = treamentsService.saveTreatment(treatment);
    res.send(treatments);
});

module.exports = router;