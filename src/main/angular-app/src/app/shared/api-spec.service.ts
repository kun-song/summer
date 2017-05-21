import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { ApiSpec } from '../mock/api-spec';
import { APISPECLIST } from '../mock/api-spec-mock';

@Injectable()
export class ApiSpecService {

  private apiSpecListUrl = 'http://127.0.0.1:8080/rest/api/spec';

  constructor(private http: Http) {}


  getApiSpecList(): Promise<ApiSpec[]> {
    return this.http.get(this.apiSpecListUrl)
                .toPromise()
                .then(response => response.json().data as ApiSpec[])
                .catch(this.errorHandler);
  }

  getApiSpec(id: number) {
    const url = `${this.apiSpecListUrl}/${id}`;
    return this.http.get(url)
                .toPromise()
                .then(response => response.json().data as ApiSpec)
                .catch(this.errorHandler);
  }

  // 内部异常处理
  private errorHandler(error: any): Promise<any> {
    console.log('An error occured: ', error);
    return Promise.reject(error.message || error);
  }
}
