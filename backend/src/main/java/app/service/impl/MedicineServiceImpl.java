package app.service.impl;

import app.model.Medicine;
import app.model.MedicineSearch;
import app.repository.MedicineRepository;
import app.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    private MedicineRepository medicineRepository;

    @Autowired
    public MedicineServiceImpl(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Override
    public Medicine saveMedicine(Medicine medicine) {
        return this.medicineRepository.save(medicine);
    }

    @Override
    public List<Medicine> searchMedicines(MedicineSearch medicineSearch) {

        return medicineRepository.findByNameIgnoreCaseContainingOrCodeIgnoreCaseContaining(
                medicineSearch.getSearchName(),
                medicineSearch.getSearchName());

    }
}
