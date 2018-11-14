import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {HttpRequestService} from '../services/http.service';
import {Medicine} from '../model/Medicine';
import {MessageService} from 'primeng/components/common/messageservice';

@Component({
  selector: 'app-medicines',
  templateUrl: './medicines.component.html',
  styleUrls: ['./medicines.component.css']
})
export class MedicinesComponent implements OnInit {

  @Input() public searchable = true;

  @Input() public selectable = true;

  @Input() public selectionMode = 'multiple';

  @Input() public saveable = true;

  @Input()
  private medicines: Medicine[] = [];

  @Output()
  addSelectedMedicines = new EventEmitter();

  searchName: string;
  selectedMedicines: Medicine[];

  newMedicine: Medicine = new Medicine();
  displayAddNewMedicine = false;

  constructor(
    private httpService: HttpRequestService,
    private messageService: MessageService) {
  }

  ngOnInit(): void {
  }

  searchMedicine() {

    if (!this.searchable) {
      return;
    }

    const body = {
      'searchName': this.searchName,
    };

    this.httpService.sendPostRequest('/medicine/searchMedicines', body,
      (res: Medicine[]) => {
        this.medicines = res;
        this.selectedMedicines = [];
      }, (res) => {
      });

  }

  addMedicines() {
    this.addSelectedMedicines.emit(this.selectedMedicines);
  }

  saveNewMedicine() {

    if (!this.saveable) {
      return;
    }

    this.httpService.sendPostRequest('/medicine/saveMedicine', this.newMedicine,
      (res: Medicine[]) => {
        this.messageService.add({severity: 'info', summary: 'Medicine added'});
        this.medicines = res;
        this.displayAddNewMedicine = false;
        this.newMedicine = new Medicine();
      }, (res) => {
      });

  }

  openAddNewMedicineDialog() {
    this.displayAddNewMedicine = true;
  }
}
