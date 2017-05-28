import { Component } from '@angular/core';

import { ApiSpec } from './mock/api-spec';
import { ApiSpecService } from './shared/api-spec.service';

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: [
    './app.component.css',
    '../../node_modules/primeng/resources/themes/omega/theme.css',
    '../../node_modules/primeng/resources/primeng.min.css',
    '../../node_modules/font-awesome/css/font-awesome.css'
  ]
})
export class AppComponent {
  appTitle = 'Elastic API Manager';
}
