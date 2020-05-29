import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../../dashboard.service';
import { MatDialogRef, MatSnackBar } from '@angular/material';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-spersoncreate',
  templateUrl: './spersoncreate.component.html',
  styleUrls: ['./spersoncreate.component.css']
})
export class SpersoncreateComponent implements OnInit {

  constructor(private dashboardService: DashboardService, public dialogRef: MatDialogRef<SpersoncreateComponent>, public snackBar: MatSnackBar) { }

  salesForm: FormGroup = new FormGroup({
    firstname: new FormControl(null),
    lastname: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
    address: new FormControl('', Validators.required),
    phone: new FormControl('', Validators.required),
    jobtitle: new FormControl('', Validators.required),
  });

  ngOnInit() {
  }

  addSales() {
    console.log(this.salesForm.value);
    this.dashboardService.createSales(this.salesForm.value).subscribe(
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
