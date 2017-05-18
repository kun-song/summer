import { Injectable } from '@angular/core';

import { ApiSpec } from '../mock/api-spec';
import { APISPECLIST } from '../mock/api-spec-mock';

@Injectable()
export class ApiSpecService {
  getApiSpecList(): Promise<ApiSpec[]> {
    return Promise.resolve(APISPECLIST);
  }

  getApiSpec(id: number) {
    return this.getApiSpecList()
                .then(list => list.find(apiSpec => apiSpec.id === id));
  }
}
