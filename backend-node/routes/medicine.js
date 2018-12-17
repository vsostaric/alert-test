var express = require('express');
var router = express.Router();

function saveMedicine(medicine) {
    return medicine;
}

function searchMedicines(searchName) {
    return [{"id": 10, "code": "0002-0800", "name": "Amyvid"}, {
        "id": 13,
        "code": "0002-1433",
        "name": "TALTZ"
    }, {"id": 14, "code": "0002-1434", "name": "AXIRON"}, {"id": 15, "code": "0002-1445", "name": "Prozac"}, {
        "id": 16,
        "code": "0002-1975",
        "name": "Strattera"
    }, {"id": 17, "code": "0002-3004", "name": "Symbyax"}, {
        "id": 18,
        "code": "0002-3227",
        "name": "Cymbalta"
    }, {"id": 19, "code": "0002-3228", "name": "Zyprexa"}, {
        "id": 20,
        "code": "0002-3229",
        "name": "Olumiant"
    }, {"id": 21, "code": "0002-3230", "name": "Evista"}, {
        "id": 22,
        "code": "0002-3229",
        "name": "Olumiant"
    }, {"id": 23, "code": "0002-3230", "name": "Evista"}, {"id": 28, "code": "asdasd", "name": "sad"}];
}

router.post('/saveMedicine', function (req, res, next) {

    let medicine = req.body;
    medicine = saveMedicine();
    res.send(medicine);

});

router.post('/searchMedicines', function (req, res, next) {

    let searchName = req.body.searchName;
    medicines = searchMedicines(searchName);
    res.send(medicines);

});

module.exports = router;