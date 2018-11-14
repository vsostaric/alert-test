package app.repository.rule;

import app.model.Medicine;
import app.model.rule.dao.Study;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudyRepositoryTest {

    private StudyRepository studyRepository;

    @Autowired
    public void setStudyRepository(
            StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }

    @Test
    public void testCreate() {

        final Study study = new Study();
        study.setTitle("New Study Title");

        Study persisted = studyRepository.save(study);
        assertThat(persisted.getId()).isNotNull();

        final Long id = persisted.getId();
        persisted = studyRepository.findById(id).orElse(null);
        assertThat(persisted).isNotNull();

        studyRepository.deleteById(id);

    }

    @Test
    public void testUpdate() {

        Study study = new Study();
        study.setTitle("New Funny Title");

        Study persisted = studyRepository.save(study);
        final Long id = persisted.getId();

        final String newUpdatedName = "New Cure Name";
        persisted.setTitle(newUpdatedName);
        persisted = studyRepository.save(study);

        persisted = studyRepository.findById(id).orElse(null);

        assertThat(persisted).isNotNull();
        assertThat(persisted.getTitle()).isEqualTo(newUpdatedName);

        studyRepository.deleteById(id);

    }

    @Test
    public void testDelete() {

        Study study = new Study();
        study.setTitle("New Funny Title");

        Study persisted = studyRepository.save(study);
        final Long id = persisted.getId();

        assertThat(studyRepository.findById(id).orElse(null)).isNotNull();
        studyRepository.deleteById(id);
        assertThat(studyRepository.findById(id).orElse(null)).isNull();

    }

}
