import {Component, Input, OnInit} from '@angular/core';
import {Alert} from '../model/Alert';

@Component({
  selector: 'app-alerts',
  templateUrl: './alerts.component.html',
  styleUrls: ['./alerts.component.css']
})
export class AlertsComponent implements OnInit {

  @Input() private alerts: Alert[] = [];

  constructor() {
  }

  ngOnInit(): void {
  }

}
