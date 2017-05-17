import { Component, OnInit } from '@angular/core';

import { ApiSpec } from './mock/api-spec';
import { ApiSpecService } from './shared/api-spec.service';

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  appTitle = 'Elastic API Manager';
  apiSpecList: ApiSpec[];
  apiSpecSelected: ApiSpec;

  constructor(private apiSpecService: ApiSpecService) { }

  getApiSpecList(): void {
    this.apiSpecService.getApiSpecList()
        .then(list => this.apiSpecList = list);
  }

  ngOnInit(): void {
    this.getApiSpecList();
  }

  onSelect(apispec: ApiSpec): void {
    this.apiSpecSelected = apispec;
  }
}
