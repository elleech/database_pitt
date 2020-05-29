import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatSnackBar, MatDialogRef } from '@angular/material';
import { DashboardService } from '../../dashboard.service';
import { FormGroup, Validators, FormControl } from '@angular/forms';
 
@Component({
  selector: 'app-customeredit',
  templateUrl: './customeredit.component.html',
  styleUrls: ['./customeredit.component.css']
})
export class CustomereditComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private dashboardService: DashboardService, public dialogRef: MatDialogRef<CustomereditComponent>, public snackBar: MatSnackBar, ) { }

  customerForm: FormGroup = new FormGroup({
    id: new FormControl('', Validators.required), 
    firstname: new FormControl('', Validators.required),
    lastname: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
    address: new FormControl('', Validators.required),
    phone: new FormControl('', Validators.required),
    company: new FormControl('', Validators.required),
    grossannualincome:new FormControl('', [Validators.required, Validators.pattern("^[0-9]*$")]),
  });

  ngOnInit() {
    this.fetchData()
  }

  fetchData() {
    this.customerForm.setValue({
      id: this.data.id,
      firstname: this.data.firstname,
      lastname: this.data.lastname,
      email: this.data.email,
      address: this.data.address,
      phone: this.data.phone,
      company:this.data.company,
      grossannualincome:this.data.grossannualincome
    })
  }

  editCustomer() {
    console.log(this.customerForm.value);
    this.dashboardService.editCustomer(this.customerForm.value).subscribe(
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
