import { Component, OnInit } from '@angular/core';

import { ApiSpec } from './mock/api-spec';
import { ApiSpecService } from './shared/api-spec.service';

@Component({
  selector: 'my-app',
  template: `
    <header [title] = appTitle></header>
    <h2>ApiSpec List</h2>
    <ul class = "apispec-list">
      <li *ngFor = "let apispec of apiSpecList"
          [class.selected] = "apispec === apiSpecSelected"
          (click) = "onSelect(apispec)">
        <span class = "badge">{{ apispec.id }}</span> {{ apispec.title }}
      </li>
    </ul>

    <api-spec-detail [apiSpec] = "apiSpecSelected"></api-spec-detail>
  `,
  styleUrls: ['./app.component.css'],
  providers: [ ApiSpecService ]
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
