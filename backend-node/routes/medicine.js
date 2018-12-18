var express = require('express');
var router = express.Router();

var medicineService = require('../services/medicines.service');

router.post('/saveMedicine', function (req, res, next) {

    let medicine = req.body;
    medicine = medicineService.saveMedicine();
    res.send(medicine);

});

router.post('/searchMedicines', function (req, res, next) {

    let searchName = req.body.searchName;
    medicines = medicineService.searchMedicines(searchName);
    res.send(medicines);

});

module.exports = router;