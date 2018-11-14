import {Component, OnInit} from '@angular/core';
import {DomainRuleDAO} from '../model/DomainRuleDAO';
import {HttpRequestService} from '../services/http.service';

@Component({
  selector: 'app-domainrules-list',
  templateUrl: './domainrules_list.component.html',
  styleUrls: ['./domainrules_list.component.css']
})
export class DomainRulesListComponent implements OnInit {

  private domainRules: DomainRuleDAO[] = [];

  constructor(private httpService: HttpRequestService) {
  }

  ngOnInit(): void {
    this.fetchDomainRules();
  }

  fetchDomainRules() {

    this.httpService.sendPostRequest('/domainrules/fetchDomainRules', {},
      (res: DomainRuleDAO[]) => {
        this.domainRules = res;
      }, (res) => {
      });


  }


}
