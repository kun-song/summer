import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ApiSpecListComponent } from './api-spec-list/api-spec-list.component';
import { ApiSpecDetailComponent } from './api-spec-detail/api-spec-detail.component';
import { DashboardComponent } from './dashboard/dashboard.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'api/spec/:id', component: ApiSpecDetailComponent },
  { path: 'api-spec-list', component: ApiSpecListComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
