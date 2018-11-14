package app.service;

import app.model.Alert;
import app.model.Treatment;

import java.util.List;

public interface TreatmentService {

    Treatment saveTreatment(Treatment treatment);

    List<Treatment> findTreatments();

    List<Alert> checkForAlerts(Treatment treatment);

}
