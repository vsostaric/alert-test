var express = require('express');
var router = express.Router();

function saveStudy(study) {
    return study;
}

function searchStudies(searchTitle) {
    return [
        {
            "id": 10,
            "title": "ISBN: 2331 Dream within a Dream"
        }
    ];
}

router.post('/saveStudy', function (req, res, next) {

    let study = req.body;
    study = saveStudy();
    res.send(study);

});

router.post('/searchStudies', function (req, res, next) {

    let searchTitle = req.body.searchTitle;
    studies = searchStudies(searchTitle);
    res.send(studies);

});

module.exports = router;