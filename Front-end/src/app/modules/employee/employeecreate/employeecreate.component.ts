import { Component, OnInit } from '@angular/core';
import { FormControl, Validators, FormGroup } from '@angular/forms';
import { MatDialogRef, MatSnackBar } from '@angular/material';
import { DashboardService } from '../../dashboard.service';

@Component({
  selector: 'app-employeecreate',
  templateUrl: './employeecreate.component.html',
  styleUrls: ['./employeecreate.component.css']
})
export class EmployeecreateComponent implements OnInit { 

  constructor(private dashboardService: DashboardService, public dialogRef: MatDialogRef<EmployeecreateComponent>, public snackBar: MatSnackBar) { }

  employeeForm: FormGroup = new FormGroup({
    firstname: new FormControl(null),
    lastname: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
    address: new FormControl('', Validators.required),
    phone: new FormControl('', Validators.required),
  });

  ngOnInit() {
  } 

  addSales() {
    console.log(this.employeeForm.value);
    this.dashboardService.createEmployee(this.employeeForm.value).subscribe(
      data => {
        setTimeout(() => {
          this.snackBar.dismiss()
        }, 2000);
        this.dialogRef.close("check");
        this.snackBar.open('::Submited successfully')
      },
      error => {
        this.snackBar.open('::Something goes wrong')
      }
    ); 
  }

}
 