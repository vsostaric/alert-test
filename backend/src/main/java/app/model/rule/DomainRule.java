package app.model.rule;

import app.model.Alert;
import app.model.Treatment;

@FunctionalInterface
public interface DomainRule {

    Alert check(Treatment treatment);

}
