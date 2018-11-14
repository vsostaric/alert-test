package app.controller;

import app.model.Alert;
import app.model.Treatment;
import app.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/treatments")
public class TreatmentController {

    private TreatmentService treatmentService;

    @Autowired
    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @PostMapping(value = "/findTreatments",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Treatment>> findTreatments() {
        return ResponseEntity.ok(treatmentService.findTreatments());
    }

    @PostMapping(value = "/saveTreatment",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Treatment>> saveTreatment(@RequestBody Treatment treatment) {
        treatmentService.saveTreatment(treatment);
        return ResponseEntity.ok(treatmentService.findTreatments());
    }

    @PostMapping(value = "/checkForAlerts",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Alert>> checkForAlerts(@RequestBody Treatment treatment) {
        return ResponseEntity.ok(treatmentService.checkForAlerts(treatment));
    }

}
