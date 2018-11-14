package app.repository;

import app.model.Medicine;
import app.model.Treatment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TreatmentRepositoryTest {

    private TreatmentRepository treatmentRepository;

    private MedicineRepository medicineRepository;

    private Iterable<Treatment> treatments;

    @Autowired
    public void setTreatmentRepository(
            TreatmentRepository treatmentRepository,
            MedicineRepository medicineRepository) {
        this.treatmentRepository = treatmentRepository;
        this.medicineRepository = medicineRepository;
    }

    @Before
    public void before() {
        treatments = treatmentRepository.findAll();
    }

    @Test
    public void testReadAll() {
        assertThat(treatments).isNotEmpty();
    }

    @Test
    public void testCreate() {

        assertThat(treatments).isNotEmpty();

        final Treatment treatment = new Treatment();
        treatment.setName("treat 3 II z54");

        List<Medicine> medicinesFromDB = medicineRepository.findAll();
        Set<Medicine> medicines = new HashSet<>();
        medicines.add(medicinesFromDB.get(0));
        medicines.add(medicinesFromDB.get(1));
        medicines.add(medicinesFromDB.get(2));

        treatment.setMedicines(medicines);

        Treatment persisted = treatmentRepository.save(treatment);
        assertThat(persisted.getId()).isNotNull();

        final Long id = persisted.getId();
        persisted = treatmentRepository.findById(id).orElse(null);
        assertThat(persisted).isNotNull();
        assertThat(persisted.getMedicines()).isNotEmpty();

        treatmentRepository.deleteById(id);

    }

    @Test
    public void testUpdate() {

        Treatment treatment = treatments.iterator().next();

        final Long id = treatment.getId();

        final String newUpdatedName = "Bad Treatment - Can Kill You";
        treatment.setName(newUpdatedName);

        treatmentRepository.save(treatment);

        treatment = treatmentRepository.findById(id).orElse(null);

        assertThat(treatment).isNotNull();
        assertThat(treatment.getName()).isEqualTo(newUpdatedName);

    }

    @Test
    public void testDelete() {

        Treatment treatment = treatments.iterator().next();

        final Long id = treatment.getId();

        assertThat(treatmentRepository.findById(id).orElse(null)).isNotNull();
        treatmentRepository.deleteById(id);
        assertThat(treatmentRepository.findById(id).orElse(null)).isNull();

    }

}
