package app.controller;

import app.model.Medicine;
import app.model.MedicineSearch;
import app.model.rule.dao.Study;
import app.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    private MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping(value = "/saveMedicine",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Study>> saveMedicine(@RequestBody Medicine medicine) {
        medicineService.saveMedicine(medicine);
        return ResponseEntity.ok(new ArrayList<>());
    }

    @PostMapping(value = "/searchMedicines",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Medicine>> searchMedicines(@RequestBody MedicineSearch medicineSearch) {
        return ResponseEntity.ok(medicineService.searchMedicines(medicineSearch));
    }

}
