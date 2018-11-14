import {Medicine} from './Medicine';
import {Alert} from './Alert';

export class Treatment {
  id: number;
  name: string;
  medicines: Medicine[] = [];
  alerts: Alert[] = [];
}
