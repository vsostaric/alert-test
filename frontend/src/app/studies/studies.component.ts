import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Study} from '../model/Study';
import {HttpRequestService} from '../services/http.service';
import {MessageService} from 'primeng/components/common/messageservice';

@Component({
  selector: 'app-studies',
  templateUrl: './studies.component.html',
  styleUrls: ['./studies.component.css']
})
export class StudiesComponent implements OnInit {

  @Input() public searchable = true;

  @Input() public selectable = false;

  @Input() public saveable = true;

  @Output()
  addSelectedStudy = new EventEmitter();

  selectedStudy: Study;

  private studies: Study[] = [];
  private searchTitle: string;

  private displayAddNewStudy = false;
  private newStudyTitle: string;

  constructor(
    private httpService: HttpRequestService,
    private messageService: MessageService) {
  }

  ngOnInit(): void {
  }

  searchStudies() {

    const body = {
      'searchTitle': this.searchTitle,
    };

    this.httpService.sendPostRequest('/studies/searchStudies', body,
      (res: Study[]) => {
        this.studies = res;
      }, (res) => {
      });

  }

  openAddNewStudyDialog() {
    this.displayAddNewStudy = true;
  }

  saveNewStudy() {
    const body = {'title': this.newStudyTitle};

    this.httpService.sendPostRequest('/studies/saveStudy', body,
      (res: Study[]) => {
        this.messageService.add({severity: 'info', summary: 'Study added'});
        this.studies = res;
        this.displayAddNewStudy = false;
        this.newStudyTitle = '';
      }, (res) => {
      });

  }

  addStudy() {
    this.addSelectedStudy.emit(this.selectedStudy);
  }


}
