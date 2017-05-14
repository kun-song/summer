import { Component, Input } from '@angular/core';

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
