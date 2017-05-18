import { Component, Input } from '@angular/core';

import { ApiSpec } from "../mock/api-spec";

@Component({
  selector: 'api-spec-detail',
  templateUrl: './api-spec-detail.component.html', 
})
export class ApiSpecDetailComponent {
  @Input() apiSpec: ApiSpec;
}
