import { Component } from '@angular/core';

import { ApiSpec } from './mock/api-spec'

const APISPECLIST: ApiSpec[] = [
  {id: 1, title: 'eService'},
  {id: 2, title: 'eSight'},
  {id: 3, title: 'eCloud'}
]

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
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  appTitle = 'Elastic API Manager';
  apiSpecList = APISPECLIST;

  apiSpecSelected: ApiSpec;

  onSelect(apispec: ApiSpec): void {
    this.apiSpecSelected = apispec;
  }
}
