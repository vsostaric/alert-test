package app.model.rule.type;

import app.model.Alert;
import app.model.Medicine;
import app.model.Treatment;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ToxicityPossible extends AbstractDomainRule {

    private Medicine medicineCausingToxicity;
    private BigDecimal toxicity;

    @Override
    public Alert check(Treatment treatment) {

        Alert alert = null;
        if(treatment.getMedicines().contains(medicineCausingToxicity)) {
            StringBuilder description = new StringBuilder();
            description.append("Medicine ");
            description.append(this.getMedicineAffected().getName());
            description.append(" is toxic when combined with ");
            description.append(this.medicineCausingToxicity.getName());
            description.append("; toxicity ");
            description.append(this.toxicity);
            description.append("%");

            alert = new Alert(description.toString());

        }

        return alert;
    }
}
