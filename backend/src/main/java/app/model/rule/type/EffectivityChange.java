package app.model.rule.type;

import app.model.Alert;
import app.model.Medicine;
import app.model.Treatment;
import app.model.rule.DomainRule;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class EffectivityChange extends AbstractDomainRule {

    private Medicine medicineCausingChange;
    private boolean isDiminish;
    private BigDecimal amountOfChange;

    @Override
    public Alert check(Treatment treatment) {

        Alert alert = null;
        if(treatment.getMedicines().contains(medicineCausingChange)) {
            StringBuilder description = new StringBuilder();
            description.append("Medicine ");
            description.append(this.getMedicineAffected().getName());
            description.append(" affected by ");
            description.append(this.getMedicineCausingChange().getName());
            description.append(this.isDiminish ? "; effect diminished by " : "; effect increased by ");
            description.append(this.amountOfChange);
            description.append("%");

            alert = new Alert(description.toString());

        }

        return alert;
    }

}
