import {Component, OnInit} from '@angular/core';
import {DomainRuleDAO} from '../model/DomainRuleDAO';
import {DomainRuleType} from '../model/DomainRuleType';
import {HttpRequestService} from '../services/http.service';
import {Medicine} from '../model/Medicine';
import {Study} from '../model/Study';
import {DomainRuleParamsDAO} from '../model/DomainRuleParamsDAO';
import {MessageService} from 'primeng/components/common/messageservice';

@Component({
  selector: 'app-domainrules',
  templateUrl: './domainrules.component.html',
  styleUrls: ['./domainrules.component.css']
})
export class DomainrulesComponent implements OnInit {

  private domainRule: DomainRuleDAO;
  private domainRuleTypes: DomainRuleType[] = [];

  domainRuleParams: DomainRuleParamsDAO[] = [];

  selectedType: DomainRuleType;

  selectedMedicine: Medicine = new Medicine();
  selectedStudy: Study = new Study();

  constructor(private httpService: HttpRequestService,
              private messageService: MessageService) {
  }

  ngOnInit(): void {
    this.domainRule = new DomainRuleDAO();
    this.getTypes();
  }

  getNewParams() {
    const body = this.selectedType;

    this.httpService.sendPostRequest('/domainrules/fetchEmptyDomainRuleParams', body,
      (res: DomainRuleParamsDAO[]) => {
        this.domainRuleParams = res;
      }, (res) => {
      });
  }

  getTypes() {
    const body = {};
    this.httpService.sendPostRequest('/domainrules/fetchDomainRuleTypes', body,
      (res: DomainRuleType[]) => {
        this.domainRuleTypes = res;
      }, (res) => {
      });
  }

  addSelectedMedicine($event: Medicine) {
    this.selectedMedicine = $event;
  }

  addSelectedStudy($event: Study) {
    this.selectedStudy = $event;
  }

  saveRule() {
    const body = new DomainRuleDAO();
    body.medicine = this.selectedMedicine;
    body.study = this.selectedStudy;
    body.domainRuleTypeDAO = this.selectedType;
    body.domainRuleParams = this.domainRuleParams;

    this.httpService.sendPostRequest('/domainrules/saveDomainRule', body,
      (res: DomainRuleType[]) => {
        this.messageService.add({severity: 'info', summary: 'Domain rule added'});
        this.selectedMedicine = new Medicine();
        this.selectedStudy = new Study();
        this.selectedType = new DomainRuleType();
        this.domainRuleParams = [];
      }, (res) => {
      });
  }

}
