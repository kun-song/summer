import { Component, Input } from '@angular/core';

import { ApiSpec } from "../mock/api-spec";

@Component({
  selector: 'api-spec-list',
  template: `
    <h2>ApiSpec List</h2>
    <ul class = "apispec-list">
      <li *ngFor = "let apispec of apiSpecList"
          [class.selected] = "apispec === apiSpecSelected"
          (onclick) = "onSelect(apispec)">
        <span class = "badge">{{ apispec.title }}</span>
      </li>
    </ul>
  `,
  styles: [`
    .selected {
      background-color: #CFD8DC !important;
      color: white;
    }
    .apispec-list {
      margin: 0 0 2em 0;
      list-style-type: none;
      padding: 0;
      width: 15em;
    }
    .apispec-list li {
      cursor: pointer;
      position: relative;
      left: 0;
      background-color: #EEE;
      margin: .5em;
      padding: .3em 0;
      height: 1.6em;
      border-radius: 4px;
    }
    .apispec-list li.selected:hover {
      background-color: #BBD8DC !important;
      color: white;
    }
    .apispec-list li:hover {
      color: #607D8B;
      background-color: #DDD;
      left: .1em;
    }
    .apispec-list .text {
      position: relative;
      top: -3px;
    }
    .apispec-list .badge {
      display: inline-block;
      font-size: small;
      color: white;
      padding: 0.8em 0.7em 0 0.7em;
      background-color: #607D8B;
      line-height: 1em;
      position: relative;
      left: -1px;
      top: -4px;
      height: 1.8em;
      margin-right: .8em;
      border-radius: 4px 0 0 4px;
    }
  `]
})
export class ApiSpecListComponent {
  @Input() apiSpecList: ApiSpec[];
  @Input() apiSpecSelected: ApiSpec;
}
