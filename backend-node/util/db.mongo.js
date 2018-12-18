const mongodb = require('mongodb');
const MongoClient = mongodb.MongoClient;

let _dbConn;

const mongoConnect = (callback) => {
    MongoClient.connect('mongodb://127.0.0.1:27017').then((res) => {
        console.log(`Connected!`);
        _dbConn = res.db();
        callback(res);
    }).catch(err => {
        console.log(`Error connecting! ${err}`);
    })
};

const getConnection = () => {
    if (_dbConn) {
        return _dbConn;
    }
    throw 'Connection not made';
}

module.exports.mongoConnect = mongoConnect;
module.exports.getConnection = getConnection;