package app.repository.rule;

import app.model.Medicine;
import app.model.rule.dao.DomainRuleDAO;
import app.model.rule.dao.DomainRuleParams;
import app.model.rule.dao.DomainRuleTypeDAO;
import app.model.rule.dao.Study;
import app.repository.MedicineRepository;
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
public class DomainRuleRepositoryTest {

    private DomainRuleRepository domainRuleRepository;
    private StudyRepository studyRepository;
    private DomainRuleTypeRepository domainRuleTypeRepository;
    private MedicineRepository medicineRepository;

    @Autowired
    public void setDomainRuleRepository(
            DomainRuleRepository domainRuleRepository,
            StudyRepository studyRepository,
            DomainRuleTypeRepository domainRuleTypeRepository,
            MedicineRepository medicineRepository) {
        this.domainRuleRepository = domainRuleRepository;
        this.studyRepository = studyRepository;
        this.domainRuleTypeRepository = domainRuleTypeRepository;
        this.medicineRepository = medicineRepository;
    }

    @Test
    public void testCreate() {

        final DomainRuleDAO domainRuleDAO = new DomainRuleDAO();

        DomainRuleDAO persisted = domainRuleRepository.save(domainRuleDAO);
        assertThat(persisted.getId()).isNotNull();

        final Long id = persisted.getId();
        persisted = domainRuleRepository.findById(id).orElse(null);
        assertThat(persisted).isNotNull();

        domainRuleRepository.deleteById(id);

    }

    @Test
    public void testCreateWithStudy() {

        final Study study = new Study();
        study.setTitle("Study on this Cure doing that: 27888 pgA");
        final Study persistedStudy = studyRepository.save(study);

        final DomainRuleDAO domainRuleDAO = new DomainRuleDAO();
        domainRuleDAO.setStudy(persistedStudy);
        DomainRuleDAO persisted = domainRuleRepository.save(domainRuleDAO);
        assertThat(persisted.getId()).isNotNull();

        final Long id = persisted.getId();
        persisted = domainRuleRepository.findById(id).orElse(null);
        assertThat(persisted).isNotNull();
        assertThat(persisted.getStudy()).isNotNull();

        domainRuleRepository.deleteById(id);

    }

    @Test
    public void testCreateWithDomainRuleType() {

        final DomainRuleTypeDAO persistedType = domainRuleTypeRepository.findAll().get(0);

        final DomainRuleDAO domainRuleDAO = new DomainRuleDAO();
        domainRuleDAO.setDomainRuleTypeDAO(persistedType);
        DomainRuleDAO persisted = domainRuleRepository.save(domainRuleDAO);
        assertThat(persisted.getId()).isNotNull();

        final Long id = persisted.getId();
        persisted = domainRuleRepository.findById(id).orElse(null);
        assertThat(persisted).isNotNull();
        assertThat(persisted.getDomainRuleTypeDAO()).isNotNull();

        domainRuleRepository.deleteById(id);

    }

    @Test
    public void testCreateWithDomainRuleParams() {

        final DomainRuleParams param1 = new DomainRuleParams();
        param1.setKey("cure1");
        param1.setValue("Paracetamol");

        final DomainRuleParams param2 = new DomainRuleParams();
        param2.setKey("cure2");
        param2.setValue("Ibuprofen");

        Set<DomainRuleParams> params = new HashSet<>();
        params.add(param1);
        params.add(param2);

        final DomainRuleDAO domainRuleDAO = new DomainRuleDAO();
        domainRuleDAO.setDomainRuleParams(params);

        DomainRuleDAO persisted = domainRuleRepository.save(domainRuleDAO);
        assertThat(persisted.getId()).isNotNull();

        final Long id = persisted.getId();
        persisted = domainRuleRepository.findById(id).orElse(null);
        assertThat(persisted).isNotNull();
        assertThat(persisted.getDomainRuleParams()).isNotEmpty();

        domainRuleRepository.deleteById(id);

    }

    @Test
    public void testCreateWithMedicineId() {

        final DomainRuleDAO domainRuleDAO = new DomainRuleDAO();
        Medicine medicine = medicineRepository.findAll().get(0);
        domainRuleDAO.setMedicine(medicine);

        DomainRuleDAO persisted = domainRuleRepository.save(domainRuleDAO);
        assertThat(persisted.getId()).isNotNull();

        final Long id = persisted.getId();
        persisted = domainRuleRepository.findById(id).orElse(null);
        assertThat(persisted).isNotNull();
        assertThat(persisted.getMedicine()).isNotNull();

        domainRuleRepository.deleteById(id);

    }

    @Test
    public void testFindAllByMedicine() {

        Medicine medicine = medicineRepository.findAll().get(0);

        final DomainRuleDAO domainRuleDAO1 = new DomainRuleDAO();
        final DomainRuleDAO domainRuleDAO2 = new DomainRuleDAO();
        final DomainRuleDAO domainRuleDAO3 = new DomainRuleDAO();
        domainRuleDAO1.setMedicine(medicine);
        domainRuleDAO2.setMedicine(medicine);
        domainRuleDAO3.setMedicine(medicine);

        DomainRuleDAO persisted1 = domainRuleRepository.save(domainRuleDAO1);
        DomainRuleDAO persisted2 = domainRuleRepository.save(domainRuleDAO2);
        DomainRuleDAO persisted3 = domainRuleRepository.save(domainRuleDAO3);

        final Long id1 = persisted1.getId();
        final Long id2 = persisted2.getId();
        final Long id3 = persisted3.getId();
        Set<Long> ids = new HashSet<>();
        ids.add(id1);
        ids.add(id2);
        ids.add(id3);

        List<DomainRuleDAO> persisted = domainRuleRepository.findAllByMedicine(medicine);
        assertThat(persisted).isNotNull();
        assertThat(persisted.size()).isGreaterThanOrEqualTo(3);

        persisted.forEach(domainRuleDAO ->
                assertThat(ids.contains(domainRuleDAO.getId())).isTrue());

    }

    @Test
    public void testFindAllByMedicines() {

        Medicine medicine1 = medicineRepository.findAll().get(0);
        Medicine medicine2 = medicineRepository.findAll().get(1);

        final DomainRuleDAO domainRuleDAO1 = new DomainRuleDAO();
        final DomainRuleDAO domainRuleDAO2 = new DomainRuleDAO();
        final DomainRuleDAO domainRuleDAO3 = new DomainRuleDAO();
        domainRuleDAO1.setMedicine(medicine1);
        domainRuleDAO2.setMedicine(medicine1);
        domainRuleDAO3.setMedicine(medicine2);

        DomainRuleDAO persisted1 = domainRuleRepository.save(domainRuleDAO1);
        DomainRuleDAO persisted2 = domainRuleRepository.save(domainRuleDAO2);
        DomainRuleDAO persisted3 = domainRuleRepository.save(domainRuleDAO3);

        final Long id1 = persisted1.getId();
        final Long id2 = persisted2.getId();
        final Long id3 = persisted3.getId();
        Set<Long> ids = new HashSet<>();
        ids.add(id1);
        ids.add(id2);
        ids.add(id3);

        Set<Medicine> medicines = new HashSet<>();
        medicines.add(medicine1);
        medicines.add(medicine2);

        Set<DomainRuleDAO> persisted = domainRuleRepository.findAllByMedicineIn(medicines);
        assertThat(persisted).isNotNull();
        assertThat(persisted.size()).isGreaterThanOrEqualTo(3);

        persisted.forEach(domainRuleDAO ->
                assertThat(ids.contains(domainRuleDAO.getId())).isTrue());

    }

}
