const getConnection = require('../util/db.mongo').getConnection;

function checkForAlerts(treatment) {
    return [];
}

function findTreatments() {
    return new Promise(function (resolve, reject) {
        const conn = getConnection();
        conn.collection('treatments').find().toArray().then(result => {
            console.log(`Treatments found: ${result.length}`);
            resolve(result);
        }).catch(err => {
            console.log(`Error : ${err}`);
            reject();
        });
    });
}

function saveTreatment(treatment) {
    const conn = getConnection();
    conn.collection('treatments').insertOne(study).then(result => {
        console.log('Treatment inserted');
        return [];
    }).catch(err => {
        console.log(`Error : ${err}`);
    });
    return [];
}

module.exports = {
    checkForAlerts: checkForAlerts,
    findTreatments: findTreatments,
    saveTreatment: saveTreatment
}