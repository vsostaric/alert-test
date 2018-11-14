package app.service;

import app.model.Medicine;
import app.model.MedicineSearch;

import java.util.List;

public interface MedicineService {

    Medicine saveMedicine(Medicine medicine);

    List<Medicine> searchMedicines(MedicineSearch medicineSearch);

}
