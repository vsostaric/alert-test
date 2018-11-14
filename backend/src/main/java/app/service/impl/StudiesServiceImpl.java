package app.service.impl;

import app.model.StudySearch;
import app.model.rule.dao.Study;
import app.repository.rule.StudyRepository;
import app.service.StudiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudiesServiceImpl implements StudiesService {

    private StudyRepository studyRepository;

    @Autowired
    public StudiesServiceImpl(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }

    @Override
    public Study saveStudy(Study study) {
        return this.studyRepository.save(study);
    }

    @Override
    public List<Study> searchStudies(StudySearch studySearch) {
        return studyRepository
                .findByTitleIgnoreCaseContaining(studySearch.getSearchTitle());
    }
}
