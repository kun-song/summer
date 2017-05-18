import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import 'rxjs/add/operator/switchMap';

import { ApiSpec } from "../mock/api-spec";
import { ApiSpecService } from '../shared/api-spec.service';

@Component({
  selector: 'api-spec-detail',
  templateUrl: './api-spec-detail.component.html',
  styleUrls: [ './api-spec-detail.component.css' ]
})
export class ApiSpecDetailComponent implements OnInit {
  apiSpec: ApiSpec;

  constructor(
    private apiSpecService: ApiSpecService,
    private route: ActivatedRoute,
    private location: Location
  ) {}

  ngOnInit(): void {
    this.route.params
        .switchMap((params: Params) => this.apiSpecService.getApiSpec(+params['id']))
        .subscribe(apiSpec => this.apiSpec = apiSpec);
  }

  goBack(): void {
    this.location.back();
  }
}
