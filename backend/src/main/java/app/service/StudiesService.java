package app.service;

import app.model.StudySearch;
import app.model.rule.dao.Study;

import java.util.List;

public interface StudiesService {

    Study saveStudy(Study study);

    List<Study> searchStudies(StudySearch studySearch);

}
