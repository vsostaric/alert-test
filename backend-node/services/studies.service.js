const getConnection = require('../util/db.mongo').getConnection;

function saveStudy(study) {
    const conn = getConnection();
    conn.collection('studies').insertOne(study).then(result => {
        console.log('Study inserted');
        return [];
    }).catch(err => {
        console.log(`Error : ${err}`);
    });
    return {};
}

function searchStudies(searchTitle) {
    return new Promise(function (resolve, reject) {
        const conn = getConnection();
        conn.collection('studies').find().toArray().then(result => {
            console.log(`Studies found: ${result.length}`);
            resolve(result);
        }).catch(err => {
            console.log(`Error : ${err}`);
            reject();
        });
    });
}

module.exports = {
    saveStudy: saveStudy,
    searchStudies: searchStudies
};
