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
public class MedicineRepositoryTest {

    private MedicineRepository medicineRepository;

    private Iterable<Medicine> medicines;

    @Autowired
    public void setMedicineRepository(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Before
    public void before() {
        medicines = medicineRepository.findAll();
    }

    @Test
    public void testReadAll() {
        assertThat(medicines).isNotEmpty();
    }

    @Test
    public void testCreate() {

        assertThat(medicines).isNotEmpty();

        final Medicine medicine = new Medicine();
        medicine.setCode("AA-22");
        medicine.setName("Funnyvill");

        Medicine persisted = medicineRepository.save(medicine);
        assertThat(persisted.getId()).isNotNull();

        final Long id = persisted.getId();
        persisted = medicineRepository.findById(id).orElse(null);
        assertThat(persisted).isNotNull();
        assertThat(persisted.getId()).isNotNull();

        medicineRepository.deleteById(id);

    }

    @Test
    public void testUpdate() {

        Medicine medicine = medicines.iterator().next();

        final Long id = medicine.getId();
        final String name = medicine.getName();

        final String newUpdatedName = "New Cure Name";
        medicine.setName(newUpdatedName);

        medicineRepository.save(medicine);

        medicine = medicineRepository.findById(id).orElse(null);

        assertThat(medicine).isNotNull();
        assertThat(medicine.getName()).isEqualTo(newUpdatedName);

    }

    @Test
    public void testDelete() {

        Medicine medicine = medicines.iterator().next();

        final Long id = medicine.getId();

        assertThat(medicineRepository.findById(id).orElse(null)).isNotNull();
        medicineRepository.deleteById(id);
        assertThat(medicineRepository.findById(id).orElse(null)).isNull();

    }

}
