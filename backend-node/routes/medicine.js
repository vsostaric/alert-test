var express = require('express');
var router = express.Router();

var medicineService = require('../services/medicines.service');

router.post('/saveMedicine', function (req, res, next) {

    let medicine = req.body;
    medicineService.saveMedicine(medicine);
    res.send(medicine);

});

router.post('/searchMedicines', function (req, res, next) {

    let searchName = req.body.searchName;
    medicineService.searchMedicines(searchName).then((medicines) => {
        res.send(medicines);
    });
});

module.exports = router;