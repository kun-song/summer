import { Component, OnInit } from '@angular/core';

import { ApiSpec } from './mock/api-spec';
import { ApiSpecService } from './shared/api-spec.service';

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  appTitle = 'Elastic API Manager';
}
