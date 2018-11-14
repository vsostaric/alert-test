import {Medicine} from './Medicine';
import {Study} from './Study';
import {DomainRuleType} from './DomainRuleType';
import {DomainRuleParamsDAO} from './DomainRuleParamsDAO';

export class DomainRuleDAO {
  id: number;
  medicine: Medicine;
  study: Study;
  domainRuleTypeDAO: DomainRuleType;
  domainRuleParams: DomainRuleParamsDAO[];
}
