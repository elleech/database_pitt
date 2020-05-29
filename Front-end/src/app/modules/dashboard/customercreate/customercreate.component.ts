import { Component, OnInit } from '@angular/core';
import { Customer } from './Customer';
import { FormGroup, Validators, FormControl, ReactiveFormsModule } from '@angular/forms';
import { MatDialogRef, MatSnackBar } from '@angular/material';
import { DashboardService } from '../../dashboard.service';

@Component({
  selector: 'app-customercreate',
  templateUrl: './customercreate.component.html',
  styleUrls: ['./customercreate.component.css']
})
export class CustomercreateComponent implements OnInit {
  public customer: Customer;

  constructor(private dashboardService: DashboardService, public dialogRef: MatDialogRef<CustomercreateComponent>, public snackBar: MatSnackBar, ) { }

  customerForm: FormGroup = new FormGroup({
    firstname: new FormControl('', Validators.required),
    lastname: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
    address: new FormControl('', Validators.required),
    phone: new FormControl('', Validators.required),
    company: new FormControl('', Validators.required),
    grossannualincome:new FormControl('', [Validators.required, Validators.pattern("^[0-9]*$")]),
  });
 
  ngOnInit() {
  }

  addCustomer() {
    console.log(this.customerForm.value);
    this.dashboardService.createCustomer(this.customerForm.value).subscribe(
      data => {
        setTimeout(() => {
          this.snackBar.dismiss()
        }, 2000);
        this.snackBar.open('::Submited successfully')
        this.dialogRef.close("check");
      },
      error => {
        setTimeout(() => {
          this.snackBar.dismiss()
        }, 2000);
        this.snackBar.open('::Something goes wrong')
      }
    );
  }

}
