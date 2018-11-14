package app.service;

import app.model.Alert;
import app.model.Treatment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TreatmentServiceImplTest {

    private TreatmentService treatmentService;

    @Autowired
    public void setTreatmentService(
            TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @Test
    public void testCheckForAlerts() {

        Treatment treatment =
                treatmentService
                        .findTreatments().get(1);

        List<Alert> alerts = treatmentService.checkForAlerts(treatment);
        assertThat(alerts).isNotEmpty();

    }

}
