import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DefaultComponent } from './default.component';
import { DashboardComponent } from 'src/app/modules/dashboard/dashboard.component';
import { RouterModule } from '@angular/router';
import { PostsComponent } from 'src/app/modules/posts/posts.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { MatSidenavModule, MatDividerModule, MatCardModule, MatPaginatorModule, MatTableModule, MatButtonModule, MatDialogModule, MatGridListModule, MatFormFieldModule, MatInputModule, MatToolbarModule, MatSnackBarModule, MatDatepickerModule, MatNativeDateModule, MatSortModule } from '@angular/material';
import { FlexLayoutModule } from '@angular/flex-layout';
import { DashboardService } from 'src/app/modules/dashboard.service';
import { MatIconModule } from "@angular/material/icon";
import { CustomerdetailComponent } from 'src/app/modules/dashboard/customerdetail/customerdetail.component';
import { CustomercreateComponent } from 'src/app/modules/dashboard/customercreate/customercreate.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SpersonComponent } from 'src/app/modules/sperson/sperson.component';
import { SpersondetailComponent } from 'src/app/modules/sperson/spersondetail/spersondetail.component';
import { SpersoncreateComponent } from 'src/app/modules/sperson/spersoncreate/spersoncreate.component';
import { ProductComponent } from 'src/app/modules/product/product.component';
import { ProductcreateComponent } from 'src/app/modules/product/productcreate/productcreate.component';
import { BuyComponent } from 'src/app/modules/buy/buy.component';
import { BuycreateComponent } from 'src/app/modules/buy/buycreate/buycreate.component';
import { CaseComponent } from 'src/app/modules/case/case.component';
import { CasedetailComponent } from 'src/app/modules/case/casedetail/casedetail.component';
import { CasecreateComponent } from 'src/app/modules/case/casecreate/casecreate.component';
import { EmployeeComponent } from 'src/app/modules/employee/employee.component';
import { EmployeedetailComponent } from 'src/app/modules/employee/employeedetail/employeedetail.component';
import { EmployeecreateComponent } from 'src/app/modules/employee/employeecreate/employeecreate.component';
import { CasecommentComponent } from 'src/app/modules/casecomment/casecomment.component';
import { CarecommentcreateComponent } from 'src/app/modules/casecomment/carecommentcreate/carecommentcreate.component';
import { ResolutionComponent } from 'src/app/modules/resolution/resolution.component';
import { ResolutioncreateComponent } from 'src/app/modules/resolution/resolutioncreate/resolutioncreate.component';
import { CustomereditComponent } from 'src/app/modules/dashboard/customeredit/customeredit.component';
import { BrowserModule } from '@angular/platform-browser';
import { CaseeditComponent } from 'src/app/modules/case/caseedit/caseedit.component';

 
@NgModule({
  declarations: [
    DefaultComponent,
    DashboardComponent,
    PostsComponent,
    CustomerdetailComponent,
    CustomercreateComponent,  
    SpersonComponent,
    SpersondetailComponent,
    SpersoncreateComponent,
    ProductComponent,
    ProductcreateComponent,
    BuyComponent,
    BuycreateComponent,
    CaseComponent,
    CasedetailComponent,
    CasecreateComponent,
    EmployeeComponent,
    EmployeedetailComponent,
    EmployeecreateComponent,
    CasecommentComponent,
    CarecommentcreateComponent,
    ResolutionComponent,
    ResolutioncreateComponent,
    CustomereditComponent,
    CaseeditComponent
  ],
  imports: [ 
    CommonModule,
    RouterModule,
    SharedModule,
    MatSidenavModule,
    MatDividerModule,
    MatCardModule,
    MatPaginatorModule,
    MatTableModule,
    FlexLayoutModule,
    MatIconModule,
    MatButtonModule,
    MatDialogModule,
    FormsModule,
    MatGridListModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatInputModule,
    MatToolbarModule,
    MatSnackBarModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSortModule,
    BrowserModule
  ],
  providers: [
    DashboardService 
  ],
  entryComponents:[
    CustomerdetailComponent,
    CustomercreateComponent, 
    CustomereditComponent,
    SpersondetailComponent, 
    SpersoncreateComponent, 
    ProductcreateComponent, 
    BuycreateComponent, 
    CasedetailComponent, 
    CasecreateComponent,
    CaseeditComponent,
    EmployeedetailComponent,
    EmployeecreateComponent,
    CarecommentcreateComponent,
    ResolutioncreateComponent
  ]
})
export class DefaultModule { }
