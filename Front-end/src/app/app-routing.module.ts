import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DefaultComponent } from './layouts/default/default.component';
import { DashboardComponent } from './modules/dashboard/dashboard.component';
import { PostsComponent } from './modules/posts/posts.component';
import { SpersonComponent } from './modules/sperson/sperson.component';
import { ProductComponent } from './modules/product/product.component';
import { BuyComponent } from './modules/buy/buy.component';
import { CaseComponent } from './modules/case/case.component';
import { EmployeeComponent } from './modules/employee/employee.component';
import { CasecommentComponent } from './modules/casecomment/casecomment.component';
import { ResolutionComponent } from './modules/resolution/resolution.component';

const routes: Routes = [{
  path: '',
  component: DefaultComponent,
  children: [{
    path: '',
    component: DashboardComponent
  }, {
    path: 'posts', 
    component: PostsComponent
  }, {
    path: 'salesPerson',
    component: SpersonComponent
  }, {
    path: 'products',
    component: ProductComponent
  }, {
    path: 'buy',
    component: BuyComponent
  }, {
    path: 'case',
    component: CaseComponent
  }, {
    path: 'employee',
    component: EmployeeComponent
  }, {
    path: 'caseComment',
    component: CasecommentComponent
  }, {
    path: 'resolution',
    component: ResolutionComponent
  }
]
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
