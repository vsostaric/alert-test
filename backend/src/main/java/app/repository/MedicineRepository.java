package app.repository;

import app.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {

    List<Medicine> findByNameOrCode(String name, String code);

    List<Medicine> findByNameIgnoreCaseContainingOrCodeIgnoreCaseContaining(String name, String code);

}
