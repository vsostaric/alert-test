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

module.exports = {
    saveStudy: saveStudy,
    searchStudies: searchStudies
}
