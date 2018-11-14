import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {HttpRequestService} from '../services/http.service';
import {Medicine} from '../model/Medicine';
import {Treatment} from '../model/Treatment';
import {MessageService} from 'primeng/components/common/messageservice';

@Component({
  selector: 'app-newtreatment',
  templateUrl: './newtreatment.component.html',
  styleUrls: ['./newtreatment.component.css']
})
export class NewtreatmentComponent implements OnInit {

  @Output()
  treatmentAdded = new EventEmitter();

  private newTreatment = new Treatment();
  private newMedicines: Medicine[] = [];

  constructor(private httpService: HttpRequestService,
              private messageService: MessageService) {
  }

  ngOnInit(): void {
  }

  addSelected($event: Medicine[]) {
    $event.forEach((medicine) => {
      this.newMedicines.push(medicine);
    });
  }

  saveNewTreatment() {
    this.newTreatment.medicines = this.newMedicines;
    const body = this.newTreatment;

    this.httpService.sendPostRequest('/treatments/saveTreatment', body,
      (res: Treatment[]) => {
        this.messageService.add({severity: 'info', summary: 'Treatment added'});
        this.newTreatment = new Treatment();
        this.treatmentAdded.emit(res);
      }, (res) => {
      });


  }
}
