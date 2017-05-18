import { Component, OnInit } from '@angular/core';

import { ApiSpec } from '../mock/api-spec';

import { ApiSpecService } from '../shared/api-spec.service';

@Component({
  selector: 'dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: [ './dashboard.component.css' ]
})
export class DashboardComponent implements OnInit {
  apiSpecList: ApiSpec[] = [];

  constructor(private apiSpecService: ApiSpecService) {}

  ngOnInit(): void {
    this.apiSpecService.getApiSpecList()
        .then(list => this.apiSpecList = list.slice(0, 4));
  }
}
