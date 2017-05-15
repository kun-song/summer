import { Component, Input } from '@angular/core';

import { ApiSpec } from "../mock/api-spec";

@Component({
  selector: 'api-spec-detail',
  template: `
    <div *ngIf = "apiSpec">
      <h2>{{ apiSpec.id }} details!</h2>
      <div><label>id: </label>{{ apiSpec.id }}</div>
      <div>
        <label>title: </label>
        <input [(ngModel)] = "apiSpec.title" placeholder="title"/>
      </div>
    </div>
  `
})
export class ApiSpecDetailComponent {
  @Input() apiSpec: ApiSpec;
}
