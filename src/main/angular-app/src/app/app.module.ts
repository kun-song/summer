import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';

import { AppComponent }  from './app.component';

import { HeaderComponent } from './header/header.component';
import { ApiSpecListComponent } from './api-spec-list/api-spec-list.component';
import { ApiSpecDetailComponent } from './api-spec-detail/api-spec-detail.component';

/**
 * 使用 HeaderComponent/ApiSpecListComponent 之前，必须现在 declarations 中声明
 */
@NgModule({
  imports:      [
    BrowserModule,
    FormsModule
  ],
  declarations: [
    AppComponent,
    HeaderComponent,
    ApiSpecListComponent,
    ApiSpecDetailComponent
  ],
  bootstrap:    [
    AppComponent
  ]
})

export class AppModule {}
