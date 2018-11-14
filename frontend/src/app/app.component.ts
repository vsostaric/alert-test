import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {MenuItem} from 'primeng/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class AppComponent implements OnInit {

  public routerItems: MenuItem[];

  ngOnInit(): void {

    this.routerItems = [];
    this.routerItems.push({
      label: 'Treatments',
      routerLink: ['/treatments']
    });
    this.routerItems.push({
      label: 'Medicines',
      routerLink: ['/medicines']
    });
    this.routerItems.push({
      label: 'Studies',
      routerLink: ['/studies']
    });
    this.routerItems.push({
      label: 'Domain rules list',
      routerLink: ['/domainRulesList']
    });
    this.routerItems.push({
      label: 'Domain rules',
      routerLink: ['/domainRules']
    });
  }
}
