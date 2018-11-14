import {Component, OnInit} from '@angular/core';
import {Treatment} from '../model/Treatment';
import {HttpRequestService} from '../services/http.service';
import {Alert} from '../model/Alert';

@Component({
  selector: 'app-treatments',
  templateUrl: './treatments.component.html',
  styleUrls: ['./treatments.component.css']
})
export class TreatmentsComponent implements OnInit {

  private treatments: Treatment[] = [];
  private cols: any[];
  private displayAddNewTreatment = false;

  constructor(private httpService: HttpRequestService) {
  }

  ngOnInit(): void {
    this.cols = [
      {field: 'id', header: 'Id'},
      {field: 'name', header: 'Name'},
    ];

    this.findTreatments();
  }

  findTreatments() {

    const body = {};

    this.httpService.sendPostRequest('/treatments/findTreatments', body,
      (res: Treatment[]) => {
        this.treatments = res;
      }, (res) => {
      });

  }

  openAddNewTreatmentDialog() {
    this.displayAddNewTreatment = true;
  }

  handleTreatmentAdded($event: any) {
    this.treatments = $event;
    this.displayAddNewTreatment = false;
  }

  checkAlerts(rowData) {
    const body = rowData;

    this.httpService.sendPostRequest('/treatments/checkForAlerts', body,
      (res: Alert[]) => {
        rowData.alerts = [];
        rowData.alerts = res;
      }, (res) => {
      });

  }
}
