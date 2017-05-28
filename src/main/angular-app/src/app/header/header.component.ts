import { Component, Input } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { TabMenuModule, MenuItem } from 'primeng/primeng';

@Component({
  selector: 'header',
  template: `
    <h1>{{ title }}</h1>
    <HR style="border:1 dashed #987cb9" width="100%" color=#987cb9 SIZE=1>
  `,
})

export class HeaderComponent {
  @Input() title: String;
}
