import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';

import { AppComponent }  from './app.component';

import { HeaderComponent } from './header/header.component';
import { ApiSpecListComponent } from './api-spec-list/api-spec-list.component';
import { ApiSpecDetailComponent } from './api-spec-detail/api-spec-detail.component';
import { DashboardComponent } from './dashboard/dashboard.component';

// Service
import { ApiSpecService } from './shared/api-spec.service';

// 导入路由模块
import { AppRoutingModule } from './app-routing.module';

/**
 * 使用 HeaderComponent/ApiSpecListComponent 之前，必须现在 declarations 中声明
 */
@NgModule({
  imports:      [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    HeaderComponent,
    ApiSpecListComponent,
    ApiSpecDetailComponent,
    DashboardComponent
  ],
  providers: [ ApiSpecService ],
  bootstrap:    [
    AppComponent
  ]
})

export class AppModule {}
