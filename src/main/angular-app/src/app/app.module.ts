import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { RouterModule } from '@angular/router';

import { AppComponent }  from './app.component';

import { HeaderComponent } from './header/header.component';
import { ApiSpecListComponent } from './api-spec-list/api-spec-list.component';
import { ApiSpecDetailComponent } from './api-spec-detail/api-spec-detail.component';

// Service
import { ApiSpecService } from './shared/api-spec.service';

/**
 * 使用 HeaderComponent/ApiSpecListComponent 之前，必须现在 declarations 中声明
 */
@NgModule({
  imports:      [
    BrowserModule,
    FormsModule,
    // 路由定义：path 定义匹配的地址。component 定义导航到该路由时 Router 需要创建的组件。
    RouterModule.forRoot([
      {
        path: 'api-spec-list',
        component: ApiSpecListComponent
      }
    ])
  ],
  declarations: [
    AppComponent,
    HeaderComponent,
    ApiSpecListComponent,
    ApiSpecDetailComponent
  ],
  providers: [ ApiSpecService ],
  bootstrap:    [
    AppComponent
  ]
})

export class AppModule {}
