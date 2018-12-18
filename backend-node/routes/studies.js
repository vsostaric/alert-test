var express = require('express');
var router = express.Router();

var studiesService = require('../services/studies.service')

router.post('/saveStudy', function (req, res, next) {

    let study = req.body;
    study = studiesService.saveStudy(study);
    res.send(study);

});

router.post('/searchStudies', function (req, res, next) {

    let searchTitle = req.body.searchTitle;
    studies = studiesService.searchStudies(searchTitle);
    res.send(studies);

});

module.exports = router;