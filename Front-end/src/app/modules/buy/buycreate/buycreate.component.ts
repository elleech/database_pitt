import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { DashboardService } from '../../dashboard.service';
import { MatDialogRef, MatSnackBar } from '@angular/material';
import { DatePipe } from '@angular/common';

export class Buybody{
  quantity:string;
  oderDate:string;
  payDate:string;
  deliverDate:string;
}

@Component({
  selector: 'app-buycreate',
  templateUrl: './buycreate.component.html',
  styleUrls: ['./buycreate.component.css'],
  providers: [[DatePipe]] //need to add this 
})
export class BuycreateComponent implements OnInit {

  constructor(private dashboardService: DashboardService, public dialogRef: MatDialogRef<BuycreateComponent>, public snackBar: MatSnackBar,  private datePipe: DatePipe) { }

  buyForm: FormGroup = new FormGroup({
    customerId: new FormControl('', [Validators.required, Validators.pattern("^[0-9]*$")]),
    productId: new FormControl('', [Validators.required, Validators.pattern("^[0-9]*$")]),
    salespersonId: new FormControl('', [Validators.required, Validators.pattern("^[0-9]*$")]),
    quantity: new FormControl('', [Validators.required, Validators.pattern("^[0-9]*$")]),
    oderDate: new FormControl('', Validators.required),
    payDate: new FormControl('', Validators.required),
    deliverDate: new FormControl('', Validators.required),
  });

  ngOnInit() {
  }

  addBuy() {
    console.log(this.buyForm.value);
    let buyBody: Buybody ={
      quantity : this.buyForm.value.quantity,
      oderDate : this.buyForm.value.oderDate,
      payDate : this.buyForm.value.payDate,
      deliverDate : this.buyForm.value.deliverDate, 
      // oderDate : this.datePipe.transform(this.buyForm.value.oderDate, 'MM/dd/yy hh:mm a'),
      // payDate : this.datePipe.transform(this.buyForm.value.payDate, 'MM/dd/yy hh:mm a'),
      // deliverDate : this.datePipe.transform(this.buyForm.value.deliverDate, 'MM/dd/yy hh:mm a')
    }
    console.log(buyBody);
    this.dashboardService.createBuy(this.buyForm.value.customerId, this.buyForm.value.productId,this.buyForm.value.salespersonId, buyBody).subscribe(
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
