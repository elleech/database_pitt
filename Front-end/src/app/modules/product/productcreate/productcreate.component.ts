import { Component, OnInit } from '@angular/core';
import { DashboardService } from '../../dashboard.service';
import { MatDialogRef, MatSnackBar } from '@angular/material';
import { FormGroup, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-productcreate',
  templateUrl: './productcreate.component.html',
  styleUrls: ['./productcreate.component.css']
})
export class ProductcreateComponent implements OnInit {

  constructor(private dashboardService: DashboardService, public dialogRef: MatDialogRef<ProductcreateComponent>, public snackBar: MatSnackBar, ) { }

  productForm: FormGroup = new FormGroup({
    productname: new FormControl(null),
    description: new FormControl('', Validators.required),
    price: new FormControl('', Validators.required),
  });

  ngOnInit() {
  } 

  addProduct() {
    console.log(this.productForm.value);
    this.dashboardService.createProduct(this.productForm.value).subscribe(
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
