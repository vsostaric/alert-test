package app.repository.rule;

import app.model.Medicine;
import app.model.rule.dao.Study;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyRepository extends JpaRepository<Study, Long> {

    List<Study> findByTitleIgnoreCaseContaining(String title);

}
