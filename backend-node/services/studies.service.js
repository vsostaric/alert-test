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
    const conn = getConnection();
    conn.collection('studies').find().toArray().then(result => {
        console.log(result);
        return result;
    }).catch(err => {
        console.log(`Error : ${err}`);
    });

}

module.exports = {
    saveStudy: saveStudy,
    searchStudies: searchStudies
}
