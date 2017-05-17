import { Injectable } from '@angular/core';

import { ApiSpec } from '../mock/api-spec';
import { APISPECLIST } from '../mock/api-spec-mock';

@Injectable()
export class ApiSpecService {
  getApiSpecList(): Promise<ApiSpec[]> {
    return Promise.resolve(APISPECLIST);
  }
}
