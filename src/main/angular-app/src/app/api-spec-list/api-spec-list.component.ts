import { Component, OnInit } from '@angular/core';

import { ApiSpec } from "../mock/api-spec";
import { ApiSpecService } from '../shared/api-spec.service';

@Component({
  selector: 'api-spec-list',
  templateUrl: './app-spec-list.component.html',
  styleUrls: ['./api-spec-list.component.css']
})
export class ApiSpecListComponent implements OnInit {
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
