const getConnection = require('../util/db.mongo').getConnection;

function saveMedicine(medicine) {
    const conn = getConnection();
    conn.collection('medicines').insertOne(medicine).then(result => {
        console.log('Medicine inserted');
        return [];
    }).catch(err => {
        console.log(`Error : ${err}`);
    });
    return [];
}

function searchMedicines(searchName) {
    return new Promise(function (resolve, reject) {
        const conn = getConnection();
        conn.collection('medicines').find().toArray().then(result => {
            console.log(`Medicines found: ${result.length}`);
            resolve(result);
        }).catch(err => {
            console.log(`Error : ${err}`);
            reject();
        });
    });
}

module.exports = {
    saveMedicine: saveMedicine,
    searchMedicines: searchMedicines
};