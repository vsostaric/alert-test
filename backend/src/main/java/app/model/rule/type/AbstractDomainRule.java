package app.model.rule.type;

import app.model.Medicine;
import app.model.rule.DomainRule;
import lombok.Data;

@Data
public abstract class AbstractDomainRule implements DomainRule {

    protected Medicine medicineAffected;

}
