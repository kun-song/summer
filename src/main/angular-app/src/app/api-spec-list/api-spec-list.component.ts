import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

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

  constructor(
    private apiSpecService: ApiSpecService,
    private router: Router
  ) { }

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

  // 使用 Router.navigate 实现命令式导航
  gotoDetail():void {
    // 数据内容：（1）路径 （2）路由参数
    this.router.navigate(['/api/spec', this.apiSpecSelected.id]);
  }
}
